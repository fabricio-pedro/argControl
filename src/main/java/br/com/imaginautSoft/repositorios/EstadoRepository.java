package br.com.imaginautSoft.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.imaginautSoft.dominio.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    //@EntityGraph(attributePaths = "cidades")
	@Query(value="select e from Estado e join fetch e.cidades c where e.id=:id")
	Optional<Estado> findById(@Param("id") Long id);
	
}
