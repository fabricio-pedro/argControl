package br.com.imaginautSoft.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dominio.Pedido;
import br.com.imaginautSoft.repositorios.PedidoRepository;

@Service
public class PedidoService {

	private final PedidoRepository pedRep;

	public PedidoService(PedidoRepository pedRep) {
		super();
		this.pedRep = pedRep;
	}
	
	public Optional<Pedido> buscarPor(Long id) {
		Optional<Pedido> pedido=pedRep.findById(id);
		return pedido;
	
		
	}
	
	
	
	
}
