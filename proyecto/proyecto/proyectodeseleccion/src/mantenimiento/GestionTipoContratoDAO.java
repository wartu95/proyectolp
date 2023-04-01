package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.TipoContrato;
import interfaces.TipoContratoInterfaseDAO;
import utils.MySQLConexion8;

public class GestionTipoContratoDAO implements TipoContratoInterfaseDAO{

	//LISTAR TIPO DE PEDIDO EN UN OBJETO CLASE
	
		public ArrayList<TipoContrato> listarTipoContrato(){
			
			ArrayList <TipoContrato> list = new ArrayList<TipoContrato>();;
			
			Connection con =null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			
			try {
				
				con = MySQLConexion8.getConexion();
				
				String sql = "select * from tb_tipoContrato"; 			
				pstm = con.prepareStatement(sql);				
				res = pstm.executeQuery();
				
				while (res.next()) {
					TipoContrato tipCon = new TipoContrato(
							res.getInt(1),
							res.getString(2)
							
							);
					
					list.add(tipCon);
				}
				
				
			}catch(Exception e) {
				System.out.println("Error en la listar los tipos de contratos" + e.getMessage());
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
