package Clases;

import Views.ItemsCompra;

public class CompraItem {
	public boolean valido;
	public String errores;
	public Integer id;
	public String nombre;	
	public double precio;
	public Integer cantidad;
	public double importe;
	public Integer idCompra; // Se paso al final 
	public CompraItem(Integer id, String nombre, double precio, Integer cantidad, double importe, Integer idCompra) {
		super();
		errores="";
		valido=true;
		this.id = id;
		this.nombre = nombre;		
		this.precio = precio;//validación
		this.cantidad = cantidad;//validacion
		this.importe = importe;
		this.idCompra = idCompra; // Se paso al final
	}
	public CompraItem(ItemsCompra c) {
		this.id = Compra.getIntInput(c.textid.getText());
		this.nombre = c.textitem.getText();		
		this.precio=Compra.getDouInput(c.textpu.getText()); //Double	
		if (precio==0) {errores+="Precio:El precio tiene que ser mayor que 0 y un número valido \n";valido=false;}
		this.cantidad=Compra.getIntInput(c.textcant.getText());
		if (precio==0) {errores+="Cantidad:La cantidad tiene que ser mayor que 0 y un número valido \n";valido=false;}
		this.importe=Compra.getDouInput(c.textimpor.getText()); //Double
		this.idCompra=c.idCompra;
	}
	@Override
	public String toString() {
		return "CompraItem [id=" + id + ", nombre=" + nombre + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", importe=" + importe + ", idCompra=" + idCompra + "]";
	}	
	
}
