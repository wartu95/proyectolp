package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clase.Comprobante;
import conexion.MySqlConexion;
import interfaz.ComprobanteInterfaz;

public class ComprobanteDAO implements ComprobanteInterfaz{

	@Override
	public List<Comprobante> listarComprobante() {
		
		String cad_sql = "{call listar_venta}";
		List<Comprobante> lista = new ArrayList<Comprobante>();
		Comprobante obj = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = MySqlConexion.conectar().prepareStatement(cad_sql);
			
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				obj = new Comprobante();
				obj.setIdVenta(rs.getString(1));
				obj.setIdCliente(rs.getString(2));
				obj.setFechaVenc(rs.getDate(3));
				obj.setTotal(rs.getDouble(4));
				
				lista.add(obj);
			}
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return lista;
	}
	
}
