package com.pocketreddit.library.authentication;

public interface Authenticator {
    /**
     * @param username
     * @param password
     * @return a reddit session id.
     * @throws AuthenticationException
     *             if user wasn't able to be authenticated.
     */
    public LoginResult authenticate(String username, String password) throws AuthenticationException;
}
