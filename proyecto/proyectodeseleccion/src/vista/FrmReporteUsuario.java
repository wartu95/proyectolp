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

public class FrmReporteUsuario extends JInternalFrame implements ActionListener {
	private JPanel panelReporte;
	private JButton btnReporte;
	
    GestionUsuarioDAO gUser = new GestionUsuarioDAO();

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
		setBounds(100, 100, 794, 618);
		getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reporte de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(10, 20, 762, 501);
		getContentPane().add(panelReporte);
		
		btnReporte = new JButton("");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/img/report.png")));
		btnReporte.setBounds(10, 536, 69, 43);
		getContentPane().add(btnReporte);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		 ArrayList<Usuario> listUsu =  gUser.listarUsuarios();
		  //validar 
		 try {
		  //Paso 1 obtener la data 
		 JRBeanCollectionDataSource data = new  JRBeanCollectionDataSource(listUsu);
		 
		  
		  //paso 2 el diseño del reporte 
		 String fileName = "Report_Usuario.jasper";
		  
		  //paso 3 generar el reporte 
		  JasperPrint jaspPrint =  ModelReporte.generar(fileName, data, null);
		  
		  //paso 4 mostrar el reporte 
		  JRViewer jvi = new JRViewer(jaspPrint);
		  
		  
		  //añadir el reporte al panel 
		  panelReporte.removeAll(); 
		  panelReporte.add(jvi);
		  panelReporte.repaint();
		  panelReporte.revalidate();
		  
		  
		  } catch (Exception e1) { System.out.println("Error al generar reporte " +
		  e1.getMessage()); }
		 
	}
}
