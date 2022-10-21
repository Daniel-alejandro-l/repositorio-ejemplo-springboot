package com.example.demo.controllers;

import com.example.demo.entities.lista_tareas;
import com.example.demo.entities.task;
import com.example.demo.services.TaskService;
import jdk.jfr.DataAmount;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Taskcontroller {
    TaskService service;
    public  Taskcontroller(TaskService service){

        this.service=service;
    }
  //  @GetMapping("/tasks")
    //public List<task> TaskList(){

      //  return  this.service.getLista();

    
    @PostMapping("/tasks")
    public  RedirectView createTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") task task, Model model){
            model.addAttribute(task);
            task.setEstado(false);
             this.service.createTask(task);
            return new RedirectView("/tasks");

    }
    @PatchMapping("/tasks/{id}")
    public  RedirectView updateTask(@PathVariable("id") Long id){
        this.service.markTaskFinished(id);
        return new RedirectView("/tasks");
    }

    @DeleteMapping("/tasks/{id}")
    public  RedirectView deleteTask(@PathVariable("id") Long id){
        this.service.deleteTask(id);
        return new RedirectView("/tasks");
    }
}
