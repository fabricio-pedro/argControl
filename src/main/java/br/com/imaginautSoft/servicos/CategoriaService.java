package br.com.imaginautSoft.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dto.CategoriaDTO;
import br.com.imaginautSoft.exceptions.DataIntregrityException;
import br.com.imaginautSoft.exceptions.ObjectNotFoundException;
import br.com.imaginautSoft.repositorios.CategoriaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository catRep;
    private final ModelMapper mapper;
	public CategoriaService(CategoriaRepository catRep, ModelMapper mapper) {
		super();
		this.catRep = catRep;
		this.mapper=mapper;
	}
	
	public Optional<Categoria> findBy(Long id) {
		Optional<Categoria> cat=catRep.findById(id);
		if(cat.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getSimpleName());
			
		}
		return cat;
	
		
	}
	
	public Categoria update(Categoria cat) { 
	Optional<Categoria> catOpt=this.findBy(cat.getId());
	return this.catRep.save(catOpt.get());	
	}

	public Categoria insert(Categoria cat) {
        cat.setId(null);
   
		// TODO Auto-generated method stub
	  return this.catRep.save(cat);
	}
	
	public List<Categoria> List(){
		
		return this.catRep.findAll();
		
	}
	
  public void delete(Long id) {
	 findBy(id);
	 try {
	  this.catRep.deleteById(id);
	 }
	 catch(DataIntegrityViolationException ex) {
		throw new DataIntregrityException("Não é possível remover uma categoria que possui produtos"); 
	 }
  }	
  
  public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	    return this.catRep.findAll(pageRequest);    
	}
  public Categoria fromCategoriaDTO(CategoriaDTO catDTO) {
	  return this.mapper.map(catDTO, Categoria.class);
	  
  }
  public CategoriaDTO fromCategoria(Categoria cat) {
	  return this.mapper.map(cat, CategoriaDTO.class);
  }
}
