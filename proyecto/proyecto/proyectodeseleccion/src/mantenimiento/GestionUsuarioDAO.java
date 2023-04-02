package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.plaf.ComponentUI;

import clases.Usuario;
import interfaces.UsuarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfaceDAO {

	private Usuario user;

	@Override
	public int registrar(Usuario u) {
		
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null; // ejecutar la instucciones SQL
		try {
		
			con = MySQLConexion8.getConexion();
		
			String sql =" insert into tb_usuarios values(?,?,?,?,?,default,default)";
			
			pstm = con.prepareStatement(sql);
			
		    pstm.setString(1, u.getIdUsuario());
		    pstm.setString(2, u.getContraseña());
			pstm.setString(3, u.getNombre());
			pstm.setString(4, u.getApellido());
			pstm.setInt(5, u.getIdCargo());
			pstm.setInt(6, u.getIdPerfil());
			
			
			//paso 5:ejecutar la instruccion SQL
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ERROR EN LA INSTRUCCION DE LA BD"+e.getMessage());
		}finally {
			try {
				
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println( "ERROR AL CERRAR LAS CONEXIONES" +e2.getMessage());

			}
		}


		return res ;
	}

	public int Usuario(ComponentUI ui) {
		// TODO Auto-generated method stub
		return 0;
	}

}
