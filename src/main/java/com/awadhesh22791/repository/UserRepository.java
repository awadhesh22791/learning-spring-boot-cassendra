package com.awadhesh22791.repository;
import java.util.UUID;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.awadhesh22791.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User, UUID> {

	Mono<User> findByUsername(String todo);

	Flux<User> findAllByUsernameStartsWithIgnoringCase(String username);

}