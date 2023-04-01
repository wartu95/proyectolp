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

public class DlgDetalleContratos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	//insntanciar de la clase table
	DefaultTableModel model= new DefaultTableModel();
	
	
	private JButton okButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDetalleContratos dialog = new DlgDetalleContratos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDetalleContratos() {
		setBounds(100, 100, 658, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setBorder(new TitledBorder(null, "CONTRATO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel2.setBounds(10, 10, 634, 247);
			contentPanel.add(panel2);
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(10, 46, 128, 20);
				panel2.add(textField);
			}
			{
				JLabel lblObjetoContrato = new JLabel("Objeto de contrato:");
				lblObjetoContrato.setBounds(10, 76, 96, 14);
				panel2.add(lblObjetoContrato);
			}
			{
				JComboBox cboObjeto = new JComboBox();
				cboObjeto.setBounds(10, 92, 146, 22);
				panel2.add(cboObjeto);
			}
			{
				JLabel lblTipoContrato = new JLabel("Tipo de Contrato:");
				lblTipoContrato.setBounds(10, 130, 113, 14);
				panel2.add(lblTipoContrato);
			}
			{
				JComboBox cboTipo = new JComboBox();
				cboTipo.setBounds(10, 150, 146, 22);
				panel2.add(cboTipo);
			}
			{
				JLabel lblFecha = new JLabel("Fecha Inicio :");
				lblFecha.setBounds(216, 21, 86, 14);
				panel2.add(lblFecha);
			}
			{
				JButton btnNuevo = new JButton("");
				btnNuevo.setBounds(148, 46, 46, 23);
				panel2.add(btnNuevo);
			}
			{
				JDateChooser dcFecha = new JDateChooser();
				dcFecha.setBounds(215, 46, 122, 20);
				panel2.add(dcFecha);
			}
			{
				JLabel lblDescrip = new JLabel("Descripcion de Tipo de Contrato :");
				lblDescrip.setBounds(202, 76, 226, 14);
				panel2.add(lblDescrip);
			}
			{
				JLabel lblEstado = new JLabel("Estado :");
				lblEstado.setBounds(355, 21, 46, 14);
				panel2.add(lblEstado);
			}
			{
				JLabel lblNroPedido = new JLabel("ID Contrato:");
				lblNroPedido.setBounds(10, 21, 72, 14);
				panel2.add(lblNroPedido);
			}
			{
				textField_1 = new JTextField();
				textField_1.setText("");
				textField_1.setColumns(10);
				textField_1.setBounds(202, 93, 383, 108);
				panel2.add(textField_1);
			}
			{
				JLabel lblEstado_1 = new JLabel("Aprobación");
				lblEstado_1.setBounds(485, 21, 72, 14);
				panel2.add(lblEstado_1);
			}
			{
				JComboBox cboObjeto_2 = new JComboBox();
				cboObjeto_2.setBounds(477, 44, 100, 22);
				panel2.add(cboObjeto_2);
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(354, 46, 86, 19);
				panel2.add(textField_3);
				textField_3.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		
	}

	

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Error !!",0);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	protected void actionPerformedOkButton(ActionEvent e) {
	
	}
}
