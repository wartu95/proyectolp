package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import clases.Participante;
import mantenimiento.GestionParticipanteDAO;
import utils.Tool;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class DlgListParticipante extends JDialog implements ActionListener {
	//insntanciar de la clase table
	DefaultTableModel model= new DefaultTableModel();
	GestionParticipanteDAO gPart = new GestionParticipanteDAO();
	Participante Part = new Participante();
	
	
	private JButton okButton;
	private JTable tbParticipante;
	private JScrollPane scrollPane ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListParticipante dialog = new DlgListParticipante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListParticipante() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 658, 353);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 285, 644, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
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
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 26, 624, 249);
			getContentPane().add(scrollPane);
			
			tbParticipante = new JTable();
			scrollPane.setViewportView(tbParticipante);
			tbParticipante.setFillsViewportHeight(true);
			
			
			tbParticipante.setModel(model);
		}
		
		
		model.addColumn("id_Participante");
		model.addColumn("Apellido");
		model.addColumn("Nombre");
		model.addColumn("DNI");
		model.addColumn("Telefono");
		model.addColumn("Correo");
		
		listarParticipante();
	}

		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	private void listarParticipante() {
		
		model.setRowCount(0);
		
		ArrayList<Participante> lista =gPart.ListarParticipante();
		
		if (lista.size() == 0) {
			Tool.mensajeError(this, "La lista esta vacia");
		}else {
			for(Participante Part : lista) {
				Object fila[] = { Part.getIdParticipante(), Part.getApellido(), Part.getNombre(),Part.getDni(),Part.getTelefono(),Part.getCorreo()};
				model.addRow(fila);
	}
	}
	}
	
	protected void actionPerformedOkButton(ActionEvent e) {
	enviarDatos();
	}

	private void enviarDatos() {
		String Idpart,Nombre,apellido,dni,telefono,correo;
		int fila;
		fila =tbParticipante.getSelectedRow();
		
		//Obener los datos de las columnas 
		Idpart = tbParticipante.getValueAt(fila, 0).toString();
	    apellido= tbParticipante.getValueAt(fila, 1).toString();
	    Nombre= tbParticipante.getValueAt(fila, 2).toString();
	    dni= tbParticipante.getValueAt(fila, 3).toString();
	    telefono= tbParticipante.getValueAt(fila, 4).toString();
	    correo = tbParticipante.getValueAt(fila, 5).toString();
		
		//enciar los datos a las cajas de texto del FrmBoleta
		FrmContrato.txtParticipante.setText(Idpart);
		FrmContrato.txtNombre.setText(Nombre);
		FrmContrato.txtApellido.setText(apellido);
		FrmContrato.txtDni.setText(dni);
		
		//cerra la ventana actual
		this.dispose();
		
	}
}
