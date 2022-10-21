package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "task")
public class task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha")
    private LocalDate fecha;



  public  task(){

  }
public task (String descripcion,boolean estado,LocalDate fecha){

    this.descripcion=descripcion;
    this.estado=estado;
    this.fecha=fecha;
}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado(){
        return this.estado;
}
public void setEstado(boolean estado){
    this.estado=estado;
}


public LocalDate getFecha(){
return this.fecha;
}
public void setFecha(LocalDate fecha){
    this.fecha=fecha;
}
}