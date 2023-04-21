package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Perfil;
import clases.TipoUsuario;
import interfaces.PerfilInterfaceDAO;
import utils.MySQLConexion8;

public class GestionPerfilDAO implements PerfilInterfaceDAO{

	@Override
	public List<Perfil> listarPerfil() {
		// TODO Auto-generated method stub
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Perfil objPerfil = null;
		//planilla
		try {
			//1.
			con = MySQLConexion8.getConexion();
			//2.
			String sql = "select * from tb_perfil";
			//3.
			pstm = con.prepareStatement(sql);
			//4. --> no
			//5.
			res = pstm.executeQuery();
			//6.
			while (res.next()) {
				objPerfil = new Perfil();
				//setear
				objPerfil.setIdperfil(res.getInt(1));
				objPerfil.setDescipPerfil(res.getString(2));
				//agregar a la lista
				lista.add(objPerfil);
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
