package com.play.check.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dado_requisicao")
public class DadoRequisicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@Column(name = "data_requisicao")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataRequisicao;

	
	@PrePersist
	public void prePrersist() {
		setDataRequisicao(LocalDate.now());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDate getDataRequisicao() {
		return dataRequisicao;
	}


	public void setDataRequisicao(LocalDate dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}
	
}
