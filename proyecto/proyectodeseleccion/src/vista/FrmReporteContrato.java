package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import clases.Contrato;
import clases.Usuario;
import mantenimiento.GestionContratoDAO;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.*;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmReporteContrato extends JInternalFrame implements ActionListener {
	private JPanel panelReporte;
	private JButton btnReporte;
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

	private JPanel panelBusquedaFecha;
	private JDateChooser dcFecha;
	private JLabel lblNewLabel;
	private JPanel panelBusquedad;

	GestionContratoDAO gCont = new GestionContratoDAO();
	private JButton btnLimpiar;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteContrato frame = new FrmReporteContrato();
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
	public FrmReporteContrato() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Reporte de Contrato");
		setBounds(100, 100, 836, 720);
		getContentPane().setLayout(null);

		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Reporte de Contratos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReporte.setBounds(10, 158, 804, 501);
		getContentPane().add(panelReporte);

		panelBusquedaFecha = new JPanel();
		panelBusquedaFecha.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Busqueda por Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedaFecha.setToolTipText("");
		panelBusquedaFecha.setBounds(10, 26, 304, 122);
		getContentPane().add(panelBusquedaFecha);
		panelBusquedaFecha.setLayout(null);

		btnReporte = new JButton("");
		btnReporte.setBounds(236, 65, 58, 47);
		panelBusquedaFecha.add(btnReporte);
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteContrato.class.getResource("/img/calendar.png")));

		dcFecha = new JDateChooser();
		dcFecha.setBounds(151, 21, 143, 25);
		panelBusquedaFecha.add(dcFecha);

		lblNewLabel = new JLabel("Fecha  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(31, 27, 86, 19);
		panelBusquedaFecha.add(lblNewLabel);

		panelBusquedad = new JPanel();
		panelBusquedad.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Reporte General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedad.setBounds(335, 26, 188, 122);
		getContentPane().add(panelBusquedad);
		panelBusquedad.setLayout(null);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmReporteContrato.class.getResource("/img/delete (2).png")));
		btnLimpiar.setBounds(102, 41, 62, 48);
		panelBusquedad.add(btnLimpiar);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(FrmReporteContrato.class.getResource("/img/Reporte-icon.png")));
		btnNewButton.setBounds(21, 41, 62, 48);
		panelBusquedad.add(btnNewButton);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {

		String fecha;
		fecha = getFec();
		if (fecha == null) {
			return;
		} else {

			ArrayList<Contrato> listCs = gCont.listarContratoxFecha(fecha);
			if (listCs.size() == 0) {
				utils.Tool.mensajeError(this, "Lista vacia");
			} else {

				try {
					
					JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(listCs);

					String fileName = "Report_Contrato.jasper";

					JasperPrint jaspPrint = ModelReporte.generar(fileName, data, null);

					JRViewer jvi = new JRViewer(jaspPrint);
					jvi.setPreferredSize(panelReporte.getSize());

					panelReporte.removeAll();
					panelReporte.add(jvi);
					panelReporte.repaint();
					panelReporte.revalidate();

				} catch (Exception e2) {
					System.out.println("Error al generar Reporte " + e2.getMessage());
				}

		}
		}
	    }

	private String getFec() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(dcFecha.getDate());
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		ArrayList<Contrato> lisCont = gCont.listarContrato();

		try {
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lisCont);

			String fileName = "Report_Contrato.jasper";

			JasperPrint jaspPrint = ModelReporte.generar(fileName, data, null);

			JRViewer jvi = new JRViewer(jaspPrint);

			panelReporte.removeAll();
			jvi=null;
			panelReporte.repaint();
			panelReporte.revalidate();

		} catch (Exception e1) {
			System.out.println("Error al generar reporte " + e1.getMessage());
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		ArrayList<Contrato> lisCont = gCont.listarContrato();

		try {
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lisCont);

			String fileName = "Report_Contrato.jasper";

			JasperPrint jaspPrint = ModelReporte.generar(fileName, data, null);

			JRViewer jvi = new JRViewer(jaspPrint);
			jvi.setPreferredSize(panelReporte.getSize());

			panelReporte.removeAll();
			panelReporte.add(jvi);
			panelReporte.repaint();
			panelReporte.revalidate();

		} catch (Exception e1) {
			System.out.println("Error al generar reporte " + e1.getMessage());
		}
	}
}