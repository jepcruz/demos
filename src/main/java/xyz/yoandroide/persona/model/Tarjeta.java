package xyz.yoandroide.persona.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tarjeta")
public class Tarjeta {
	
	@Id
	private Long id;
	private int ahno;
	private int mes;
	private int codigo;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	public Tarjeta() {
	}
	
	
	public Tarjeta(Long id, int ahno, int mes, int codigo, Cliente cliente) {
		this.id = id;
		this.ahno = ahno;
		this.mes = mes;
		this.codigo = codigo;
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public int getAhno() {
		return ahno;
	}


	public void setAhno(int ahno) {
		this.ahno = ahno;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
