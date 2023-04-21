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
import clases.Participante;
import clases.Usuario;
import mantenimiento.GestionContratoDAO;
import mantenimiento.GestionParticipanteDAO;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.*;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmReporteParticipante extends JInternalFrame implements ActionListener {
	private JPanel panelReporte;
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
 
    GestionContratoDAO gCont = new GestionContratoDAO();
    GestionParticipanteDAO gPart = new GestionParticipanteDAO();
    private JPanel panelBusquedad;
    private JButton btnLimpiar;
    private JButton btnReporteGeneral;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteParticipante frame = new FrmReporteParticipante();
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
	public FrmReporteParticipante() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Reporte de Participante");
		setBounds(100, 100, 836, 651);
		getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reporte de Participante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReporte.setBounds(10, 132, 804, 480);
		getContentPane().add(panelReporte);
		
		panelBusquedad = new JPanel();
		panelBusquedad.setLayout(null);
		panelBusquedad.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						" Reporte General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedad.setBounds(10, 10, 188, 100);
		getContentPane().add(panelBusquedad);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setIcon(new ImageIcon(FrmReporteParticipante.class.getResource("/img/delete (2).png")));
		btnLimpiar.setBounds(103, 30, 62, 48);
		panelBusquedad.add(btnLimpiar);
		
		btnReporteGeneral = new JButton("");
		btnReporteGeneral.addActionListener(this);
		btnReporteGeneral.setIcon(new ImageIcon(FrmReporteParticipante.class.getResource("/img/Reporte-icon.png")));
		btnReporteGeneral.setBounds(22, 30, 62, 48);
		panelBusquedad.add(btnReporteGeneral);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnReporteGeneral) {
			actionPerformedBtnReporteGeneral(e);
		}
	}
	protected void actionPerformedBtnReporteGeneral(ActionEvent e) {
		ArrayList<Participante> lisPart =  gPart.ListarParticipante();
		  
		 try {
		 JRBeanCollectionDataSource data = new  JRBeanCollectionDataSource(lisPart);
		 
		 String fileName = "Report_Participante.jasper";
		  
		 JasperPrint jaspPrint =  ModelReporte.generar(fileName, data, null);
		  
		 JRViewer jvi = new JRViewer(jaspPrint);
		 jvi.setPreferredSize(panelReporte.getSize()); 
		 
		  panelReporte.removeAll(); 
		  panelReporte.add(jvi);
		  panelReporte.repaint();
		  panelReporte.revalidate();
		  
		  
		  } catch (Exception e1) { System.out.println("Error al generar reporte " +
		  e1.getMessage()); }
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
}
