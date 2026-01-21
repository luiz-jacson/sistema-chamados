package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
	
	public Comentario() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String texto;
	
	@Column(name="chamado_id")
	private int chamado_id;
	
	public Comentario(String texto, int chamado_id) {
		this.texto = texto;
		this.chamado_id = chamado_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getChamado_id() {
		return chamado_id;
	}
	public void setChamado_id(int chamado_id) {
		this.chamado_id = chamado_id;
	}
	
	
	
}
