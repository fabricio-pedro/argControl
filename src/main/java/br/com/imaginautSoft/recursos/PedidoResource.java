package br.com.imaginautSoft.recursos;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.imaginautSoft.dominio.Pedido;
import br.com.imaginautSoft.exceptions.ResourceException;
import br.com.imaginautSoft.servicos.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	
	private final PedidoService pedServ;
	
	public PedidoResource(PedidoService serv) {
		super();
		this.pedServ = serv;
	}
	@ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pedido findPedido (@PathVariable("id")Long id) {
		Optional<Pedido> pedOpt=this.pedServ.find(id);
	    StringBuilder msgError = new StringBuilder();
	    if(pedOpt.isEmpty()) {
	     msgError.append("O recurso ")
	     .append(Pedido.class.getSimpleName())
	     .append(" com id:"+id)
	     .append(" não foi encontrado");
	     
	    }
	    return pedOpt.orElseThrow(()-> new ResourceException(HttpStatus.NOT_FOUND, msgError.toString()));
	}

}
