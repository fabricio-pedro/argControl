package br.com.imaginautSoft.recursos;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.exceptions.ResourceException;
import br.com.imaginautSoft.servicos.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
   
	private final CategoriaService catS;
	public CategoriaResource(CategoriaService catS) {
		this.catS=catS;
		// TODO Auto-generated constructor stub
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Categoria buscaCategoria(@PathVariable Long id) {
		StringBuilder messageBuilder = new StringBuilder();
		Optional<Categoria> catOp=catS.buscarPor(id);
		if(catOp.isEmpty()) {
		 messageBuilder.append("O recurso ")
		  .append(Categoria.class.getSimpleName())
		  .append(" com id:")
		  .append(id)
		  .append(" não foi encontrado");
		}
		return catOp.orElseThrow(()->new ResourceException(HttpStatus.NOT_FOUND, messageBuilder.toString()) );
			
		
		
		}
		
	
	
	@GetMapping
	public String listar() {
		// TODO Auto-generated method stub
         return "Service rest is working";
	}
}