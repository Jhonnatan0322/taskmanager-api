package com.tatandev.taskmanager;

import com.tatandev.taskmanager.dto.TaskDTO;
import com.tatandev.taskmanager.entity.Task;
import com.tatandev.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/api/tasks/saludo")
    public String saludar(){
        return  "Task Manager API funcionando";
    }

    @GetMapping("/api/tasks/ejemplo")
    public Task obtenerTareaEjemplo(){
        Task tarea = new Task("Tarea de prueba");
        return tarea;
    }

    @GetMapping("/api/tasks")
    public List<TaskDTO> obtenerTodasLasTareas(){
        return taskService.obtenerTodas();
    }

    @PostMapping("/api/tasks")
    public Task crearTarea(@Valid @RequestBody Task nuevaTarea){
        return taskService.crearTarea(nuevaTarea);
    }

    @GetMapping("/api/tasks/{id}")
    public TaskDTO obtenerTareaPorId(@PathVariable Long id){
        return taskService.obtenerPorId(id);
    }

    @PutMapping("/api/tasks/{id}")
    public Task actualizarTarea(@PathVariable Long id,@Valid @RequestBody Task datosActualizados){
        return taskService.actualizarTarea(id,datosActualizados);
    }

    @DeleteMapping("/api/tasks/{id}")
    public void eliminarTarea(@PathVariable Long id){
        taskService.eliminarTarea(id);
    }

}
