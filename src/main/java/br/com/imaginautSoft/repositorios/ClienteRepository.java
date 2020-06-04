package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imaginautSoft.dominio.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
