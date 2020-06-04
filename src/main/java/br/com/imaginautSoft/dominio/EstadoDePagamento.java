package br.com.imaginautSoft.dominio;

public enum EstadoDePagamento {

	PEDENTE(1,"Pedente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	private final int code;
	private final String status;
	private EstadoDePagamento(int cod,String st) {
		// TODO Auto-generated constructor stub
	this.status=st;
	this.code=cod;
	}
	public String getStatus() {
		return status;
	}
	public int getCode() {
		
		return this.code;
	}
public static EstadoDePagamento toEnum(Integer cod) {
		
		if (cod==null) {
			return null;
		}
		
		for (EstadoDePagamento st:EstadoDePagamento.values()) {
		  	if(cod.equals(st.code)) {
		  	  	
		  		return st;
		  	}
		}
		throw new IllegalArgumentException("Não há um estado de pagamento com esse codigo");
	}
}
