package ejercicio2;

public class Lavadora extends Electrodomestico{
	int carga;

	public Lavadora(String codigo, double precio, double peso, String color, char consumo, int carga) {
		super(codigo, precio, peso, color, consumo);
		this.carga = carga;
	}
	
	public Lavadora(String codigo){
		super(codigo);
	}
	
	public Lavadora(String codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}
	
	public Lavadora() {
		super();
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	public void precioFinalLavadora() {
		super.precioFinal();
		if(carga>30) {
			precio +=50;
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
	               "Carga: "+carga;
	}
	
	
}
