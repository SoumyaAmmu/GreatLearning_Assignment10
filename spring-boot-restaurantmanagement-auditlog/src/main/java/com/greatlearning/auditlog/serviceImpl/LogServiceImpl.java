package com.greatlearning.auditlog.serviceImpl;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.auditlog.entity.AuditLog;
import com.greatlearning.auditlog.repository.AuditRepository;
import com.greatlearning.auditlog.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	AuditRepository auditRepository;
	
	@Override
	public String addLog(AuditLog auditLog) {
		auditRepository.saveAndFlush(auditLog);
		return "Saved successfully";
		
	}
	
}
