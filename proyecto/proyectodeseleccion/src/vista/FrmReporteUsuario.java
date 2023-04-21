package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import clases.Usuario;
import mantenimiento.GestionUsuarioDAO;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.ModelReporte;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FrmReporteUsuario extends JInternalFrame implements ActionListener {
	private JPanel panelReporte;
	private JButton btnReporte;
	
    GestionUsuarioDAO gUser = new GestionUsuarioDAO();
    private JPanel panelBusquedaxtipocont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteUsuario frame = new FrmReporteUsuario();
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
	public FrmReporteUsuario() {
		setTitle("Reporte de Usuario");
		setBounds(100, 100, 804, 706);
		getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reporte de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(10, 128, 762, 539);
		getContentPane().add(panelReporte);
		
		panelBusquedaxtipocont = new JPanel();
		panelBusquedaxtipocont.setLayout(null);
		panelBusquedaxtipocont.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Reporte General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedaxtipocont.setBounds(10, 21, 140, 91);
		getContentPane().add(panelBusquedaxtipocont);
		
		btnReporte = new JButton("");
		btnReporte.setBounds(61, 38, 69, 43);
		panelBusquedaxtipocont.add(btnReporte);
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/img/new (1).png")));

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		 ArrayList<Usuario> listUsu =  gUser.listarUsuarios();
		  
		 try {
		 JRBeanCollectionDataSource data = new  JRBeanCollectionDataSource(listUsu);
		 
		 String fileName = "Report_Usuario.jasper";
		  
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
