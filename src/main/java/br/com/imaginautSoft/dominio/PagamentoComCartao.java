package br.com.imaginautSoft.dominio;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {

	private Integer numeroParcelas;
	public PagamentoComCartao() {
		// TODO Auto-generated constructor stub
	}
	public PagamentoComCartao(Long id, EstadoDePagamento estadoPg, Pedido pedido) {
		super(id, estadoPg, pedido);
		this.numeroParcelas=numeroParcelas;
		// TODO Auto-generated constructor stub
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
}
