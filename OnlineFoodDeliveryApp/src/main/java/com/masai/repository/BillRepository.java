package com.masai.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
	
@Query("SELECT b FROM Bill b WHERE b.billDate BETWEEN :startDate AND :endDate")
public List<Bill> viewBillByDateRange(LocalDate startDate, LocalDate endDate);
  
}
