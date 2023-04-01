package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class FrmObservacion extends JInternalFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtContrato;
	private JButton btnBuscar;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JDateChooser dcFechaApelacion;
	private JButton btnNewButton_1;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmObservacion frame = new FrmObservacion();
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
	public FrmObservacion() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Observacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ADMINSTRATIVA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 192, 128);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("ID Contrato :");
		lblNewLabel.setBounds(10, 26, 103, 14);
		panel.add(lblNewLabel);
		
		txtContrato = new JTextField();
		txtContrato.setBounds(10, 41, 103, 20);
		panel.add(txtContrato);
		txtContrato.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(123, 26, 40, 23);
		panel.add(btnBuscar);
		
		lblNewLabel_1 = new JLabel("Estado de Contrato :");
		lblNewLabel_1.setBounds(10, 72, 125, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 86, 103, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_2.setBounds(20, 140, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 165, 530, 211);
		contentPane.add(textArea);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OBSERVACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(212, 11, 318, 128);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_3 = new JLabel("ID Observacion :");
		lblNewLabel_3.setBounds(10, 22, 118, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 37, 92, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Estado de Observacion :");
		lblNewLabel_4.setBounds(10, 68, 150, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 86, 118, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Fecha de la Observacion :");
		lblNewLabel_5.setBounds(152, 22, 156, 14);
		panel_1.add(lblNewLabel_5);
		
		dcFechaApelacion = new JDateChooser();
		dcFechaApelacion.setBounds(152, 37, 123, 20);
		panel_1.add(dcFechaApelacion);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(193, 85, 40, 23);
		panel_1.add(btnNewButton_1);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(222, 387, 109, 23);
		contentPane.add(btnRegistrar);
	}
}
