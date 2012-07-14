package com.pocketreddit.library.authentication;

import com.pocketreddit.library.authentication.AuthenticationException;
import com.pocketreddit.library.authentication.LiveAuthenticator;
import com.pocketreddit.library.authentication.LoginResult;

import android.test.AndroidTestCase;
import android.util.Log;

public class IntegrationLiveAuthenticationTest extends AndroidTestCase {
    private static final String TAG = IntegrationLiveAuthenticationTest.class.getName();

    public void testLoginWithBadPw() {
        LiveAuthenticator authenticator = new LiveAuthenticator();
        try {
            LoginResult result = authenticator.authenticate("testachan", "baddpw");
            assertFalse("LoginResult should produce errors when there is a bad pw.", result
                    .getErrors().isEmpty());
        } catch (AuthenticationException e) {

        }
    }

    public void testLoginSuccess() {
        LiveAuthenticator authenticator = new LiveAuthenticator();
        try {
            LoginResult result = authenticator.authenticate("testachan", "testachan");
            assertTrue("LoginResult shouldn't have any errors.", result.getErrors().isEmpty());
        } catch (AuthenticationException e) {
            Log.e(TAG, e.getMessage(), e);
            fail("Could not authenticate: " + e.getMessage());
        }
    }

}
