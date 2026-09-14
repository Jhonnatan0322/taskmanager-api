package com.tatandev.taskmanager.service;

import com.tatandev.taskmanager.entity.Task;
import com.tatandev.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> obtenerTodas(){

        return taskRepository.findAll();
    }

    public Task crearTarea(Task nuevaTarea){
        return taskRepository.save(nuevaTarea);
    }

    public Task obtenerPorId(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task actualizarTarea(Long id, Task datosActualizados){
        Task tareaExistente = obtenerPorId(id);
        if(tareaExistente != null){
            tareaExistente.setTitle(datosActualizados.getTitle());
            tareaExistente.setCompleted(datosActualizados.isCompleted());
            return taskRepository.save(tareaExistente);

        }
        return null;
    }

    public void eliminarTarea(Long id){
        taskRepository.deleteById(id);

    }
}
