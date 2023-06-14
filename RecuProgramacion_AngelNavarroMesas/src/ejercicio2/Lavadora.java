package ejercicio2;

public class Lavadora extends Electrodomestico{
	int carga;
	
	public Lavadora() {
		super();
	}
	
	public Lavadora(int codigo){
		super(codigo);
	}
	
	public Lavadora(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}
	
	public Lavadora(int codigo, double precio, double peso, String color, char consumo, int carga) {
		super(codigo, precio, peso, color, consumo);
		this.carga = carga;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	@Override
	public void precioFinal() {
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
	               "Consumo: "+ce+"\n"+
	               "Carga: "+carga;
	}
	
	
}
