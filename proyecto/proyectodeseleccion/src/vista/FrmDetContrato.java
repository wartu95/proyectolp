package vista;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Contrato;
import clases.DetalleContrato;
import clases.TipoUsuario;
import clases.Usuario;
import mantenimiento.GestionContratoDAO;
import mantenimiento.GestionDetalleContratoDAO;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmDetContrato extends JDialog implements ActionListener {

	private JPanel  contentPane;
	private JLabel lblIdContratado;
	private JTextField txtIdContrato;
	private JButton btnVisado;
	private JLabel lblEstadoVisado;
	private JComboBox<Object> cboIdCargo;
	private JLabel lblIdUsuario;
	private JTextField txtEstadoContrato;
	
	private GestionContratoDAO gCon =new  GestionContratoDAO();
	private GestionUsuarioDAO gUsu = new GestionUsuarioDAO();
	private GestionTipoUsuarioDAO gtipUsu = new GestionTipoUsuarioDAO();
	private JTextField txtItemVisado;
	private JLabel lblItemVisado;

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
		setBounds(100, 100, 399, 153);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
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
		btnVisado.addActionListener(this);
		btnVisado.setBounds(239, 71, 89, 23);
		contentPane.add(btnVisado);
		
		lblEstadoVisado = new JLabel("ESTADO");
		lblEstadoVisado.setBounds(253, 11, 83, 14);
		contentPane.add(lblEstadoVisado);
		
		cboIdCargo = new JComboBox<Object>();
		cboIdCargo.setBounds(10, 72, 148, 20);
		contentPane.add(cboIdCargo);
		
		lblIdUsuario = new JLabel("ID USUARIO");
		lblIdUsuario.setBounds(10, 57, 94, 14);
		contentPane.add(lblIdUsuario);
		
		txtEstadoContrato = new JTextField();
		txtEstadoContrato.setBounds(253, 26, 120, 20);
		contentPane.add(txtEstadoContrato);
		txtEstadoContrato.setColumns(10);
		
		txtItemVisado = new JTextField();
		txtItemVisado.setColumns(10);
		txtItemVisado.setBounds(120, 26, 94, 20);
		contentPane.add(txtItemVisado);
		
		lblItemVisado = new JLabel("ITEM VISADO");
		lblItemVisado.setBounds(120, 11, 94, 14);
		contentPane.add(lblItemVisado);
		
		mostrarDetalle();
		cargarUsuario();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVisado) {
			actionPerformedBtnVisado(e);
		}
	}
	
	protected void actionPerformedBtnVisado(ActionEvent e) {
		
		visarContrato();
		
	}
	
	
	//GETTER
	
	public String getIdContrato() {
		String res = null;
		
		res = txtIdContrato.getText();
		
		return res;
	}
	
	public String getEstado() {
		String res = null;
		
		res = txtEstadoContrato.getText();
		
		return res;
	}
	
	public String getIdCargo() {
		String res = null;
		
		res= cboIdCargo.getSelectedItem().toString();
		
		return res;
	}
	
	public int getItemVisado() {
		int res= -1;
		
		res = Integer.parseInt(txtItemVisado.getText());
		
		return res;
	}
	
	//METODOS QUE RETORNAN VALORES
	
	private int correlativoItem() {
		int res = -1;
		
		Contrato objCon = FrmContratoVisado.objContrato;
		
		if(new GestionDetalleContratoDAO().ListarDestalleContratoPorIdContrato(objCon.getIdContrato()).size()==0){
			res = 1;
		}else {
			for (DetalleContrato obj: new GestionDetalleContratoDAO().ListarDestalleContratoPorIdContrato(objCon.getIdContrato())) {
				res = obj.getIdVisado() +1;
			}
		}
		
		
		return res;
	}
	
	//VOID
	
	private void visarContrato() {
		
		int res = 0;
		
		String idContrato = getIdContrato();
		int idVisado = getItemVisado();
		String idUsuario = getIdCargo();
		String estado = getEstado();
		
		DetalleContrato objDetCon = new DetalleContrato(idContrato,idVisado,idUsuario,estado);
		
		Contrato objCon = FrmContratoVisado.objContrato;
		
		objCon.setEstado("PENDIENTE");
		
		
		if (new GestionDetalleContratoDAO().ListarDestalleContratoPorIdContrato(idContrato).size()>=3){
			Tool.mensajeError(this, "SOLO SE PUEDE HACER 3 VISADOS");
			return;
		}else if (new GestionDetalleContratoDAO().ListarDestalleContratoPorIdContrato(idContrato).size()>=2){
			objCon.setEstado("APROBADO");
			res = gCon.visarContrato(objDetCon, objCon);
			
			if(res!=0) {
				Tool.mensajeExito(this, "VISADO EXITOSO, DOCUMENTO APROBADO");
				FrmDocumento doc = new FrmDocumento();
				doc.setVisible(true);
				doc.setLocationRelativeTo(this);
				this.dispose();
			}else {
				utils.Tool.mensajeError(this, "VISADO FALLIDO");
			}
			return;
		}else {
			res = gCon.visarContrato(objDetCon, objCon);
			
			if(res!=0) {
				Tool.mensajeExito(this, "VISADO EXITOSO");
				FrmDocumento doc = new FrmDocumento();
				doc.setVisible(true);
				doc.setLocationRelativeTo(this);
				this.dispose();
			}else {
				utils.Tool.mensajeError(this, "VISADO FALLIDO");
			}
			return;
		}
		
		
	}
	
	private void mostrarDetalle() {
		
		Contrato objCon = FrmContratoVisado.objContrato;
		
		txtIdContrato.setText(objCon.getIdContrato());
		txtItemVisado.setText(correlativoItem() + "");
		txtEstadoContrato.setText("APROBADO");
		
	}
	
	private void cargarUsuario() {
		
		cboIdCargo.addItem("SELECCIONE USUARIO");
		cboIdCargo.setSelectedIndex(0);
		
		for (TipoUsuario obj: gtipUsu.listarTipoUsuarios() ) {
			
			cboIdCargo.addItem(obj.getDescripCargo());
			
		}
		
	}
}
