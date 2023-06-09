package ejercicios;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	static TreeSet<Producto> producto = new TreeSet<Producto>();
	static Scanner sc = new Scanner(System.in);
	static String nombre = "", perecedero = "", tipo = "";
	static int dias, cont;
	static double precio;
	
	public static void main(String[] args) {
		int opc;
		
		System.out.println("-----Iniciando-----");
		
		do{
			System.out.println("1. Añadir producto");
			System.out.println("2. Listar productos");
			System.out.println("3. Modificar producto");
			System.out.println("4. Eliminar producto");
			System.out.println("5. Guardar");
			System.out.println("0. Salir");
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
	
	private static void añadir() {
		System.out.println("Introduzca el nombre del producto");
		nombre = sc.nextLine();
		System.out.println("Introduzca el precio del producto");
		precio = sc.nextDouble();
		sc.nextLine();
		System.out.println("El producto es precedero? s/n");
		perecedero = sc.next();
		sc.nextLine();
		
		if(perecedero.equals("s")) {
			System.out.println("Introduzca los dias de caducidad");
			dias = sc.nextInt();
			sc.nextLine();
			Perecedero pere = new Perecedero(nombre, precio, dias);
			producto.add(pere);
		}else {
			System.out.println("Introduzca el tipo de producto");
			tipo = sc.nextLine();
			NoPerecedero noPere = new NoPerecedero(nombre, precio, tipo);
			producto.add(noPere);
		}
		
	}
	
	private static void listar() {
		if (producto.size() == 0) {
			System.out.println("No hay productos");
		} else {
			for (Producto i:producto) {
				System.out.println(i);
			}
		}
	}
	
	private static void modificar() {
		int opc;
		System.out.println("Indique el nombre del producto a modificar");
		nombre = sc.nextLine();
		Producto p = new Producto(nombre);
		
		if(producto.contains(p)) {
			do {
				System.out.println("Que dato quiere modificar?");
				System.out.println("1. Precio");
				if(p instanceof Perecedero) {
					System.out.println("2. Tipo");
				}else if(p instanceof NoPerecedero) {
					System.out.println("2. Dias de caducacion");
				}
				opc = sc.nextInt();
				sc.nextLine();
			}while(opc!=1||opc!=2);
			
			if (opc==1) {
				System.out.println("Introduzca el precio");
				p.setPrecio(sc.nextDouble());
				System.out.println("producto modificado");
			}
		}else {
			System.out.println("El producto no existe");
		}
		
	}
	
	private static void eliminar() {
		System.out.println("Introduzca el nombre del objeto a eliminar");
		nombre = sc.nextLine();
		Producto p = new Producto(nombre);
		if(producto.contains(p)) {
			producto.remove(p);
			System.out.println("El producto ha sido eliminado correctamente");
		}else {
			System.out.println("El producto no existe");
		}
		
	}
	
	private static void guardar() {
		
	}
	
}
