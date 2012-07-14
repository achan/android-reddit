package com.pocketreddit.library.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {
    private static StreamUtils instance;

    private StreamUtils() {
    }

    public static StreamUtils getInstance() {
        if (instance == null) {
            instance = new StreamUtils();
        }

        return instance;
    }

    public String convertStreamToString(InputStream is) throws UtilsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw new UtilsException("Couldn't read line from stream.", e);
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
