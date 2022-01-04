package com.greatlearning.auditlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.auditlog.entity.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Integer>{

}
