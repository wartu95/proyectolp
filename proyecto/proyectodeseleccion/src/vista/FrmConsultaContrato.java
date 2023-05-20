package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Contrato;
import mantenimiento.GestionContratoDAO;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaContrato extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	//INSTANCIAR OBJETOS
	GestionContratoDAO conDao = new GestionContratoDAO();
	Contrato objCon = new Contrato();
	private JLabel lblEstadoContrato;
	private JComboBox <Object>cboEstadoContrato;
	private JButton btnConsultar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaContrato frame = new FrmConsultaContrato();
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
	public FrmConsultaContrato() {
		setTitle("CONSULTA DE CONTRATOS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setIconifiable(true);
		this.setClosable(true);
		this.setMaximizable(true);
		
		setBounds(100, 100, 820, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		//table.setAutoResizeMode(0);
		
		model = new DefaultTableModel();
		model.addColumn("ID CONTRATO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("TIPO DE CONTRATO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("RESOLUCION");
		model.addColumn("ESTADO");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 794, 436);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(192, 192, 192));
		table.setModel(model);
		
		lblEstadoContrato = new JLabel("ESTADO DE CONTRATO");
		
		cboEstadoContrato = new JComboBox<Object>();
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cboEstadoContrato, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEstadoContrato, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEstadoContrato)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboEstadoContrato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		arranque();
		
	}
	
	public void arranque() {
		cargarTablaParticipante();
		cargarEstadoContrato();
	}
	
	public void cargarTablaParticipante() {
		
		model.setRowCount(0);
		List<Contrato> lista=conDao.listarContrato();
		
		for(Contrato obj:lista ) {
			
			Object [] x = new Object[]{
					obj.getIdContrato(),
					obj.getIdParticipante(),
					obj.getTiPoContrato(),
					obj.getDescripcion(),
					obj.getFecha(),
					obj.getResolucion(),
					obj.getEstado()
			};
			model.addRow(x);
		}
	}
	
	public void cargarContratoPorEstado() {
		
		String estado= cboEstadoContrato.getSelectedItem().toString();
		
		model.setRowCount(0);
		List<Contrato> lista=conDao.listarContrato();
		
		for(Contrato obj:lista ) {
			
			if(cboEstadoContrato.getSelectedIndex()!=0) {
				if(obj.getEstado().equals(estado)) {
					Object [] x = new Object[]{
							obj.getIdContrato(),
							obj.getIdParticipante(),
							obj.getTiPoContrato(),
							obj.getDescripcion(),
							obj.getFecha(),
							obj.getResolucion(),
							obj.getEstado()
					};
					model.addRow(x);
				}
			}else {
				JOptionPane.showMessageDialog(this, "ELIGA UNA ESTADO DE LA LISTA");
			}
			
		}
	}
	
	public void cargarEstadoContrato() {
		
		List<Contrato> lista=conDao.listarContrato();
		
		cboEstadoContrato.addItem("SELECCIONAR ESTADO");
		cboEstadoContrato.setSelectedIndex(0);
		
		for(Contrato obj:lista ) {
			cboEstadoContrato.addItem(obj.getEstado());
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		cargarContratoPorEstado();
	}
}
