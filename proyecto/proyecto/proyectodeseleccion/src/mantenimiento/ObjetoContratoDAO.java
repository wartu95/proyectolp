package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.ObjContrato;
import utils.MySQLConexion8;

public class ObjetoContratoDAO {

	// LISTAR OBJETO DE PEDIDO EN UN OBJETO CLASE

	public static ArrayList<ObjContrato> listarObjContrato(){
			
			ArrayList <ObjContrato> list = new ArrayList<ObjContrato>();;
			
			Connection con =null;
			PreparedStatement pstm = null;
			
			ResultSet res = null;
			
			try {
				
				con = MySQLConexion8.getConexion();
				
				String sql = "select * from tb_objetoContrato"; 
							
				pstm = con.prepareStatement(sql);
				
				res = pstm.executeQuery();
				
				while (res.next()) {
					ObjContrato objCont = new ObjContrato(
							res.getInt(1),
							res.getString(2)
							
							);
					
					list.add(objCont);
				}
				
				
			}catch(Exception e) {
				System.out.println("Error en la instruccion" + e.getMessage());
			}finally {
				try {
					if (con!=null)con.close();
					if (pstm!=null)pstm.close();
					if (res !=null)res.close();
				}catch (SQLException e) {
					System.out.println("Error al cerrar la base de datos" + e.getMessage());
				}
			}
			
			
			return list;
	}
}
