package testedados;

import java.sql.Connection;

import java.sql.DriverManager;
 
import java.sql.SQLException;
 

public class Conexao {
	
	public static Connection connection;
	static String url = "jdbc:mysql://localhost/formulario";
	static String user = "root";
	static String pass = "Info@1234";

	   public Conexao(){  
		   
	   }

	    public static Connection Conecta(){
 
	    	try{
	   	 
	           Class.forName("org.gjt.mm.mysql.Driver");
	      
	           connection = DriverManager.getConnection(url,user,pass);
	      
	           System.out.println("Conexao realizada com sucesso.");
	           
	         }
	     
	         catch(SQLException ex){
	          System.out.println("Problemas na conexao com o banco de dados."+ex);
	          
	         }

	         catch(ClassNotFoundException ex){
	           System.out.println("Driver JDBC-ODBC nao encontrado: "+ ex); 
	         }

	         return connection;
	    
	    }

	    public static void Fecha(){
	      
	           System.out.println("Conexao finalizada com sucesso");
	    
	    }
}
