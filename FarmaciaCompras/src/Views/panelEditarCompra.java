package Views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.BD;
import Clases.Compra;
import Clases.CompraItem;
import Clases.Response;

public class panelEditarCompra extends JPanel {

	/**
	 * Create the panel.
	 */
	public JTable table;
	private windowPrincipal parent;
	public JTextField txttrabajador;
	public JTextField txtdnitrabaj;
	public JTextField txtproveedor;
	public JTextField txtruc;
	public JTextField txtfactura;
	public JTextField txtdiaemi;
	public JTextField txtmesemi;
	public JTextField txtañoemi;
	public JTextField txtimporte;
	public JComboBox cbmoneda;
	public JTextField txtdiaesti;
	public JTextField txtmesesti;
	public JTextField txtañoesti;
	public JTextField txtdiaentre;
	public JTextField txtmesentre;
	public JTextField txtañoentre;
	public JTextField txtid;
	public JComboBox cbestado;
	public Compra c;
	public panelEditarCompra(windowPrincipal parent, Compra c) {
		this.c = c;
		
		this.setBounds(100, 100, 1117, 445);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		this.parent = parent; 
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Trabajador:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(203, 44, 212, 56);
		add(panel);
		panel.setLayout(null);
		txttrabajador = new JTextField();
		txttrabajador.setBounds(10, 26, 192, 20);
		panel.add(txttrabajador);
		txttrabajador.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "DNI:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(425, 44, 121, 56);
		this.add(panel_1);
		
		txtdnitrabaj = new JTextField();
		txtdnitrabaj.setColumns(10);
		txtdnitrabaj.setBounds(10, 22, 101, 20);
		panel_1.add(txtdnitrabaj);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Nombre del proveedor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(548, 44, 217, 56);
		this.add(panel_2);
		
		txtproveedor = new JTextField();
		txtproveedor.setColumns(10);
		txtproveedor.setBounds(10, 22, 200, 20);
		panel_2.add(txtproveedor);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(null, "RUC:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBounds(766, 44, 127, 56);
		this.add(panel_2_1);
		
		txtruc = new JTextField();
		txtruc.setColumns(10);
		txtruc.setBounds(10, 22, 107, 20);
		panel_2_1.add(txtruc);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(null, "Número de factura:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1.setBounds(425, 99, 218, 56);
		this.add(panel_2_1_1);
		
		txtfactura = new JTextField();
		txtfactura.setColumns(10);
		txtfactura.setBounds(10, 25, 180, 20);
		panel_2_1_1.add(txtfactura);
		
		/*
		if (txtfactura.isNumeric())
			System.out.println("Cadena numerica ");
		else
			System.out.println(txtfactura + " No es un numero");
		*/
		
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new TitledBorder(null, "Fecha de emisión:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1_1.setBounds(198, 155, 217, 56);
		this.add(panel_2_1_1_1);
		
		txtdiaemi = new JTextField();
		txtdiaemi.setBounds(10, 25, 51, 20);
		panel_2_1_1_1.add(txtdiaemi);
		txtdiaemi.setColumns(10);
		
		txtmesemi = new JTextField();
		txtmesemi.setColumns(10);
		txtmesemi.setBounds(71, 25, 53, 20);
		panel_2_1_1_1.add(txtmesemi);
		
		txtañoemi = new JTextField();
		txtañoemi.setColumns(10);
		txtañoemi.setBounds(134, 25, 73, 20);
		panel_2_1_1_1.add(txtañoemi);
		
		JLabel lblNewLabel_1 = new JLabel("Dia");
		lblNewLabel_1.setBounds(22, 11, 22, 14);
		panel_2_1_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mes");
		lblNewLabel_1_1.setBounds(89, 11, 31, 14);
		panel_2_1_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("A\u00F1o");
		lblNewLabel_1_1_1.setBounds(158, 11, 31, 14);
		panel_2_1_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Importe Total:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(744, 99, 149, 56);
		this.add(panel_1_1);
		
		txtimporte = new JTextField();
		txtimporte.setColumns(10);
		txtimporte.setBounds(10, 25, 107, 20);
		panel_1_1.add(txtimporte);
		
		JList list = new JList();
		list.setBounds(297, 295, -9, -19);
		this.add(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Moneda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(653, 99, 89, 56);
		this.add(panel_3);
		panel_3.setLayout(null);
		
		cbmoneda = new JComboBox();
		cbmoneda.setModel(new DefaultComboBoxModel(new String[] {"S/.", "$.", "Otros."}));
		cbmoneda.setBounds(10, 23, 69, 22);
		panel_3.add(cbmoneda);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//btn guardar
				System.out.print("Has pulsado el botón");
				guardar();
			}
		});
		btnguardar.setBounds(708, 402, 89, 23);
		this.add(btnguardar);
		
		JLabel lblNewLabel = new JLabel("Editar datos de compra");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel.setBounds(456, 10, 187, 23);
		this.add(lblNewLabel);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(null, "Fecha estimada de entrega:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1_1_1.setBounds(426, 155, 217, 56);
		this.add(panel_2_1_1_1_1);
		
		txtdiaesti = new JTextField();
		txtdiaesti.setColumns(10);
		txtdiaesti.setBounds(10, 25, 51, 20);
		panel_2_1_1_1_1.add(txtdiaesti);
		
		txtmesesti = new JTextField();
		txtmesesti.setColumns(10);
		txtmesesti.setBounds(71, 25, 53, 20);
		panel_2_1_1_1_1.add(txtmesesti);
		
		txtañoesti = new JTextField();
		txtañoesti.setColumns(10);
		txtañoesti.setBounds(134, 25, 73, 20);
		panel_2_1_1_1_1.add(txtañoesti);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dia");
		lblNewLabel_1_2.setBounds(22, 11, 22, 14);
		panel_2_1_1_1_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mes");
		lblNewLabel_1_1_2.setBounds(89, 11, 31, 14);
		panel_2_1_1_1_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("A\u00F1o");
		lblNewLabel_1_1_1_1.setBounds(158, 11, 31, 14);
		panel_2_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2_1_1_1_2 = new JPanel();
		panel_2_1_1_1_2.setLayout(null);
		panel_2_1_1_1_2.setBorder(new TitledBorder(null, "Fecha de entrega:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1_1_2.setBounds(653, 155, 240, 56);
		this.add(panel_2_1_1_1_2);
		
		txtdiaentre = new JTextField();
		txtdiaentre.setColumns(10);
		txtdiaentre.setBounds(10, 25, 51, 20);
		panel_2_1_1_1_2.add(txtdiaentre);
		
		txtmesentre = new JTextField();
		txtmesentre.setColumns(10);
		txtmesentre.setBounds(71, 25, 53, 20);
		panel_2_1_1_1_2.add(txtmesentre);
		
		txtañoentre = new JTextField();
		txtañoentre.setColumns(10);
		txtañoentre.setBounds(134, 25, 73, 20);
		panel_2_1_1_1_2.add(txtañoentre);
		
		JLabel lblNewLabel_1_3 = new JLabel("Dia");
		lblNewLabel_1_3.setBounds(22, 11, 22, 14);
		panel_2_1_1_1_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Mes");
		lblNewLabel_1_1_3.setBounds(89, 11, 31, 14);
		panel_2_1_1_1_2.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("A\u00F1o");
		lblNewLabel_1_1_1_2.setBounds(158, 11, 31, 14);
		panel_2_1_1_1_2.add(lblNewLabel_1_1_1_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Lista de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(198, 222, 695, 175);
		this.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 675, 123);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nombre", "Precio", "Cantidad", "Importe"
			}
		));
		scrollPane.setViewportView(table);
		//BD.listCompraItem(table, Integer.parseInt(txtid.getText()));//*
		
		JButton btnitem = new JButton("Nuevo Item");
		btnitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditItem();
			}
		});
		btnitem.setBounds(314, 11, 107, 23);
		panel_4.add(btnitem);
		
		JButton btneliminar = new JButton("Eliminar Item");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Editar Eliminar Item
				
				int row = table.getSelectedRow();
				TableModel m = table.getModel();
				System.out.println(row);
				if(row==-1 || table.getSelectedColumnCount() > 1) return;
								
				BD.deleteCompraItem(BD.intVal(m, row, 0)); //Falta Metodo
				BD.listCompraItem(table, Integer.parseInt(txtid.getText()));//Falta Metodo
				
			}
		});
		btneliminar.setBounds(553, 11, 114, 23);
		panel_4.add(btneliminar);
		
		JButton btneditar = new JButton("Editar Item");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btneditar.setBounds(429, 11, 114, 23);
		panel_4.add(btneditar);
		
		JButton btnRecargar = new JButton("Recargar Tabla");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
			}
		});
		btnRecargar.setBounds(151, 12, 153, 21);
		panel_4.add(btnRecargar);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btncancelar.setBounds(804, 402, 89, 23);
		this.add(btncancelar);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(null, "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3_1.setBounds(198, 99, 74, 56);
		this.add(panel_3_1);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(10, 25, 53, 20);
		panel_3_1.add(txtid);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(null, "Estado:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_2.setBounds(282, 99, 133, 56);
		this.add(panel_2_1_2);
		
		cbestado = new JComboBox();
		cbestado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado", "Entregado"}));
		cbestado.setBounds(10, 23, 105, 22);
		panel_2_1_2.add(cbestado);
		System.out.println("iddddddddddddd"+txtid.getText());
		if (c.id!=null) BD.listCompraItem(table, c.id);
		loadData();
	}
	private void loadData() {
		if(this.c.id == null) return;
		System.out.println("C:"+c);
		String[] fechaemision = c.fechaEmision.split("-",4);
		this.txtañoemi.setText(fechaemision[0]);
		this.txtmesemi.setText(fechaemision[1]);
		this.txtdiaemi.setText(fechaemision[2]);
		System.out.println(fechaemision[0]+fechaemision[1]+fechaemision[2]);
		
		String[] fechaestimada = c.fechaEntregaEstimada.split("-",4);
		this.txtañoesti.setText(fechaestimada[0]);
		this.txtmesesti.setText(fechaestimada[1]);
		this.txtdiaesti.setText(fechaestimada[2]);
		
		String[] fechaentrega = c.fechaEntrega.split("-",4);
		this.txtañoentre.setText(fechaentrega[0]);
		this.txtmesentre.setText(fechaentrega[1]);
		this.txtdiaentre.setText(fechaentrega[2]);
									
		this.txttrabajador.setText(c.nombre);
		this.txtdnitrabaj.setText(c.DNI);
		this.txtproveedor.setText(c.nomproveedor);
		this.txtruc.setText(c.rucProv);
		this.txtfactura.setText(c.numFactura);
		this.txtimporte.setText(String.valueOf(c.totalImporte));
		this.txtid.setText(String.valueOf(c.id));
		this.cbestado.setSelectedIndex(c.estado);
		this.cbmoneda.setSelectedIndex(c.moneda );
		
	}
	public void guardar() {
		System.out.println("Testing");
		Compra c = new Compra(this);
		System.out.println(c);
		
		try {
			Response r;
			if (c.id!=0)
				r = BD.editCompra(c);
			else
				r = BD.nuevaCompra(c);	
			if(r.status == 1) {
				Exito ex = new Exito(r.msg);
				ex.setVisible(true);
				this.parent.frame.setContentPane(new panelListaCompras(this.parent));
				this.parent.frame.revalidate();
			}
			else {
				Error er = new Error(r.msg);
				er.setVisible(true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	public void cancelar() {
		this.parent.frame.setContentPane(new panelListaCompras(this.parent));
		this.parent.frame.revalidate();
	}
	public void openEditItem() {
		ItemsCompra ni = new ItemsCompra(Integer.parseInt(txtid.getText()),this);
		System.out.println(Integer.parseInt(txtid.getText()));
		ni.setVisible(true);
	}
	public void reload() {
		if (c.id!=null) BD.listCompraItem(table, c.id);
	}
	public void editar() {
		System.out.println(table);
		int row = table.getSelectedRow();							
		TableModel m = table.getModel();			
		System.out.println(row);
		if(row==-1 || table.getSelectedColumnCount() > 1) return;								
		CompraItem c = BD.getCompraItem(BD.intVal(m, row, 0)); // Falta 
		System.out.println("Compra:"+c);
		ItemsCompra ei = new ItemsCompra(Integer.parseInt(txtid.getText()),this); //Falta metodo Editar()
		
		ei.textid.setText(String.valueOf(c.id));
		ei.textpu.setText(String.valueOf(c.precio));
		ei.textitem.setText(c.nombre);
		ei.textcant.setText(String.valueOf(c.cantidad));				
		ei.textimpor.setText(String.valueOf(c.importe));
		
		ei.setVisible(true);
	}
}
