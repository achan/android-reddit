package com.am05.reddit.library.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

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

    public JSONObject getJsonFromGet(String uri) throws NetException {
        HttpClient client = new DefaultHttpClient();

        try {
            return getJsonFromResponse(client.execute(new HttpGet(uri)));
        } catch (Exception e) {
            throw new NetException("Error while parsing GET response from " + uri
                    + " into JSON object.", e);
        }
    }

    private JSONObject getJsonFromResponse(HttpResponse response) throws IllegalStateException,
            IOException, JSONException {
        InputStream is = null;
        try {
            is = response.getEntity().getContent();
            String content = convertStreamToString(is);
            Log.v(TAG, "stream content: " + content);
            return new JSONObject(content);
        } finally {
            if (is != null)
                is.close();
        }
    }

    public JSONObject getJsonFromPost(URI uri, List<NameValuePair> params) throws NetException {
        HttpClient httpClient = new DefaultHttpClient();

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

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
