package com.play.check.dto;

import java.time.LocalDate;

public class RespostaDadosDTO {

	private Long idDados;
	private LocalDate dataRequisicao;
	private String nomeCliente;
	private Long idCliente;
	

	public Long getIdDados() {
		return idDados;
	}
	public void setIdDados(Long idDados) {
		this.idDados = idDados;
	}
	public LocalDate getDataRequisicao() {
		return dataRequisicao;
	}
	public void setDataRequisicao(LocalDate dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
