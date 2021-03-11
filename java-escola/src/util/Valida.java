package util;

/**
 * Classe respons�vel por validar os dados inputados pelo usu�rio
 * 
 * @author Gustavo Metzler Pontes
 * @since 23 de fev. de 2021
 * 
 */
public class Valida {

	//Verificando se o valor digitado � nulo ou vazio
	public static boolean isEmptyOrNull(String string) {
		return (string == null || string.trim().equals(""));
	}
	
	// verificando se o valor informado � zero
	public static boolean isIntZero(int args) {
		return(args == 0);
	}
	
	// verificando se o valor informado � zero
		public static boolean isDoubleZero(double args) {
			return(args == 0);
		}
	
}
