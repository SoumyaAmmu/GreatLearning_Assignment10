package com.greatlearning.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.crud.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,Long> {

}
