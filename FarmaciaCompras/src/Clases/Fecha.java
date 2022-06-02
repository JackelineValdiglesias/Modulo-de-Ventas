package Clases;

public class Fecha {
	public int dia;
	public int mes;
	public int año;
	
	public Fecha(String dia, String mes, String año) {
		super();
		this.dia = Compra.getIntInput(dia);
		this.mes = Compra.getIntInput(mes);
		this.año = Compra.getIntInput(año);
	}
	public boolean compareTo(Fecha f2) { // True si this>f2
		return (f2.año>=this.año && f2.mes>=this.mes && f2.dia>this.dia);
	}
}
