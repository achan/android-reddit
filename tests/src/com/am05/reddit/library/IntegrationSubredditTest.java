package com.am05.reddit.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.test.AndroidTestCase;
import android.util.Log;

import com.am05.reddit.library.Subreddit;

public class IntegrationSubredditTest extends AndroidTestCase {
	public void testGetSubreddit() {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://reddit.com/r/nba/about.json");
		HttpResponse response = null;

		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();

			String content = convertStreamToString(entity.getContent());
			Log.v("IntegrationSubredditTest", content);
			JSONObject json = new JSONObject(content);
			Log.v(this.getClass().getName(), new Subreddit(json).toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
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
