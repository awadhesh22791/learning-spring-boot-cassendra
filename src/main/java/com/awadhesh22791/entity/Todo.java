package com.awadhesh22791.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Todo {
	@PrimaryKey
	private UUID id;
	private String todo;
	private boolean completed;
}
