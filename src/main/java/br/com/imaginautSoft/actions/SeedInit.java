package br.com.imaginautSoft.actions;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.imaginautSoft.dominio.Categoria;
import br.com.imaginautSoft.dominio.Cidade;
import br.com.imaginautSoft.dominio.Estado;
import br.com.imaginautSoft.dominio.Produto;
import br.com.imaginautSoft.repositorios.CategoriaRepository;
import br.com.imaginautSoft.repositorios.CidadeRepository;
import br.com.imaginautSoft.repositorios.EstadoRepository;
import br.com.imaginautSoft.repositorios.ProdutoRepository;

@Component
public class SeedInit implements CommandLineRunner {

	private final CategoriaRepository catRep; 
	private final ProdutoRepository prodRep;
	private final CidadeRepository cidRep;
	private final EstadoRepository estRep;
	public SeedInit(CategoriaRepository repo, ProdutoRepository prodRep, CidadeRepository cidRep, EstadoRepository estRep) {
		// TODO Auto-generated constructor stub
		this.catRep=repo;
		this.prodRep=prodRep;
		this.cidRep=cidRep;
		this.estRep=estRep;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("This is simple test");
		saveCatProdut();
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
	    
	    Estado est1=new Estado(null, "Minas Gerais", "MG");
	    Estado est2=new Estado(null, "Sao Paulo", "SP");
	    
	    Cidade cid1=new Cidade(null,"Uberlandia",est1);
	    Cidade cid2=new Cidade(null,"Sao Paulo",est2);
	    Cidade cid3=new Cidade(null,"Campinas",est2);
	  	
	    est1.addCidade(cid1);
	    est2.getCidades().addAll(Arrays.asList(cid2,cid3));
	    this.estRep.saveAll(Arrays.asList(est1,est2));
	    this.estRep.delete(est1);
	  	
	}

}
