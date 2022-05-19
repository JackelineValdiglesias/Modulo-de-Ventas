package Clases;

import javax.swing.JTextField;

import Views.EditarCompra;
import Views.*;

public class Compra {
	public Integer id;
	public String fechaEmision;
	public String fechaEntregaEstimada;
	public String fechaEntrega;
	public String nombre;
	public String DNI;
	public String nomproveedor;
	public String rucProv;
	public String numFactura;
	public double totalImporte;
	public Integer estado;
	public Integer moneda;

	
	public Compra(int id, String fechaEmision, String fechaEntregaEstimada, String fechaEntrega, String nombre,
			String DNI, String nomproveedor,String rucProv, String numFactura, double totalImporte, int estado, int moneda) {
		super();
		this.id = id;
		this.fechaEmision = fechaEmision;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.fechaEntrega = fechaEntrega;
		this.nombre = nombre;
		this.DNI=DNI;
		this.nomproveedor = nomproveedor;
		this.rucProv = rucProv;
		this.numFactura = numFactura;
		this.totalImporte = totalImporte;
		this.estado = estado;
		this.moneda = moneda;
		
	}
	
	public Compra(EditarCompra c) {
		super();
		
		String fechaemision=(c.txtdiaemi.getText()+(c.txtmesemi.getText()==""?"":"-")+c.txtmesemi.getText()+(c.txtañoemi.getText()==""?"":"-")+c.txtañoemi.getText());
		String fechaestimada=(c.txtdiaesti.getText()+(c.txtmesesti.getText()==""?"":"-")+c.txtmesesti.getText()+(c.txtañoesti.getText()==""?"":"-")+c.txtañoesti.getText());
		String fechaentrega=(c.txtdiaentre.getText()+(c.txtmesentre.getText()==""?"":"-")+c.txtmesentre.getText()+(c.txtañoentre.getText()==""?"":"-")+c.txtañoentre.getText());
		
		this.fechaEmision = fechaemision;
		this.fechaEntregaEstimada = fechaestimada;
		this.fechaEntrega = fechaentrega;
		this.nombre = c.txttrabajador.getText();
		this.DNI =	c.txtdnitrabaj.getText();
		this.nomproveedor = c.txtproveedor.getText();
		this.rucProv = c.txtruc.getText();
		this.numFactura = c.txtfactura.getText();
		this.totalImporte = getDouInput(c.txtimporte.getText());
		this.id = getIntInput(c.txtid.getText());
		this.estado = c.cbestado.getSelectedIndex();
		this.moneda = c.cbmoneda.getSelectedIndex();
		
	}
	public Compra(panelEditarCompra c) {
		super();
		
		String fechaemision=(c.txtdiaemi.getText()+(c.txtmesemi.getText()==""?"":"-")+c.txtmesemi.getText()+(c.txtañoemi.getText()==""?"":"-")+c.txtañoemi.getText());
		String fechaestimada=(c.txtdiaesti.getText()+(c.txtmesesti.getText()==""?"":"-")+c.txtmesesti.getText()+(c.txtañoesti.getText()==""?"":"-")+c.txtañoesti.getText());
		String fechaentrega=(c.txtdiaentre.getText()+(c.txtmesentre.getText()==""?"":"-")+c.txtmesentre.getText()+(c.txtañoentre.getText()==""?"":"-")+c.txtañoentre.getText());
		
		this.fechaEmision = fechaemision;
		this.fechaEntregaEstimada = fechaestimada;
		this.fechaEntrega = fechaentrega;
		this.nombre = c.txttrabajador.getText();
		this.DNI =	c.txtdnitrabaj.getText();
		this.nomproveedor = c.txtproveedor.getText();
		this.rucProv = c.txtruc.getText();
		this.numFactura = c.txtfactura.getText();
		this.totalImporte = getDouInput(c.txtimporte.getText());
		this.id = getIntInput(c.txtid.getText());
		this.estado = c.cbestado.getSelectedIndex();
		this.moneda = c.cbmoneda.getSelectedIndex();
		
	}
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fechaEmision=" + fechaEmision + ", fechaEntregaEstimada=" + fechaEntregaEstimada
				+ ", fechaEntrega=" + fechaEntrega + ", nombre=" + nombre + ", rucProv=" + rucProv + ", numFactura="
				+ numFactura + ", totalImporte=" + totalImporte + ", estado=" + estado + ", moneda=" + moneda + ", DNI="
				+ DNI + ", nomproveedor=" + nomproveedor + "]";
	}

	public static Integer getIntInput(String j) {
		return (j == null || j.equals("")?0:Integer.parseInt(j));
	}
	public static Double getDouInput(String j) {
		return (j == null || j.equals("")?0.0:Double.parseDouble(j));
	}
		
}
