package ejercicio2;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static LinkedHashSet<Electrodomestico> elect = new LinkedHashSet<Electrodomestico>();
	static Scanner sc = new Scanner(System.in);
	static int codigo;
	public static void main(String[] args) {
		int opc;
		
		System.out.println("-----Iniciando-----");
		do{
			System.out.println();
			System.out.println("Que desea hacer?");
			System.out.println("1. Añadir Electrodomestico");
			System.out.println("2. Listar Electrodomesticos");
			System.out.println("3. Modificar Electrodomestico");
			System.out.println("4. Eliminar Electrodomestico");
			System.out.println("5. Guardar");
			System.out.println("0. Salir");
			System.out.println();
			opc = sc.nextInt();
			sc.nextLine();
			switch(opc) {
			case 1:
				añadir();
				break;
			case 2:
				listar();
				break;
			case 3:
				modificar();
				break;
			case 4:
				eliminar();
				break;
			case 5:
				guardar();
				break;
			case 0:
				System.out.println("-----Saliendo-----");
				break;
			default:
				System.out.println("Elija una de las 5 opciones");
				break;
			}
			
		}while(opc!=0);
	
	}
	
	public static void añadir() {
		System.out.println("Introduzca el codigo del nuevo electrodomestico (Solo numeros)");
		codigo = sc.nextInt();
		sc.nextLine();
		Electrodomestico e = new Electrodomestico(codigo);
		if(elect.contains(e)) {
			
		}
	}
}
