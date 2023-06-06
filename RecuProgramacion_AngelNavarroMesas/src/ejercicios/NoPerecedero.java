package ejercicios;

public class NoPerecedero extends Producto{
	
	String tipo;

	public NoPerecedero(String nombre, double precio, String tipo) {
		super(nombre, precio);
		if(tipo != null && !tipo.isEmpty()){
			this.tipo = tipo;
		}
	}
	
	public NoPerecedero(String nombre, double precio) {
		super(nombre, precio);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double calcular(int cantidad) {
		double total;
		total = cantidad*precio;
		return total;
	}
	
	@Override
	public String toString() {
		String mostrar;
		mostrar = "nombre = " + nombre +"\n"+"precio = " + precio+"\n"+ "tipo = "+tipo;
		return mostrar;
	}
	
}
