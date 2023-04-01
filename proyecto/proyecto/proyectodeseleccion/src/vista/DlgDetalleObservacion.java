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
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;

public class DlgDetalleObservacion extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	//insntanciar de la clase table
	DefaultTableModel model= new DefaultTableModel();
	
	
	private JButton okButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnBuscar;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JDateChooser dcFechaApelacion;
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDetalleObservacion dialog = new DlgDetalleObservacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDetalleObservacion() {
		setBounds(100, 100, 658, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ADMINSTRATIVA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(57, 10, 192, 128);
		contentPanel.add(panel);
		
		lblNewLabel = new JLabel("ID Contrato :");
		lblNewLabel.setBounds(10, 26, 103, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 41, 103, 20);
		panel.add(textField);
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(123, 26, 40, 23);
		panel.add(btnBuscar);
		
		lblNewLabel_1 = new JLabel("Estado de Contrato :");
		lblNewLabel_1.setBounds(10, 72, 125, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 86, 103, 20);
		panel.add(textField_1);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "OBSERVACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(259, 10, 318, 128);
		contentPanel.add(panel_1);
		
		lblNewLabel_2 = new JLabel("ID Observacion :");
		lblNewLabel_2.setBounds(10, 22, 118, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 37, 92, 20);
		panel_1.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Estado de Observacion :");
		lblNewLabel_3.setBounds(10, 68, 150, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 86, 118, 20);
		panel_1.add(textField_3);
		
		lblNewLabel_4 = new JLabel("Fecha de la Observacion :");
		lblNewLabel_4.setBounds(152, 22, 156, 14);
		panel_1.add(lblNewLabel_4);
		
		dcFechaApelacion = new JDateChooser();
		dcFechaApelacion.setBounds(152, 37, 123, 20);
		panel_1.add(dcFechaApelacion);
		
		btnNewButton = new JButton("");
		btnNewButton.setBounds(193, 85, 40, 23);
		panel_1.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(57, 164, 530, 104);
		contentPanel.add(textArea);
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
