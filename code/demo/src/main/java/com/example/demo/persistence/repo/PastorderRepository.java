package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entity.Pastorder;

public interface PastorderRepository extends JpaRepository<Pastorder,Integer>{

}
