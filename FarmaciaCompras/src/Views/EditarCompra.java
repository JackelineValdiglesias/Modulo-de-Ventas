package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.BD;
import Clases.Compra;
import Clases.CompraItem;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class EditarCompra extends JFrame {

	public JPanel contentPane;
	public JTextField txttrabajador;
	public JTextField txtdnitrabaj;
	public JTextField txtproveedor;
	public JTextField txtruc;
	public JTextField txtfactura;
	public JTextField txtimporte;
	public JTextField txtdiaemi;
	public JTextField txtmesemi;
	public JTextField txtañoemi;
	public JTextField txtdiaesti;
	public JTextField txtmesesti;
	public JTextField txtañoesti;
	public JTextField txtdiaentre;
	public JTextField txtmesentre;
	public JTextField txtañoentre;
	public JTable table;
	public JTextField txtid;
	public JComboBox cbestado;
	public JComboBox cbmoneda;
	public Compra c;
	public ListaCompras Parent;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param listaCompras 
	 */
	public EditarCompra(Compra c, ListaCompras listaCompras) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nombre del Trabajador:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 65, 217, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txttrabajador = new JTextField();
		txttrabajador.setBounds(10, 22, 200, 20);
		panel.add(txttrabajador);
		txttrabajador.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "DNI:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(229, 65, 121, 56);
		contentPane.add(panel_1);
		
		txtdnitrabaj = new JTextField();	
		txtdnitrabaj.setColumns(10);
		txtdnitrabaj.setBounds(10, 22, 101, 20);
		panel_1.add(txtdnitrabaj);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Nombre del proveedor:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(360, 65, 217, 56);
		contentPane.add(panel_2);
		
		txtproveedor = new JTextField();
		txtproveedor.setColumns(10);
		txtproveedor.setBounds(10, 22, 200, 20);
		panel_2.add(txtproveedor);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(null, "RUC:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBounds(578, 65, 127, 56);
		contentPane.add(panel_2_1);
		
		txtruc = new JTextField();
		txtruc.setColumns(10);
		txtruc.setBounds(10, 22, 107, 20);
		panel_2_1.add(txtruc);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new TitledBorder(null, "Número de factura:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1.setBounds(276, 120, 217, 56);
		contentPane.add(panel_2_1_1);
		
		txtfactura = new JTextField();
		txtfactura.setColumns(10);
		txtfactura.setBounds(10, 25, 200, 20);
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
		panel_2_1_1_1.setBounds(10, 176, 217, 56);
		contentPane.add(panel_2_1_1_1);
		
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
		panel_1_1.setBounds(578, 120, 127, 56);
		contentPane.add(panel_1_1);
		
		txtimporte = new JTextField();
		txtimporte.setColumns(10);
		txtimporte.setBounds(10, 25, 107, 20);
		panel_1_1.add(txtimporte);
		
		JList list = new JList();
		list.setBounds(297, 295, -9, -19);
		contentPane.add(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Moneda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(503, 120, 74, 56);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		cbmoneda = new JComboBox();
		cbmoneda.setModel(new DefaultComboBoxModel(new String[] {"S/.", "$.", "Otros."}));
		cbmoneda.setBounds(10, 23, 54, 22);
		panel_3.add(cbmoneda);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//btn guardar
				System.out.print("Has pulsado el botón");
				guardar();
			}
		});
		btnguardar.setBounds(520, 423, 89, 23);
		contentPane.add(btnguardar);
		
		JLabel lblNewLabel = new JLabel("Editar datos de compra");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel.setBounds(256, 11, 187, 23);
		contentPane.add(lblNewLabel);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setLayout(null);
		panel_2_1_1_1_1.setBorder(new TitledBorder(null, "Fecha estimada de entrega:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_1_1_1.setBounds(250, 176, 217, 56);
		contentPane.add(panel_2_1_1_1_1);
		
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
		panel_2_1_1_1_2.setBounds(488, 176, 217, 56);
		contentPane.add(panel_2_1_1_1_2);
		
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
		panel_4.setBounds(10, 243, 695, 175);
		contentPane.add(panel_4);
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
				close();
			}
		});
		btnitem.setBounds(395, 11, 89, 23);
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
		btneliminar.setBounds(584, 11, 101, 23);
		panel_4.add(btneliminar);
		
		JButton btneditar = new JButton("Editar Item");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(table);
				int row = table.getSelectedRow();							
				TableModel m = table.getModel();			
				System.out.println(row);
				if(row==-1 || table.getSelectedColumnCount() > 1) return;								
				CompraItem c = BD.getCompraItem(BD.intVal(m, row, 0)); // Falta 
				System.out.println("Compra:"+c);
				ItemsCompra ei = new ItemsCompra(Integer.parseInt(txtid.getText()),null); //Falta metodo Editar()
				
				ei.textid.setText(String.valueOf(c.id));
				ei.textpu.setText(String.valueOf(c.precio));
				ei.textitem.setText(c.nombre);
				ei.textcant.setText(String.valueOf(c.cantidad));				
				ei.textimpor.setText(String.valueOf(c.importe));
				
				ei.setVisible(true);
			}
		});
		btneditar.setBounds(490, 11, 89, 23);
		panel_4.add(btneditar);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btncancelar.setBounds(616, 423, 89, 23);
		contentPane.add(btncancelar);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(null, "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3_1.setBounds(10, 120, 74, 56);
		contentPane.add(panel_3_1);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(10, 25, 53, 20);
		panel_3_1.add(txtid);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new TitledBorder(null, "Estado:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1_2.setBounds(94, 120, 172, 56);
		contentPane.add(panel_2_1_2);
		
		cbestado = new JComboBox();
		cbestado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado", "Entregado"}));
		cbestado.setBounds(10, 23, 152, 22);
		panel_2_1_2.add(cbestado);
		System.out.println("iddddddddddddd"+txtid.getText());
		if (c.id!=null) BD.listCompraItem(table, c.id);
	}
	public void guardar() {
		System.out.println("Testing");
		Compra c = new Compra(this);
		System.out.println(c);
		if (c.id!=0) {
			BD.editCompra(c);
		}
		else {
			BD.nuevaCompra(c);
		}		
		
		Exito ex;
		try {
			ex = new Exito("Correcto!");
			ListaCompras lc=new ListaCompras();
			lc.setVisible(true);	
			this.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	public void cancelar() {
		ListaCompras lc=new ListaCompras();
		lc.setVisible(true);		
		this.setVisible(false);
	}
	public void close() {
		ItemsCompra ni = new ItemsCompra(Integer.parseInt(txtid.getText()),null);
		System.out.println(Integer.parseInt(txtid.getText()));
		ni.setVisible(true);
		this.setVisible(false);
	}
}	
