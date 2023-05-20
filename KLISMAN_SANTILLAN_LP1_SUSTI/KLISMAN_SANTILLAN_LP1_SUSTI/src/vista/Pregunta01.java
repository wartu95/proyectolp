package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ComprobanteDAO;
import clase.Comprobante;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Pregunta01 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private ComprobanteDAO compDao = new ComprobanteDAO(); 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta01 frame = new Pregunta01();
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
	public Pregunta01() {
		setTitle("LISTADO  DE COMPROBANTE DE PAGOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 414, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel ();
		model.addColumn("ID VENTA");
		model.addColumn("ID CLIENTE");
		model.addColumn("FECHA VENC");
		model.addColumn("TOTAL");
		table.setModel(model);
		
		
		cargarData();
		
	}
	
	private void cargarData() {
		model.setRowCount(0);
		
		for (Comprobante obj: compDao.listarComprobante()) {
			Object[] x = new Object[] {
				obj.getIdVenta(),
				obj.getIdCliente(),
				obj.getFechaVenc(),
				obj.getTotal()
			};
			
			model.addRow(x);
		}
	}
}
