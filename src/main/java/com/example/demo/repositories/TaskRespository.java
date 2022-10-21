package com.example.demo.repositories;

import com.example.demo.entities.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRespository extends JpaRepository<task,Long> {
}
