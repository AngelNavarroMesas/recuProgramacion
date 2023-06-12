package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	static TreeSet<Producto> producto = new TreeSet<Producto>();
	static Scanner sc = new Scanner(System.in);
	static File fichero = new File("src/ejercicio1/Productos.txt");
	static String nombre = "", perecedero = "", tipo = "";
	static int dias, cont;
	static double precio;
	
	public static void main(String[] args) {
		int opc;
		
		System.out.println("-----Iniciando-----");
		leerFichero();
		do{
			System.out.println();
			System.out.println("Que desea hacer?");
			System.out.println("1. Añadir producto");
			System.out.println("2. Listar productos");
			System.out.println("3. Modificar producto");
			System.out.println("4. Eliminar producto");
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
				System.out.println("-------------------------");
			}
		}
	}
	
	private static void modificar() {
		int opc;
		System.out.println("Indique el nombre del producto a modificar");
		nombre = sc.nextLine();
		Producto p = new Producto(nombre);
		
		for (Producto pro : producto) {
			if(pro.equals(p)) {
				do {
					System.out.println("Que dato quiere modificar?");
					System.out.println("1. Precio");
					if(pro instanceof Perecedero) {
						System.out.println("2. Dias de caducacion");
					}else if(pro instanceof NoPerecedero) {
						System.out.println("2. Tipo");
					}
					opc = sc.nextInt();
					sc.nextLine();
				}while(opc!=1&&opc!=2);
				
				if (opc==1) {
					System.out.println("Introduzca el precio");
					pro.setPrecio(sc.nextDouble());
					System.out.println("producto modificado");
				}else if (pro instanceof Perecedero) {
						System.out.println("Introduzca los días a caducar");
						Perecedero per = (Perecedero) pro;
						per.setDiasCaducar(sc.nextInt());
						System.out.println("producto modificado");
					} else if (pro instanceof NoPerecedero) {
						System.out.println("Introduzca el tipo");
						NoPerecedero no = (NoPerecedero) pro;
						no.setTipo(sc.next());
						System.out.println("producto modificado");
					}
				
			}
		}
		
	}
	
	private static void eliminar() {
		System.out.println("Introduzca el nombre del objeto a eliminar");
		nombre = sc.nextLine();
		Producto p = new Producto(nombre);
		if(producto.remove(p)) {
			System.out.println("El producto ha sido eliminado correctamente");
		}else {
			System.out.println("El producto no existe");
		}
		
	}
	
	private static void guardar() {
		try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Producto pro: producto) {
            	bw.write(pro.getNombre()+";"+pro.getPrecio()+";");
            	if(pro instanceof Perecedero) {
            		Perecedero per = (Perecedero) pro;
            		bw.write(String.valueOf(per.getDiasCaducar()));
            	}else if(pro instanceof NoPerecedero) {
            		NoPerecedero no = (NoPerecedero) pro;
            		bw.write(String.valueOf(no.getTipo()));
            	}
            	bw.newLine();
            }
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	private static TreeSet<Producto> leerFichero() {
		try {
			String linea;
			String[] info;
			Producto pro = null;
			Scanner scf = new Scanner(new FileReader(fichero));
	        
	        while (scf.hasNext()){
	            linea = scf.nextLine();
	            info = linea.split(";");
	            try {
	            	pro = new Perecedero(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]));
	            }catch(NumberFormatException e) {
	            	pro = new NoPerecedero(info[0], Double.parseDouble(info[1]), info[2]);
	            }finally {
	            	producto.add(pro);
	            }
	            
	        }
		}catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		return producto;
	}
	
}
