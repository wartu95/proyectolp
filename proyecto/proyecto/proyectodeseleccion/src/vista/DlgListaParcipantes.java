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

public class DlgListaParcipantes extends JDialog implements ActionListener {
	//insntanciar de la clase table
	DefaultTableModel model= new DefaultTableModel();
	
	
	private JTable tbParticipantes;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListaParcipantes dialog = new DlgListaParcipantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListaParcipantes() {
		setBounds(100, 100, 626, 335);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 592, 278);
		getContentPane().add(scrollPane);
		
		tbParticipantes = new JTable();
		scrollPane.setViewportView(tbParticipantes);
		
		model.addColumn("id_Participante");
		model.addColumn("Nombre completo");
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
	}
}
