package ejercicios;

public class Producto implements Comparable<Producto>{
	
	protected String nombre = "";
	protected double precio;
	
	public Producto(String nombre, double precio) {
		if(nombre != null && !nombre.isEmpty()){
			this.nombre = nombre;
		}
		if(precio>=0) {
			this.precio = precio;
		}
	}
	
	public Producto() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre != null && !nombre.isEmpty()){
			this.nombre = nombre;
		}
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		if(precio>=0) {
			this.precio = precio;
		}
	}
	
	public double calcular(int cantidad) {
		double total=0;
		if(cantidad>0) {
			total = cantidad*precio;
		}
		return total;
	}
	
	@Override
	public String toString() {
		String mostrar;
		mostrar = "nombre = " + nombre +"\n"+"precio = " + precio;
		return mostrar;
	}

	@Override
	public int compareTo(Producto o) {
		int pos;
		if(this.nombre.equals(nombre)){
			pos = this.nombre.compareTo(nombre);
		}else if(this.precio < precio) {
			pos=-1;
		}else {
			pos=1;
		}
		
		return pos;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean igual=false;
		if(this.nombre.equals(nombre)) {
			igual=true;
		}
		return igual;
	}
	
}
