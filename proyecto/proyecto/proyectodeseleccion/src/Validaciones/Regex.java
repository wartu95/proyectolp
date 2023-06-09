package Validaciones;

public class Regex {

	//USUARIO
	
		public static String NOMBRE_USUARIO = ".{3,25}";
		public static String APELLIDO_USUARIO = ".{3,25}";
		public static String USER_USUARIO = "[A-Za-z0-9]{4,15}";
		public static String CLAVE_USUARIO = "[A-Za-z]{4,8}";
		
		//ENTIDAD CONTRATO
		
		public static String ID_CONTRATO = "[C][D]\\d{3}";
		public static String ENTIDAD_CONTRATO = ".{3,20}";
		public static String RUC_PEDIDO = "\\d{11}";
		
		//PARTICIPANTE
		
		public static String ID_PARTICIPANTE="[P][A]\\d{3}";
		public static String ENTIDAD_PARTICIPANTE =".{3,20}";
		public static String RUC_PARTICIPANTE = "\\d{11}";
		
		public static String TELEFONO_PARTICIPANTE = "\\d{7,9}";
		public static String CORREO_PARTICIPANTE = ".+@(hotmail|outlook|gmail).com";
		
		
		//MIEMBO ADMINISTRATIVO
		
		public static String ID_ADMI = "[M][C]\\d{3}";
		public static String NOMBRE_ADMI="[a-zA-Z\\s]{2,20}";
		public static String APELLIDO_ADMI="[a-zA-Z\\�\\s]{2,20}";
		public static String DNI_ADMI = "\\d{8}";
		public static String FUNCION_ADMI ="[a-zA-Z\\s]{2,20}";
		public static String DEPENDENCIA_ADMI ="[a-zA-Z\\s]{2,20}";
		
		
		//OBSERVACION
		
		public static String ID_OBSER = "[A][P]\\d{3}";
		public static String DESCRIPCION_APE=".{2,450}";
		public static String ESTADO_APE="[a-zA-Z\\�\\s]{2,20}";
		
		
		
}