package br.com.imaginautSoft.actions;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dominio.Cidade;
import br.com.imaginautSoft.dominio.Cliente;
import br.com.imaginautSoft.dominio.Endereco;
import br.com.imaginautSoft.dominio.Estado;
import br.com.imaginautSoft.dominio.Produto;
import br.com.imaginautSoft.repositorios.CategoriaRepository;
import br.com.imaginautSoft.repositorios.CidadeRepository;
import br.com.imaginautSoft.repositorios.ClienteRepository;
import br.com.imaginautSoft.repositorios.EstadoRepository;
import br.com.imaginautSoft.repositorios.ProdutoRepository;

@Component
public class SeedInit implements CommandLineRunner {

	private final CategoriaRepository catRep; 
	private final ProdutoRepository prodRep;
	private final CidadeRepository cidRep;
	private final EstadoRepository estRep;
	private final ClienteRepository cliRep;
	public SeedInit(CategoriaRepository repo, ProdutoRepository prodRep, CidadeRepository cidRep, EstadoRepository estRep, ClienteRepository cliRep) {
		// TODO Auto-generated constructor stub
		this.catRep=repo;
		this.prodRep=prodRep;
		this.cidRep=cidRep;
		this.estRep=estRep;
		this.cliRep=cliRep;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("This is simple test");
		saveCatProdut();
		saveCidadesEstados();
		saveClienteEndereco();
	}
	private void saveCatProdut() {
	  	Categoria cat1=new Categoria(null, "informatica");
	  	Categoria cat2=new Categoria(null, "escritorio");
	  	Produto prod1=new Produto(null, "computador", 2000.00);
	  	Produto prod2=new Produto(null, "impressora", 800.00);
	  	Produto prod3=new Produto(null, "mouse", 80.00);
	  	//cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
	  	//cat2.addOneProduto(prod2);
	  	prod1.getCategorias().add(cat1);
	  	prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	  	prod3.getCategorias().add(cat1);
	  	this.prodRep.saveAll(Arrays.asList(prod1,prod2,prod3));
	    
	    
	 
	  	
	}
	
	private void saveCidadesEstados() {
		Estado est1=new Estado(null, "Minas Gerais", "MG");
	    Estado est2=new Estado(null, "Sao Paulo", "SP");
	    
	    Cidade cid1=new Cidade(null,"Uberlandia",est1);
	    Cidade cid2=new Cidade(null,"Sao Paulo",est2);
	    Cidade cid3=new Cidade(null,"Campinas",est2);
	    est1.addCidade(cid1);
	    est2.getCidades().addAll(Arrays.asList(cid2,cid3));
	    this.estRep.saveAll(Arrays.asList(est1,est2));
		
	}
  private void saveClienteEndereco() {
	   Cliente cli=new Cliente(null,"Maria Silva","mariasilva@gmail.com","36378912377",1);
	    cli.addtelefone("34988459325");
	    Optional<Estado> estadoCliEstado=this.estRep.findById(1l);
	    Cidade cid=estadoCliEstado.get().getCidades().get(0);
	    Endereco end = new Endereco(null, "Rua Flores", "300", "apto 103", "Jardim", "38220834", cid, cli);
	    Endereco end2 = new Endereco(null, "Avenida Matos", "105", "apto 103", "Centro", "38777012", cid, cli);
	    cli.addEndereco(end);
	    cli.addEndereco(end2);
	    this.cliRep.save(cli);
  }

}
