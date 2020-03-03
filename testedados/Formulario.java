package testedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Formulario {
	
	private static final PessoaDTO PessoaDTO = null;


	public void Inserir(PessoaDTO pdto) {
		
		try {
			
		
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		String sql = "insert into usuario(id,nome,telefone,email) values(?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, pdto.getId());
		statement.setString(2, pdto.getNome());
		statement.setInt(3, pdto.getTelefone());
		statement.setString(4, pdto.getEmail());

		statement.execute();
		connection.close();
		
		}catch(Exception e) {
			System.out.println("Erro ao inserir valores: ");
			e.printStackTrace();
		}
		
	
	}
	
	public List<PessoaDTO> listaTodos(){
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		try {
			Connection con = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "select * from usuario";
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				PessoaDTO pdto = new PessoaDTO();
				pdto.setId(resultset.getInt("id"));
				pdto.setNome(resultset.getString("nome"));
				pdto.setTelefone(resultset.getInt("telefone"));
				pdto.setEmail(resultset.getString("email"));
				
				listaPessoas.add(pdto);
			}
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaPessoas;
	}
	
	
	public static void main(String[] args) {
		PessoaDTO pdto = new PessoaDTO();
		Scanner sc = new Scanner(System.in);
		
//		pdto.setNome("Renan Alves");
//		pdto.setTelefone(56734567);
//		pdto.setEmail("renannissan@gmail.com");
		
		Formulario form = new Formulario();
		form.listaTodos();
		//form.Inserir(pdto);
		
	}

}








