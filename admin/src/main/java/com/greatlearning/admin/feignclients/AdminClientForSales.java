package com.greatlearning.admin.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.greatlearning.admin.model.MonthlySalesReport;

@FeignClient(url = "http://localhost:8086", name = "Admin-Client-For-Sale")
public interface AdminClientForSales {
	
	@GetMapping("/getMonthlySalesReport")
	public List<MonthlySalesReport> getMonthlySalesReport();
}
