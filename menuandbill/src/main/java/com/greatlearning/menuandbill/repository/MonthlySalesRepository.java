package com.greatlearning.menuandbill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.menuandbill.entity.MonthlySalesReport;

@Repository
public interface MonthlySalesRepository extends JpaRepository<MonthlySalesReport,String> {

}
