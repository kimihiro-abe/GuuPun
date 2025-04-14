package com.example.demo.app.forgotten_mimolette.entity;

import java.time.LocalDateTime;

public class Todo {

    private String todoId;
    private String userId;
    private String content;
    private LocalDateTime createDate;
    
    // getter setter
	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
    
    


    
    
}
