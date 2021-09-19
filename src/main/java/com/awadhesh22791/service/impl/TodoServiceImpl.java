package com.awadhesh22791.service.impl;

import java.util.UUID;

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
	public Flux<Todo> findAll(String todo) {
		if (todo == null || todo.isEmpty()) {
			return todoRepository.findAll();
		} else {
			return todoRepository.findAllByTodoStartsWithIgnoringCase(todo); // TODO: Not working
		}
	}

	@Override
	public Mono<Todo> create(Todo todo) {
		todo.setId(Uuids.timeBased());
		return todoRepository.save(todo);
	}

	@Override
	public Mono<Todo> findById(String id) {
		return todoRepository.findById(UUID.fromString(id));
	}

	@Override
	public Mono<Todo> toggleStatus(String id) {
		return todoRepository.findById(UUID.fromString(id)).flatMap(existingTodo -> {
			existingTodo.setCompleted(!existingTodo.isCompleted());
			return todoRepository.save(existingTodo);
		});
	}

	@Override
	public Mono<Todo> update(Todo todo) {
		return todoRepository.findById(todo.getId()).flatMap(existingTodo -> {
			existingTodo.setTodo(todo.getTodo());
			existingTodo.setCompleted(todo.isCompleted());
			return todoRepository.save(existingTodo);
		});
	}

	@Override
	public Mono<Boolean> delete(String id) {
		return todoRepository.findById(UUID.fromString(id)).flatMap(existingTodo -> {
			return todoRepository.delete(existingTodo).then(Mono.just(true));
		});
	}
}
