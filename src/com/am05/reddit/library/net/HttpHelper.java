package com.am05.reddit.library.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.am05.reddit.library.utils.StreamUtils;

public class HttpHelper {
    private static final String TAG = HttpHelper.class.getName();
    private static final String SCHEME_SSL = "https";
    private static final int SCHEME_PORT_SSL = 443;

    private static HttpHelper instance;

    private HttpHelper() {
    }

    public static HttpHelper getInstance() {
        if (instance == null)
            instance = new HttpHelper();

        return instance;
    }

    public JSONObject getJsonFromGet(String uri, List<Cookie> cookies) throws NetException {
        HttpClient client = buildHttpClient(cookies);

        try {
            return getJsonFromResponse(client.execute(new HttpGet(uri)));
        } catch (Exception e) {
            throw new NetException("Error while parsing GET response from " + uri
                    + " into JSON object.", e);
        }
    }

    private HttpClient buildHttpClient(List<Cookie> cookies) {
        DefaultHttpClient client = new DefaultHttpClient();

        if (cookies != null && !cookies.isEmpty()) {
            client.setCookieStore(buildCookieStore(cookies));
        }

        return client;
    }

    private CookieStore buildCookieStore(List<Cookie> cookies) {
        Cookie[] cookieArray = new Cookie[cookies.size()];
        return buildCookieStore(cookies.toArray(cookieArray));
    }

    private CookieStore buildCookieStore(Cookie... cookies) {
        CookieStore cookieStore = new BasicCookieStore();
        for (Cookie cookie : cookies) {
            cookieStore.addCookie(cookie);
        }

        return cookieStore;
    }

    private JSONObject getJsonFromResponse(HttpResponse response) throws IllegalStateException,
            IOException, JSONException {
        InputStream is = null;
        try {
            is = response.getEntity().getContent();
            String content = StreamUtils.getInstance().convertStreamToString(is);
            Log.v(TAG, "stream content: " + content);
            return new JSONObject(content);
        } finally {
            if (is != null)
                is.close();
        }
    }

    public JSONObject getJsonFromGet(String uri) throws NetException {
        return getJsonFromGet(uri, null);
    }

    public JSONObject getJsonFromPost(URI uri, List<NameValuePair> params) throws NetException {
        return getJsonFromPost(uri, params, null);
    }

    public JSONObject getJsonFromPost(URI uri, List<NameValuePair> params, List<Cookie> cookies)
            throws NetException {
        HttpClient httpClient = buildHttpClient(cookies);

        if (SCHEME_SSL.equals(uri.getScheme())) {
            HostnameVerifier hostnameVerifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

            SchemeRegistry registry = new SchemeRegistry();
            SSLSocketFactory sslFactory = SSLSocketFactory.getSocketFactory();
            sslFactory.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier);
            registry.register(new Scheme(SCHEME_SSL, sslFactory, SCHEME_PORT_SSL));
            SingleClientConnManager connectManager = new SingleClientConnManager(
                    httpClient.getParams(), registry);

            httpClient = new DefaultHttpClient(connectManager, httpClient.getParams());
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        }

        HttpPost post = new HttpPost(uri);

        try {
            post.setEntity(new UrlEncodedFormEntity(params));
            return getJsonFromResponse(httpClient.execute(post));
        } catch (Exception e) {
            throw new NetException("Error while parsing POST response from " + uri
                    + " into JSON object.", e);
        }
    }
}
