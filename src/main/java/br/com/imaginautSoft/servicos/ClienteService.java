package br.com.imaginautSoft.servicos;

import java.util.Optional;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import br.com.imaginautSoft.dominio.Cidade;
import br.com.imaginautSoft.dominio.Cliente;
import br.com.imaginautSoft.dominio.Endereco;
import br.com.imaginautSoft.dominio.TipoCliente;
import br.com.imaginautSoft.dto.ClienteDTO;
import br.com.imaginautSoft.dto.ClienteNewDTO;
import br.com.imaginautSoft.repositorios.CidadeRepository;
import br.com.imaginautSoft.repositorios.ClienteRepository;

@Service
public class ClienteService {
 
private final ClienteRepository cliRep;
private final CidadeRepository cidRep;

public ClienteService(ClienteRepository cliRep, CidadeRepository cidRep) {
	super();
	this.cliRep = cliRep;
	this.cidRep=cidRep;
}

public Optional<Cliente> find(Long id){
	
	return this.cliRep.findById(id);
	
}

public Cliente fromDTO(ClienteNewDTO cliDTO) {
  	Cliente cli=new Cliente(null,cliDTO.getNome() ,cliDTO.getEmail(),cliDTO.getCpfOuCnpj(),cliDTO.getTipo());
    Optional<Cidade> cidOp=cidRep.findById(cliDTO.getCidadeId());
  	Endereco end=new Endereco(null,cliDTO.getLogradouro(), cliDTO.getNumero(),cliDTO.getComplemento(),cliDTO.getBairro(), cliDTO.getCep(), cidOp.get());
   cli.addEndereco(end);
  	return cli;
	
}
 
}
