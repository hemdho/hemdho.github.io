package com.adi.taskmanagement.controller;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adi.taskmanagement.entity.Task;
import com.adi.taskmanagement.repository.TaskRepository;

@RestController
public class TaskController {

	
	@Autowired
	TaskRepository repo;
	
	@PostMapping("/tasks")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createTask() {
		
		Task task = new Task();
		task.setName("Hemant");
		task.setDescription("Hemant Test");
		task.setStatus("Active");
		task.setCreatedDate(OffsetDateTime.now());
		task=repo.save(task);
		System.out.println(task.getId());
		System.out.println(" Created a task");
	}
	
	@PutMapping("/tasks/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void updateTask(@PathVariable int id,@RequestBody Task task) {
		repo.save(task);
	
	}
	
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable int id) {
		Task task = repo.getOne(id);
		repo.delete(task);
		//System.out.println("Task Updated deleted" + id);
	}
	
	@GetMapping("/tasks")
	@ResponseStatus(value=HttpStatus.OK)
	public List<Task> getTasks() {
		return repo.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public Task getTasksById(@PathVariable int id) {
		Optional<Task> optionTask=repo.findById(id);
		return optionTask.get() ;
	}
	
}
