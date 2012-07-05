package com.am05.reddit.library;

import java.util.List;

public class Listing extends Thing {
	/**
	 * A list of things that this Listing wraps.
	 */
	private List<Thing> data;

	/**
	 * The full name of the listing that precedes this page. Null, if there is
	 * no previous.
	 */
	private String before;

	/**
	 * The fullname of the listing that follows after this page. null if there
	 * is no next page.
	 */
	private String after;

	/**
	 * This modhash is not the same modhash provided upon login. You do not need
	 * to update your user's modhash everytime you get a new modhash. You can
	 * reuse the modhash given upon login.
	 */
	private String modHash;

	@Override
	public List<Thing> getData() {
		return data;
	}

	public void setData(List<Thing> data) {
		this.data = data;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getModHash() {
		return modHash;
	}

	public void setModHash(String modHash) {
		this.modHash = modHash;
	}
}
