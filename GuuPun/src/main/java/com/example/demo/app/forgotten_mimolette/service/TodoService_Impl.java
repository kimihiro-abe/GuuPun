package com.example.demo.app.forgotten_mimolette.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.app.forgotten_mimolette.entity.Todo;
import com.example.demo.app.forgotten_mimolette.repository.TodoRepository;

@Service
public class TodoService_Impl implements TodoService {
	
	private final TodoRepository repository;
	
	public TodoService_Impl(TodoRepository repository) {
		this.repository = repository;
	}
	
	// 全件取得
	@Override
	public List<Todo> findAll() {
		return repository.findAll();
	}

	// todoの追加
	@Override
	public void add(Todo todo) {
		repository.add(todo);
	}

	// todoの削除
	@Override
	public void deleteById(String todoId, String userId) {

		//todoを更新 idがなければ例外発生
		if(repository.deleteById(todoId, userId) == 0) {
			throw new TodoNotFoundException("There are no tasks to delete! :|");
		}

	}
}

