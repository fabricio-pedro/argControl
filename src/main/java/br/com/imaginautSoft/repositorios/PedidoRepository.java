package br.com.imaginautSoft.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imaginautSoft.dominio.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
