package br.com.alura.gerenciador2.modelo;

import java.util.Date;

public class Company {
	
	private Integer id;
	private String nome;
	private Date dateOpen = new Date();
	
	public Date getDateOpen() {
		return dateOpen;
	}
	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
