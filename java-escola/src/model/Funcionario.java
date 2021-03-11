package model;

/**
 * Classe responsável por armazenar os atributos e métodos do funcionário
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public abstract class Funcionario {

	// Declarando os atributo
	private int codigo;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private Contato contato;
	private double salario;
	
	
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
