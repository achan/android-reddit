package com.pocketreddit.library.authentication;

import com.pocketreddit.library.authentication.LoginResult;

import android.test.AndroidTestCase;
import android.util.Log;

public class TestLoginResult extends AndroidTestCase {
    private static final String TAG = TestLoginResult.class.getName();

    private final String successfulLoginJson = "{\"json\": {\"errors\": [], \"data\": {\"modhash\": \"7l7jf0fzvt9556d747b9ef00409e1a90d2fbdc328cd26b599b\", \"cookie\": \"13829964,2012-07-05T10:56:57,3acfec8427be44b0b90970d59a56e1b50ff74adf\"}}}";
    private final String badPasswordJson = "{\"json\": {\"errors\": [[\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"]]}}";

    public void testLoginResultFromSuccess() {
        try {
            LoginResult login = new LoginResult(successfulLoginJson);
            assertTrue("LoginResult shouldn't produce any errors.", login.getErrors().isEmpty());
        } catch (Exception e) {
            Log.e(TAG, "Failed parsing login response.", e);
            fail("Failed parsing login response.");
        }
    }

    public void testLoginResultBadPw() {
        try {
            LoginResult login = new LoginResult(badPasswordJson);
            assertTrue("The first error should be WRONG_PASSWORD", login.getErrors().get(0).get(0)
                    .equals("WRONG_PASSWORD"));
            assertTrue("Modhash should be empty on bad login", login.getModHash() == null);
        } catch (Exception e) {
            Log.e(TAG, "Failed parsing login response.", e);
            fail("Failed parsing login response.");
        }
    }
}
