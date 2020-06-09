package br.com.imaginautSoft.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.imaginautSoft.dominio.Cliente;
import br.com.imaginautSoft.repositorios.ClienteRepository;

@Service
public class ClienteService {
 
private final ClienteRepository cliRep;

public ClienteService(ClienteRepository cliRep) {
	super();
	this.cliRep = cliRep;
}

public Optional<Cliente> BuscaCliente(Long id){
	
	return this.cliRep.findById(id);
	
}
 
}
