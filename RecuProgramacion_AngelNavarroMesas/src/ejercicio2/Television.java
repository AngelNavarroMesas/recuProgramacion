package ejercicio2;

public class Television extends Electrodomestico{
	
	double resolucion;
	boolean TDT;
	
	public Television() {
		super();
	}
	
	public Television(int codigo) {
		super(codigo);
	}
	
	public Television(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}

	public Television (int codigo, double precio, double peso, String color, char consumo, double resolucion, boolean tDT) {
		super(codigo, precio, peso, color, consumo);
		this.resolucion = resolucion;
		TDT = tDT;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		if(resolucion>0) {
			this.resolucion = resolucion;
		}
	}
	
	public boolean isTDT() {
		return TDT;
	}

	public void setTDT(boolean tDT) {
		TDT = tDT;
	}
	
	@Override
	public void precioFinal() {
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
		return 	"Television \n"+
				   "Codigo: "+codigo+"\n"+
	               "Precio: "+precio+"\n"+
	               "Peso: "+peso+"\n"+
	               "Color: "+color+"\n"+
	               "Consumo: "+ce+"\n"+
	               "Resolución: "+resolucion+"\n"+
	               "TDT: "+TDT;
	}
	
	
	
	
}
