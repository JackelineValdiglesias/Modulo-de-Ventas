package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.BD;
import Clases.Compra;
import Clases.CompraItem;
import Clases.Response;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ItemsCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textid;
	public JTextField textpu;
	public JTextField textitem;
	public JTextField textcant;
	public JTextField textimpor;
	public int idCompra;
	public panelEditarCompra parent;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemsCompra dialog = new ItemsCompra(1,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param parent 
	 */
	public ItemsCompra(int idCompra, panelEditarCompra parent) {
		this.idCompra=idCompra;
		this.parent = parent;
		setBounds(100, 100, 417, 285);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(10, 57, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(10, 119, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(10, 88, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setBounds(198, 119, 58, 14);
		contentPanel.add(lblNewLabel_4);
		
		textid = new JTextField();
		textid.setEditable(false);
		textid.setBounds(66, 54, 80, 20);
		contentPanel.add(textid);
		textid.setColumns(10);
		
		textpu = new JTextField();
		textpu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				System.out.println("E:"+e);
				if(c=='.' || c=='-') return;
		        if (c<'0' || c>'9') {		        	 
		        	 e.consume();
		        }
			}
		});
		textpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(Integer.parseInt(textpu.getText()));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		textpu.setBounds(66, 116, 80, 20);
		contentPanel.add(textpu);
		textpu.setColumns(10);
		
		textitem = new JTextField();
		textitem.setBounds(66, 85, 309, 20);
		contentPanel.add(textitem);
		textitem.setColumns(10);
		
		textcant = new JTextField();
		textcant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				System.out.println("E:"+e);
				if(c=='-') return;
		        if (c<'0' || c>'9') {		        	 
		        	 e.consume();
		        }
			}
		});
		textcant.setBounds(276, 116, 96, 20);
		contentPanel.add(textcant);
		textcant.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Importe total:");
		lblNewLabel_5.setBounds(173, 173, 86, 14);
		contentPanel.add(lblNewLabel_5);
		
		textimpor = new JTextField();
		textimpor.setEnabled(false);
		textimpor.setAutoscrolls(false);
		textimpor.setBounds(289, 170, 86, 20);
		contentPanel.add(textimpor);
		textimpor.setColumns(10);
				
		JLabel lblNewLabel_6 = new JLabel("Compra");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_6.setBounds(160, 11, 81, 22);
		contentPanel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textimpor.setText(""+Double.parseDouble(textpu.getText()) * Integer.parseInt(textcant.getText()));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(33, 169, 89, 23);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.print("Has pulsado el botón");
						guardar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//Editar
		
	}
	
	public void guardar() {	
		CompraItem c = new CompraItem(this);
		System.out.println("Item por guardar:"+c);
		if(!c.valido) {
			Error er = new Error(c.errores);
			er.setVisible(true);
			return;
		}
		try {
			Response r;			
			
			if (c.id!=0)
				r = BD.editCompraItem(c);//
			else
				r = BD.newCompraItem(c);//
			if(r.status == 1) {
				Compra cf = BD.getCompra(this.idCompra);
				this.parent.reload();
				this.setVisible(false);
				Exito ex = new Exito("Correcto!");
				ex.setVisible(true);
			}
			else {
				System.out.println("Aqui esta el error");
				Error er = new Error(r.msg);
				er.setVisible(true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void close() {
		this.setVisible(false);
	}
}
