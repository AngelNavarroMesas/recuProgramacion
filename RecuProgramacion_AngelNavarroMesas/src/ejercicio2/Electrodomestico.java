package ejercicio2;

import ejercicio1.Producto;

public class Electrodomestico implements Comparable<Electrodomestico>{
	double precio, peso;
	enum color{
		blanco, negro,rojo, azul, gris
	}
	enum consumo{
		A,B,C,D,E
	}
    String codigo="";

    public Electrodomestico(String codigo, double precio, double peso, String color, char consumo) {
        this.codigo = codigo;
    	this.precio = precio;
        this.peso = peso;
        this.color = comprobarColor(color);
        this.consumo = comprobarConsumoEnergetico(consumo);
    }
    
    public Electrodomestico(String codigo) {
    	this.codigo = codigo;
    }
    
    public Electrodomestico(String codigo, double precio, double peso){
    	this.codigo = codigo;
        this.precio = precio;
        this.peso = peso;
    }
    
    public Electrodomestico(){
        this.color = "blanco";
        this.consumo = 'F';
        this.precio = 100;
        this.peso = 5;
    }
    
    private static char comprobarConsumoEnergetico(char letra){
        switch (letra){
            case 'A','B','C','D','E':
                break;
            default:
                letra = 'F';
        }
        return letra;
    }
    
    private static String comprobarColor(String color){
        switch (color.toLowerCase()){
            case "blanco", "negro","rojo", "azul", "gris":
                break;
            default:
                color = "blanco";
        }
        return color;
    }
    
    public void precioFinal(){
        switch (consumo){
            case 'A':
                precio+=100;
                break;
            case 'B':
                precio+=80;
                break;
            case 'C':
                precio+=60;
                break;
            case 'D':
                precio+=50;
                break;
            case 'E':
                precio+=30;
                break;
            case 'F':
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
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = comprobarConsumoEnergetico(consumo);
    }
    
    @Override
    public String toString() {
        return "Codigo: "+codigo+"\n"+
               "Precio: "+precio+"\n"+
               "Peso: "+peso+"\n"+
               "Color: "+color+"\n"+
               "Consumo: "+consumo;
    }
    
    @Override
	public boolean equals(Object obj) {
		boolean igual=false;
		Electrodomestico e = (Electrodomestico) obj;
		if(this.codigo.equals(e.codigo)) {
			igual=true;
		}
		return igual;
	}

	@Override
	public int compareTo(Electrodomestico o) {
		int pos = 0;
		pos = this.codigo.compareTo(o.codigo);
		return pos;
	}
}

