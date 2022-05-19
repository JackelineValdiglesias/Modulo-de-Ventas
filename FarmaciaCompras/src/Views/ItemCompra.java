package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ItemCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textid;
	private JTextField textpu;
	private JTextField textitem;
	private JTextField textcant;
	private JTextField textimpor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemCompra dialog = new ItemCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemCompra() {
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
		textpu.setBounds(66, 116, 80, 20);
		contentPanel.add(textpu);
		textpu.setColumns(10);
		
		textitem = new JTextField();
		textitem.setBounds(66, 85, 309, 20);
		contentPanel.add(textitem);
		textitem.setColumns(10);
		
		textcant = new JTextField();
		textcant.setBounds(276, 116, 96, 20);
		contentPanel.add(textcant);
		textcant.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Importe total:");
		lblNewLabel_5.setBounds(173, 173, 86, 14);
		contentPanel.add(lblNewLabel_5);
		
		textimpor = new JTextField();
		textimpor.setEditable(false);
		textimpor.setAutoscrolls(false);
		textimpor.setBounds(289, 170, 86, 20);
		contentPanel.add(textimpor);
		textimpor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Compra");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_6.setBounds(160, 11, 81, 22);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
