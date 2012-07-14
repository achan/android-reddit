package com.pocketreddit.library.authentication;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.pocketreddit.library.net.HttpHelper;

public class LiveAuthenticator implements Authenticator {
    private static final String TAG = LiveAuthenticator.class.getName();

    private static final String LOGIN_URI = "https://ssl.reddit.com/api/login";
    private static final String PARAM_USERNAME = "user";
    private static final String PARAM_PASSWORD = "passwd";

    private static final String PARAM_API_TYPE = "api_type";
    private static final String API_TYPE_JSON = "json";

    public LoginResult authenticate(String username, String password)
            throws AuthenticationException {
        try {
            return new LoginResult(HttpHelper.getInstance().getJsonObjectFromPost(
                    new URI(LOGIN_URI + "/" + username),
                    nameValuePairs(PARAM_USERNAME, username, PARAM_PASSWORD, password,
                            PARAM_API_TYPE, API_TYPE_JSON)));
        } catch (Exception e) {
            Log.e(TAG, "Unable to authenticate user: " + username, e);
            throw new AuthenticationException("Unable to authenticate user: " + username, e);
        }
    }

    private List<NameValuePair> nameValuePairs(String... keysAndValues) {
        if (keysAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Must contain keys and values, length cannot be odd");
        }

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();

        for (int i = 0; i < keysAndValues.length; i += 2) {
            pairs.add(new BasicNameValuePair(keysAndValues[i], keysAndValues[i + 1]));
        }

        return pairs;
    }
}
