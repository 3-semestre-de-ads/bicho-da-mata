package interfaces;

import java.awt.Button;
import java.awt.Component;
import java.awt.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.events.EventException;

import com.mysql.cj.xdevapi.Statement;
/**
 * classe criada para realizar a conexao do banco de dados MySQL com o Eclipse. os metodos relacionados a requisicoes ao banco de dados, tambem serao criados nesta classe.
 * @author mauri
 *
 */
public class BancoDeDados {
	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");

	private static final int ArrayList = 0;
	private Connection conneciton = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	/**
	 * metodo criado para conectar ao banco de dados, por enquanto nao atribuimos senha para a conexao.
	 */
	public void conectar() {
		String servidor ="jdbc:mysql://localhost:3306/bichodamata?useTimezone=true&serverTimezone=America/Sao_Paulo";
		String usuario ="root";
		String senha = "";
		String driver = "com.mysql.cj.jdbc.Driver"; //com.mysql.jdbc.Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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

			String query = "SELECT * from fornecedor ORDER by id";
			this.resultset = this.statement.executeQuery(query);
			String msg = null;
			while(this.resultset.next()) {

				msg = resultset.getString("id") + resultset.getString("nome") + resultset.getString("cnpj");

			}


		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	/**
	 * metodo sera utilizado para fazer uma requisicao no banco de dados buscando todos os dados da tabela fornecedor 
	 */

	public void pesquisaFornecedor() {

		try {

			String query = "SELECT * FROM fornecedor WHERE nome LIKE '%" + TelaFornecedor.txtBusca.getText() + "%' ORDER by 'name' ASC;";

			resultset = this.statement.executeQuery(query);

			DefaultListModel<String> DML = new DefaultListModel<String>();

			while(this.resultset.next()) {
				//System.out.println(("id: "+ this.resultset.getString("id") + " Nome: " + this.resultset.getString("nome") + " cnpj: " + this.resultset.getString("cnpj") + " contato: " + this.resultset.getString("contato") + " telefone: " + this.resultset.getString("telefone") + " descricao: " + this.resultset.getString("descricao")));

				DML.addElement(this.resultset.getString("nome"));
				//	Nome.setText(this.resultset.getString("id"));
			}
			TelaFornecedor.listName.setModel(DML);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	public void pesquisaAniaml() {
		try {
			String query = "SELECT cliente.*, animal.* from animal join cliente on cliente.id = animal.idclie Where cliente.nome LIKE '%" + TelaAnimal.txtBuscaDono.getText() + "%' ORDER by 'date'";
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
			TelaAnimal.list.setModel(DML1);
			TelaAnimal.listName.setModel(DML);
			TelaAnimal.list2.setModel(DML2);
		} catch (Exception e) {

		}
	}

	public void pesquisaFuncionario() {

		try {

			String query = "SELECT * FROM funcionario WHERE nome LIKE '%" + TelaFuncionario.txtBusca.getText() + "%' ORDER by 'name' ASC;";
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			while(this.resultset.next()) {
				//System.out.println(("id: "+ this.resultset.getString("id") + " Nome: " + this.resultset.getString("nome") + " cnpj: " + this.resultset.getString("cnpj") + " contato: " + this.resultset.getString("contato") + " telefone: " + this.resultset.getString("telefone") + " descricao: " + this.resultset.getString("descricao")));


				DML.addElement(this.resultset.getString("nome"));
				//	Nome.setText(this.resultset.getString("id"));
			}
			TelaFuncionario.listName.setModel(DML);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	public void addVacina(	) {
		//	TelaFicha.comboVacina.getSelectedItem();


		//	ArrayList<String> DML = new ArrayList<String>();
		//		DefaultListModel<String> DML = new DefaultListModel<String>();
		//	ListSelectionModel DML = new ListSelectionModel();
		//		DML.addElement((String) TelaFicha.comboVacina.getSelectedItem());

		//	TelaFicha.listVacina.setModel(DML);
		//TelaFicha.listVacina.
		//	System.out.println(DML);
	}
	public void pesquisaFicha() {
		try {
			//		String query = "SELECT  animal.nome , ficha.data from ficha join animal where animal.nome ='" + TelaFicha.txtNome.getText() + "';";
			String query = "SELECT a.nome nome, b.data dia FROM animal a inner join ficha b on a.idanimal = b.idanimal where a.nome ='" + TelaFicha.txtNome.getText() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			DefaultListModel<String> DML1 = new DefaultListModel<String>();
			while(this.resultset.next()) {

				//	String dia = this.resultset.getString("ficha.data").substring(8);
				//	String mes = this.resultset.getString("ficha.data").substring(5,7);
				//	String ano = this.resultset.getString("ficha.data").substring(0,4);
				//	String datasql = dia+"/"+mes+"/"+ano;

				String dia = this.resultset.getString("dia").substring(8);
				String mes = this.resultset.getString("dia").substring(5,7);
				String ano = this.resultset.getString("dia").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				//DML.addElement(this.resultset.getString("animal.nome"));
				DML.addElement(this.resultset.getString("nome"));

				DML1.addElement(datasql);
			}
			TelaFicha.list.setModel(DML1);
			TelaFicha.list_2.setModel(DML);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public void pesquisarVacina() {
		try {
			String query = "SELECT * FROM vacina WHERE idanimal =" + TelaFicha.txtAnimal.getText() + " order by data;";
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

			TelaFicha.listVacina.setModel(DML);
			TelaFicha.listData.setModel(DML1);
		} 

		catch (Exception e ) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	public void buscarFicha() {
		try {
			String dia = TelaFicha.list.getSelectedValue().toString().substring(0,2);
			String mes = TelaFicha.list.getSelectedValue().toString().substring(3,5);
			String ano = TelaFicha.list.getSelectedValue().toString().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			System.out.println(datasql);
			//String query = "Select funcionario.nome, ficha.*, animal.* from ficha join funcionario join animal where animal.data = " + "'" + TelaFicha.list.getSelectedValue() + "';";
			String query = "Select funcionario.nome, ficha.*, animal.* from ficha join funcionario join animal where ficha.data ="+"'" + datasql + "'"+ " and " + "animal.nome="+"'"+TelaFicha.txtNome.getText() +"';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {

				TelaFicha.txtPeso.setText(this.resultset.getString("ficha.peso"));
				TelaFicha.txtDia.setText(this.resultset.getString("ficha.diagnostico"));
				TelaFicha.txtHistorico.setText(this.resultset.getString("ficha.historico"));
				TelaFicha.comboVet.setSelectedItem(this.resultset.getString("funcionario.nome"));
				TelaFicha.txtIdFicha.setText(this.resultset.getString("ficha.idficha"));

			}
		} catch (Exception e ) {

		}
	}
	public void buscarAgendaLista() {
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
			TelaAgenda.list.setModel(DML);
			TelaAgenda.listVet.setModel(DML1);
			TelaAgenda.listData.setModel(DML2);
			TelaAgenda.listHora.setModel(DML3);


		} catch (Exception e ) {
			JOptionPane.showMessageDialog(null, e.getStackTrace());
			
		}
	}
	public void inserirVacinaId() {
		try {
			String query = "SELECT * from vacina where vacina = " + "'" +TelaFicha.listVacina.getSelectedValue() +"';";
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {

				TelaFicha.txtIdVacina.setText(this.resultset.getString("idvacina"));
			}
		}catch (Exception e) {

		}
	}


	public void deletarVacina() {
		try {
			String query = "Delete from vacina where idvacina = '"+TelaFicha.txtIdVacina.getText()+"';";
			System.out.println(query);
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Vacina excluida com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir!");
		}
	}



	public void pesquisaCliente() {

		try {

			String query = "SELECT * FROM cliente WHERE nome LIKE '%" + TelaCadastro.txtBusca.getText() + "%' ORDER by 'name' ASC;";
			resultset = this.statement.executeQuery(query);
			DefaultListModel<String> DML = new DefaultListModel<String>();
			while(this.resultset.next()) {

				//System.out.println(("id: "+ this.resultset.getString("id") + " Nome: " + this.resultset.getString("nome") + " cnpj: " + this.resultset.getString("cnpj") + " contato: " + this.resultset.getString("contato") + " telefone: " + this.resultset.getString("telefone") + " descricao: " + this.resultset.getString("descricao")));

				DML.addElement(this.resultset.getString("nome"));
				//	Nome.setText(this.resultset.getString("id"));
			}
			TelaCadastro.listName.setModel(DML);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	public void buscarVacinFa() {
		try {

		}catch(Exception e) {

		}
	}
	public void buscarAnimal() {
		try {
			String query = "SELECT cliente.* , animal.* FROM animal join cliente on cliente.id = animal.idclie where animal.nome = " + "'" + TelaAnimal.listName.getSelectedValue() +"';";

			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {

				String dia = this.resultset.getString("animal.nascimento").substring(8);
				String mes = this.resultset.getString("animal.nascimento").substring(5,7);
				String ano = this.resultset.getString("animal.nascimento").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				// problemas quanto possui mais de um animal.

				TelaAnimal.txtClie.setText(this.resultset.getString("cliente.id"));
				TelaAnimal.txtDono.setText(this.resultset.getString("cliente.nome"));
				TelaAnimal.txtAnimal.setText(this.resultset.getString("animal.idanimal"));
				TelaAnimal.txtNome.setText(this.resultset.getString("animal.nome"));
				TelaAnimal.txtEspecie.setText(this.resultset.getString("animal.especie"));
				TelaAnimal.txtRaca.setText(this.resultset.getString("animal.raca"));
				TelaAnimal.txtNascimento.setText(datasql);
				TelaAnimal.txtCor.setText(this.resultset.getString("animal.cor"));
				TelaAnimal.txtObs.setText(this.resultset.getString("animal.obs"));
				if (this.resultset.getString("animal.sexo").equals("Macho")) {
					TelaAnimal.opMacho.setSelected(true);
				} else {
					TelaAnimal.opFem.setSelected(true);
				}
				if (this.resultset.getString("castrado").equals("Sim")) {
					TelaAnimal.opSim.setSelected(true);
				}else {
					TelaAnimal.opNao.setSelected(true);
				}
			}

		} catch (Exception e) {

		}
	}


	public void InserirFornecedor() {

		try {

			String query = "SELECT * FROM fornecedor WHERE nome = " + "'" +TelaFornecedor.listName.getSelectedValue() +"';";
			resultset = this.statement.executeQuery(query);

			while(this.resultset.next()) {

				String dia1 = this.resultset.getString("data").substring(8);
				String mes1 = this.resultset.getString("data").substring(5,7);
				String ano1 = this.resultset.getString("data").substring(0,4);
				String datasql1 = dia1+"/"+mes1+"/"+ano1;



				//String d = String.valueOf(this.resultset.getObject("descricao"));

				//String a = String.valueOf(this.resultset.getObject("descricao"));
				TelaFornecedor.txtDescricao.setText(this.resultset.getString("descricao"));
				TelaFornecedor.txtData.setText(datasql1);
				TelaFornecedor.txtNome.setText(this.resultset.getString("nome"));
				TelaFornecedor.txtCnpj.setText(this.resultset.getString("cnpj"));
				TelaFornecedor.txtContato.setText(this.resultset.getString("contato"));
				TelaFornecedor.txtTelefone.setText(this.resultset.getString("telefone"));
				TelaFornecedor.txtEmail.setText(this.resultset.getString("email"));
				TelaFornecedor.txtID.setText(this.resultset.getString("id"));
				//TelaFornecedor.txtDescricao.setText



			}


		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	private String getText(String d) {
		// TODO Auto-generated method stub
		return null;
	}


	public void buscarFuncionario() {

		try {
			String query = "SELECT * FROM funcionario WHERE nome = " + "'" +TelaFuncionario.listName.getSelectedValue() +"';";
			resultset = this.statement.executeQuery(query);


			while(this.resultset.next()) {

				String dia = this.resultset.getString("nascimento").substring(8);
				String mes = this.resultset.getString("nascimento").substring(5,7);
				String ano = this.resultset.getString("nascimento").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				String dia2 = this.resultset.getString("validade").substring(8);
				String mes2 = this.resultset.getString("validade").substring(5,7);
				String ano2 = this.resultset.getString("validade").substring(0,4);
				String validade = dia2+"/"+mes2+"/"+ano2;

				TelaFuncionario.txtNome.setText(this.resultset.getString("nome"));
				TelaFuncionario.txtCpf.setText(this.resultset.getString("cpf"));
				TelaFuncionario.txtDataNasc.setText(datasql);
				TelaFuncionario.txtCep.setText(this.resultset.getString("cep"));
				TelaFuncionario.txtRua.setText(this.resultset.getString("rua"));
				TelaFuncionario.txtNum.setText(this.resultset.getString("numero"));
				TelaFuncionario.txtBairro.setText(this.resultset.getString("bairro"));
				TelaFuncionario.txtCidade.setText(this.resultset.getString("cidade"));
				TelaFuncionario.txtUf.setText(this.resultset.getString("uf"));
				TelaFuncionario.txtComp.setText(this.resultset.getString("complemento"));
				TelaFuncionario.txtTel.setText(this.resultset.getString("telefone"));
				TelaFuncionario.txtCel.setText(this.resultset.getString("celular"));
				TelaFuncionario.txtEmail.setText(this.resultset.getString("email"));
				TelaFuncionario.txtID.setText(this.resultset.getString("id"));
				TelaFuncionario.txtValidade.setText(validade);
				if (this.resultset.getString("sexo").equals("Masculino")) {
					TelaFuncionario.opMasc.setSelected(true);
				} else {
					TelaFuncionario.opFem.setSelected(true);
				}
				TelaFuncionario.comboFuncao.setSelectedItem(this.resultset.getString("funcao"));
				TelaFuncionario.txtCrmv.setText(this.resultset.getString("crmv"));


			}


		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	public void setClienteAnimal() {
		try {
			String query = "SELECT * FROM cliente WHERE nome =" + "'" +TelaCadastro.listName.getSelectedValue() +"';";

			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				TelaAnimal.txtDono.setText(this.resultset.getString("nome"));
				TelaAnimal.txtClie.setText(this.resultset.getString("ID"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}


	}
	public void setFicha() {
		try {
			String query = "SELECT cliente.* , animal.* FROM animal join cliente on cliente.id = animal.idclie where animal.nome = " + "'" + TelaAnimal.listName.getSelectedValue() +"';";
			System.out.println(query);

			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println(query);
				TelaFicha.txtDono.setText(this.resultset.getString("cliente.nome"));
				TelaFicha.txtNome.setText(this.resultset.getString("animal.nome"));
				TelaFicha.txtAnimal.setText(this.resultset.getString("animal.idanimal"));
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "nao foi possivel localizar");

		}
	}
	public void setVet() {
		try {
			String query = "SELECT nome from funcionario where funcao = 'Veterinário';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(this.resultset.getString("nome"));


			}

			TelaFicha.comboVet.setModel(model);
		}catch (Exception e) {

		}
	}
	public void setCliente() {
		try {
			String query = "SELECT id from cliente where nome ='" + TelaAgenda.comboCliente.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				TelaAgenda.idClie.setText(this.resultset.getString("id"));
			}


		}catch (Exception e) {

		}
	}
	public void setClieAgenda() {
		try {
			String query = "SELECT nome from cliente;";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(this.resultset.getString("nome"));


			}
			TelaAgenda.comboCliente.setModel(model);
		}catch (Exception e) {

		}
	}
	public void setVetAgenda() {
		try {
			String query = "SELECT * from funcionario where funcao = 'Veterinário';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(this.resultset.getString("nome"));


			}
			TelaAgenda.comboVet.setModel(model);
		}catch (Exception e) {

		}
	}
	public void setIDVet() {
		try {
			String query = "SELECT * from funcionario where nome ='" + TelaFicha.comboVet.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				TelaFicha.txtIdVet.setText(this.resultset.getString("id"));
			}
		}catch (Exception e) {

		}
	}
	public void setIdPet() {
		try {
			String query = "SELECT idanimal from animal where nome ='" + TelaAgenda.comboPet.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				TelaAgenda.idPet.setText(this.resultset.getString("idanimal"));
			}
		}catch (Exception e) {

		}
	}

	public void setIDVetAgenda() {
		try {
			String query = "SELECT id from funcionario where nome ='" + TelaAgenda.comboVet.getSelectedItem() + "';";
			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				TelaAgenda.txtIdVet.setText(this.resultset.getString("id"));
			}
		}catch (Exception e) {

		}
	}
	public void buscarAnimalAgenda() {
		try {
			String query = "SELECT animal.nome from cliente inner join animal on cliente.id = animal.idclie where cliente.nome ='" +  TelaAgenda.comboCliente.getSelectedItem() + "';";

			System.out.println(query);
			resultset = this.statement.executeQuery(query);
			DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
			while(this.resultset.next()) {
				model.addElement(this.resultset.getString("animal.nome"));


			}
			TelaAgenda.comboPet.setModel(model);
		}catch (Exception e) {

		}
	}
	public void buscarCliente() {

		try {

			String query = "SELECT * FROM cliente WHERE nome = " + "'" +TelaCadastro.listName.getSelectedValue() +"';";
			resultset = this.statement.executeQuery(query);



			while(this.resultset.next()) {

				String dia = this.resultset.getString("nascimento").substring(8);
				String mes = this.resultset.getString("nascimento").substring(5,7);
				String ano = this.resultset.getString("nascimento").substring(0,4);
				String datasql = dia+"/"+mes+"/"+ano;

				String dia1 = this.resultset.getString("data").substring(8);
				String mes1 = this.resultset.getString("data").substring(5,7);
				String ano1 = this.resultset.getString("data").substring(0,4);
				String datasql1 = dia1+"/"+mes1+"/"+ano1;




				TelaCadastro.txtData.setText(datasql1);
				TelaCadastro.txtNome.setText(this.resultset.getString("nome"));
				TelaCadastro.txtCpf.setText(this.resultset.getString("cpf"));
				TelaCadastro.txtDataNasc.setText(datasql);
				TelaCadastro.txtCep.setText(this.resultset.getString("cep"));
				TelaCadastro.txtRua.setText(this.resultset.getString("rua"));
				TelaCadastro.txtNum.setText(this.resultset.getString("numero"));
				TelaCadastro.txtBairro.setText(this.resultset.getString("bairro"));
				TelaCadastro.txtCidade.setText(this.resultset.getString("cidade"));
				TelaCadastro.txtUf.setText(this.resultset.getString("uf"));
				TelaCadastro.txtComp.setText(this.resultset.getString("complemento"));
				TelaCadastro.txtTel.setText(this.resultset.getString("telefone"));
				TelaCadastro.txtCel.setText(this.resultset.getString("celular"));
				TelaCadastro.txtEmail.setText(this.resultset.getString("email"));
				TelaCadastro.txtID.setText(this.resultset.getString("id"));

				if (this.resultset.getString("sexo").equals("Masculino")) {
					TelaCadastro.opMasc.setSelected(true);

				} else {
					TelaCadastro.opFem.setSelected(true);

				}
				//				TelaFornecedor.txtDescricao.setText(this.resultset.getString("descricao"));

			}


		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}


	/**
	 * Metodo criado para inserir rows ao banco de dados.
	 * @param nome String nome 
	 * @param telefone String numero de telefone 
	 */

	public void inserirAnimal(int idclie, String nome, String especie , String raca, String sexo, String nascimento, String castrado, String cor, String data, String obs) {
		try {
			String query = "INSERT INTO animal (idclie, nome, especie, raca, sexo, nascimento, castrado, cor,data,obs) VALUES ('" + idclie + "' , '" + nome + "' , '" + especie + "','" + raca + "','" + sexo + "' , '" + nascimento + "','" + castrado + "','" + cor + "','" + data + "','" + obs + "');";
			//System.out.println(query);
			this.statement.executeUpdate(query);

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}


	public void inserirAgenda(int idvet, String cliente, int idanimal, String tipo, String data, String hora, String termino, int comparecimento, String obs, String descricao ) {
		try {
			String query = "INSERT INTO agenda (idvet, cliente, idanimal, tipo, data, hora, termino, comparecimento, obs, descricao) VALUES ('"+ idvet + "','" + cliente + "','"+ idanimal + "','" + tipo + "','" + data + "','" + hora + "','" + termino + "','" + comparecimento + "','" + obs + "','" + descricao + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}

	public void inserirVacina(Object vacina, int idanimal, String data) {
		try {
			String query = "INSERT INTO vacina (vacina , idanimal, data) VALUES ('"+ vacina +"','"+idanimal+"','"+ data +"');";

			this.statement.executeUpdate(query);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	}

	public void inserirFicha(JTextField idanimal, JTextField idvacina, JTextField idfunc, JTextField data , JTextField peso, JTextPane diagnostico, JTextPane historico) {
		try {
			String query = "INSERT INTO ficha (idanimal, idvacina, idfunc, data, peso, diagnostico, historico) values ('" + idanimal +"','" + idvacina + "','" + idfunc + "','" + data + "','" + peso + "','" + diagnostico.getText() + "','" + historico.getText() + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {

		}
	}

	public void inserirContato(String data,String nome, String cnpj, String contato, String telefone,String email, String descricao) {
		try {

			String query = "INSERT INTO fornecedor (data, nome , cnpj, contato, telefone,email, descricao) VALUES ('"+ data + "','" + nome + "','" + cnpj + "','" + contato + "','" + telefone + "','" + email + "','" + descricao + "');";

			this.statement.executeUpdate(query);

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
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

	public void inserirCliente(String data,String nome, String cpf, String sexo, String nascimento, String cep, String rua , String numero, String bairro, String cidade, String uf , String complemento, String telefone, String celular, String email ) {
		try {
			String query = "INSERT INTO cliente (data,nome, cpf, sexo, nascimento , cep, rua, numero, bairro, cidade,uf,complemento,telefone,celular,email) VALUES ( '" + data + "' , '" + nome + "' , '" + cpf + "' , '" + sexo + "' , '" + nascimento + "' , '" + cep + "','" + rua + "' , '" + numero + "' , '" + bairro + "' , '" + cidade + "','"  + uf + "' , '" + complemento + "' , '" + telefone + "' , '" + celular + "' , '" + email + "');";

			this.statement.executeUpdate(query);
		}catch (Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
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
	public void editarFornecedor() {
		try {
			String dia = TelaFornecedor.txtData.getText().substring(0,2);
			String mes = TelaFornecedor.txtData.getText().substring(3,5);
			String ano = TelaFornecedor.txtData.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;


			String query = "UPDATE fornecedor SET data = '"+ datasql + "', nome ='" + TelaFornecedor.txtNome.getText() + "', cnpj ='" + TelaFornecedor.txtCnpj.getText() + "', contato ='"+TelaFornecedor.txtContato.getText() + "', telefone ='"+TelaFornecedor.txtTelefone.getText()+"', email= '"+TelaFornecedor.txtEmail.getText()+"', descricao = '"+TelaFornecedor.txtDescricao.getText()+"' WHERE id ='"+TelaFornecedor.txtID.getText()+"';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void editarFuncionario() {
		try {
			String dia = TelaFuncionario.txtDataNasc.getText().substring(0,2);
			String mes = TelaFuncionario.txtDataNasc.getText().substring(3,5);
			String ano = TelaFuncionario.txtDataNasc.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String dia2 = TelaFuncionario.txtValidade.getText().substring(0,2);
			String mes2 = TelaFuncionario.txtValidade.getText().substring(3,5);
			String ano2 = TelaFuncionario.txtValidade.getText().substring(6);
			String validade = ano2+"-"+mes2+"-"+dia2;


			String d = null;
			if (TelaFuncionario.opMasc.isSelected()) {
				d = "Masculino";
			} else if (TelaFuncionario.opFem.isSelected()) {
				d = "Feminino";
			}
			String c = null;
			if (TelaFuncionario.comboFuncao.getSelectedItem() .equals("Veterinário")) {
				c = "Veterinário";
			}
			if (TelaFuncionario.comboFuncao.getSelectedItem() .equals("Auxiliar")) {
				c = "Auxiliar";
			}
			if (TelaFuncionario.comboFuncao.getSelectedItem() .equals("Secretária(o)")) {
				c = "Secretária(o)";
			}

			String query = "UPDATE funcionario SET nome = '"+TelaFuncionario.txtNome.getText()+ "', cpf ='" + TelaFuncionario.txtCpf.getText() +"', funcao ='"+c+"', crmv='"+ TelaFuncionario.txtCrmv.getText()+ "', validade ='" + validade + "', sexo ='" + d + "', nascimento ='"+ datasql + "', cep ='"+TelaFuncionario.txtCep.getText()+"', rua= '"+TelaFuncionario.txtRua.getText()+"', numero ='" + TelaFuncionario.txtNum.getText() + "'"
					+ ", bairro ='" + TelaFuncionario.txtBairro.getText() + "', cidade ='" + TelaFuncionario.txtCidade.getText() + "', uf ='" + TelaFuncionario.txtUf.getText() + "', complemento ='" + TelaFuncionario.txtComp.getText() + "', telefone ='" + TelaFuncionario.txtTel.getText() + "', celular ='" + TelaFuncionario.txtCel.getText() + "', email ='" + TelaFuncionario.txtEmail.getText() + "' WHERE id ='"+TelaFuncionario.txtID.getText()+"';";

			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");

		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void editarCliente() {
		try {
			String dia = TelaCadastro.txtDataNasc.getText().substring(0,2);
			String mes = TelaCadastro.txtDataNasc.getText().substring(3,5);
			String ano = TelaCadastro.txtDataNasc.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String dia1 = TelaCadastro.txtData.getText().substring(0,2);
			String mes1 = TelaCadastro.txtData.getText().substring(3,5);
			String ano1 = TelaCadastro.txtData.getText().substring(6);
			String datasql1 = ano1+"-"+mes1+"-"+dia1;

			String d = null;
			if (TelaCadastro.opMasc.isSelected()) {
				d = "Masculino";
			} else if (TelaCadastro.opFem.isSelected()) {
				d = "Feminino";
			}

			String query = "UPDATE cliente SET nome ='"+TelaCadastro.txtNome.getText()+ "', data ='" + datasql1 + "', cpf ='" + TelaCadastro.txtCpf.getText() + "', sexo ='" + d + "', nascimento ='"+ datasql + "', cep ='"+TelaCadastro.txtCep.getText()+"', rua= '"+TelaCadastro.txtRua.getText()+"', numero ='" + TelaCadastro.txtNum.getText() + "'"
					+ ", bairro ='" + TelaCadastro.txtBairro.getText() + "', cidade ='" + TelaCadastro.txtCidade.getText() + "', uf ='" + TelaCadastro.txtUf.getText() + "', complemento ='" + TelaCadastro.txtComp.getText() + "', telefone ='" + TelaCadastro.txtTel.getText() + "', celular ='" + TelaCadastro.txtCel.getText() + "', email ='" + TelaCadastro.txtEmail.getText() + "' WHERE id ='"+TelaCadastro.txtID.getText()+"';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void editarAnimal() {
		try {
			String dia = TelaAnimal.txtNascimento.getText().substring(0,2);
			String mes = TelaAnimal.txtNascimento.getText().substring(3,5);
			String ano = TelaAnimal.txtNascimento.getText().substring(6);
			String datasql = ano+"-"+mes+"-"+dia;

			String dia1 = TelaAnimal.txtDataFicha.getText().substring(0,2);
			String mes1 = TelaAnimal.txtDataFicha.getText().substring(3,5);
			String ano1 = TelaAnimal.txtDataFicha.getText().substring(6);
			String datasql1 = ano1+"-"+mes1+"-"+dia1;

			String d = null;
			if (TelaAnimal.opMacho.isSelected()) {
				d = "Macho";
			} else if (TelaAnimal.opFem.isSelected()) {
				d = "Femea";
			}

			String c = null;
			if (TelaAnimal.opSim.isSelected()) {
				c = "Sim";
			} else if (TelaAnimal.opNao.isSelected()) {
				c = "Nao";
			}

			String query = "UPDATE animal SET nome ='"+TelaAnimal.txtNome.getText()+ "', especie ='" +  TelaAnimal.txtEspecie.getText() + "', raca ='"+TelaAnimal.txtRaca.getText() + "', sexo ='" + d + "', nascimento = '" + datasql + "', castrado ='"+ c + "', cor ='"+TelaAnimal.txtCor.getText()+"', data ='"+ datasql1 + "', obs ='" + TelaAnimal.txtObs.getText() + "' WHERE idanimal ='"+TelaAnimal.txtAnimal.getText()+"';";;
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
	public void excluirFornecedor() {
		try {
			String query = "Delete From fornecedor Where id = '"+TelaFornecedor.txtID.getText()+"';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso!");


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public void excluirFuncionario() {
		try {
			String query = "Delete From funcionario Where id = '"+TelaFuncionario.txtID.getText()+"';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");



		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void excluirCliente() {
		try {
			String query ="DELETE from cliente Where id = '"+TelaCadastro.txtID.getText()+ "';";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir!");
		}


	}
	public void excluirAnimal() {
		try {
			String query = "DELETE from animal WHERE idanimal = '"+TelaAnimal.txtAnimal.getText()+"';";
			this.statement.execute(query);
			JOptionPane.showMessageDialog(null, TelaAnimal.txtNome.getText()+" excluido com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel excluir!");
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


