package com.greatlearning.menuandbill.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.menuandbill.entity.MenuCard;
import com.greatlearning.menuandbill.entity.MonthlySalesReport;
import com.greatlearning.menuandbill.repository.MenuAndBillRepository;
import com.greatlearning.menuandbill.repository.MonthlySalesRepository;
import com.greatlearning.menuandbill.service.MenuAndBillService;

@Service
public class MenuAndBillServiceImpl implements MenuAndBillService {
	
	@Autowired
	MenuAndBillRepository menuAndBillRepository;
	
	@Autowired
	MonthlySalesRepository monthlySalesRepository;
	
	
	@Override
	public List<MenuCard> getMenu() {
		return menuAndBillRepository.findAll();
	}

	@Override
	public List<MenuCard> getItemByIds(List<Integer> seq_num) {
		return menuAndBillRepository.findAllById(seq_num);
		
	}
	
	public int getBill(List<MenuCard> menucard) {
		int finalbill = 0;
		
		for (int i = 0;i < menucard.size();i++) {
			
			finalbill = finalbill + menucard.get(i).getPrice();
		}
		return finalbill;
	}
	
	public int getBillForMultipleItem(List<MenuCard> menucard, List<Integer> numberforitem) {
		int finalbill = 0;
		int missingquantityforordereditems = menucard.size() - numberforitem.size();
		
		if (missingquantityforordereditems > 0) {
			for(int indx = 0; indx < missingquantityforordereditems; indx++) {
				numberforitem.add(1);
			}
		}
		
		for (int i = 0;i < menucard.size();i++) {
						
			finalbill = finalbill + (menucard.get(i).getPrice()*numberforitem.get(i));
		}
		return finalbill;
	}
	
	public String tableBooking(int person, String bookingdate) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		Date dt = new Date();
		cal.setTime(dt);
		cal.add(Calendar.DATE, 0);
		Date currentDate = cal.getTime();
		
		cal.add(Calendar.DATE, 2);
		Date maxDate = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = sdf.parse(bookingdate);
        
        
        if(inputDate.before(currentDate)){
        	return "Sorry!!! Booking is not possible for previous date";
        }else if(inputDate.after(maxDate)) {
        	return "Sorry!!! Booking is not possible in advance for more than 2 days";
        }else {		
        	return "Table booked for " +person + " people for date " + bookingdate;
        }
	}

	@Override
	public List<MonthlySalesReport> getMonthlySalesReport() {
		return monthlySalesRepository.findAll();
	}

}
