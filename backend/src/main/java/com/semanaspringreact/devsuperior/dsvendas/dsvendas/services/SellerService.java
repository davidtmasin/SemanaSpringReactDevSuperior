package com.semanaspringreact.devsuperior.dsvendas.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semanaspringreact.devsuperior.dsvendas.dsvendas.dto.SellerDTO;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.entities.Seller;
import com.semanaspringreact.devsuperior.dsvendas.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	//Lista de SellersDTO
	public List<SellerDTO> findAll(){
		List<Seller> result = sellerRepository.findAll();
		//Converte o List <Seller> para List <SellerDTO>
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
}
