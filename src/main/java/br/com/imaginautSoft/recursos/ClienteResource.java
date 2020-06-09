package br.com.imaginautSoft.recursos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.imaginautSoft.dominio.Cliente;
import br.com.imaginautSoft.exceptions.ResourceException;
import br.com.imaginautSoft.servicos.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteResource {

	private final ClienteService cliServ;

	public ClienteResource(ClienteService cliServ) {
		super();
		this.cliServ = cliServ;
	}
	
	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE )
	public Cliente buscaCliente (@PathVariable Long id){
	    StringBuilder msgError=new StringBuilder();	
        Optional<Cliente> clienteOp=cliServ.BuscaCliente(id);
        if(clienteOp.isEmpty()) {
        	msgError.append("O recurso ")
        	.append(Cliente.class.getSimpleName())
        	.append(" com id: ")
        	.append(id)
        	.append(" não foi encontrado");
        	
        }
        
		return clienteOp.orElseThrow(()-> new ResourceException(HttpStatus.NOT_FOUND, msgError.toString()));
		
	} 
	
	
	
}
