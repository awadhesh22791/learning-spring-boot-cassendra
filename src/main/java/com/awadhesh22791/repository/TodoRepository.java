package com.awadhesh22791.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.awadhesh22791.entity.Todo;

import reactor.core.publisher.Flux;

@Repository
public interface TodoRepository extends ReactiveCassandraRepository<Todo, UUID> {

	Flux<Todo> findAllByTodoStartsWithIgnoringCase(String todo);

}
