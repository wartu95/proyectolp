package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.*;
import utils.MySQLConexion8;

public class ContratoDAO {

public int registrarPedido(Contrato cont) {
		
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "insert into tb_contrato values (?,?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,cont.getCodigo());
			pstm.setString(2,cont.getEntidad());
			pstm.setString(3,cont.getRuc());
			pstm.setInt(4,cont.getTipo());
			pstm.setInt(5,cont.getObjeto());
			pstm.setString(6,cont.getDescripcion());
			pstm.setString(7,cont.getFecha());
			pstm.setString(8,cont.getEstado());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
		
		
	}
	
	public int actualizarContrato(Contrato cont) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql;
			sql = "update tb_contrato set "
					+ "entidad_con = ?, ruc_con= ?, id_tipoContrato = ?, id_objetoContrato = ?, descripcion_con = ?, fecha_con=?,estado_con=?"
					+ "where id_con = ?";
			
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1,cont.getEntidad());
			pstm.setString (2,cont.getRuc());
			pstm.setInt(3,cont.getTipo());
			pstm.setInt(4,cont.getObjeto());
			pstm.setString(5,cont.getDescripcion());
			pstm.setString(6,cont.getFecha());
			pstm.setString(7,cont.getEstado());
			
			pstm.setString(8,cont.getCodigo());
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
	}

	public int eliminarContrato(int idContrato) {
		int res = 0;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_contrato where id_con = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, idContrato);
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion" + e.getMessage());
		}finally {
			try {
				if (con!=null)con.close();
				if (pstm!=null)pstm.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la base de datos" + e.getMessage());
			}
		}
		
		
		return res;
	}
	
	public ArrayList<Contrato> listarContrato(){
		ArrayList <Contrato> list = new ArrayList<Contrato>();
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_contrato"; 
						
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Contrato ped = new Contrato(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getInt(5),
						res.getString(6),
						res.getString(7),
						res.getString(8)
						
						);
				
				list.add(ped);
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
	
	//BUSQUEDA 
	
	public Contrato buscarXIdContrato(String idContrato) {
		
		Contrato cont = null;
		
		Connection con =null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select * from tb_contrato"
					+ " where id_con = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setString (1,idContrato);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				cont = new Contrato(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getInt(5),
						res.getString(6),
						res.getString(7),
						res.getString(8)
						
						);
				
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
		
		
		
		return cont;
		
	}

	public ArrayList <Contrato> listarContratoConParticipantes (){
		
		ArrayList<Contrato> list= new ArrayList<Contrato>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql= "select con.* from tb_contrato con "
					+ "inner join  tb_participante parti on con.id_con = parti.id_con "
					+ "where con.id_con = parti.id_con group by id_con";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Contrato cont = new Contrato(
						res.getString(1),
						res.getString(2),
						res.getString(3),
						res.getInt(4),
						res.getInt(5),
						res.getString(6),
						res.getString(7),
						res.getString(8)
						);
				
				list.add(cont);
			}
			
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DEL BD" +  e.getMessage());
		}finally {
			try {
				if(con!=null) con.close();
				if(pstm!=null) pstm.close();
				if(res!=null) res.close();
			}catch (SQLException e2) {
				System.out.println("ERROR AL CERRAR LA CONEXION DE BD" +  e2.getMessage());
			}
		}
		return list;
		
	}
	
	public ArrayList<Object[]> reporteContrato() {
		ArrayList<Object[]> list= new ArrayList<Object[]>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql= "select con.id_con, ticon.des_tipoContrato, obcon.des_objetoContrato, ped.estado_con from tb_Contrato con inner join tb_tipoContrato tiped on ped.id_tipoContrato = tiped.id_tipoContrato"
					+ " inner join tb_objetoContrato obped on con.id_objetoContrato = obped.id_objetoContrato ";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				Object[] cont = {
					res.getString(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
				};
				
				list.add(cont);
			}
			
		}catch (Exception e){
			System.out.println("ERROR EN LA INSTRUCCION DEL BD" +  e.getMessage());
		}finally {
			try {
				if(con!=null) con.close();
				if(pstm!=null) pstm.close();
				if(res!=null) res.close();
			}catch (SQLException e2) {
				System.out.println("ERROR AL CERRAR LA CONEXION DE BD" +  e2.getMessage());
			}
		}
		return list;
	}

	

}
