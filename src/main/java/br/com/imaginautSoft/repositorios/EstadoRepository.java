package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imaginautSoft.dominio.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
