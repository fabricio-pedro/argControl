package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imaginautSoft.dominio.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
