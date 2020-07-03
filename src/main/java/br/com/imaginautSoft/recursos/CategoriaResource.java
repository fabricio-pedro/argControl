package br.com.imaginautSoft.recursos;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dto.CategoriaDTO;
import br.com.imaginautSoft.servicos.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
   

	private final CategoriaService catS;
	public CategoriaResource(CategoriaService catS) {
		
		this.catS=catS;
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> find(@PathVariable Long id) {
		Optional<Categoria> obj = catS.findBy(id);
		return ResponseEntity.ok().body(obj.get());
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>  insert(@Valid  @RequestBody CategoriaDTO catDto){
	Categoria cat=this.catS.fromCategoriaDTO(catDto);
	Categoria categoria=this.catS.insert(cat);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
		    .path("/{id}").buildAndExpand(categoria.getId()).toUri();
	
	return ResponseEntity.created(uri).build();
		
		
	}

  @PutMapping(path = "/{id}")	
  public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody CategoriaDTO catDto){
    
	Categoria categoria=this.catS.fromCategoriaDTO(catDto);
    categoria.setId(id);
    this.catS.update(categoria);
    return ResponseEntity.noContent().build();
	  
  }
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>>  findAll() {
		// TODO Auto-generated method stub
		List<Categoria> categorias=this.catS.List();
		List<CategoriaDTO> catPro=new ArrayList<>();
		
		for(Categoria cat:categorias ) {
			CategoriaDTO catP= this.catS.fromCategoria(cat);
			catPro.add(catP);
		}
		
		
		return ResponseEntity.ok().body(catPro);
         
	}
	
	@DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id){
	catS.delete(id);
	return ResponseEntity.noContent().build();
	  
    }
	@GetMapping(value="/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Categoria> list = catS.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(cat-> this.catS.fromCategoria(cat));
		
		return ResponseEntity.ok().body(listDto);
	
	
}

}