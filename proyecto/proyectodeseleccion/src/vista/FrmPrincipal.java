package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import utils.HiloReloj;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class FrmPrincipal extends JFrame implements ActionListener   {
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mniUsuario;
	private JMenuItem mniSalir;
	private JMenu mnMantenimiento;
	private JMenu mnTransaccion;
	private JMenu mnReporte;
	private JMenu mnAyuda;
	private JMenuItem mniContrato;
	private JMenuItem mniParticipante;
	private JDesktopPane escritorio;
	private JMenuItem mniContratoPendientes;
	private JMenuItem mniTipoContratos;
	private JMenu mnNewMenu;
	private JMenuItem mniConsultaParticipante;
	private JMenuItem mniConsultaContratos;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JLabel lblReloj;
	private JLabel lblFondo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/logo-smv.png")));
		setTitle("CONTRATACION DE PERSONAL ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 690);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/folder.png")));
		menuBar.add(mnArchivo);
		
		mniUsuario = new JMenuItem("Gestion de usuarios");
		mniUsuario.addActionListener(this);
		mniUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/social-media.png")));
		mnArchivo.add(mniUsuario);
		
		mniSalir = new JMenuItem("Salir");
		mniSalir.addActionListener(this);
		mniSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/logout.png")));
		mnArchivo.add(mniSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/maintenance.png")));
		menuBar.add(mnMantenimiento);
		
		mniContrato = new JMenuItem("Registro de Contrato");
		mniContrato.addActionListener(this);
		mniContrato.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/contract.png")));
		mnMantenimiento.add(mniContrato);
		
		mniParticipante = new JMenuItem("Participantes");
		mniParticipante.addActionListener(this);
		mniParticipante.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/diversity.png")));
		mnMantenimiento.add(mniParticipante);
		
		mniContratoPendientes = new JMenuItem("Contratos Pendientes");
		mnMantenimiento.add(mniContratoPendientes);
		
		mniTipoContratos = new JMenuItem("Tipo de Contratos");
		mnMantenimiento.add(mniTipoContratos);
		
		mnNewMenu = new JMenu("Consulta");
		mnNewMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/query.png")));
		menuBar.add(mnNewMenu);
		
		mniConsultaParticipante = new JMenuItem("Consulta Participante");
		mnNewMenu.add(mniConsultaParticipante);
		
		mniConsultaContratos = new JMenuItem("Consulta de Contratos");
		mnNewMenu.add(mniConsultaContratos);
		
		mnTransaccion = new JMenu("Transacci\u00F3n");
		mnTransaccion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/transaction.png")));
		menuBar.add(mnTransaccion);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report.png")));
		menuBar.add(mnReporte);
		
		mntmNewMenuItem_3 = new JMenuItem("Reporte de Contratos");
		mnReporte.add(mntmNewMenuItem_3);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/respect.png")));
		menuBar.add(mnAyuda);
		
		mntmNewMenuItem_4 = new JMenuItem("¿Quienes somos?");
		mnAyuda.add(mntmNewMenuItem_4);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(192, 192, 192));
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		lblReloj = new JLabel("hh:mm:ss");
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReloj.setForeground(Color.WHITE);
		lblReloj.setBackground(Color.WHITE);
		lblReloj.setBounds(815, 23, 134, 27);
		escritorio.add(lblReloj);
		
		lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Screenshot_20.png")));
		lblFondo.setBounds(0, 0, 959, 621);
		escritorio.add(lblFondo);
		//mostrar hora
		cargarHora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mniUsuario) {
			actionPerformedMniUsuario(e);
		}
		if (e.getSource() == mniSalir) {
			actionPerformedMniSalir(e);
		}
		if (e.getSource() == mniParticipante) {
			actionPerformedMniParticipante(e);
		}
		if (e.getSource() == mniContrato) {
			actionPerformedMniContrato(e);
		}
		// TODO Auto-generated method stub
		
	}
	
	private void cargarHora() {
		
		HiloReloj h = new HiloReloj(lblReloj);
		h.start();
	}

	//MANTENIMIENTO 
	protected void actionPerformedMniContrato(ActionEvent e) {
		FrmContrato contrato = new FrmContrato();
		contrato.setVisible(true);
		escritorio.add(contrato).setLocation(0,0);
		contrato.toFront();
		
	
	}
	protected void actionPerformedMniParticipante(ActionEvent e) {

		FrmParticipante part = new FrmParticipante();
		part.setVisible(true);
		escritorio.add(part).setLocation(0,0);
		part.toFront();


	}
	//ARCHIVO
	protected void actionPerformedMniSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMniUsuario(ActionEvent e) {
		FrmUsuario usuario = new FrmUsuario();
		usuario.setVisible(true);
		escritorio.add(usuario).setLocation(0,0);
		usuario.toFront();
	}
}