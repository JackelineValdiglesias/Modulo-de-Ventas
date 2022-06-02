package Clases;

public class Fecha {
	public int dia;
	public int mes;
	public int a�o;
	
	public Fecha(String dia, String mes, String a�o) {
		super();
		this.dia = Compra.getIntInput(dia);
		this.mes = Compra.getIntInput(mes);
		this.a�o = Compra.getIntInput(a�o);
	}
	public boolean compareTo(Fecha f2) { // True si this>f2
		return (f2.a�o>=this.a�o && f2.mes>=this.mes && f2.dia>this.dia);
	}
}
