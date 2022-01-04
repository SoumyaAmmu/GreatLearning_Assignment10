package com.greatlearning.menuandbill.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.greatlearning.menuandbill.entity.MenuCard;
import com.greatlearning.menuandbill.entity.MonthlySalesReport;
import com.greatlearning.menuandbill.repository.MenuAndBillRepository;
import com.greatlearning.menuandbill.repository.MonthlySalesRepository;

@SpringBootTest
public class MenuAndBillServiceImplTest {

	@Mock
	MenuAndBillRepository menuAndBillRepository;
	
	@Mock
	MonthlySalesRepository monthlySalesRepository;
	
	@InjectMocks
	MenuAndBillServiceImpl menuAndBillServiceImpl;
	
	@Test
	public void shouldViewMenu() {
		List<MenuCard> menuCard = new ArrayList<>();
		menuCard.add(new MenuCard(1,"Lassi",35));
		menuCard.add(new MenuCard(2,"Apple Juice",55));
		menuAndBillServiceImpl.getMenu();
		Mockito.verify(menuAndBillRepository).findAll();
	}
	
	@Test
	public void shouldGetItemById() {
		List<MenuCard> menuCard = new ArrayList<>();
		List<Integer> seq_num = new ArrayList<>();
		menuCard.add(new MenuCard(1,"Lassi",35));
		seq_num.add(1);
		menuAndBillServiceImpl.getItemByIds(seq_num);
		Mockito.verify(menuAndBillRepository).findAllById(seq_num);
	}
	
	@Test
	public void shouldGetFinalBillBySelectingItemsbyIds() {
		List<MenuCard> menuCard = new ArrayList<>();
		List<Integer> seq_num = new ArrayList<>();
		menuCard.add(new MenuCard(1,"Lassi",35));
		menuCard.add(new MenuCard(2,"Apple Juice",55));
		//I have mocked the getItemByIds method of menuAndBillServiceImpl class
		//because the same is dependent method for getBill . Mockito is not able to communicate
		//while using menuAndBillRepository due to multi-layered dependency
		Mockito.when(menuAndBillServiceImpl.getItemByIds(seq_num)).thenReturn(menuCard);
		assertEquals(90,menuAndBillServiceImpl.getBill(menuCard));
	}
	
	@Test
	public void shouldGetMonthlySalesReport() {
		List<MonthlySalesReport> monthlySalesReport = new ArrayList<>();
		monthlySalesReport.add(new MonthlySalesReport("October2021",400000));
		menuAndBillServiceImpl.getMonthlySalesReport();
		Mockito.verify(monthlySalesRepository).findAll();
	}
	
}
