package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySqlConexion {
	
	
	
	public static void main (String[] args) {
		new MySqlConexion();
	}
	
	public MySqlConexion(){
		conectar();
	}	
	public static Connection conectar() {

		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/bdtambo";
		String usuario="root";
		String password="mysql";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,usuario,password);
			
			JOptionPane.showMessageDialog(null, "CONEXION EXITOSA","MENSAJE",1);
			
		}catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),"MENSAJE",1);
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(),"MENSAJE",1);
		}
		
		return con;
	}
	
}
