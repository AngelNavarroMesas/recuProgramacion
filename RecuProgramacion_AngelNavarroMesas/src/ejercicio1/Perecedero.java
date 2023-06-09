package ejercicio1;

public class Perecedero extends Producto{
	
	int diasCaducar;
	
	public Perecedero(String nombre, double precio, int diasCaducar) {
		super(nombre, precio);
		this.diasCaducar = diasCaducar;
	}

	public Perecedero(String nombre, double precio) {
		super(nombre, precio);
	}


	public int getDiasCaducar() {
		return diasCaducar;
	}

	public void setDiasCaducar(int diasCaducar) {
		this.diasCaducar = diasCaducar;
	}
	
	public double calcular(int cantidad) {
		double total;
		total = cantidad*precio;
		
		if(diasCaducar==1) {
			total/=4;
		}else if(diasCaducar==2) {
			total/=3;
		}else if(diasCaducar==3) {
			total/= 2;
		}
		
		
		return total;
	}
	
	@Override
	public String toString() {
		String mostrar;
		mostrar = "nombre = " + nombre +"\n"+"precio = " + precio+"\n"+ "dias a caducar = "+diasCaducar;
		return mostrar;
	}
	
}
