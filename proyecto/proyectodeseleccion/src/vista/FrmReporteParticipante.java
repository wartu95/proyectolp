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
    private JPanel panelBusquedaxtipocont;
 
    GestionContratoDAO gCont = new GestionContratoDAO();
    GestionParticipanteDAO gPart = new GestionParticipanteDAO();
    private JButton btnNewButton;
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
		panelReporte.setBounds(10, 111, 804, 501);
		getContentPane().add(panelReporte);
		
		panelBusquedaxtipocont = new JPanel();
		panelBusquedaxtipocont.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Reporte General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedaxtipocont.setBounds(10, 28, 160, 76);
		getContentPane().add(panelBusquedaxtipocont);
		panelBusquedaxtipocont.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(FrmReporteParticipante.class.getResource("/img/Reporte-icon.png")));
		btnNewButton.setBounds(77, 22, 73, 48);
		panelBusquedaxtipocont.add(btnNewButton);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		ArrayList<Participante> lisPart =  gPart.ListarParticipante();
		  
		 try {
		 JRBeanCollectionDataSource data = new  JRBeanCollectionDataSource(lisPart);
		 
		 String fileName = "Report_Participante.jasper";
		  
		  JasperPrint jaspPrint =  ModelReporte.generar(fileName, data, null);
		  
		  JRViewer jvi = new JRViewer(jaspPrint);
		  
		  panelReporte.removeAll(); 
		  panelReporte.add(jvi);
		  panelReporte.repaint();
		  panelReporte.revalidate();
		  
		  
		  } catch (Exception e1) { System.out.println("Error al generar reporte " +
		  e1.getMessage()); }
	}
}
