package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imaginautSoft.dominio.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
