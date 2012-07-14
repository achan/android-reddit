package com.pocketreddit.library;

public interface Votable {
	public int getUpvotes();

	public int getDownvotes();

	/**
	 * @return true if thing is liked by the user. false if thing is disliked.
	 *         null if the user is neutral on the thing.
	 */
	public Boolean isLiked();
}
