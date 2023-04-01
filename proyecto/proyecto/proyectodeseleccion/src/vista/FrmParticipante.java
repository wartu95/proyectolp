package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import utils.Tool;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import Validaciones.Regex;
import clases.Admin;
import clases.Contrato;
import clases.Participante;
import mantenimiento.AdminDAO;
import mantenimiento.GestionContratoDAO;
import mantenimiento.ParticipanteDAO;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class FrmParticipante extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JTable tbParticipante;
	private JPanel panel_1;
	private JLabel lblIdContrato;
	private JButton btnBuscar;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_7;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtNombres;
	private JLabel lblNombres;
	private JTextField txtDNI;
	private JLabel lblDNI;
	private JLabel lblDni;

	// instanciar un objeto para modelar la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private ParticipanteDAO partDao;
	private AdminDAO admDao;
	private JTextField txtIdParticipante;
	private GestionContratoDAO contDao;
	private DefaultTableModel modelo;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmParticipante frame = new FrmParticipante();
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
	public FrmParticipante() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Participantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 681, 245);
		contentPane.add(scrollPane);

		tbParticipante = new JTable();
		scrollPane.setViewportView(tbParticipante);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 21, 681, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblIdContrato = new JLabel("ID. Participante :");
		lblIdContrato.setBounds(10, 24, 96, 14);
		panel_1.add(lblIdContrato);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(FrmParticipante.class.getResource("/img/query.png")));
		btnBuscar.setBounds(134, 33, 43, 26);
		panel_1.add(btnBuscar);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 70, 75, 14);
		panel_1.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(10, 90, 156, 20);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(332, 70, 75, 14);
		panel_1.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(332, 90, 156, 20);
		panel_1.add(txtCorreo);
		txtCorreo.setColumns(10);

		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(186, 121, 75, 14);
		panel_1.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(186, 143, 123, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(10, 143, 156, 20);
		panel_1.add(txtNombres);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 121, 123, 14);
		panel_1.add(lblNombres);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(186, 90, 123, 20);
		panel_1.add(txtDNI);

		lblDNI = new JLabel("");
		lblDNI.setBounds(186, 70, 75, 14);
		panel_1.add(lblDNI);

		lblDni = new JLabel("DNI:");
		lblDni.setBounds(186, 70, 75, 14);
		panel_1.add(lblDni);
		
		txtIdParticipante = new JTextField();
		txtIdParticipante.setColumns(10);
		txtIdParticipante.setBounds(10, 39, 114, 20);
		panel_1.add(txtIdParticipante);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(FrmParticipante.class.getResource("/img/new (1).png")));
		btnNuevo.setBounds(187, 33, 37, 26);
		panel_1.add(btnNuevo);

		lblNewLabel_7 = new JLabel("TABLA DE PARTICIPANTE");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(0, 206, 701, 23);
		contentPane.add(lblNewLabel_7);

		btnAgregar = new JButton("REGISTRAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAgregar.setBounds(133, 487, 89, 23);
		contentPane.add(btnAgregar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(311, 487, 112, 23);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(521, 487, 89, 23);
		contentPane.add(btnEliminar);

		// agregar columna
		model.addColumn("ID CONTRATO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("APELLIDOS");
		model.addColumn("NOMBRES");
		model.addColumn("DNI");
		model.addColumn("TELEFONO");
		model.addColumn("DIRECCION");
		model.addColumn("CORREO");

		// asociar tabla
		tbParticipante.setModel(model);

		new AdminDAO();
		partDao = new ParticipanteDAO();
		admDao = new AdminDAO();

	}

	
}
