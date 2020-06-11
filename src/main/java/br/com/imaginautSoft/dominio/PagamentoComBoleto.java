package br.com.imaginautSoft.dominio;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class PagamentoComBoleto extends Pagamento {
    
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataVencimento;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPagamento;
	public PagamentoComBoleto() {
		// TODO Auto-generated constructor stub
	}
	public PagamentoComBoleto(Long id, EstadoDePagamento estadoPg, Pedido pedido) {
		super(id, estadoPg, pedido);
		this.dataPagamento=dataPagamento;
		this.dataVencimento=dataVencimento;
		// TODO Auto-generated constructor stub
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
}
