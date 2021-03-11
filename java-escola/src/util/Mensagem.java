package util;

/**
 * Classe para armazenar as mensagens exibidas ao usuário
 * 
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public class Mensagem {

	// Mensagens de informação 
	public static String informeCodigo = "Informe o codigo";
	public static String informeNome = "Informe o nome";
	public static String informeCpf = "Informe o CPF";
	public static String informeRg = "Informe o RG";
	public static String informeLogradouro = "Informe o logradouro";
	public static String informeNomeLogradouro = "Informe o nome do logradouro";
	public static String informeNumero = "Informe o número";
	public static String informeBairro = "Informe o bairro";
	public static String informeComplemento = "Informe o complemento";
	public static String informeCidade = "Informe a cidade";
	public static String informeEstado = "Informe o estado";
	public static String informeCep = "Informe o cep";
	public static String informeCelular = "Informe o celular";
	public static String informeEmail = "Informe o email";
	public static String informeSalario = "Informe o salário";
	public static String informeAno = "Informe o ano";
	
	// Mensagens de informação  de vazio
	public static String codigoVazio = "Informe o código, campo obrigatório!";
	public static String nomeVazio = "Informe o nome, campo obrigatório!";
	public static String cpfVazio = "Informe o CPF, campo obrigatório!";
	public static String rgVazio = "Informe o RG, campo obrigatório!";

	public static String logradouroVazio = "Informe o logradouro, campo obrigatório";
	public static String nomeLogradouroVazio = "Informe o nome do logradouro, campo obrigatório";
	public static String numeroVazio = "Informe o número, campo obrigatório";
	public static String bairroVazio = "Informe o bairro, campo obrigatório";
	public static String cidadeVazia = "Informe a cidade, campo obrigatório";
	public static String estadoVazio = "Informe o estado, campo obrigatório";
	public static String cepVazio = "Informe o cep, campo obrigatório";
	public static String salarioVazio = "Informe o salário, campo obrigatório";
	
	
	public static String celularVazio = "Informe o cep, campo obrigatório";
	public static String emailVazio = "Informe o cep, campo obrigatório";

	
	// Mensagens de informação de inválido
	public static String codigoInvalido = "Informe um código válido";
	public static String nomeInvalido = "Informe um nome válido";
	public static String numeroInvalido = "Informe um número válido";
	public static String salarioInvalido = "Informe um salário válido";
	public static String anoInvalido = "Ano inválido";

	
	public static String opcaoInvalida = "Opção inálida!";
	
	public static String alunosVazio = "Não existem alunos cadastrados";
	public static String professoresVazio = "Não existem professores cadastrados";
	public static String turmasVazio = "Não existem turmas cadastradas";
	public static String anoVazio = "Não existe ano cadastrado";
	
	
	// // Mensagens de confirmação de cadastro
	public static String materiaCadastrada = "Matéria cadastrada com sucesso!";
	public static String professorCadastrado = "Professor cadastrado com sucesso!";
	public static String alunoCadastrado = "Aluno cadastrado com sucesso!";
	public static String turmaCadastrada = "Turma cadastrada com sucesso!";

	// Mensagens de informação de erro
	public static String erroCadastroProfessor = "Para cadastrar um professor, cadastre primeiro a matéria";
	public static String erroCadastroTurma = "Erro ao cadastrar turma";
	
}
