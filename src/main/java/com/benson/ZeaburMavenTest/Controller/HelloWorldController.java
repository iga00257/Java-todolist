package com.benson.ZeaburMavenTest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    private List<String> todos = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<List<String>> getAllTodos() {
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addTodo(@RequestBody String todo) {
        todos.add(todo);
        return new ResponseEntity<>("{\"message\": \"Todo added successfully\"}", HttpStatus.CREATED);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteTodo(@PathVariable int index) {
        if (index >= todos.size()) {
            return new ResponseEntity<>("{\"message\": \"Todo not found\"}", HttpStatus.NOT_FOUND);
        }
        todos.remove(index);
        return new ResponseEntity<>("{\"message\": \"Todo deleted successfully\"}", HttpStatus.OK);
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> updateTodo(@PathVariable int index, @RequestBody String todo) {
        if (index >= todos.size()) {
            return new ResponseEntity<>("{\"message\": \"Todo not found\"}", HttpStatus.NOT_FOUND);
        }
        todos.set(index, todo);
        return new ResponseEntity<>("{\"message\": \"Todo updated successfully\"}", HttpStatus.OK);
    }
}