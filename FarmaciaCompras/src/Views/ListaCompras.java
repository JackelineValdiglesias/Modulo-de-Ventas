package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.BD;
import Clases.Compra;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class ListaCompras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCompras frame = new ListaCompras();					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaCompras() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 77, 619, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setForeground(Color.DARK_GRAY);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Fecha Emision", "Nombre Trabajador", "Nombre Proveedor", "Total Importe", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		BD.listCompra(table);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear();
				
			}
		});
		btnCrear.setBounds(34, 43, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(133, 43, 89, 23);
		contentPane.add(btnEditar);
		
		
		JLabel lblNewLabel = new JLabel("Listado de Compras");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(241, 11, 200, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();							
				TableModel m = table.getModel();			
				System.out.println(row);
				if(row==-1 || table.getSelectedColumnCount() > 1) return;
								
				BD.deleteCompra(BD.intVal(m, row, 0));
				BD.listCompra(table);
			}
		});
		btnEliminar.setBounds(232, 43, 89, 23);
		contentPane.add(btnEliminar);
		//String data[][]= {{"101", "Hola Mundo", " 12 "}, {"101", "Hola Mundo", " 12 "}};
		//String column[]= {"id", "name", "salario"};
		//table=new JTable(data,column);
	}
	public void crear() {
		EditarCompra ec = new EditarCompra(new Compra(),this);
		ec.setVisible(true);
		this.setVisible(false);
	}
	public void editar() {
		System.out.println(table);
		int row = table.getSelectedRow();							
		TableModel m = table.getModel();			
		System.out.println("rr"+row);
		if(row==-1 || table.getSelectedColumnCount() > 1) return;
						
		Compra c = BD.getCompra(BD.intVal(m, row, 0));
		EditarCompra ec = new EditarCompra(c,this);
		
		String[] fechaemision = c.fechaEmision.split("-",4);
		ec.txtañoemi.setText(fechaemision[0]);
		ec.txtmesemi.setText(fechaemision[1]);
		ec.txtdiaemi.setText(fechaemision[2]);
		System.out.println(fechaemision[0]+fechaemision[1]+fechaemision[2]);
		
		String[] fechaestimada = c.fechaEntregaEstimada.split("-",4);
		ec.txtañoesti.setText(fechaestimada[0]);
		ec.txtmesesti.setText(fechaestimada[1]);
		ec.txtdiaesti.setText(fechaestimada[2]);
		
		String[] fechaentrega = c.fechaEntrega.split("-",4);
		ec.txtañoentre.setText(fechaentrega[0]);
		ec.txtmesentre.setText(fechaentrega[1]);
		ec.txtdiaentre.setText(fechaentrega[2]);
									
		ec.txttrabajador.setText(c.nombre);
		ec.txtdnitrabaj.setText(c.DNI);
		ec.txtproveedor.setText(c.nomproveedor);
		ec.txtruc.setText(c.rucProv);
		ec.txtfactura.setText(c.numFactura);
		ec.txtimporte.setText(String.valueOf(c.totalImporte));
		ec.txtid.setText(String.valueOf(c.id));
		ec.cbestado.setSelectedIndex(c.estado);
		ec.cbmoneda.setSelectedIndex(c.moneda );
		ec.c=c;
		
		ec.setVisible(true);
		this.setVisible(false);
	}
}
