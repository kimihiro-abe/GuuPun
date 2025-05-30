package com.example.demo.app.chitchat_cue.entity;

public class Chatcue {
	private int chatcue_id;
	private int category;
	private String content;
	private int access_level;
	
	// constructor
	protected Chatcue() {}
	
	// constructor2
	// ChatcueRepository_Implの中でqueryForObjectする際に使用する。設定しないとエラー
    public Chatcue(int chatcueId, int category, String content, int accessLevel) {
        this.chatcue_id = chatcueId;
        this.category = category;
        this.content = content;
        this.access_level = accessLevel;
    }
	
	// getter setter
	public int getChatcue_id() {
		return chatcue_id;
	}
	public void setChatcue_id(int chatcue_id) {
		this.chatcue_id = chatcue_id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAccess_level() {
		return access_level;
	}
	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}
	
	

}
