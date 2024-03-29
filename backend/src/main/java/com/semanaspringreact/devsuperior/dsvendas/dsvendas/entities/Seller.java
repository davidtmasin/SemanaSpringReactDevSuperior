package com.semanaspringreact.devsuperior.dsvendas.dsvendas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sellers")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;	
	
	@OneToMany(mappedBy = "seller") //Implementando a associação de várias sales para um seller
	private List<Sale> sales = new ArrayList<>();
	
	//Construtores default e com argumentos
	public Seller() {}
		
	public Seller(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//Métodos Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setNameSeller(String name) {
		this.name = name;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
}
