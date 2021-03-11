package controller;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import model.Aluno;
import model.Contato;
import model.Endereco;
import model.Materia;
import model.Professor;
import model.Turma;
import util.Mensagem;
import util.Rotulo;
import util.Valida;

/**
 * Classe responsável por controlar o sistema de gerenciamento para dastro de
 * alunos turmas matérias e professores
 * 
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public class GerenciaEscola {

	// Declarando as listas para armazenar os conteúdos do sistema (Aluno
	// professores)
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Materia> materias;
	private ArrayList<Turma> turmas;

	// Construtor da classe
	public GerenciaEscola() {
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		materias = new ArrayList<Materia>();
		turmas = new ArrayList<Turma>();

		menuPrincipal();
	}

	// Método para criar um menu de opções
	public void menuPrincipal() {

		String menu = "INFORME A OPÇÃO DESEJADA\n" + "\n1 - CADASTRAR MATÉRIA" + "\n2 - CADASTRAR PROFESSOR"
				+ "\n3 - CADASTRAR ALUNO" + "\n4 - CADASTRAR TURMA" + "\n5 - LISTAR ALUNOS" + "\n6 - LISTA PROFESSORES"
				+ "\n7 - LISTAR TURMAS" + "\n8 - CONSULTAR TURMA" + "\n9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			}
		}
	}

	// Switch para levar opção digitada ao método referente
	public void processamentoPrincipal(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarMateria();
			break;
		case 2:
			cadastrarProfessor();
			break;
		case 3:
			cadastrarAluno();
			break;
		case 4:
			cadastrarTurma();
			break;
		case 5:
			listarAlunos();
			break;
		case 6:
			listarProfessores();
			break;
		case 7:
			listarTurmas();
			break;
		case 8:
			consultarTurma();
			break;
		case 9:
			sair();
			break;
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			break;
		}
	}

	// 1 - MÉTODO PARA CADASTRAR MATÉRIA
	public void cadastrarMateria() {
		materias.add(getMateria());
		JOptionPane.showInternalMessageDialog(null, Mensagem.materiaCadastrada, Rotulo.cadastroMateria, 1);
	}

	// 2 - Método para cadastrar professor
	public void cadastrarProfessor() {
		if (materias.size() > 0) {
			professores.add(getProfessor());
			JOptionPane.showMessageDialog(null, Mensagem.professorCadastrado, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroProfessor, Rotulo.cadastroProfessor, 2);
		}
	}

	// 3 - Método para cadastrar um aluno
	public void cadastrarAluno() {
		alunos.add(getAluno());
		JOptionPane.showInternalMessageDialog(null, Mensagem.alunoCadastrado, Rotulo.cadastroAluno, 1);
	}

	// 4 - Método para cadastrar turma
	public void cadastrarTurma() {
		if (professores.size() > 0 && alunos.size() > 0) {
			turmas.add(getTurma());
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadastrada, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showConfirmDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurma, 2);
		}
	}

	// Método para retornar um objeto do tipo turma
	private Turma getTurma() {
		Turma turma = new Turma();
		
		turma.setCodigo(getCodigoTurma());
		turma.setAno(getAno());
		turma.setProfessor(getProfessorTurma());
		turma.setMateria(getMateriaTurma());
		turma.setAlunos(getAlunosTurma());
		
		return turma;
	}

	// 5 - Método para listar alunos
	public void listarAlunos() {

		String mensagem = "Alunos cadastrados\n";
		boolean existe = false;

		for (Aluno aluno : alunos) {
			existe = true;
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.alunosVazio, Rotulo.cadastroAluno, 2);
		}
	}

	// 6 - Método para listar professores
	public void listarProfessores() {

		String mensagem = "Professores cadastrados\n";
		boolean existe = false;
		for (Professor professor : professores) {
			existe = true;
			mensagem += "\nCodigo: " + professor.getCodigo() + " - " + professor.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.professoresVazio, Rotulo.cadastroProfessor, 2);
		}
	}

	// 7 - Método para listar turmas
	public void listarTurmas() {
		String mensagem = "Turmas cadastradas\n";
		boolean existe = false;
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nCodigo: " + turma.getCodigo() + " - " + turma.getAno() + " - "
					+ turma.getMateria().getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmasVazio, Rotulo.cadastroTurma, 2);
		}
	}

	// 8 - Consultar uma turma
	public void consultarTurma() {
		Turma turma = getConsultarTurma();
		String mensagem = "Detalhes da turma\n";
		mensagem += "\nCódigo" + turma.getCodigo();
		mensagem += "\nAno: " + turma.getAno();
		mensagem += "Professor: " + turma.getProfessor().getNome();
		mensagem += "Matéria: " + turma.getMateria().getNome();
		mensagem += "\n\nAlunos Matriculados: ";
		
		for (Aluno aluno : alunos) {
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.consultaTurmas, 1);
	}

	// 9 - Sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// Método para retornar os atributos do aluno
	public Aluno getAluno() {
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		aluno.setCodigo(getCodigoAluno());
		aluno.setNome(getNomeAluno());
		aluno.setCpf(getCpfAluno());
		aluno.setRg(getRgAluno());

		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		aluno.setEndereco(endereco);
		aluno.setContato(contato);
		return aluno;
	}

	// Método para retornar os atributos do professor
	private Professor getProfessor() {
		Professor professor = new Professor();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		professor.setNome(getNomeProfessor());
		professor.setCpf(getCpfProfessor());
		professor.setRg(getRgProfessor());
		professor.setCodigo(getCodigoProfessor());

		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		professor.setEndereco(endereco);
		professor.setContato(contato);
		professor.setListaMaterias(getMaterias());

		professor.setSalario(getSalario());
		return professor;
	}

	// Método para retrnar um objeto matéria
	private Materia getMateria() {
		Materia materia = new Materia();
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());
		return materia;
	}

	// Método para pegar código da matéria através de input
	private int getCodigoMateria() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroMateria, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
				execute = true;
			}
		}
		return codigo;
	}

	// Método para pegar nome da matéria através de input
	private String getNomeMateria() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroMateria, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}

	// Método para pegar código do aluno através de input
	private int getCodigoAluno() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroAluno, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroAluno, 0);
				execute = true;
			}
		}
		return codigo;
	}

	// Método para pegar nome do aluno através de input
	private String getNomeAluno() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}
	
	// Método para pegar cpf do aluno através de input
	private String getCpfAluno() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}
	
	// Método para pegar rg do aluno através de input
	private String getRgAluno() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}
	
	// Método para pegar nome do logradouro do endereço através de input
	private String getLogradouro() {
		boolean execute = true;
		String logradouro = "";
		while (execute) {
			logradouro = JOptionPane.showInputDialog(Mensagem.informeLogradouro);
			if (Valida.isEmptyOrNull(logradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return logradouro;
	}
	// Método para pegar nome do logradouro do endereço através de input
	private String getNomeLogradouro() {
		boolean execute = true;
		String nomeLogradouro = "";
		while (execute) {
			nomeLogradouro = JOptionPane.showInputDialog(Mensagem.informeNomeLogradouro);
			if (Valida.isEmptyOrNull(nomeLogradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeLogradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nomeLogradouro;
	}
	// Método para pegar numero do endereço através de input
	private int getNumero() {
		boolean execute = true;
		int numero = 0;
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));

				if (Valida.isIntZero(numero)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.cadastroEndereco, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroEndereco, 0);
				execute = true;
			}
		}
		return numero;
	}

	// Método para pegar complemento do endereço através de input
	private String getComplemento() {
		String complemento = "";
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	}

	// Método para pegar bairro do endereço através de input
	private String getBairro() {
		boolean execute = true;
		String bairro = "";
		while (execute) {
			bairro = JOptionPane.showInputDialog(Mensagem.informeBairro);
			if (Valida.isEmptyOrNull(bairro)) {
				JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return bairro;
	}

	// Método para pegar cidade do endereço através de input
	private String getCidade() {
		boolean execute = true;
		String cidade = "";
		while (execute) {
			cidade = JOptionPane.showInputDialog(Mensagem.informeCidade);
			if (Valida.isEmptyOrNull(cidade)) {
				JOptionPane.showMessageDialog(null, Mensagem.cidadeVazia, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cidade;
	}

	// Método para pegar estado do endereço através de input
	private String getEstado() {
		boolean execute = true;
		String estado = "";
		while (execute) {
			estado = JOptionPane.showInputDialog(Mensagem.informeEstado);
			if (Valida.isEmptyOrNull(estado)) {
				JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return estado;
	}
	
	// Método para pegar cep do endereço através de input
	private String getCep() {
		boolean execute = true;
		String cep = "";
		while (execute) {
			cep = JOptionPane.showInputDialog(Mensagem.informeCep);
			if (Valida.isEmptyOrNull(cep)) {
				JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cep;
	}

	// Método para pegar celular do contato através de input
	private String getCelular() {
		boolean execute = true;
		String celular = "";
		while (execute) {
			celular = JOptionPane.showInputDialog(Mensagem.informeCelular);
			if (Valida.isEmptyOrNull(celular)) {
				JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return celular;
	}

	// Método para pegar celular do contato através de input
	private String getEmail() {
		boolean execute = true;
		String email = "";
		while (execute) {
			email = JOptionPane.showInputDialog(Mensagem.informeEmail);
			if (Valida.isEmptyOrNull(email)) {
				JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return email;
	}

	// Método para pegar celular do endereço através de input
	private int getCodigoProfessor() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}
		}
		return codigo;
	}
	
	// Método para pegar nome do professor através de input
	private String getNomeProfessor() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}

	// Método para pegar cpf do professor através de input
	private String getCpfProfessor() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}

	// Método para pegar rg do professor através de input
	private String getRgProfessor() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}

	// Método para pegar materias do professor através de input
	private ArrayList<Materia> getMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "Matérias cadastradas\n";

		for (Materia materia : this.materias) {
			mensagem += "\nCódigo: " + materia.getCodigo() + " - " + materia.getNome();
		}

		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra matéria?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
			}
		}
		return materias;
	}

	// Método para pegar salario do professor através de input
	private double getSalario() {
		boolean execute = true;
		double salario = 0;
		while (execute) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog(Mensagem.informeSalario));

				if (Valida.isDoubleZero(salario)) {
					JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}
		}
		return salario;
	}

	// Método para pegar código da turma através de input
	private int getCodigoTurma() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroTurma, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
				execute = true;
			}
		}
		return codigo;
	}

	// Método para pegar ano da turma através de input
	private int getAno() {
		boolean execute = true;
		int ano = 0;
		while (execute) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeAno));

				if (Valida.isIntZero(ano)) {
					JOptionPane.showMessageDialog(null, Mensagem.anoVazio, Rotulo.cadastroTurma, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.anoInvalido, Rotulo.cadastroTurma, 0);
				execute = true;
			}
		}
		return ano;
	}

	// Método para pegar professor da turma através de input
	private Professor getProfessorTurma() {
		Professor retorno = new Professor();
		String mensagem = "Professores cadastrados\n";

		for (Professor professor : professores) {
			mensagem += "\nCódigo: " + professor.getCodigo() + " - " + professor.getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = professores.get(codigo - 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
		}
		return retorno;
	}
	
	// Método para pegar matéria da turma através de input
	private Materia getMateriaTurma() {
		Materia retorno = new Materia();
		String mensagem = "Matérias cadastradss\n";

		for (Materia materia : materias) {
			mensagem += "\nCódigo: " + materia.getCodigo() + " - " + materia.getNome();
		}
		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = materias.get(codigo - 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
		}
		return retorno;
	}
	
	// Método para pegar alunos da turma através de input
	private ArrayList<Aluno> getAlunosTurma() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "Aluno cadastrados\n";

		for (Aluno aluno : this.alunos) {
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				alunos.add(this.alunos.get(codigo - 1));

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
			}
		}
		return alunos;
	}
	
	// Método para consultar turma 
	private Turma getConsultarTurma() {
		Turma retorno = new Turma();
		String mensagem = "Turmas cadastradas\n";

		for (Turma turma : turmas) {
			mensagem += "\nCódigo: " + turma.getCodigo() + " - " + turma.getAno() + " - " + turma.getMateria().getNome();
		}
		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = turmas.get(codigo - 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
		}
		return retorno;
	}
}