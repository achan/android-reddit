package com.pocketreddit.library.authentication;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginResult {
    private String modHash;
    private String cookie;
    private List<List<String>> errors;

    public LoginResult(String json) throws AuthenticationException, JSONException {
        this(new JSONObject(json));
    }

    public LoginResult(JSONObject json) throws AuthenticationException {
        try {
            errors = new ArrayList<List<String>>();
            json = json.getJSONObject("json");

            JSONArray jsonErrors = json.getJSONArray("errors");
            for (int i = 0; i < jsonErrors.length(); i++) {
                JSONArray currentError = jsonErrors.getJSONArray(i);
                List<String> errorKeys = new ArrayList<String>();
                for (int j = 0; j < currentError.length(); j++) {
                    errorKeys.add(currentError.getString(j));
                }

                errors.add(errorKeys);
            }

            if (jsonErrors.length() == 0) {
                JSONObject data = json.getJSONObject("data");
                setModHash(data.getString("modhash"));
                setCookie(data.getString("cookie"));
            }
        } catch (JSONException e) {
            throw new AuthenticationException("Could not parse login response.", e);
        }
    }

    public String getModHash() {
        return modHash;
    }

    public void setModHash(String modHash) {
        this.modHash = modHash;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public List<List<String>> getErrors() {
        return errors;
    }

    public void setErrors(List<List<String>> errors) {
        this.errors = errors;
    }
}
