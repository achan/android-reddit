package com.am05.reddit.library.things;

public abstract class Thing {
	private String id;
	private String name;
	
	public abstract Kind getKind();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
