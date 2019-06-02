package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.Statement;
/**
 * classe criada para realizar a onexao dp MySQL com o JAVA.
 * @author mauri
 *
 */
public class BancoDeDados {

	private Connection conneciton = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;
/**
 * metodo criado para conectar ao banco de dados
 */
	public void conectar() {
		String servidor ="jdbc:mysql://localhost:3306/bichodamata?useTimezone=true&serverTimezone=America/Sao_Paulo";
		String usuario ="root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.conneciton = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.conneciton.createStatement();
		}catch (Exception e)
		{
			System.out.println("Erro: " + e.getMessage());	
		}
	}
	/**
	 * metodo criado para verificar a conexao com o banco de dados
	 * @return conexao true ou falsa
	 */
	public boolean estaConectado() {
		if (this.conneciton != null) {
			return true;
		}else {
			return false;
		}

	}
/**
 * metodo criado para buscar os dados da tabela
 */
	public void listar() {
		try {
			String query = "SELECT * from contato ORDER by Nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("id: "+ this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " Telefone: " + this.resultset.getString("telefone"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	/**
	 * Metodo criado para inserir rows ao banco de dados.
	 * @param nome String nome 
	 * @param telefone String numero de telefone 
	 */
	public void inserirContato(String nome, String telefone) {
		try {
			String query = "INSERT INTO contato (nome , telefone) VALUES ('" + nome + "','" + telefone + "');";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	/**
	 * Metodo criado para atualizar a tabela do banco de dados
	 * @param id indice sera a referencia para atualizacao 
	 * @param nome nome a ser atualizado na dupla
	 * @param telefone telefone a ser alterado na dupla
	 */
	public void editarContato(String id , String nome , String telefone) {
		try {
			String query = "UPDATE contato SET nome = '"+ nome + "', telefone = '" + telefone + "' WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	/**
	 * Metodo criado para apagar duplas 
	 * @param id indicador referenciado a ser apagado
	 */
	public void apagarContato(String id) {
		try {
			String query ="Delete FROM contato Where id =" + id +";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	/**
	 * Metodo criado para desconectar do banco de dados.
	 */
	public void desconectar() {
		try {
			this.conneciton.close();
		}catch (Exception e ) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

