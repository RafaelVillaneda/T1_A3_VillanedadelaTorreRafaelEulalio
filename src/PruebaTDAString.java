import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
1.Mostrar la cadena invertida por letra y por palabras
2.Agregar/eliminar caracteres y/o subcadenas en posiciones especificas
3.Mostrar cadena en formato CaMeL CaSe especial
4.Mostar la cadena con la primer letra de cada palabra en mayúscula
 */
class StringTDA{
	Scanner entrada=new Scanner(System.in);
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
		System.out.println("Cadena invertida por palabra");
		for(int i=sep.length-1;i>=0;i--) {
			System.out.println(sep[i]);
		}
	}
	public void agregarEliminarCaracteresY_OSubcadenasPociEspecificas(String opcion){
		if(opcion.equalsIgnoreCase("A")) {
			System.out.println("Que letra quieres eliminar de tu palabra/frase?");
			String carac=entrada.nextLine();
			setCadena(getCadena().replace(carac,""));
			System.out.println(getCadena());
		}else if(opcion.equalsIgnoreCase("B")) {
			System.out.println("Desde que pocicion a que pocicion deseas eliminar");
			System.out.println("Ejemplo '5-6'");
			String subcadEliminar=entrada.nextLine();
			String cadRes="";
			int poci=Integer.parseInt(subcadEliminar.split("-")[0]),poci2=Integer.parseInt(subcadEliminar.split("-")[1]);
			poci=poci-1;
			poci2=poci2-1;
			if((poci<getCadena().length() || poci2<getCadena().length())) {
				for(int i=0;i<getCadena().length();i++) {
					if(!(i>=poci && i<=poci2)) {
						cadRes=cadRes+getCadena().substring(i,i+1);
					}
				}
			}else {
				System.out.println("Los limites que ingresaste no exiten");
			}
			setCadena(cadRes);
			System.out.println("Resultado: "+getCadena());
		}else if(opcion.equalsIgnoreCase("C")) {
			System.out.println("Que pocicion quieres cambiar de tu palabra/frase?");
			int poci=0;
			boolean bandera=false;
			try {
			poci=entrada.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("No ingresaste un valor numerico");
				bandera=true;
			}
			entrada.nextLine();
			System.out.println("Por que caracter lo deseas cambiar?");
			String carac=entrada.nextLine();
			if(bandera==false) {
				String copi="";
				for(int i=0;i<getCadena().length();i++) {
					if(poci-1==i) {
						copi=copi+carac;
					}else {
						copi=copi+getCadena().substring(i, i+1);
					}
					
				}
				setCadena(copi);
				System.out.println(getCadena());
			}
			
		}
	}
	public void mostrarMayusculaCadaPalabra() {
		int num=0;
		for(int i=0;i<getCadena().length();i++) {
			if(getCadena().substring(i, i+1).equalsIgnoreCase(" ")) {
				num++;
			}
		}//for
		if(num>0) {
			String palabras[]=getCadena().split(" ");
			String cadNueva="";
			for(int i=0;i<palabras.length;i++) {
				for(int x=0;x<palabras[i].length();x++) {
					if(x==0) {
						cadNueva=cadNueva+palabras[i].substring(x, x+1).toUpperCase();
					}else {
						cadNueva=cadNueva+palabras[i].substring(x, x+1);
					}
				}
				cadNueva=cadNueva+" ";
				//cadNueva=cadNueva+palabras[i];
			}
			setCadena(cadNueva);
		}else {
			String cad="";
			for(int i=0;i<getCadena().length();i++) {
				if(i==0) {
					cad=cad+getCadena().substring(i, i+1).toUpperCase();
				}else {
					cad=cad+getCadena().substring(i, i+1);
				}
			}
			setCadena(cad);
		}
		System.out.println(getCadena());
	}
	public void mostrarCadenaCaMeLcAsE() {
		for(int i=0;i<cadena.length();i++) {
			if(i%2==0) {
				System.out.print(cadena.substring(i, i+1).toUpperCase());
			}else {
				System.out.print(cadena.substring(i, i+1).toLowerCase());
			}
		}
		System.out.println();
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
			System.out.println("Elige la opcion que necesites");
			System.out.println("1-Mostrar la cadena invertida por letra y por palabras");
			System.out.println("2-Agregar/eliminar caracteres y/o subcadenas en posiciones especificas");
			System.out.println("3-Mostar la cadena con la primer letra de cada palabra en mayúscula");
			System.out.println("4-Cambiar la cadena");
			System.out.println("5-Mostrar Cadena en formato especial (CaMeL cAsE)");
			System.out.println("6-Salir");
				try {
					op=entrada.nextByte();
				} catch (InputMismatchException e) {
					System.out.println("Debes de ingresar un numero");
					op=0;
				}
				entrada.nextLine();
			switch (op) {
			case 1:
				cade.mostrarCadenaInvertidaLetrasPalabras();
				break;
			case 2:
				boolean bandera=true;
				String op1="";
				do {
					System.out.println("Elige la opcion deseada");
					System.out.println("A) Eliminar 'X' caracter de la palabra");
					System.out.println("B) Eliminar fragmento de la palabra en base a su pocicion ("+cade.getCadena().length()+" tamaño de espacios en palabra actual)");
					System.out.println("C) Agregar 'X' caracter de la palabra en 'X'pocicion");
					op1=entrada.nextLine().toUpperCase();
					switch (op1) {
					case "A":
						cade.agregarEliminarCaracteresY_OSubcadenasPociEspecificas(op1);
						break;
					case "B":
						cade.agregarEliminarCaracteresY_OSubcadenasPociEspecificas(op1);
						break;
					case "C":
						cade.agregarEliminarCaracteresY_OSubcadenasPociEspecificas(op1);
						System.out.println(cade.getCadena());
						break;
					default:
						System.out.println("Elige una opcion correcta");
						break;
					}	
					if(op1.equalsIgnoreCase("A") || op1.equalsIgnoreCase("B") || op1.equalsIgnoreCase("C")) {
						bandera=false;
						}
					}while(bandera==true);
				break;
			case 3:
				cade.mostrarMayusculaCadaPalabra();
				break;
			case 4:
				System.out.println("Ingresa la nueva palabra/Frase");
				String nuevo=entrada.nextLine();
				cade.setCadena(nuevo);
				break;
			case 5:
				cade.mostrarCadenaCaMeLcAsE();
				break;
				case 6:
					System.out.println("Saliendo");
					break;
			default:
				System.out.println("Ingresa una opcion disponible que este en el menu");
				break;
			}
		}while(op!=6);
	}
	

}
