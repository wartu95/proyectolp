package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Contrato;
import clases.DetalleContrato;
import mantenimiento.GestionContratoDAO;
import mantenimiento.GestionDetalleContratoDAO;
import utils.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmDocumento extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblId_contrato;
	private JTextField txtIdContrato;
	private JLabel lblTipContrato;
	private JTextField txtTipoContrato;
	private JLabel lblDescripcion;
	private JTable tbDocumento;
	private JButton btnVisarDoc;

	DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTextArea txtDescripcion;

	GestionContratoDAO gCont = new GestionContratoDAO();
	GestionDetalleContratoDAO gDetCon = new GestionDetalleContratoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDocumento frame = new FrmDocumento();
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
	public FrmDocumento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("INFORMACION DEL DOCUMENTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 0, 621, 23);
		contentPane.add(lblNewLabel);

		lblId_contrato = new JLabel("Contrato:");
		lblId_contrato.setBounds(10, 58, 72, 14);
		contentPane.add(lblId_contrato);

		txtIdContrato = new JTextField();
		txtIdContrato.setBounds(10, 72, 114, 20);
		contentPane.add(txtIdContrato);
		txtIdContrato.setColumns(10);

		lblTipContrato = new JLabel("Tipo de Contrato:");
		lblTipContrato.setBounds(155, 58, 123, 14);
		contentPane.add(lblTipContrato);

		txtTipoContrato = new JTextField();
		txtTipoContrato.setBounds(155, 72, 114, 20);
		contentPane.add(txtTipoContrato);
		txtTipoContrato.setColumns(10);

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 103, 123, 14);
		contentPane.add(lblDescripcion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 74, 275, 127);
		contentPane.add(scrollPane);

		tbDocumento = new JTable();
		tbDocumento.addMouseListener(this);
		tbDocumento.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbDocumento);

		tbDocumento.setModel(model);

		btnVisarDoc = new JButton("Visar Doc");
		btnVisarDoc.addActionListener(this);
		btnVisarDoc.setBounds(10, 189, 89, 23);
		contentPane.add(btnVisarDoc);

		txtDescripcion = new JTextArea();
		JScrollPane scrollDescripcion = new JScrollPane();
		scrollDescripcion.setBounds(10, 128, 147, 50);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBorder(new EmptyBorder(4,4,4,4));
		scrollDescripcion.setViewportView(txtDescripcion);
		contentPane.add(scrollDescripcion);

		model.addColumn("ITEM");
		model.addColumn("ENCARGADO");
		model.addColumn("ESTADO");

		tbDocumento.setModel(model);

		cargarData();
		mostrarData();
	}

	private void mostrarData() {
		
		Contrato obj = FrmContratoVisado.objContrato;
		
		txtIdContrato.setEnabled(false);
		txtTipoContrato.setEnabled(false);
		txtDescripcion.setEnabled(false);
		
		// paso 2: mostrar la informacion obtenida de la tabla a las cajas de texto
		txtIdContrato.setText(obj.getIdContrato());
		txtTipoContrato.setText(obj.getTiPoContrato()+"");
		txtDescripcion.setText(obj.getDescripcion());

	}
	

	public void cargarData() {
		String id_contrato = FrmContratoVisado.objContrato.getIdContrato();
		// limpiar la tabla
		model.setRowCount(0);
		// Obtener el resultados del proceso
		ArrayList<DetalleContrato> lista = gDetCon.ListarDestalleContratoPorIdContrato(id_contrato);
		// Validar el resultado del proceso
		if (lista.size() == 0) {
			mensajeError("Lista Vacia");
		} else {
			// bucle
			for (DetalleContrato c : lista) {
				Object Fila[] = { c.getIdVisado(),c.getIdUsuario(),c.getEstado() };
				model.addRow(Fila);
			}
		}

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "!!Error !!!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVisarDoc) {
			actionPerformedBtnVisarDoc(e);
		}
	}

	protected void actionPerformedBtnVisarDoc(ActionEvent e) {
		registrarVisados();
	}

	private void registrarVisados() {
		List<Contrato> lista = gCont.listarContrato();
		boolean bandera = false;

		for (Contrato obj : lista) {
			if (obj.getIdContrato().equals(txtIdContrato.getText())) {
				bandera = true;
			}
		}

		if (bandera == true) {
			FrmPrincipal principal = new FrmPrincipal();

			FrmDetContrato ventana = new FrmDetContrato(principal, true);

			ventana.setLocationRelativeTo(this);
			ventana.setVisible(true);
			this.dispose();
			ventana.toFront();
		} else {
			Tool.mensajeError(this, "NO SE PUEDO VISAR UN CONTRATO QUE NO SE ENCUENTRE REGISTRADO");
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbDocumento) {
			mouseClickedTbDocumento(e);
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

	protected void mouseClickedTbDocumento(MouseEvent e) {
		//EVENTO DE LA TABLA AL DARLE CLICK
	}
}
