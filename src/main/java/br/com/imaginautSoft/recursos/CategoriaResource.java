package br.com.imaginautSoft.recursos;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dto.CategoriaDTO;
import br.com.imaginautSoft.servicos.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
   
	private final ModelMapper mapper;
	private final CategoriaService catS;
	public CategoriaResource(CategoriaService catS, ModelMapper mapper) {
		this.mapper=mapper;
		this.catS=catS;
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> find(@PathVariable Long id) {
		Optional<Categoria> obj = catS.findBy(id);
		return ResponseEntity.ok().body(obj.get());
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>  insert(@RequestBody Categoria cat){
	Categoria categoria=this.catS.insert(cat);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
		    .path("/{id}").buildAndExpand(categoria.getId()).toUri();
	
	return ResponseEntity.created(uri).build();
		
		
	}

  @PutMapping(path = "/{id}")	
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Categoria cat){
    Categoria categoria=cat;
    cat.setId(id);
    this.catS.update(categoria);
    return ResponseEntity.noContent().build();
	  
  }
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>>  findAll() {
		// TODO Auto-generated method stub
		List<Categoria> categorias=this.catS.List();
		List<CategoriaDTO> catPro=new ArrayList<>();
		
		for(Categoria cat:categorias ) {
			CategoriaDTO catP= this.mapper.map(cat, CategoriaDTO.class);
			catPro.add(catP);
		}
		
		
		return ResponseEntity.ok().body(catPro);
         
	}
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id){
	catS.delete(id);
	return ResponseEntity.noContent().build();
	  
  }
}
