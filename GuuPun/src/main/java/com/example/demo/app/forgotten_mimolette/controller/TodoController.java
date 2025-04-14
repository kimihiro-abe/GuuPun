package com.example.demo.app.forgotten_mimolette.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.forgotten_mimolette.entity.Todo;
import com.example.demo.app.forgotten_mimolette.service.TodoService;

import jakarta.validation.Valid;

/**
 * ToDoアプリ
 */
@Controller
@RequestMapping("/forgotten_mimolette")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    /**
     * タスクの一覧を表示します
     * @param todoForm
     * @param model
     * @return resources/templates下のHTMLファイル名
     */
    @GetMapping
    public String todo(TodoForm todoForm, Model model) {

    	//新規登録か更新かを判断する仕掛け
//    	todoForm.setNewTodo(true);

        //todoのリストを取得する
    	List<Todo> list = todoService.findAll();
    	Collections.reverse(list);

        model.addAttribute("list", list);
        model.addAttribute("title", "Volatile List：Forgotten Mimolette");

        return "forgotten_mimolette/index";
    }

    /**
     * タスクデータを一件挿入
     * @param todoForm
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/add")// タスクの新規登録
    public String add(
    	@Valid @ModelAttribute TodoForm todoForm,
        BindingResult result,
        RedirectAttributes redirectAttributes,
        Model model) {

    	//todoFormのデータをtodoに格納
    	Todo todo = makeTodo(todoForm);
    	
        if (!result.hasErrors()) {
        	//一件挿入後リダイレクト
        	todoService.add(todo);
        	System.out.println("if:いっけん");
            return "redirect:/forgotten_mimolette";
        } 
        else {
            //todoForm. setNewTodo(true);
            model.addAttribute("todoForm", todoForm);
            List<Todo> list = todoService.findAll();
            Collections.reverse(list);
            model.addAttribute("list", list);
            model.addAttribute("title", "Volatile List：Forgotten Mimolette");
            System.out.println("else:処理でエラーが出てるからelse");
            return "forgotten_mimolette/index";
        }
    }

    /**
     * タスクidを取得し、一件のデータ削除
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/delete")
    public String delete(
    	@RequestParam("todoId") String todoId,
    	Model model) {

    	//タスクを一件削除しリダイレクト
    	todoService. deleteById(todoId, "1");
        return "redirect:/forgotten_mimolette";
    }

    /**
     * todoFormのデータをtodoに入れて返す
     * @param todoForm
     * @param todoId 新規登録の場合は0を指定
     * @return
     */
    private Todo makeTodo(TodoForm todoForm) {
    	// システムのデフォルトタイムゾーンで現在時刻を取得
    	LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault()); 
    	
    	//DateTimeFormatter formatter_todoId = DateTimeFormatter.ofPattern("yyyyMMdd_SSSSSSSSS");
    	// todoIdのデータ設定
    	String timestampBasedId = String.valueOf(System.currentTimeMillis());
       	int randomNum = (int)(Math.random() * 10000);
       	String formated_randomNum = String.format("%04d", randomNum);
       	String todoId = timestampBasedId + "_" + formated_randomNum;
    	
       	// createDateのデータ設定
    	DateTimeFormatter formatter_createDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	LocalDateTime createDate = 
    			LocalDateTime.parse(now.format(formatter_createDate), formatter_createDate);
    	
    	// debug
    	System.out.println("todoId : " + todoId );
    	System.out.println("createDate: " + createDate);
    	
    	Todo todo = new Todo();
        
        todo.setTodoId(todoId);
        todo.setUserId("1");
        todo.setContent(todoForm.getContent());
        todo.setCreateDate(createDate);      
        return todo;
    }
}
