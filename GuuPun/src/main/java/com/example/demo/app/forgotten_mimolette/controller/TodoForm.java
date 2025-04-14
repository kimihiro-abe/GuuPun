package com.example.demo.app.forgotten_mimolette.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TodoForm {

    @NotBlank (message = "Please enter the content.😵‍💫")
    @Size(max = 60, message = "Please enter up to 60 characters.😵‍💫")
    private String content;

    // constructor
    public TodoForm() {}

    // constructor
	public TodoForm(
//			int todoId,
//			String userId,
			String content 
//			LocalDateTime creationDate
			) {
//		this.todoId = todoId;
//		this.userId = userId;
		this.content = content;
//		this.creationDate = creationDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}