package com.greatlearning.menuandbill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.menuandbill.entity.MenuCard;

@Repository
public interface MenuAndBillRepository extends JpaRepository<MenuCard,Integer>{

}
