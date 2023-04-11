package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Participante;
import mantenimiento.GestionParticipanteDAO;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class FrmConsultaParticipante extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	//INSTANCIAR OBJETOS
	GestionParticipanteDAO parDao = new GestionParticipanteDAO();
	Participante objPar = new Participante();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaParticipante frame = new FrmConsultaParticipante();
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
	public FrmConsultaParticipante() {
		setTitle("CONSULTA DE PARTICIPANTES");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		
		setBounds(100, 100, 648, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 612, 341);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		
		model = new DefaultTableModel();
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("APELLIDO");
		model.addColumn("NOMBRE");
		model.addColumn("DNI");
		model.addColumn("TELEFONO");
		model.addColumn("CORREO");
		table.setModel(model);
		
		arranque();
		
	}
	
	public void arranque() {
		cargarTablaParticipante();
	}
	
	public void cargarTablaParticipante() {
		
		model.setRowCount(0);
		List<Participante> lista=parDao.ListarParticipante();
		
		for(Participante obj:lista ) {
			
			Object [] x = new Object[]{
					obj.getIdParticipante(),
					obj.getApellido(),
					obj.getNombre(),
					obj.getDni(),
					obj.getTelefono(),
					obj.getCorreo()
			};
			
			model.addRow(x);
			
		}
		
	}
}