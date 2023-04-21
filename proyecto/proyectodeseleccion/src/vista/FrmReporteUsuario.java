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

import clases.TipoUsuario;
import clases.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.ModelReporte;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;

public class FrmReporteUsuario extends JInternalFrame implements ActionListener {
	private JPanel panelReporte;
	private JButton btnReporte;
	
    GestionUsuarioDAO gUser = new GestionUsuarioDAO();
    
    GestionTipoUsuarioDAO gtipUs = new  GestionTipoUsuarioDAO();
    private JPanel panelBusquedaGeneral;
    private JPanel panelBusquedad;
    private JLabel lblNewLabel;
    private JComboBox cboCargo;
    private JButton btnNewButton;
    private JButton btnLimpiar;

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
		getContentPane().setBackground(new Color(192, 192, 192));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Reporte de Usuario");
		setBounds(100, 100, 804, 706);
		getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reporte de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(10, 111, 762, 556);
		getContentPane().add(panelReporte);
		
		panelBusquedaGeneral = new JPanel();
		panelBusquedaGeneral.setLayout(null);
		panelBusquedaGeneral.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedaGeneral.setBounds(10, 21, 170, 79);
		getContentPane().add(panelBusquedaGeneral);
		
		btnReporte = new JButton("");
		btnReporte.setBounds(10, 16, 62, 52);
		panelBusquedaGeneral.add(btnReporte);
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/img/new (1).png")));
		
		btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/img/delete (2).png")));
		btnLimpiar.setBounds(87, 16, 54, 52);
		panelBusquedaGeneral.add(btnLimpiar);
		
		panelBusquedad = new JPanel();
		panelBusquedad.setLayout(null);
		panelBusquedad.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBusquedad.setBounds(190, 21, 343, 72);
		getContentPane().add(panelBusquedad);
		
		lblNewLabel = new JLabel("Cargo  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 76, 24);
		panelBusquedad.add(lblNewLabel);
		
		cboCargo = new JComboBox();
		cboCargo.setBounds(97, 25, 151, 24);
		panelBusquedad.add(cboCargo);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(FrmReporteUsuario.class.getResource("/img/Cargo.png")));
		btnNewButton.setBounds(281, 10, 52, 52);
		panelBusquedad.add(btnNewButton);
		cargarTipoCargo();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	private void cargarTipoCargo() {

		ArrayList<TipoUsuario> listipUs = gtipUs.listarTipoUsuarios();

		cboCargo.removeAllItems();
		cboCargo.addItem("SELECCIONE..");

		for (TipoUsuario tipUsu : listipUs) {

		cboCargo.addItem(tipUsu.getIdcargo() + ". " + tipUsu.getDescripCargo());

		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		 ArrayList<Usuario> listUsu =  gUser.listarUsuarios();
		  
		 try {
		 JRBeanCollectionDataSource data = new  JRBeanCollectionDataSource(listUsu);
		 
		 String fileName = "Report_Usuario.jasper";
		  
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
	private int getCargo() {
		int cargo;
		cargo = cboCargo.getSelectedIndex();
		
		return cargo;
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int cargo;
		cargo = getCargo();
		if (cargo == 0) {
			return;
		} else {
			ArrayList<Usuario> lista = gUser.listarUsuariosxCargo(cargo);
			if (lista.size() == 0) {
				utils.Tool.mensajeError(this, "Lista vacia");
			} else {
				try {
					JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);

					String fileName = "Report_Usuario.jasper";

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
	}
        }

