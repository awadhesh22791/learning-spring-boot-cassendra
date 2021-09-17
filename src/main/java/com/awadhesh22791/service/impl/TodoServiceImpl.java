package com.awadhesh22791.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awadhesh22791.entity.Todo;
import com.awadhesh22791.repository.TodoRepository;
import com.awadhesh22791.service.TodoService;
import com.datastax.oss.driver.api.core.uuid.Uuids;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Flux<Todo> getAll(String todo) {
		if (todo == null || todo.isEmpty()) {
			return todoRepository.findAll();
		} else {
			return todoRepository.findAllByTodoStartsWithIgnoringCase(todo); //TODO: Not working
		}
	}

	@Override
	public Mono<Todo> create(Todo todo) {
		todo.setId(Uuids.timeBased());
		return todoRepository.save(todo);
	}

}
