package com.awadhesh22791.entity;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Table
@Data
public class Todo {
	@PrimaryKey
	private UUID id;
	private String todo;
	private boolean completed;
}
