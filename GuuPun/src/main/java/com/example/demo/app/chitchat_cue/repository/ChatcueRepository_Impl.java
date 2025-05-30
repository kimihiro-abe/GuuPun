package com.example.demo.app.chitchat_cue.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.app.chitchat_cue.entity.Chatcue;

@Repository
public class ChatcueRepository_Impl implements ChatcueRepository {
	
	private final JdbcTemplate jdbcTemplate;

	public ChatcueRepository_Impl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 一件だけ引っ張ってくる。
	@Override
	public Chatcue findOne() {
		// TODO Auto-generated method stub
		String sql = "SELECT "
				+ "chatcue_id, category, content, access_level "
				+ "FROM chatcues "
				+ "ORDER BY random() LIMIT 1";
		
		// JdbcTemplate.queryForObject() を使う場合、
		// SQLの結果をオブジェクトに変換するために コンストラクター経由で値をセットする必要あり
		// RowMapper を使うと 引数ありのコンストラクターが必要
        Chatcue cue = jdbcTemplate.queryForObject(sql, new RowMapper<Chatcue>() {
            @Override
            public Chatcue mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Chatcue(
                    rs.getInt("chatcue_id"),
                    rs.getInt("category"),
                    rs.getString("content"),
                    rs.getInt("access_level")
                );
            }
        });
		
		return cue;
	}

}
