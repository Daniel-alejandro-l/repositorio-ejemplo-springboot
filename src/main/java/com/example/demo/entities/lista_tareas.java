package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class lista_tareas {
    private String Nombre;
    private List<task> lista_tareas;

    public lista_tareas(String Nombre) {
        this.setNombre(Nombre);
        this.lista_tareas=new ArrayList<>();
    }
    public void  addTask(task task){
        this.lista_tareas.add(task);
    }
    public  List<task> getList(){
        return  this.lista_tareas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}

