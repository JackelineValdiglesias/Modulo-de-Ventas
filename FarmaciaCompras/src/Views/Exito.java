package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exito extends JDialog {
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public Exito(String msg) throws IOException {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Operación Exitosa!");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(139, 122, 161, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel();
			ImageIcon imagen1=new javax.swing.ImageIcon(getClass().getResource("/imagenes/Success.png"));
			lblNewLabel_1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH))); 
			lblNewLabel_1.setBounds(171, 24, 101, 86);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblmsg = new JLabel(msg);
			lblmsg.setHorizontalAlignment(SwingConstants.CENTER);
			lblmsg.setBounds(124, 165, 197, 14);
			contentPanel.add(lblmsg);
		}
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ok");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}		
	}
	public void close() {
		this.setVisible(false);
	}

}
