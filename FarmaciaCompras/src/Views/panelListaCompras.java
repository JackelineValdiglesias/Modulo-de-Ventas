package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Clases.BD;
import Clases.Compra;

public class panelListaCompras extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9120289202232625444L;
	public JTable table;
	private windowPrincipal parent;

	/**
	 * Create the panel.
	 */
	public panelListaCompras(windowPrincipal parent) {
		this.parent = parent; 
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 70, 1038, 337);
		this.add(scrollPane);
		
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
		this.add(btnCrear);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(133, 43, 89, 23);
		this.add(btnEditar);
		
		
		JLabel lblNewLabel = new JLabel("Listado de Compras");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(464, 10, 200, 23);
		this.add(lblNewLabel);
		
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
		this.add(btnEliminar);
	}
	public void crear() {
		this.parent.frame.setContentPane(new panelEditarCompra(this.parent, new Compra()));
		this.parent.frame.revalidate();
	}
	public void editar() {
		System.out.println(table);
		int row = table.getSelectedRow();							
		TableModel m = table.getModel();			
		System.out.println("rr"+row);
		if(row==-1 || table.getSelectedColumnCount() > 1) return;
						
		Compra c = BD.getCompra(BD.intVal(m, row, 0));
		System.out.println("C:::"+c);
		this.parent.frame.setContentPane(new panelEditarCompra(this.parent, c));
		this.parent.frame.revalidate();
	}
}
