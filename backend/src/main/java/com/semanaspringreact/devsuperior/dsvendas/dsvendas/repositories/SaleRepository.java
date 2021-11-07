package com.semanaspringreact.devsuperior.dsvendas.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SaleSuccessDTO;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SaleSumDTO;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
	
	
}
