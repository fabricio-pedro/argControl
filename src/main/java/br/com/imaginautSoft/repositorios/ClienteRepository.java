package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imaginautSoft.dominio.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

  public Cliente findByEmail(String email);	
}
