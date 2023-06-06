package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	static TreeSet<Producto> producto = new TreeSet<Producto>();
	static Scanner sc = new Scanner(System.in);
	static String nombre, precedero, tipo;
	static int precio, dias;
	
	public static void main(String[] args) {
		
		menu();
		
	}

	public static void menu() {
		int opc =10;
		
		while(opc!=0) {
			System.out.println("1. Añadir producto");
			System.out.println("2. Listar productos");
			System.out.println("3. Modificar producto");
			System.out.println("4. Eliminar producto");
			System.out.println("0. Salir");
			opc = sc.nextInt();
			
			switch(opc) {
			case 1:
				Añadir();
				break;
			case 2:
				Listar();
				break;
			case 3:
				Modificar();
				break;
			case 4:
				Eliminar();
				break;
			case 0:
				System.out.println("-----Saliendo-----");
				break;
			}
			
		}
	}
	
	private static void Añadir() {
		
		System.out.println("Introduzca el nombre del producto");
		nombre = sc.nextLine();
		System.out.println("Introduzca el precio del producto");
		precio = sc.nextInt();
		System.out.println("El producto es precedero? s/n");
		precedero = sc.next();
		
		if(precedero.equals("s")) {
			System.out.println("Introduzca los dias de caducidad");
			dias = sc.nextInt();
		}else {
			System.out.println("Introduzca el tipo de producto");
			tipo = sc.nextLine();
		}
		
		
	}
	
	private static void Listar() {
		// TODO Auto-generated method stub
		
	}
	
	private static void Modificar() {
		// TODO Auto-generated method stub
		
	}
	
	private static void Eliminar() {
		// TODO Auto-generated method stub
		
	}
	
}
