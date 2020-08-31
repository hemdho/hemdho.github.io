package com.adi.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adi.taskmanagement.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {

}
