package com.tatandev.taskmanager.service;

import com.tatandev.taskmanager.dto.TaskDTO;
import com.tatandev.taskmanager.entity.Task;
import com.tatandev.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> obtenerTodas(){
        List<Task> tareas = taskRepository.findAll();
        List<TaskDTO> tareasDto = new ArrayList<>();

       for(Task t: tareas){
           TaskDTO task = convertirADto(t);

           tareasDto.add(task);
       }
       return tareasDto;
    }

    public Task crearTarea(Task nuevaTarea){

        return taskRepository.save(nuevaTarea);
    }

    public TaskDTO obtenerPorId(Long id){

        Task registro = taskRepository.findById(id).orElse(null);


        if(registro != null){
            TaskDTO dataReponse = convertirADto(registro);
            return dataReponse;
        }
        return null;
    }

    public Task obtenerPorIdEntity(Long id){

        return taskRepository.findById(id).orElse(null);
    }

    public Task actualizarTarea(Long id, Task datosActualizados){
        Task tareaExistente = obtenerPorIdEntity(id);
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

    public TaskDTO convertirADto(Task tarea){
        TaskDTO task = new TaskDTO(tarea.getId(),tarea.getTitle(),tarea.isCompleted());
        return task;
    }


}
