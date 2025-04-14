package com.example.demo.app.forgotten_mimolette.service;

import java.util.List;

import com.example.demo.app.forgotten_mimolette.entity.Todo;

public interface TodoService {
	
	List<Todo> findAll();

	void add(Todo todo);

	void deleteById(String todoId, String userId);

}
