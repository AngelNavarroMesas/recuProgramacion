package ejercicios;

public class Productos {
	
	String nombre;
	double precio;
	
	public Productos(String nombre, double precio) {
		if(nombre != null && !nombre.isEmpty()){
			this.nombre = nombre;
		}
		if(precio>=0) {
			this.precio = precio;
		}
	}
	
	public Productos() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double calcular(int cantidad) {
		double total;
		total = cantidad*precio;
		return total;
	}
	
	@Override
	public String toString() {
		String mostrar;
		mostrar = "nombre = " + nombre +"\n"+"precio = " + precio;
		return mostrar;
	}
	
	
}
