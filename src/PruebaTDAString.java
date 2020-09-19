import java.util.InputMismatchException;
import java.util.Scanner;

/*
1.Mostrar la cadena invertida por letra y por palabras
2.Agregar/eliminar caracteres y/o subcadenas en posiciones especificas
3.Mostrar cadena en formato CaMeL CaSe especial
4.Mostar la cadena con la primer letra de cada palabra en mayúscula
 */
class StringTDA{
	private String cadena;

	public StringTDA(String cadena) {
		this.cadena = cadena;
	}
	
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public void mostrarCadenaInvertidaLetrasPalabras() {
		System.out.println("Cadena invertida");
		for (int i=getCadena().length()-1; i >=0; i--) {
			System.out.print(getCadena().charAt(i));
		}
		System.out.println();
		System.out.println("Cadena por palabras");
		String[] sep=getCadena().split(" ");
		for (int i = 0; i < sep.length; i++) {
			System.out.println(sep[i]);
		}
	}
	
}
public class PruebaTDAString {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Ingresa la una palabra para poder usar el programa");
		byte op=0;
		String cad=entrada.nextLine();
		StringTDA cade=new StringTDA(cad);
		do {
			System.out.println("Elige la opcion que desses");
			System.out.println("1-Mostrar la cadena invertida por letra y por palabras");
			System.out.println("2-Agregar/eliminar caracteres y/o subcadenas en posiciones especificas");
			System.out.println("3-Mostar la cadena con la primer letra de cada palabra en mayúscula");
			System.out.println("4-Cambiar la cadena");
			System.out.println("5-Salir");
			//entrada.nextLine();
				try {
					op=entrada.nextByte();
				} catch (InputMismatchException e) {
					System.out.println("Debes de ingresar un numero");
					op=0;
				}
			switch (op) {
			case 1:
				cade.mostrarCadenaInvertidaLetrasPalabras();
				break;
	
			default:
				System.out.println("Ingresa una opcion disponible que este en el menu");
				break;
			}
		}while(op!=5);
	}
	

}
