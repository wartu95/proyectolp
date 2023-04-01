package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class FrmPrincipal extends JFrame implements ActionListener   {
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mniUsuario;
	private JMenuItem mniSalir;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenu mnTransaccion;
	private JMenu mnReporte;
	private JMenu mnAyuda;
	private JMenuItem mniContrato;
	private JMenuItem mniParticipante;
	private JDesktopPane escritorio;
	private JMenuItem mntmContratosPendientes;
	private JMenuItem mntmNewMenuItem;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/logo-smv.png")));
		setTitle("CONTRATACION DE PERSONAL ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 720);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/folder.png")));
		menuBar.add(mnArchivo);
		
		mniUsuario = new JMenuItem("Gestion de usuarios");
		mniUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/social-media.png")));
		mnArchivo.add(mniUsuario);
		
		mniSalir = new JMenuItem("Salir");
		mniSalir.addActionListener(this);
		mniSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/logout.png")));
		mnArchivo.add(mniSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/maintenance.png")));
		menuBar.add(mnMantenimiento);
		
		mniContrato = new JMenuItem("Registrar Contrato");
		mniContrato.addActionListener(this);
		mniContrato.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/contract.png")));
		mnMantenimiento.add(mniContrato);
		
		mniParticipante = new JMenuItem("Participantes");
		mniParticipante.addActionListener(this);
		mniParticipante.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/diversity.png")));
		mnMantenimiento.add(mniParticipante);
		
		mntmContratosPendientes = new JMenuItem("Contratos Pendientes");
		mnMantenimiento.add(mntmContratosPendientes);
		
		mntmNewMenuItem = new JMenuItem("Lista de Contratos");
		mnMantenimiento.add(mntmNewMenuItem);
		
		mnConsulta = new JMenu(" ");
		mnConsulta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/query.png")));
		menuBar.add(mnConsulta);
		
		mnTransaccion = new JMenu("Transacci\u00F3n");
		mnTransaccion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/transaction.png")));
		menuBar.add(mnTransaccion);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report.png")));
		menuBar.add(mnReporte);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/respect.png")));
		menuBar.add(mnAyuda);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.textHighlight);
		getContentPane().add(escritorio, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
	
	//MANTENIMIENTO 
	protected void actionPerformedMniContrato(ActionEvent e) {
		FrmContrato contrato = new FrmContrato();
		contrato.setVisible(true);
		escritorio.add(contrato);
		
	
	}
	protected void actionPerformedMniParticipante(ActionEvent e) {
		FrmParticipante participante = new FrmParticipante();
		participante.setVisible(true);
		escritorio.add(participante);
	}
	
	//ARCHIVO
	protected void actionPerformedMniSalir(ActionEvent e) {
		System.exit(0);
	}
}
