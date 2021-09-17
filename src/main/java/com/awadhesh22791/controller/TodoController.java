package com.awadhesh22791.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.awadhesh22791.entity.Todo;
import com.awadhesh22791.service.TodoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public Flux<Todo>get(@RequestParam(name = "todo",required = false)String todo){
		return todoService.getAll(todo);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Todo>create(@RequestBody Todo todo){
		return todoService.create(todo);
	}

}
