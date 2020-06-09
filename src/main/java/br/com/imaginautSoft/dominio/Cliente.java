package br.com.imaginautSoft.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

@Entity
public class Cliente {

 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
 private Long id;
 private String nome;
 @Email
 private String email;
 private String cnpjOuCpf;
 @Enumerated(EnumType.ORDINAL)
 private TipoCliente tipoCli;
 @ElementCollection
 @CollectionTable(name="telefones_cliente", joinColumns = @JoinColumn(name="cliente_id"))
 @Column(name = "telefone")
 private Set<String> telefones=new HashSet<>();	
 @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
 private List<Endereco> enderecos=new ArrayList<>();
 @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
 private List<Pedido> pedidos=new ArrayList<>();
 public Cliente() {
	// TODO Auto-generated constructor stub
}
 
 public Cliente(Long id, String nome, @Email String email, String cnpjOuCpf, int tipoCliente) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.cnpjOuCpf = cnpjOuCpf;
	this.tipoCli = TipoCliente.toEnum(tipoCliente);
}
public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
}
 public String getNome() {
	return nome;
 }
 public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCnpjOuCpf() {
	return cnpjOuCpf;
}
public void setCnpjOuCpf(String cnpjOuCpf) {
	this.cnpjOuCpf = cnpjOuCpf;
}
public TipoCliente getTipoCli() {
	return tipoCli;
}
public void setTipoCli(TipoCliente tipoCli) {
	this.tipoCli = tipoCli;
}
public Set<String> getTelefones() {
	return telefones;
}
public void setTelefones(Set<String> telefones) {
	this.telefones = telefones;
}
public List<Endereco> getEnderecos() {
	return enderecos;
}
public void setEnderecos(List<Endereco> enderecos) {
	this.enderecos = enderecos;
}
 public List<Pedido> getPedidos() {
	return pedidos;
}
public void setPedidos(List<Pedido> pedidos) {
	this.pedidos = pedidos;
}
public void addEndereco(Endereco end) {
 this.enderecos.add(end); 
 }
public void addPedido(Pedido ped) {
  this.pedidos.add(ped);	
	
}

public void removePedido(Pedido ped) {
	this.pedidos.remove(ped);
}

public void addtelefone(String tel) {
this.telefones.add(tel);	
}

public void removeTelefone(String tel){
	
	
	
}

}
