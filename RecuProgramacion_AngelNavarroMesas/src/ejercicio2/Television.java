package ejercicio2;

public class Television extends Electrodomestico{
	
	double resolucion;
	boolean TDT;
	
	public Television(String codigo, double precio, double peso, String color, char consumo) {
		super(codigo, precio, peso, color, consumo);
	}
	
		public Television(String codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}

	public Television(String codigo, double precio, double peso, String color, char consumo, double resolucion,
			boolean tDT) {
		super(codigo, precio, peso, color, consumo);
		this.resolucion = resolucion;
		TDT = tDT;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTDT() {
		return TDT;
	}

	public void setTDT(boolean tDT) {
		TDT = tDT;
	}
	
	public void precioFinalLavadora() {
		super.precioFinal();
		if(resolucion>40) {
			precio+= (precio*0.3);
		}
		if(TDT=true) {
			precio+=50;
		}
	}

	@Override
	public String toString() {
		return 	"Lavadora \n"+
				   "Codigo: "+codigo+"\n"+
	               "Precio: "+precio+"\n"+
	               "Peso: "+peso+"\n"+
	               "Color: "+color+"\n"+
	               "Consumo: "+consumo+"\n"+
	               "Resolución: "+resolucion+"\n"+
	               "TDT: "+TDT;
	}
	
	
	
	
}
