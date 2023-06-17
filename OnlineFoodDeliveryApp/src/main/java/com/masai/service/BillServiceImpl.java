package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.BillException;
import com.masai.exception.CategoryException;
import com.masai.model.Bill;
import com.masai.model.Item;
import com.masai.model.OrderDetails;
import com.masai.repository.BillRepository;
import com.masai.repository.OrderRepository;

@Service
public class BillServiceImpl implements BillService{
  
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private OrderRepository orderRepository;


	@Override
	public Bill addBill(Bill bill, Integer orderId) {
		
		if(bill==null) {
			throw new BillException("bill details should not null");
		}
		OrderDetails order = orderRepository.findById(orderId).orElseThrow(()-> new BillException("No Order present with this Order Id"));
         
		bill.setOrder(order);
		
		return billRepository.save(bill);
	}



	@Override
	public Bill updateBill(Integer billId, Integer totalItem, double totalCost) {
		// TODO Auto-generated method stub
	
		Bill billupdate = billRepository.findById(billId).orElseThrow(()-> new BillException("No Bill present with this Bill Id"));
         
		billupdate.setTotalCost(totalCost);
		billupdate.setTotalItem(totalItem);
		
		
		return billRepository.save(billupdate);
	}





	@Override
	public Bill removeBill(Bill bill) {
		// TODO Auto-generated method stub
	if(bill==null) {
		throw new BillException("bill details should not null");
	}
	
	Bill fordelet= billRepository.findById(bill.getBillId()).orElseThrow(()-> new BillException("no bill present with this bill id"));
	
	   billRepository.delete(fordelet);
	   
	   return fordelet;
	
	}



	@Override
	public Bill viewBill(Bill bill) {
		// TODO Auto-generated method stub
		
		if(bill==null) {
			throw new BillException("bill should not be null");
		}
		
	Optional<Bill> opt=	billRepository.findById(bill.getBillId());
	
	if(opt.isEmpty()) {
	throw new BillException("bill is empty");
	}
	
	Bill viewbill= opt.get();
		return viewbill;
	}


	@Override
 	public List<Bill> viewBillByDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		
		if(startDate==null && endDate==null) {
			throw new BillException(" plse provide proper date");
		}
		
	List<Bill>  billdateRange=	billRepository.viewBillByDateRange(startDate, endDate);
		
		
	if(billdateRange.isEmpty()) {
		throw new BillException("bill is empty");
	}
		return billdateRange;
	}


	@Override
	public List<Bill> viewBill(Integer customerId) {
		// TODO Auto-generated method stub
		
       Pageable pageable = PageRequest.of(0,5, Sort.by("categoryName").ascending());
		
		List<Bill> bill = billRepository.findAll(pageable).getContent();
		if(bill.isEmpty()) throw new CategoryException("category list is Empty");
		return bill;
		
	
	}



//@Override
//public List<Bill> viewBillByDateRange(LocalDate startDate, LocalDate endDate) {
//	// TODO Auto-generated method stub
//	return null;
//}

	
}
