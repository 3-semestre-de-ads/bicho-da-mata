package connection;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class BancoDeDados {

	SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");

	//private static final int ArrayList = 0;
	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel model;

	public void conectar() {
		String servidor ="jdbc:mysql://localhost:3306/bichodamata?useTimezone=true&serverTimezone=America/Sao_Paulo";
		String usuario ="root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		}catch (Exception e)
		{
			System.out.println("Erro: " + e.getMessage());	
		}
	}

	public void desconectar() {
		try {
			this.connection.close();
		}catch (Exception e ) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		}else {
			return false;
		}

	}

	public void pesquisaTudo(String tabela, JList<String> lista, String coluna) {
		try {

			DefaultListModel<String> DML = new DefaultListModel<String>();
			String query = "SELECT * FROM " + tabela;

			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {
				DML.addElement(this.resultset.getString(coluna));
			}
			lista.setModel(DML);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void salvarAnimal(JRadioButton macho, JRadioButton femea, JRadioButton sim, JRadioButton nao, int idclie, String nome, String especie, String raca, String nascimento, String cor, String data, String obs) {
		String d = null;
		if (macho.isSelected()) {
			d = "Macho";
		} else if (femea.isSelected()) {
			d = "Femea";
		}

		String op = null;
		if (sim.isSelected()) {
			op = "Sim";
		}else if (nao.isSelected()) {
			op = "Nao";
		}

		try {
			String query = "INSERT INTO animal (idclie, nome, especie, raca, sexo, nascimento, castrado, cor,data,obs) VALUES ('" + idclie + "' , '" + nome + "' , '" + especie + "','" + raca + "','" + d + "' , '" + nascimento + "','" + op + "','" + cor + "','" + data + "','" + obs + "');";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void pesquisarAnimal(JTextField dono, JList<String> lista1, JList<String> lista2, JList<String> lista3) {
		try {
			String query = "SELECT cliente.*, animal.* from animal join cliente on cliente.id = animal.idclie Where cliente.nome LIKE '%" + dono.getText() + "%' ORDER by 'date'";
			resultset = this.statement.executeQuery(query);

			DefaultListModel<String> DML = new DefaultListModel<String>();
			DefaultListModel<String> DML1 = new DefaultListModel<String>();
			DefaultListModel<String> DML2 = new DefaultListModel<String>();

			while(this.resultset.next()) {

				String dia = this.resultset.getString("animal.data").substring(8);
				String mes = this.resultset.getString("animal.data").substring(5,7);
				String ano = this.resultset.getString("animal.data").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				DML.addElement(this.resultset.getString("animal.nome"));
				DML1.addElement(this.resultset.getString("cliente.nome"));
				DML2.addElement(datasql);
			}
			lista1.setModel(DML1);
			lista2.setModel(DML);
			lista3.setModel(DML2);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void editarAnimal(JRadioButton macho, JRadioButton femea, JRadioButton sim, JRadioButton nao, int idAnimal, String nome, String especie, String raca, String nascimento, String cor, String data, String obs) {
		try {
			String d = null;
			if (macho.isSelected()) {
				d = "Macho";
			} else if (femea.isSelected()) {
				d = "Femea";
			}

			String c = null;
			if (sim.isSelected()) {
				c = "Sim";
			} else if (nao.isSelected()) {
				c = "Nao";
			}

			String query = "UPDATE animal SET nome ='" + nome + "', especie ='" +  especie + "', raca ='" + raca + "', sexo ='" + d + "', nascimento = '" + nascimento + "', castrado ='" + c + "', cor ='" + cor + "', data ='" + data + "', obs ='" + obs + "' WHERE idanimal ='" + idAnimal + "';";;
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso!");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluirAnimal(int idAnimal) {
		try {
			String query = "DELETE from animal WHERE idanimal = '" + idAnimal + "';";
			this.statement.execute(query);
			JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir! Erro: " + e.getMessage());
		}
	}

	public void fichaAnimal(JList<String> lista, JTextField dono, JTextField nome, JTextField animal) {
		try {
			String query = "SELECT cliente.* , animal.* FROM animal join cliente on cliente.id = animal.idclie where animal.nome = '" + lista.getSelectedValue() +"';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {
				System.out.println(query);
				dono.setText(this.resultset.getString("cliente.nome"));
				nome.setText(this.resultset.getString("animal.nome"));
				animal.setText(this.resultset.getString("animal.idanimal"));
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void idVeterinario(JComboBox<Object> veterinario, JTextField idVeterinario) {
		try {
			String query = "SELECT * from funcionario where nome ='" + veterinario.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				idVeterinario.setText(this.resultset.getString("id"));
			}
		}catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void pesquisarVacina(JTextField animal, JList<String> lista1, JList<String> lista2) {
		try {
			String query = "SELECT * FROM vacina WHERE idanimal =" + animal.getText() + " order by data;";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			DefaultListModel<String> DML1 = new DefaultListModel<String>();
			while(this.resultset.next()) {
				String dia = this.resultset.getString("data").substring(8);
				String mes = this.resultset.getString("data").substring(5,7);
				String ano = this.resultset.getString("data").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				DML.addElement(this.resultset.getString("vacina"));
				DML1.addElement(datasql);
			}
			lista1.setModel(DML);
			lista2.setModel(DML1);
		} 
		catch (Exception e ) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void buscarVeterinario(JComboBox<Object> veterinario) {
		try {
			String query = "SELECT nome FROM funcionario WHERE funcao = 'Veterinário';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(resultset.getString("nome"));
			}
			veterinario.setModel(model);
		}catch (Exception e) {

		}
	}

	public void inserirVacinaId(JList<String> lista, JTextField idVacina) {
		try {
			String query = "SELECT * from vacina where vacina = " + "'" + lista.getSelectedValue() + "';";
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				idVacina.setText(this.resultset.getString("idvacina"));
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirVacina(JComboBox<Object> vacina, int idanimal, String data) {
		try {
			String query = "INSERT INTO vacina (vacina , idanimal, data) VALUES ('"+ vacina +"','" + idanimal + "','" + data + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void deletarVacina(JTextField idVacina) {
		try {
			String query = "DELETE FROM vacina WHERE idvacina = '" + idVacina.getText() +"';";
			System.out.println(query);
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir!\nErro: " + e.getMessage());
		}
	}

	public void inserirFicha(JTextField idanimal, JTextField idvacina, JTextField idfunc, String data , JTextField peso, JTextPane diagnostico, JTextPane historico) {
		try {
			String query = "INSERT INTO ficha (idanimal, idvacina, idfunc, data, peso, diagnostico, historico) values ('" + idanimal.getText() + "','" + idvacina.getText() + "','" + idfunc.getText() + "','" + data + "','" + peso.getText() + "','" + diagnostico.getText() + "','" + historico.getText() + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void pesquisarFicha(JTextField nome, JList<String> lista1, JList<String> lista2) {
		try {
			String query = "SELECT a.nome nome, b.data dia FROM animal a inner join ficha b on a.idanimal = b.idanimal where a.nome ='" + nome.getText() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);

			DefaultListModel<String> DML = new DefaultListModel<String>();
			DefaultListModel<String> DML1 = new DefaultListModel<String>();
			while(this.resultset.next()) {
				String dia = this.resultset.getString("dia").substring(8);
				String mes = this.resultset.getString("dia").substring(5,7);
				String ano = this.resultset.getString("dia").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				DML.addElement(this.resultset.getString("nome"));
				DML1.addElement(datasql);
			}
			lista1.setModel(DML1);
			lista2.setModel(DML);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void buscarFicha(JList<String> listaData, JTextField nome, JTextField peso, JTextPane dia, JTextPane historico, JComboBox<Object> veterinario, JTextField idFicha) {
		try {
			String diaF = listaData.getSelectedValue().toString().substring(0,2);
			String mes = listaData.getSelectedValue().toString().substring(3,5);
			String ano = listaData.getSelectedValue().toString().substring(6);
			String datasql = ano+"-"+mes+"-"+diaF;

			String query = "Select funcionario.nome, ficha.*, animal.* from ficha join funcionario join animal where ficha.data ='" + datasql + "' and " + " animal.nome = '" + nome.getText() +"';";
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {
				peso.setText(this.resultset.getString("ficha.peso"));
				dia.setText(this.resultset.getString("ficha.diagnostico"));
				historico.setText(this.resultset.getString("ficha.historico"));
				veterinario.setSelectedItem(this.resultset.getString("funcionario.nome"));
				idFicha.setText(this.resultset.getString("ficha.idficha"));
			}
		} catch (Exception e ) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirFornecedor(JList<String> lista, JTextPane descricao, JTextField data, JTextField nome, JTextField cnpj, JTextField contato, JTextField telefone, JTextField email, JTextField id) {
		try {
			String query = "SELECT * FROM fornecedor WHERE nome = " + "'" + lista.getSelectedValue() + "';";
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {

				String dia1 = this.resultset.getString("data").substring(8);
				String mes1 = this.resultset.getString("data").substring(5,7);
				String ano1 = this.resultset.getString("data").substring(0,4);
				String datasql1 = dia1+"/"+mes1+"/"+ano1;

				descricao.setText(this.resultset.getString("descricao"));
				data.setText(datasql1);
				nome.setText(this.resultset.getString("nome"));
				cnpj.setText(this.resultset.getString("cnpj"));
				contato.setText(this.resultset.getString("contato"));
				telefone.setText(this.resultset.getString("telefone"));
				email.setText(this.resultset.getString("email"));
				id.setText(this.resultset.getString("id"));
			}
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarFornecedor(JTextField data, JTextField nome, JTextField cnpj, JTextField contato, JTextField telefone, JTextField email, JTextPane descricao, JTextField id) {
		try {
			String dia = data.getText().substring(0,2);
			String mes = data.getText().substring(3,5);
			String ano = data.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String query = "UPDATE fornecedor SET data = '" + datasql + "', nome ='" + nome.getText() + "', cnpj ='" + cnpj.getText() + "', contato ='" + contato.getText() + "', telefone ='" + telefone.getText() + "', email = '" + email.getText() + "', descricao = '" + descricao.getText() + "' WHERE id ='" + id.getText() + "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void pesquisarFornecedor(JTextField busca, JList<String> lista) {
		try {
			String query = "SELECT * FROM fornecedor WHERE nome LIKE '%" + busca.getText() + "%' ORDER by 'name' ASC;";
			resultset = this.statement.executeQuery(query);

			DefaultListModel<String> DML = new DefaultListModel<String>();

			while(this.resultset.next()) {
				DML.addElement(this.resultset.getString("nome"));
			}
			lista.setModel(DML);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluirFornecedor(JTextField id) {
		try {
			String query = "Delete From fornecedor Where id = '" + id.getText() + "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirContato(JTextField data, JTextField nome, JTextField cnpj, JTextField contato, JTextField telefone, JTextField email, JTextPane descricao) {
		try {
			String query = "INSERT INTO fornecedor (data, nome , cnpj, contato, telefone,email, descricao) VALUES ('"+ data.getText() + "','" + nome.getText() + "','" + cnpj.getText() + "','" + contato.getText() + "','" + telefone.getText() + "','" + email.getText() + "','" + descricao.getText() + "');";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirFuncionario(String nome, String cpf,String funcao,String crmv,String validade, String sexo, String nascimento,String cep, String rua, String numero, String bairro, String cidade, String uf, String complemento, String telefone, String celular, String email ) {
		try {
			String query = "INSERT INTO funcionario (nome , cpf, funcao, crmv ,validade, sexo, nascimento,cep, rua, numero, bairro, cidade, uf,complemento,telefone,celular,email) VALUES ('"+ nome + "','" + cpf + "','"+ funcao + "','" + crmv + "','" + validade + "','" + sexo + "','" + nascimento + "','" + cep + "','" + rua + "','" + numero + "','" + bairro + "','" + cidade + "','" + uf + "','" + complemento + "','" + telefone + "','" + celular + "','" + email + "');";

			this.statement.executeUpdate(query);

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Todos os campos deverão ser preenchidos");
		}
	}

	public void editarFuncionario(JTextField dataNascimento, JTextField validade, JRadioButton masculino, JRadioButton feminino, JComboBox<Object> funcao, JTextField nome, JTextField cpf, JTextField crmv, JTextField cep, JTextField rua, JTextField numero, JTextField bairro, JTextField cidade, JTextField uf, JTextField complemento, JTextField telefone, JTextField celular, JTextField email, JTextField id) {
		try {
			String dia = dataNascimento.getText().substring(0,2);
			String mes = dataNascimento.getText().substring(3,5);
			String ano = dataNascimento.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String dia2 = validade.getText().substring(0,2);
			String mes2 = validade.getText().substring(3,5);
			String ano2 = validade.getText().substring(6);
			String validadeV = ano2+"-"+mes2+"-"+dia2;


			String d = null;
			if (masculino.isSelected()) {
				d = "Masculino";
			} else if (feminino.isSelected()) {
				d = "Feminino";
			}
			String c = null;
			if (funcao.getSelectedItem() .equals("Veterinário")) {
				c = "Veterinário";
			}
			if (funcao.getSelectedItem() .equals("Auxiliar")) {
				c = "Auxiliar";
			}
			if (funcao.getSelectedItem() .equals("Secretária(o)")) {
				c = "Secretária(o)";
			}

			String query = "UPDATE funcionario SET nome = '" + nome.getText() + "', cpf = '" + cpf.getText() +"', funcao ='" + c + "', crmv = '"+ crmv.getText()+ "', dataNascimento ='" + validadeV + "', sexo ='" + d + "', nascimento ='" + datasql + "', cep ='" + cep.getText() + "', rua= '" + rua.getText() + "', numero ='" + numero.getText() + "', bairro ='" + bairro.getText() + "', cidade ='" + cidade.getText() + "', uf ='" + uf.getText() + "', complemento ='" + complemento.getText() + "', telefone ='" + telefone.getText() + "', celular ='" + celular.getText() + "', email ='" + email.getText() + "' WHERE id ='" + id.getText() + "';";
			this.statement.executeUpdate(query);			
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void pesquisarFuncionario(JTextField busca, JList<String> lista) {
		try {
			String query = "SELECT * FROM funcionario WHERE nome LIKE '%" + busca.getText() + "%' ORDER by 'name' ASC;";
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			while(this.resultset.next()) {
				DML.addElement(this.resultset.getString("nome"));
			}
			lista.setModel(DML);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void excluirFuncionario(JTextField id) {
		try {
			String query = "Delete From funcionario Where id = '" + id.getText() + "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void idVeterinarioAgenda(JComboBox<Object> veterinario, JTextField idVeterinario) {
		try {
			String query = "SELECT id FROM funcionario WHERE nome ='" + veterinario.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				idVeterinario.setText(this.resultset.getString("id"));
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void clienteAgenda(JComboBox<Object> cliente, JTextField idCliente) {
		try {
			String query = "SELECT id from cliente where nome ='" + cliente.getSelectedItem() + "';";
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				idCliente.setText(this.resultset.getString("id"));
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void buscarAnimalAgenda(JComboBox<Object> cliente, JComboBox pet) {
		try {
			String query = "SELECT animal.nome from cliente inner join animal on cliente.id = animal.idclie where cliente.nome ='" + cliente.getSelectedItem() + "';";
			resultset = this.statement.executeQuery(query);
			DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(this.resultset.getString("animal.nome"));
			}
			pet.setModel(model);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void idPet(JComboBox<Object> pet, JTextField idPet) {
		try {
			String query = "SELECT idanimal from animal where nome ='" + pet.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				idPet.setText(this.resultset.getString("idanimal"));
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirAgenda(JTextField idvet, JTextField cliente, JTextField idanimal, String tipo, String data, JTextField hora, JTextField termino, int comparecimento, TextArea obs, TextArea descricao ) {
		try {
			String query = "INSERT INTO agenda (idvet, cliente, idanimal, tipo, data, hora, termino, comparecimento, obs, descricao) VALUES ('"+ idvet.getText() + "','" + cliente.getText() + "','"+ idanimal.getText() + "','" + tipo + "','" + data + "','" + hora.getText() + "','" + termino.getText() + "','" + comparecimento + "','" + obs.getText() + "','" + descricao.getText() + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void buscarAgendaLista(JList<String> lista, JList<String> listaVeterinario, JList<String> listaData, JList<String> listaHora) {
		try {
			String query = "SELECT cliente.nome, funcionario.nome, agenda.data, agenda.hora FROM cliente JOIN agenda join funcionario on cliente.id = agenda.cliente and funcionario.id = agenda.idvet;";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			DefaultListModel<String> DML1 = new DefaultListModel<String>();
			DefaultListModel<String> DML2 = new DefaultListModel<String>();
			DefaultListModel<String> DML3 = new DefaultListModel<String>();
			while(this.resultset.next()) {

				String dia = this.resultset.getString("agenda.data").substring(8);
				String mes = this.resultset.getString("agenda.data").substring(5,7);
				String ano = this.resultset.getString("agenda.data").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				DML.addElement(this.resultset.getString("cliente.nome"));
				DML1.addElement(this.resultset.getString("funcionario.nome"));
				DML2.addElement(datasql);
				DML3.addElement(this.resultset.getString("agenda.hora"));
			}
			lista.setModel(DML);
			listaVeterinario.setModel(DML1);
			listaData.setModel(DML2);
			listaHora.setModel(DML3);
		} catch (Exception e ) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getStackTrace());
		}
	}

	public void inserirCliente(String data,JTextField nome, JTextField cpf, String sexo, String nascimento, JTextField cep, JTextField rua , JTextField numero, JTextField bairro, JTextField cidade, JTextField uf , JTextField complemento, JTextField telefone, JTextField celular, JTextField email ) {
		try {
			String query = "INSERT INTO cliente (data,nome, cpf, sexo, nascimento , cep, rua, numero, bairro, cidade,uf,complemento,telefone,celular,email) VALUES ( '" + data + "' , '" + nome.getText() + "' , '" + cpf.getText() + "' , '" + sexo + "' , '" + nascimento + "' , '" + cep.getText() + "','" + rua.getText() + "' , '" + numero.getText() + "' , '" + bairro.getText() + "' , '" + cidade.getText() + "','"  + uf.getText() + "' , '" + complemento.getText() + "' , '" + telefone.getText() + "' , '" + celular.getText() + "' , '" + email.getText() + "');";

			this.statement.executeUpdate(query);
		}catch (Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
		}
	}

	public void pesquisarCliente(JTextField busca, JList<String> lista) {
		try {
			String query = "SELECT * FROM cliente WHERE nome LIKE '%" + busca.getText() + "%' ORDER by 'name' ASC;";
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			while(this.resultset.next()) {
				DML.addElement(this.resultset.getString("nome"));
			}
			lista.setModel(DML);
		}
		catch(Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
		}
	}

	public void editarCliente(JTextField dataNascimento, JTextField data, JRadioButton masculino, JRadioButton feminino, JTextField nome, JTextField cpf, JTextField cep, JTextField rua, JTextField numero, JTextField bairro, JTextField cidade, JTextField uf, JTextField complemento, JTextField telefone, JTextField celular, JTextField email, JTextField id) {
		try {
			String dia = dataNascimento.getText().substring(0,2);
			String mes = dataNascimento.getText().substring(3,5);
			String ano = dataNascimento.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String dia1 = data.getText().substring(0,2);
			String mes1 = data.getText().substring(3,5);
			String ano1 = data.getText().substring(6);
			String datasql1 = ano1+"-"+mes1+"-"+dia1;

			String d = null;
			if (masculino.isSelected()) {
				d = "Masculino";
			} else if (feminino.isSelected()) {
				d = "Feminino";
			}

			String query = "UPDATE cliente SET nome ='" + nome.getText()+ "', data ='" + datasql1 + "', cpf ='" + cpf.getText() + "', sexo ='" + d + "', nascimento ='" + datasql + "', cep ='" + cep.getText() + "', rua= '" + rua.getText() + "', numero ='" + numero.getText() + "', bairro ='" + bairro.getText() + "', cidade ='" + cidade.getText() + "', uf ='" + uf.getText() + "', complemento ='" + complemento.getText() + "', telefone ='" + telefone.getText() + "', celular ='" + celular.getText() + "', email ='" + email.getText() + "' WHERE id ='" + id.getText() + "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
		}
	}

	public void excluirCliente(JTextField id) {
		try {
			String query ="DELETE from cliente Where id = '" + id.getText() + "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir! Erro: " + e.getMessage());
		}
	}

	public void clienteAnimal(JList<String> listaNome, JTextField dono, JTextField cliente) {
		try {
			String query = "SELECT * FROM cliente WHERE nome = '" + listaNome.getSelectedValue() +"';";

			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				dono.setText(this.resultset.getString("nome"));
				cliente.setText(this.resultset.getString("ID"));
			}
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
		}
	}
}