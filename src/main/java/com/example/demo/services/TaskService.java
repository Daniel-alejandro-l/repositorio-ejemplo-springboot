package com.example.demo.services;

import com.example.demo.entities.lista_tareas;
import com.example.demo.entities.task;
import com.example.demo.repositories.TaskRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRespository respository;

    public  TaskService(TaskRespository respository){
                this.respository=respository;
    }

    public List<task> getLista(){
        return  this.respository.findAll();
    }
    public  task createTask(task newTask){
        return  this.respository.save(newTask);
    }
    public  Boolean markTaskFinished(Long id){
        Optional<task> task=this.respository.findById(id);
        if (task.isPresent()){
            task.get().setEstado(true);
            this.respository.save(task.get());
            return true;
        }
        return false;

    }
    public  Boolean deleteTask(Long id){
        this.respository.deleteById(id);
        return true;
    }
}
