package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FrmAdministrativo extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblNroContrato;
	private JLabel lblIdAdmin;
	private JTextField txtAdmin;
	private JButton btnBuscarPedido;
	private JButton btnNuevo;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDNI;
	private JTextField txtDNI;
	private JLabel lblCargo;
	private JTextField txtCargo;
	private JLabel lblArea;
	private JTextField txtArea;
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNewButton_4;
	private JTextField txtContrato;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdministrativo frame = new FrmAdministrativo();
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
	public FrmAdministrativo() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Area Administrativa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(364, 416, 102, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(588, 416, 102, 23);
		contentPane.add(btnEliminar);
		
		btnNewButton_4 = new JButton("REGISTRAR");
		btnNewButton_4.setBounds(160, 416, 102, 23);
		contentPane.add(btnNewButton_4);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Administrativa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(214, 21, 562, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblIdAdmin = new JLabel("ID Administrativa:");
		lblIdAdmin.setBounds(29, 28, 108, 14);
		panel.add(lblIdAdmin);
		
		txtAdmin = new JTextField();
		txtAdmin.setBounds(29, 48, 86, 20);
		panel.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		txtArea = new JTextField();
		txtArea.setBounds(199, 102, 137, 20);
		panel.add(txtArea);
		txtArea.setColumns(10);
		
		lblArea = new JLabel("Area:");
		lblArea.setBounds(199, 79, 86, 14);
		panel.add(lblArea);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(361, 48, 145, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(29, 79, 124, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(29, 102, 147, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(361, 28, 108, 14);
		panel.add(lblDNI);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 48, 137, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(361, 79, 115, 14);
		panel.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(361, 102, 147, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(199, 28, 135, 14);
		panel.add(lblNombre);
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(132, 47, 33, 22);
		panel.add(btnBuscar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contrato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 21, 194, 131);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNroContrato = new JLabel("ID Contrato:");
		lblNroContrato.setBounds(10, 19, 108, 14);
		panel_1.add(lblNroContrato);
		
		txtContrato = new JTextField();
		txtContrato.setBounds(53, 44, 94, 20);
		panel_1.add(txtContrato);
		txtContrato.setColumns(10);
		
		btnBuscarPedido = new JButton("");
		btnBuscarPedido.setBounds(51, 79, 33, 23);
		panel_1.add(btnBuscarPedido);
		
		btnNuevo = new JButton("");
		btnNuevo.setBounds(114, 80, 33, 22);
		panel_1.add(btnNuevo);
		
		table = new JTable();
		table.setBounds(10, 190, 782, 215);
		contentPane.add(table);
	}
}
