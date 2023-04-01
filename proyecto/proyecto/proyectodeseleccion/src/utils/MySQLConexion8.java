package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {

	// metodo statico encargado de realizar la conexion a la bd "ciberfarma"

	public static Connection getConexion() {
		Connection con = null;
		try {
			// establecer la ruta del driver de conexion --> nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");

			// datos para establecer la conexion a la bd
			// driver:protocoloDrivers://ubicacion&puerto de conexion/nombreBD?datos de
			// actualizacion
			String url = "jdbc:mysql://localhost:3306/proyectobuenapro?serverTimezone=UTC";
			String usr = "root";// usuario
			String psw = "mysql";// contraseña

			con = DriverManager.getConnection(url, usr, psw);

		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		}
		return con;
	}

}
