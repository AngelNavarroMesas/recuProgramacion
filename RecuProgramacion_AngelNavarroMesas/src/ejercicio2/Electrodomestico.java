package ejercicio2;

public class Electrodomestico implements Comparable<Electrodomestico>{
	enum Color{
		blanco, negro,rojo, azul, gris
	}
	enum Consumo{
		A,B,C,D,E,F
	}
	protected Color color= Color.blanco;
	protected Consumo ce = Consumo.F;
	protected double precio = 100, peso=5;
    protected int codigo;
    
    public Electrodomestico(){
    }
    
    public Electrodomestico(int codigo) {
    	this.codigo = codigo;
    }
    
    public Electrodomestico(int codigo, double precio, double peso){
    	this.codigo = codigo;
        this.precio = precio;
        this.peso = peso;
    }
    
    public Electrodomestico(int codigo, double precio, double peso,String color,char consumo) {
        this.codigo = codigo;
    	this.precio = precio;
        this.peso = peso;
        comprobarColor(color);
        comprobarConsumoEnergetico(consumo);
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
    	if(precio>=0) {
    		this.precio = precio;
    	}
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
    	if(peso>0) {
    		this.peso = peso;
    	}
    }

    public String getColor() {
        return String.valueOf(color);
    }

    public void setColor(String color) {
        comprobarColor(color);
    }

    public char getConsumo() {
        return String.valueOf(ce).charAt(0);
    }

    public void setConsumo(char consumo) {
        comprobarConsumoEnergetico(consumo);
    }
    
    private void comprobarConsumoEnergetico(char consumo){
        switch (consumo){
            case 'A','B','C','D','E':
            	ce = Consumo.valueOf(String.valueOf(consumo));
                break;
            default:
                ce = Consumo.valueOf(String.valueOf('F'));
        }
		
    }
    
    private void comprobarColor(String c){
        switch (c.toLowerCase()){
            case "blanco", "negro","rojo", "azul", "gris":
            	color = Color.valueOf(c);
                break;
            default:
                color = Color.blanco;
        }
    }
    
    public void precioFinal(){
        switch (ce){
            case A:
                precio+=100;
                break;
            case B:
                precio+=80;
                break;
            case C:
                precio+=60;
                break;
            case D:
                precio+=50;
                break;
            case E:
                precio+=30;
                break;
            case F:
                precio+=10;
                break;
        }
        if (peso <20 && peso>=0){
            precio+=10;
        } else if (peso <50 && peso>19) {
            precio+= 50;
        }else if (peso <80 && peso>49){
            precio+=80;
        }else precio+=100;
    }
    
    @Override
    public String toString() {
        return "Codigo: "+codigo+"\n"+
               "Precio: "+precio+"\n"+
               "Peso: "+peso+"\n"+
               "Color: "+color+"\n"+
               "Consumo: "+ce;
    }
    
    @Override
	public boolean equals(Object obj) {
		boolean igual=false;
		Electrodomestico e = (Electrodomestico) obj;
		if(this.codigo==e.codigo) {
			igual=true;
		}
		return igual;
	}

	@Override
	public int compareTo(Electrodomestico o) {
		int pos = 0;
		pos = this.codigo-o.codigo;
		return pos;
	}
}

