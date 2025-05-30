package com.example.demo.app.chitchat_cue.service;

import org.springframework.stereotype.Service;

import com.example.demo.app.chitchat_cue.entity.Chatcue;
import com.example.demo.app.chitchat_cue.repository.ChatcueRepository;

@Service
public class ChatcueService_Impl implements ChatcueService {
	
	private final ChatcueRepository repository;
	
	public ChatcueService_Impl(ChatcueRepository repository) {
		this.repository = repository;
	}

	@Override
	public Chatcue findOne() {
		// TODO Auto-generated method stub
		return repository.findOne();
	}

}
