package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.TipoUsuario;
import clases.Usuario;
import mantenimiento.TipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Tool;

@SuppressWarnings("serial")
public class FrmUsuario extends JInternalFrame implements ActionListener, MouseListener{
	private JLabel lblIdUsuario;
	private JTextField txtIdUsuario;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JTextField txtContraseña;
	private JLabel lblContraseña;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JTable tabla;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	
	
	DefaultTableModel model = new DefaultTableModel();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	
	
	public static void main(String [] args) {
		
		FrmUsuario form = new FrmUsuario();
		form.setVisible(true);
		
	}
	
	public FrmUsuario() {
		getContentPane().setBackground(new Color(192, 192, 192));
		
		setTitle("USUARIO");
		setBounds(100,100,696,432);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		lblIdUsuario = new JLabel("IdUsuario");
		lblIdUsuario.setBounds(10, 11, 73, 14);
		getContentPane().add(lblIdUsuario);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(10, 32, 78, 20);
		getContentPane().add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(78, 79, 156, 20);
		getContentPane().add(txtNombre);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 82, 73, 14);
		getContentPane().add(lblNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(78, 123, 156, 20);
		getContentPane().add(txtApellido);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 126, 73, 14);
		getContentPane().add(lblApellido);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(98, 32, 156, 20);
		getContentPane().add(txtContraseña);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(115, 11, 87, 14);
		getContentPane().add(lblContraseña);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(338, 99, 113, 28);
		getContentPane().add(txtEstado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(351, 74, 87, 14);
		getContentPane().add(lblEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 660, 214);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();
		tabla.setFillsViewportHeight(true);
		tabla.addMouseListener(this);
		scrollPane.setViewportView(tabla);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(533, 136, 113, 23);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(533, 102, 113, 23);
		getContentPane().add(btnModificar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(533, 31, 113, 23);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(533, 66, 113, 23);
		getContentPane().add(btnRegistrar);
		
		model = new DefaultTableModel ();
		model.addColumn("IDUSUARIO");
		model.addColumn("CONTRASE�A");
		model.addColumn("APELLIDO");
		model.addColumn("IDCARGO");
		model.addColumn("IDPERFIL");
		
		tabla.setModel(model);
	    


  
	}
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
