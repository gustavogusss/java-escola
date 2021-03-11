/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto professor
 * 
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public class Professor extends Funcionario {

	// declarando os atributos do professor
	private ArrayList<Materia> listaMaterias;

	// getters e setters
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}
	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}
}
