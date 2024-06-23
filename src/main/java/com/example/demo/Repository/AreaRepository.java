package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AreaEntity;

public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {

}
