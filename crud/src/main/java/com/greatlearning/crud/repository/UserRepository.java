package com.greatlearning.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
