package br.com.imaginautSoft.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Pedido implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime instante;
	
	@OneToMany(mappedBy = "id.pedido",cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<ItemPedido> itens=new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_endereco_entrega")
	private Endereco enderecoDeEntrega;
	@ManyToOne
	@JoinColumn(name="id_cliente")
    private Cliente cliente;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Pedido(Long id, LocalDateTime instante, Pagamento pagamento, Endereco enderecoDeEntrega, Cliente cliente) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public void setInstante(LocalDateTime instante) {
		this.instante = instante;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	public Pagamento getPagamento() {
		return pagamento;
    }
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}
	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
   public void additemDePedido(ItemPedido item) {
	  this.itens.add(item); 
	   
   }
   public void removeItemDePedido(ItemPedido item) {
	   this.itens.remove(item);
	   
   }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
