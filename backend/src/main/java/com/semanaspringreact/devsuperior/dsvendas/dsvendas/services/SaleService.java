package com.semanaspringreact.devsuperior.dsvendas.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SaleDTO;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.entities.Sale;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.repositories.SaleRepository;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		//Converte o List <Seller> para List <SellerDTO>
		return result.map(x -> new SaleDTO(x));
	}
}
