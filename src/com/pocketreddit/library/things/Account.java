package com.pocketreddit.library.things;

import org.json.JSONObject;

import com.pocketreddit.library.Created;

public class Account implements Created {
	private int commentKarma;
	private double created;
	private double createdUtc;
	private boolean mail;
	private boolean modMail;
	private String id;
	private boolean gold;
	private boolean mod;
	private int linkKarma;
	private String modHash;
	private String name;

	public int getCommentKarma() {
		return commentKarma;
	}

	public void setCommentKarma(int commentKarma) {
		this.commentKarma = commentKarma;
	}

	public double getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public double getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(long createdUtc) {
		this.createdUtc = createdUtc;
	}

	public boolean isMail() {
		return mail;
	}

	public void setMail(boolean mail) {
		this.mail = mail;
	}

	public boolean isModMail() {
		return modMail;
	}

	public void setModMail(boolean modMail) {
		this.modMail = modMail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public boolean isMod() {
		return mod;
	}

	public void setMod(boolean mod) {
		this.mod = mod;
	}

	public int getLinkKarma() {
		return linkKarma;
	}

	public void setLinkKarma(int linkKarma) {
		this.linkKarma = linkKarma;
	}

	public String getModHash() {
		return modHash;
	}

	public void setModHash(String modHash) {
		this.modHash = modHash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public JSONObject toJson() {
		throw new UnsupportedOperationException("Haven't handled this method yet.");
	}
}
