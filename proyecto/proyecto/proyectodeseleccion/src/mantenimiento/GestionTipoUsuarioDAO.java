package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.TipoUsuario;
import interfaces.TipoUsuarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionTipoUsuarioDAO  implements TipoUsuarioInterfaceDAO {

	@Override
	public ArrayList<TipoUsuario> listarTipoUsuarios() {
		
		//Declaracion de variables
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoUsuario tipUser = null;
		//planilla
		try {
			//1.
			con = MySQLConexion8.getConexion();
			//2.
			String sql = "select * from tb_cargo";
			//3.
			pstm = con.prepareStatement(sql);
			//4. --> no
			//5.
			res = pstm.executeQuery();
			//6.
			while (res.next()) {
				tipUser = new TipoUsuario();
				//setear
				tipUser.setIdcargo(res.getInt(1));
				tipUser.setDescripCargo(res.getString(2));
				//agregar a la lista
				lista.add(tipUser);
			}
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - LISTAR TIPOS"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getMessage());
			}
		}
		//tarea --> programar proceso de consulta listarTipoUsuario
		
		return lista ;
	}

}
