package com.keremk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keremk.entites.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{


	
}
