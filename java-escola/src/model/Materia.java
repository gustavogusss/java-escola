package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto matéria
 * 
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public class Materia {

	// Declarando atributos
	private int codigo;
	private String nome;
	
	
	// getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
