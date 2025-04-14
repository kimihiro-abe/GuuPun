package com.example.demo.app.forgotten_mimolette.repository;

import java.util.List;

import com.example.demo.app.forgotten_mimolette.entity.Todo;

public interface TodoRepository{

	List<Todo> findAll();

	void add(Todo todo);

	int deleteById(String todoId, String userId);
	
	void deleteOldTodos();

}