package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import clases.Contrato;
import mantenimiento.GestionContratoDAO;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;

	public class FrmContratoVisado extends JInternalFrame implements ActionListener, MouseListener{
		
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel  lblNewLabel_1;
	private JTextField txtcontrato;
	private JTable tbLista;
	private JButton btnVisualizar;
	private JScrollPane scrollPane;

	DefaultTableModel model = new DefaultTableModel();
	GestionContratoDAO gCont = new GestionContratoDAO();
	
	public static Contrato objContrato = new Contrato();
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmContratoVisado frame = new FrmContratoVisado();
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
	public FrmContratoVisado() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		
		
		setTitle("Listado Contrato");
		setBounds(100, 100, 727, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("LISTADO DE CONTRATOS");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 711, 30);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("ID_Contrato:");
		lblNewLabel_1.setBounds(21, 45, 77, 14);
		contentPane.add(lblNewLabel_1);

		txtcontrato = new JTextField();
		txtcontrato.setBounds(20, 70, 91, 20);
		contentPane.add(txtcontrato);
		txtcontrato.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 111, 671, 259);
		contentPane.add(scrollPane);

		tbLista = new JTable();
		tbLista.addMouseListener(this);
		tbLista.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbLista);

		btnVisualizar = new JButton("VISUALIZAR");
		btnVisualizar.addActionListener(this);
		btnVisualizar.setBounds(134, 69, 114, 23);
		contentPane.add(btnVisualizar);

		model.addColumn("Id_Contrato");
		model.addColumn("Tipo de contrato");
		model.addColumn("Id_participante");
		model.addColumn("Fecha");
		model.addColumn("Descripcion");
		model.addColumn("Resolucion");
		model.addColumn("Estado");

		// mostrar tabla
		tbLista.setModel(model);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(264, 69, 114, 23);
		contentPane.add(btnActualizar);
		// CARGAR TABLA CONTRATOS
		cargarDataContratos();
	}

	private void mostrarData(int posFila) {
		// paso : obtener los valores de la tabla
		String cont;
		
		cont = tbLista.getValueAt(posFila, 0).toString();

		// paso 2: mostrar la informacion obtenida de la tabla a las cajas de texto
		txtcontrato.setText(cont);
		
		objContrato= gCont.buscarContrato(cont);

	}

	private void cargarDataContratos() {
		// limpiar la tabla
		model.setRowCount(0);
		// Obtener el resultados del proceso
		ArrayList<Contrato> lista = gCont.listarContrato();
		// Validar el resultado del proceso
		if (lista.size() == 0) {
			mensajeError("Lista Vacia");
		} else {
			// bucle
			for (Contrato c : lista) {
				Object Fila[] = { c.getIdContrato(), c.getTiPoContrato(), c.getIdParticipante(), c.getFecha(),
						c.getDescripcion(), c.getResolucion(), c.getEstado() };
				model.addRow(Fila);
			}
		}

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "!!Error !!!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnVisualizar) {
			actionPerformedBtnVisualizar(e);
		}
	}

	protected void actionPerformedBtnVisualizar(ActionEvent e) {
		visualizarInforme();
	}

	private void visualizarInforme() {
		List<Contrato> lista = gCont.listarContrato();
		boolean ban = false;

		for (Contrato obj : lista) {
			if (obj.getIdContrato().equals(txtcontrato.getText())) {
				ban = true;
			}

		}
		if (ban == true) {

			FrmDocumento ventana = new FrmDocumento();

			ventana.setLocationRelativeTo(this);
			ventana.setVisible(true);
			ventana.toFront();
		} else {
			Tool.mensajeError(this, "NO SE PUEDO VISUALIZAR UN CONTRATO QUE NO SE ENCUENTRE REGISTRADO");
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbLista) {
			mouseClickedTbLista(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTbLista(MouseEvent e) {
		// obtener el valor de la fila seleecionada
		int posFila;
		
		posFila = tbLista.getSelectedRow();
		// Mostrar data
		mostrarData(posFila);
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		cargarDataContratos();
	}
}
