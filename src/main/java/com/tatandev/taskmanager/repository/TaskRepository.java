package com.tatandev.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tatandev.taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
