package com.example.todo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.todo.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

	//void updateById(Integer id, Todo todo);

}
