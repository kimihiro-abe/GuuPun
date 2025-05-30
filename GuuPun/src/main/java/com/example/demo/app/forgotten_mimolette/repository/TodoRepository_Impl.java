package com.example.demo.app.forgotten_mimolette.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.example.demo.app.forgotten_mimolette.entity.Todo;
import com.example.demo.config.LoggerUtility;


//interfaceのtodoRepositoryを実装したものが、todoRepositoryImpl
@Repository
public class TodoRepository_Impl implements TodoRepository {

	private final JdbcTemplate jdbcTemplate;

	public TodoRepository_Impl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 全件表示
	@Override
	public List<Todo> findAll() {

		String sql = "SELECT todo_id, user_id, content, createdate "
				+ "FROM todo "
				+ "WHERE user_id = '1'";
		
		// タスク一覧をMapのListで取得(queryForListがそうなってる)
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

		// return用の空のListを用意
		List<Todo> list = new ArrayList<Todo>();

		// 詰め替える
		for(Map<String, Object> result : resultList) {
			// todoのカラム
			Todo todo = new Todo();//entity
			todo.setTodoId((String)result.get("todo_id"));
			todo.setUserId((String)result.get("user_id"));
			todo.setContent((String)result.get("content"));
			todo.setCreateDate(((Timestamp) result.get("createdate")).toLocalDateTime());
			
			list.add(todo);
		}
		return list;
	}


	@Override
	public void add(Todo todo) {
		jdbcTemplate.update("INSERT INTO todo(todo_id, user_id, content, createdate) VALUES(?, ?, ?, ?)",
				 todo.getTodoId(), todo.getUserId(), todo.getContent(), todo.getCreateDate() );
	}

	@Override
	public int deleteById(String todoId, String userId) {
		return jdbcTemplate.update("DELETE FROM todo WHERE todo_id = ? and user_id = ?", todoId, userId);
	}

	@Override
	@Scheduled(cron = "0 0 18 * * ?", zone = "Asia/Tokyo")  // 最終的には深夜に実行予定
	public void deleteOldTodos() {
		LoggerUtility.logInfo("deleteOldTodos: start");
		
	    String sql = "DELETE FROM todo "
	               + "WHERE createdate < CURRENT_TIMESTAMP - INTERVAL '7 days'";
	    jdbcTemplate.update(sql);
	    
	    LoggerUtility.logInfo("deleteOldTodos: end");
	}
	//MySQL向けの文：SELECT FROM todo WHERE createdate < NOW() - INTERVAL 8 DAY and userId = '1'


}
