package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import clases.*;
import interfaces.ContratoInterfaceDAO;
import utils.MySQLConexion8;

public class GestionContratoDAO implements ContratoInterfaceDAO{


	
	@Override
	public int registrar(Contrato cont) {

		int res = 0;
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_contrato values (?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,cont.getIdContrato());
			pstm.setInt(2,cont.getTiPoContrato());
			pstm.setInt(3,cont.getIdParticipante());
			pstm.setString(4,cont.getFecha());
			pstm.setString(5,cont.getDescripcion());
			pstm.setString(6,cont.getResulucion());
			pstm.setString(7,cont.getEstado());
			
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
				  + "tipo_Contrato = ?, id_participante = ?, fecha=? , descripcion = ?,resolucion=?,estado=?"
				  + "where id_contrato = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1,cont.getTiPoContrato());
			pstm.setInt(2,cont.getIdParticipante());
			pstm.setString(3,cont.getFecha());
			pstm.setString(4,cont.getDescripcion());
			pstm.setString(5,cont.getResulucion());
			pstm.setString(6,cont.getEstado());
			pstm.setString(7,cont.getIdContrato());
			
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

	public int eliminarContrato(String idContrato) {
		int res = 0;
		Connection con =null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_contrato where id_contrato = ?"; 
						
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, idContrato);
			
			res = pstm.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion al eliminar el contrato" + e.getMessage());
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
		Contrato cont= null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_contrato"; 
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			
			while (res.next()) {
				cont = new Contrato();
						
						cont.setIdContrato(res.getString(1));
						cont.setTiPoContrato(res.getInt(2));
						cont.setIdParticipante(res.getInt(3));
						cont.setFecha(res.getString(4));
						cont.setDescripcion(res.getString(5));
						cont.setResulucion(res.getString(6));
                        cont.setEstado(res.getString(7));
						

				        list.add(cont);
			}
			
			
		}catch(Exception e) {
			System.out.println("Error en la instruccion de listar los contratos" + e.getMessage());
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
	
	public ArrayList <Contrato> listarContratoConParticipantes (){
		
		ArrayList<Contrato> list= new ArrayList<Contrato>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Contrato cont = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql= "select con.* from tb_contrato con "
					+ "inner join  tb_participante parti on con.id_con = parti.id_con "
					+ "where con.id_con = parti.id_con group by id_con";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while (res.next()) {
				cont = new Contrato();
						
						cont.setIdContrato(res.getString(1));
						cont.setTiPoContrato(res.getInt(2));
						cont.setIdParticipante(res.getInt(3));
						cont.setFecha(res.getString(4));
						cont.setDescripcion(res.getString(5));
						cont.setResulucion(res.getString(6));
                        cont.setEstado(res.getString(7));
						
						
				
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

	@Override
	public String codContrato() {
		
		String cod="C0001";
		Connection con = null;
		PreparedStatement pstm=null;
		ResultSet res = null;
		try {
			
			con=MySQLConexion8.getConexion();
			
			String sql="select substring(max(id_contrato),3) from tb_contrato;";
			pstm =con.prepareStatement(sql);
			res=pstm.executeQuery();
			
			
			
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("0000");
				cod="C"+df.format(Integer.parseInt(res.getString(1))+1);
			}
			
		} catch (Exception e) {
			System.out.println("Error al generar el codigo de contrato"+e.getMessage());
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
				if (res != null)res.close();

			} catch (SQLException e2) {
				System.out.println(">>>>>> Error al cerrar la base de datos" + e2.getMessage());
			}
		
		
		
		
	}return cod;
	}

	@Override
	public ArrayList<Contrato> listarContratoxFecha(String fech) {
    ArrayList<Contrato> lista = new ArrayList<Contrato>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Contrato cont = null;
		try {
		
			con= MySQLConexion8.getConexion();
			
			String sql = "select * from tb_contrato where fecha = ? ";

			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, fech);
			
			res= pstm.executeQuery();
			
			while(res.next()) {
				
				 cont = new Contrato();
				
				 cont.setIdContrato(res.getString(1));
				 cont.setTiPoContrato(res.getInt(2));
				 cont.setIdParticipante(res.getInt(3));
				 cont.setFecha(res.getString(4));
				 cont.setDescripcion(res.getString(5));
				 cont.setResulucion(res.getString(6));
				 cont.setEstado(res.getString(7));
				 
				 
				 lista.add(cont);
	
			}
			
		} catch (Exception e) {
			System.out.println("Error en la instrucciOn SQL - Reporte"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos"+e2.getMessage());
			}
		}
		return lista;
	}

	

	

} 
