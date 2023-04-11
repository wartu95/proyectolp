package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Contrato;
import mantenimiento.GestionContratoDAO;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class FrmConsultaContrato extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	//INSTANCIAR OBJETOS
	GestionContratoDAO conDao = new GestionContratoDAO();
	Contrato objCon = new Contrato();
	

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
		
		setBounds(100, 100, 807, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 771, 411);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		//table.setAutoResizeMode(0);
		
		model = new DefaultTableModel();
		model.addColumn("ID CONTRATO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("TIPO DE CONTRATO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("RESOLUCION");
		model.addColumn("ESTADO");
		table.setModel(model);
		
		arranque();
		
	}
	
	public void arranque() {
		cargarTablaParticipante();
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
					obj.getResulucion(),
					obj.getEstado()
			};
			
			model.addRow(x);
			
		}
		
	}
}
