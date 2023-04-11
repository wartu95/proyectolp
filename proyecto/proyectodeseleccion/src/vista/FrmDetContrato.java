package vista;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class FrmDetContrato extends JDialog {

	private JPanel contentPane;
	private JLabel lblIdContratado;
	private JTextField txtIdContrato;
	private JButton btnVisado;
	private JLabel lblEstadoVisado;
	private JComboBox<Object> cboEstadoVisado;
	private JTextField txtIdUsuario;
	private JLabel lblIdUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDetContrato frame = new FrmDetContrato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public FrmDetContrato(JFrame ventana, boolean x) {
		super(ventana,x);
		setTitle("VISADO DEL CONTRATO");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdContratado = new JLabel("ID CONTRATO");
		lblIdContratado.setBounds(10, 11, 94, 14);
		contentPane.add(lblIdContratado);
		
		txtIdContrato = new JTextField();
		txtIdContrato.setBounds(10, 26, 94, 20);
		contentPane.add(txtIdContrato);
		txtIdContrato.setColumns(10);
		
		btnVisado = new JButton("VISAR DOC");
		btnVisado.setBounds(157, 114, 89, 23);
		contentPane.add(btnVisado);
		
		lblEstadoVisado = new JLabel("ESTADO");
		lblEstadoVisado.setBounds(130, 11, 83, 14);
		contentPane.add(lblEstadoVisado);
		
		cboEstadoVisado = new JComboBox<Object>();
		cboEstadoVisado.setBounds(130, 25, 133, 22);
		contentPane.add(cboEstadoVisado);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setColumns(10);
		txtIdUsuario.setBounds(10, 72, 94, 20);
		contentPane.add(txtIdUsuario);
		
		lblIdUsuario = new JLabel("ID USUARIO");
		lblIdUsuario.setBounds(10, 57, 94, 14);
		contentPane.add(lblIdUsuario);
	}
}
