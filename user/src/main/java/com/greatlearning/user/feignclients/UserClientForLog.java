package com.greatlearning.user.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.user.model.AuditLog;


@FeignClient(url = "http://localhost:8087", name = "User-Client-Log")
public interface UserClientForLog {

	@PostMapping("/dataLogging")
	public String saveLog(AuditLog auditLog);

}
