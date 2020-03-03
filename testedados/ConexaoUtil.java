package testedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
	
	private static ConexaoUtil conexaoUtil;
	
	public static ConexaoUtil getInstance() {
		if(conexaoUtil == null) {
			conexaoUtil = new ConexaoUtil();
			
		}
		return conexaoUtil;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root", "Info@1234");
	}
	
	public static void main(String[] args) {
		
		try {
			
		System.out.println(getInstance().getConnection());
		}catch(Exception e) {
						System.out.println("Erro na conexao: ");
						e.printStackTrace();

		}
		
		}

}
