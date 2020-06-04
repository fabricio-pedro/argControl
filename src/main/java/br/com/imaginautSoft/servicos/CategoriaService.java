package br.com.imaginautSoft.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.repositorios.CategoriaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository catRep;

	public CategoriaService(CategoriaRepository catRep) {
		super();
		this.catRep = catRep;
	}
	
	public Optional<Categoria> buscarPor(Long id) {
		Optional<Categoria> cat=catRep.findById(id);
		return cat;
	
		
	}
	
	
	
	
}
