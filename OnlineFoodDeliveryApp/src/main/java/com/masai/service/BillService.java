package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.model.Bill;

public interface BillService {
   
	
	public Bill addBill(Bill bill, Integer orderId);
	
	public Bill updateBill(Integer billId, Integer totalItem, double totalCost);
	
	public Bill removeBill(Bill bill);
	
	public Bill viewBill(Bill bill);
	
	public List<Bill> viewBillByDateRange(LocalDate startDate, LocalDate endDate);
	
	public List<Bill> viewBill(Integer customerId);
	

}
