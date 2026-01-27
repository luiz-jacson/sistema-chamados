package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="chamado")
public class Chamado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String titulo;
	private String descricao;
	private String status;
	
	@OneToMany(mappedBy = "chamado", fetch = FetchType.LAZY)
	private List<Comentario> comentario;
	
	public Chamado(String titulo, String descricao, String status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}
	
	public Chamado() {
		
	}
	
	
	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
