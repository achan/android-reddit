package com.am05.reddit.library.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

public class HttpHelper {
	private static final String TAG = HttpHelper.class.getName();

	private static HttpHelper instance;

	private HttpHelper() {
	}

	public static HttpHelper getInstance() {
		if (instance == null)
			instance = new HttpHelper();

		return instance;
	}

	public JSONObject getJson(String uri) throws NetException {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(uri);
		HttpResponse response;
		JSONObject json = null;
		InputStream is = null;
		try {
			response = client.execute(get);
			is = response.getEntity().getContent();
			String content = convertStreamToString(is);
			json = new JSONObject(content);
		} catch (Exception e) {
			String message = "An error occurred trying to convert url into JSON object.";
			Log.e(TAG, message, e);
			throw new NetException(message, e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return json;
	}

	private String convertStreamToString(InputStream is) {
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
