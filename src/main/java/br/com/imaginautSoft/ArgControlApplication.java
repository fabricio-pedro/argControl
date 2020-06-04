package br.com.imaginautSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.imaginautSoft.dominio.TipoCliente;

@SpringBootApplication
public class ArgControlApplication {

	public static void main(String[] args) {
		Integer x = null;
		SpringApplication.run(ArgControlApplication.class, args);
		var t=TipoCliente.toEnum(x);
	}

}
