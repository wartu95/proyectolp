package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class FrmAyuda extends JFrame {

	private JPanel contentPane;
	private JSeparator separator;
	private JLabel lblPanel;
	private JLabel lblIntegrantes;
	private JLabel lblIntegrantes1;
	private JLabel lblIntegrantes3;
	private JLabel lblIntegrantes2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAyuda frame = new FrmAyuda();
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
	public FrmAyuda() {
		setTitle("Ayuda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(10, 76, 414, 205);
		contentPane.add(separator);
		
		lblPanel = new JLabel("PROYECTO  LP1");
		lblPanel.setBackground(SystemColor.menu);
		lblPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPanel.setBounds(10, 23, 414, 42);
		contentPane.add(lblPanel);
		
		lblIntegrantes = new JLabel("KLINSMANN SANTILLAN VALLES");
		lblIntegrantes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes.setBounds(98, 107, 221, 22);
		contentPane.add(lblIntegrantes);
		
		lblIntegrantes1 = new JLabel("JUAN CARLOS MORALES FARCEQUE");
		lblIntegrantes1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrantes1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes1.setBounds(98, 173, 221, 22);
		contentPane.add(lblIntegrantes1);
		
		lblIntegrantes3 = new JLabel("WILLINGTON JUNIOR ARMAS TUESTA");
		lblIntegrantes3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrantes3.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes3.setBounds(81, 140, 266, 22);
		contentPane.add(lblIntegrantes3);
		
		lblIntegrantes2 = new JLabel("FRANCISCO SIXTO MARTINEZ  CcALLO");
		lblIntegrantes2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrantes2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrantes2.setBounds(53, 203, 321, 22);
		contentPane.add(lblIntegrantes2);
	}
}
