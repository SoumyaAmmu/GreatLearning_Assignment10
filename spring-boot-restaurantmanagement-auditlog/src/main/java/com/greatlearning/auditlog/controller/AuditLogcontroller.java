package com.greatlearning.auditlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.auditlog.entity.AuditLog;
import com.greatlearning.auditlog.serviceImpl.LogServiceImpl;

@RestController
public class AuditLogcontroller {

	@Autowired
	LogServiceImpl logServiceImpl;
	
	@PostMapping("/dataLogging")
	public String saveLog(@RequestBody AuditLog auditLog) {
		return logServiceImpl.addLog(auditLog);
	}
	
	
}
