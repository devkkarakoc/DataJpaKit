package com.keremk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keremk.entites.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
 
}
