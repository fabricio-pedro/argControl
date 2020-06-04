package br.com.imaginautSoft.dominio;

public enum TipoCliente {
 
	PESSOAFISICA(1,"Pessoa_Fisica"),
	PESSOAJURIDICA(2,"Pessoa_Juridica");
    private  int code; 
	private  String tipo;
	TipoCliente(int cod,String tp) {
		// TODO Auto-generated constructor stub
	this.tipo=tp;
    this.code=cod;
	}
	public String getTipo() {
		return tipo;
	}
	public int getCode() {
	
		return this.code;
		
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod==null) {
			return null;
		}
		
		for (TipoCliente t:TipoCliente.values()) {
		  	if(cod.equals(t.code)) {
		  	  	
		  		return t;
		  	}
		}
		throw new IllegalArgumentException("Não há um tipoCliente com esse codigo");
	}
	
}
