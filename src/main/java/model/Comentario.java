package model;

public class Comentario {
	private int id;
	private String texto;
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
