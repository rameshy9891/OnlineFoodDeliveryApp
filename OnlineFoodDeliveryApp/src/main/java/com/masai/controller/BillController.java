package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Bill;
import com.masai.service.BillService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class BillController {
	
	@Autowired
	private BillService billservice;
	
	@PostMapping("/bill/{orderId}")
	public ResponseEntity<Bill> addBillHandler(@RequestBody @Valid Bill bill,Integer orderId){
		
	Bill addedbill=	billservice.addBill(bill, orderId);
		return new ResponseEntity<>(addedbill,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/bills/{totalItem}/{totalCost}")
	public ResponseEntity<Bill> updateBillHandler(@RequestBody @Valid Bill billId,Integer totalItem,double totalCost){
		
	Bill updatedbill=	billservice.updateBill(totalItem, totalItem, totalCost);
		return new ResponseEntity<>(updatedbill,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/bill/{billId}")
	public ResponseEntity<Bill> deleteBillHandler(@RequestBody @Valid Bill bill){
		
	Bill deleteBill=	billservice.removeBill(bill);
		return new ResponseEntity<>(deleteBill,HttpStatus.OK);
		
	}
	

	@GetMapping("/bill/{billId}")
	public ResponseEntity<Bill> viewBillHandler(@RequestBody @Valid Bill bill){
		
	Bill viewBill=	billservice.viewBill(bill);
		return new ResponseEntity<>(viewBill,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/startDate")
	public ResponseEntity<List<Bill>> viewBillDateRange(@RequestParam("startDate") LocalDate startDate,@RequestParam("endDate") LocalDate endDate){
		
		List<Bill>  allbill= billservice.viewBillByDateRange(startDate, endDate);
		
		return new ResponseEntity<>(allbill,HttpStatus.OK);
		
	}
	
	@GetMapping("/customerId")
	public ResponseEntity<List<Bill>> viewBillByCustomerHandler(@PathVariable Integer customerId){
		
		List<Bill> allBill=billservice.viewBill(customerId);
		
		return new ResponseEntity<List<Bill>>(allBill,HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
