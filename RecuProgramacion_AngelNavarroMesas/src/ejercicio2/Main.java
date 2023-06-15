package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static LinkedHashSet<Electrodomestico> elect = new LinkedHashSet<Electrodomestico>();
	static Scanner sc = new Scanner(System.in);
	static File fichero = new File("src/ejercicio2/Electrodomesticos.txt");
	static int codigo=0, carga;
	static double precio, peso, resolucion;
	static String color;
	static char consumo;
	static boolean TDT;
	
	public static void main(String[] args) {
		int opc;
		
		System.out.println("-----Iniciando-----");
		leerFichero();
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
		String opc ="";
		System.out.println("Introduzca el codigo del nuevo electrodomestico (Solo numeros)");
		codigo = sc.nextInt();
		sc.nextLine();
		Electrodomestico e = new Electrodomestico(codigo);
		
		if(elect.contains(e)) {
			System.out.println("El codigo insertado ya existe");
			
		} else {
			System.out.println("Introduzca el precio base");
			precio = sc.nextDouble();
			sc.nextLine();
			System.out.println("Introduzca el color del electrodomestico (blanco, negro, rojo, azul, gris)");
			color = sc.nextLine();
			System.out.println("Introduzca el consumo energetico (A, B, C, D, E, F)");
			consumo = sc.next().charAt(0);
			System.out.println("Introduzca el peso");
			peso = sc.nextDouble();
			sc.nextLine();
			System.out.println("El electrodomestico es una lavadora o una television? (l/t)");
			opc = sc.nextLine();
			
			if(opc.equals("l")) {
				System.out.println("Introduzca la carga");
				carga = sc.nextInt();
				sc.nextLine();
				Lavadora lava = new Lavadora(codigo, precio, peso, color, consumo, carga);
				elect.add(lava);
				
			}else if(opc.equals("t")) {
				String s="";
				System.out.println("Introduzca la resolucion en pulgadas");
				resolucion = sc.nextDouble();
				sc.nextLine();
				System.out.println("La tele tiene TDT? s/n");
				s = sc.nextLine();
				
				if(s.equals("s")) {
					TDT = true;
				}else if(s.equals("n")){
					TDT = false;
				}
				
				Television tele= new Television(codigo, precio, peso, color, consumo, resolucion, TDT);
				elect.add(tele);
			}
			
		}
	}
	
	public static void listar() {
		if (elect.size() == 0) {
			System.out.println("No hay ningun electrodomestico");
		} else {
			for (Electrodomestico i:elect) {
				System.out.println(i);
				System.out.println("-------------------------");
			}
		}
	}
	
	public static void modificar() {
		int opc;
		System.out.println("Introduzca el codigo del electrodomestico (Solo numeros)");
		codigo = sc.nextInt();
		sc.nextLine();
		Electrodomestico e = new Electrodomestico(codigo);
		for(Electrodomestico elec: elect) {
			if(elec.equals(e)) {
				System.out.println("Que dato quiere modificar?");
				System.out.println("1. Precio");
				System.out.println("2. Peso");
				System.out.println("3. color");
				System.out.println("4. consumo");
				
				if(elec instanceof Lavadora) {
					System.out.println("5. carga");
				}else if(elec instanceof Television) {
					System.out.println("5.resolucion");
					System.out.println("6.TDT");
				}
				
				opc = sc.nextInt();
				sc.nextLine();
				System.out.println();
				
				switch(opc) {
				case 1:
					System.out.println("Introduzca el nuevo precio");
					elec.setPrecio(sc.nextDouble());
					break;
				case 2:
					System.out.println("Introduzca el nuevo peso");
					elec.setPeso(sc.nextDouble());
					break;
				case 3:
					System.out.println("Introduzca el nuevo color (blanco, negro, rojo, azul, gris)");
					elec.setColor(sc.nextLine());
					break;
				case 4:
					System.out.println("Introduzca el nuevo consumo (A, B, C, D, E, F)");
					elec.setConsumo(sc.next().charAt(0));
					break;
				case 5:
					if(elec instanceof Lavadora) {
						System.out.println("Introduzca la nueva carga");
						Lavadora lava= (Lavadora) elec;
						lava.setCarga(sc.nextInt());
					}else if(elec instanceof Television) {
						System.out.println("Introduzca la nueva resolucion");
						Television tele = (Television) elec;
						tele.setResolucion(sc.nextDouble());
					}
					break;
				case 6:
					System.out.println("La television tiene TDT (s/n)");
					String r = sc.nextLine();
					Television tele = (Television) elec;
					if(r.equals("s")) {
						tele.setTDT(true);
					}else if(r.equals("n")) {
						tele.setTDT(false);
					}
					break;
				}
				System.out.println("Electrodomestico modificado correctamente");
			}else {
				System.out.println("El codigo no coincide con ningun electrodomestico");
			}
		}
		
	}
	
	public static void eliminar() {
		System.out.println("Introduzca el codigo del electrodomestico a eliminar");
		codigo = sc.nextInt();
		sc.nextLine();
		Electrodomestico i = new Electrodomestico(codigo);
		if(elect.remove(i)) {
			System.out.println("Electrodomestico eliminado correctamente");
		}else {
			System.out.println("El electrodomestico no existe");
		}
	}
	
	public static void guardar() {
		try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Electrodomestico elec: elect) {
            	if(elec instanceof Lavadora) {
            		Lavadora lava = (Lavadora) elec;
            		bw.write("Lavadora;"+elec.getCodigo()+";"+elec.getPrecio()+";"+elec.getPeso()+";"+elec.getColor()+";"+elec.getConsumo()+";"+lava.getCarga());
            	}else if(elec instanceof Television) {
            		Television tele = (Television) elec;
            		bw.write("Television;"+elec.getCodigo()+";"+elec.getPrecio()+";"+elec.getPeso()+";"+elec.getColor()+";"+elec.getConsumo()+";"+tele.getResolucion()+";"+tele.isTDT());
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
	
	public static LinkedHashSet <Electrodomestico> leerFichero() {
		try {
			String linea;
			String[] info;
			Electrodomestico elec = null;
			Scanner scf = new Scanner(new FileReader(fichero));
			boolean i = false;
			
	        while (scf.hasNext()){
	            linea = scf.nextLine();
	            info = linea.split(";");
	            try {
	            	elec = new Lavadora(Integer.parseInt(info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]), info[4], info[5].charAt(0) , Integer.parseInt(info[6]));
	            }catch(NumberFormatException e) {
	            	if(info[5].contains("true")) {
	            		i=true;
	            	}
	            	elec = new Television(Integer.parseInt(info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]), info[4], info[5].charAt(0), Double.parseDouble(info[6]), i);
	            }finally {
	            	elect.add(elec);
	            }
	            
	        }
		}catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		return elect;
		
	}
}
