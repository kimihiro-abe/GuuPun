package com.example.demo.app.chitchat_cue.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.app.chitchat_cue.entity.Chatcue;
import com.example.demo.app.chitchat_cue.service.ChatcueService;
import com.example.demo.app.common.ConstCue;

@Controller
@RequestMapping("/chitchat_cue")
public class ChitChat_Controller implements ConstCue {
	
    private final ChatcueService chatcueService;

    public ChitChat_Controller(ChatcueService chatcueService) {
        this.chatcueService = chatcueService;
    }
	
    // ルートURL（/）にアクセスしたときにサイトマップを表示
    @GetMapping()
    public String showSitemap(Model model) {
    	String message_header = ConstRead();
    	System.out.println("message_header:" + message_header);
    	model.addAttribute("message_header", message_header);
        return "chitchat_cue/index";  // templates/index.html を返す
    }
    
    // Buttonの押下後の処理
    @GetMapping("/showCue")
    public String showCue(Model model) {
    	String message_header = ConstRead();
    	System.out.println("message_header:" + message_header);
    	
    	Chatcue chatcue = chatcueService.findOne();
    	model.addAttribute("chatcue", chatcue);
    	model.addAttribute("message_header", message_header);
        return "chitchat_cue/index";
    }
    
    public String ConstRead() {
    	Random random = new Random();
    	List<String> headerList = ConstCue.CUE_HEADER;
    	String selected = headerList.get(random.nextInt(headerList.size()));
    	return selected;
    }
    
    

}
