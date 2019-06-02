package controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import WebService.WebServiceCep;

public class Funcionario {

	public static void webService(JTextField rua, JTextField bairro, JTextField cidade, JTextField uf, JFormattedTextField cep) {
		WebServiceCep webService = WebServiceCep.searchCep(cep.getText());
		try {
			if (webService.wasSuccessful()) {
				rua.setText(webService.getLogradouro());
				bairro.setText(webService.getBairro());
				cidade.setText(webService.getCidade());
				uf.setText(webService.getUf());
				rua.setEditable(false);
				bairro.setEditable(false);
				cidade.setEditable(false);
				uf.setEditable(false);
			}else {
				JOptionPane.showMessageDialog(null, "CEP NÃO LOCALIZADO");
				rua.setEditable(true);
				bairro.setEditable(true);
				cidade.setEditable(true);
				uf.setEditable(true);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
	}

	public static void funcaoSelecionada(JComboBox<String> funcao, JLabel lCrmv, JTextField tCrmv, JLabel lValidade, JFormattedTextField tValidade) {
		if (funcao.getSelectedItem().equals("Veterinário(a)")) {
			lCrmv.setVisible(true);
			tCrmv.setVisible(true);
			tCrmv.setEditable(true);
			lValidade.setVisible(true);
			tValidade.setVisible(true);
		}else {
			lCrmv.setVisible(false);
			tCrmv.setVisible(false);
			tCrmv.setText("");
			lValidade.setVisible(false);
			tValidade.setVisible(false);
			tValidade.setText("");
		}
	}

	public static void cliqueTrue(JTextField nome, JFormattedTextField cpf, JFormattedTextField nascimento, JFormattedTextField cep, JTextField numero, JTextField complemento, JFormattedTextField telefone, JFormattedTextField celular, JTextField email, JTextField crmv, JFormattedTextField validade, JButton editar, JButton salvar) {
		nome.setEditable(true);
		cpf.setEditable(true);
		nascimento.setEditable(true);
		cep.setEditable(true);
		numero.setEditable(true);
		complemento.setEditable(true);
		telefone.setEditable(true);
		celular.setEditable(true);
		email.setEditable(true);
		editar.setVisible(true);
		crmv.setEditable(true);
		validade.setEditable(true);
		salvar.setVisible(false);
	}

	public static void cliqueFalse(JTextField nome, JFormattedTextField cpf, JFormattedTextField nascimento, JFormattedTextField cep, JTextField numero, JTextField complemento, JFormattedTextField telefone, JFormattedTextField celular, JTextField email, JTextField crmv, JFormattedTextField validade, JButton editar, JButton salvar) {
		nome.setEditable(false);
		cpf.setEditable(false);
		nascimento.setEditable(false);
		cep.setEditable(false);
		numero.setEditable(false);
		complemento.setEditable(false);
		telefone.setEditable(false);
		celular.setEditable(false);
		email.setEditable(false);
		editar.setVisible(false);
		crmv.setEditable(false);
		validade.setEditable(false);
		salvar.setVisible(true);
	}

	public static void novo(JTextField nome, JFormattedTextField cpf, JFormattedTextField nascimento, JTextField rua, JTextField bairro, JTextField cidade, JTextField uf, JComboBox<String> funcao, JFormattedTextField cep, JTextField numero, JTextField complemento, JFormattedTextField telefone, JFormattedTextField celular, JTextField email, JTextField crmv, JFormattedTextField validade, JList<String> listaNome, JButton editar, JButton salvar) {
		nome.setText("");
		cpf.setText("");
		cep.setText("");
		nascimento.setText("");
		rua.setText("");
		numero.setText("");
		bairro.setText("");
		cidade.setText("");
		uf.setText("");
		complemento.setText("");
		telefone.setText("");
		celular.setText("");
		email.setText("");
		crmv.setText("");
		validade.setText("");
		telefone.setText("(19)3392-5758");
		funcao.setSelectedItem("Secretária(o)");
		nome.setEditable(true);
		cpf.setEditable(true);
		nascimento.setEditable(true);
		cep.setEditable(true);
		numero.setEditable(true);
		complemento.setEditable(true);
		telefone.setEditable(true);
		celular.setEditable(true);
		email.setEditable(true);
		validade.setEditable(true);
		salvar.setVisible(true);
		editar.setVisible(false);
		listaNome.clearSelection();
	}

	public static String sexo(JRadioButton masculino) {
		if (masculino.isSelected()) {
			return "Masculino";
		}else
			return "Feminino";
	}

	public static String data(JTextField data) {
		String dia = data.getText().substring(0,2);
		String mes = data.getText().substring(3,5);
		String ano = data.getText().substring(6);
		return ano + "-" + mes + "-" + dia;
	}

	public static String funcao(JComboBox<String> tipo, JTextField validade) { 
		if (tipo.getSelectedItem().equals("Veterinário(a)")) {
			return "Veterinário(a)";
		}
		if (tipo.getSelectedItem().equals("Auxiliar")) {
			validade.setText("01/01/0001");
			return "Auxiliar";
		}
		if (tipo.getSelectedItem().equals("Estagiário")) {
			return "Estagiário";
		}
		if (tipo.getSelectedItem().equals("Secretária(o)")) {
			validade.setText("01/01/0001");
			return "Secretária(o)";
		}
		return null;
	}

	public static boolean verificacao(JTextField nome, JFormattedTextField cpf, JRadioButton masculino, JRadioButton feminino, JFormattedTextField nascimento, JTextField rua, JTextField bairro, JTextField cidade, JTextField uf, JFormattedTextField cep, JComboBox<String> funcao, JTextField crmv, JFormattedTextField validade, JTextField numero, JFormattedTextField celular, JTextField email) {
		if(nome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo nome!");
			return false;
		}
		else if(cpf.getText().charAt(13) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo CPF!");
			return false;
		}
		else if(masculino.isSelected() == false && feminino.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Informe o sexo!");
			return false;
		}
		else if(nascimento.getText().charAt(9) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo data de nascimento!");
			return false;
		}
		else if(Integer.parseInt(nascimento.getText().substring(0,2)) > 31 || Integer.parseInt(nascimento.getText().substring(0,2)) < 1) {
			JOptionPane.showMessageDialog(null, "O dia no campo data de nascimento está incorreto!");
			return false;
		}
		else if(Integer.parseInt(nascimento.getText().substring(3,5)) < 1 || Integer.parseInt(nascimento.getText().substring(3,5)) > 12) {
			JOptionPane.showMessageDialog(null, "O mês no campo data de nascimento está incorreto!");
			return false;
		}
		else if(cep.getText().charAt(8) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo CEP!");
			return false;
		}
		else if(funcao.getSelectedItem().equals("Veterinário(a)")) {
			if(crmv.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Informe o CRMV do(a) veterinário(a)!");
				return false;
			}
			else if(validade.getText().charAt(9) == ' ') {
				JOptionPane.showMessageDialog(null, "Informe a validade do CRMV do(a) veterinário(a)!");
				return false;	
			}
			else if(Integer.parseInt(validade.getText().substring(0,2)) > 31 || Integer.parseInt(validade.getText().substring(0,2)) < 1) {
				JOptionPane.showMessageDialog(null, "O dia no campo validade está incorreto!");
				return false;
			}
			else if(Integer.parseInt(validade.getText().substring(3,5)) < 1 || Integer.parseInt(validade.getText().substring(3,5)) > 12) {
				JOptionPane.showMessageDialog(null, "O mês no campo validade está incorreto!");
				return false;
			}
			else {
				if(rua.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo logradouro(rua)!");
					return false;
				}
				else if(numero.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo número!");
					return false;
				}
				else if(bairro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo bairro!");
					return false;
				}
				else if(cidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo cidade!");
					return false;
				}
				else if(celular.getText().charAt(13) == ' ') {
					JOptionPane.showMessageDialog(null, "Preencha o campo celular!");
					return false;
				}
				else if(uf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo UF!");
					return false;
				}
				else if(email.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo E-Mail!");
					return false;
				}
				else
					return true;
			}
		}
		else if(rua.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo logradouro(rua)!");
			return false;
		}
		else if(numero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo número!");
			return false;
		}
		else if(bairro.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo bairro!");
			return false;
		}
		else if(cidade.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo cidade!");
			return false;
		}
		else if(celular.getText().charAt(13) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo celular!");
			return false;
		}
		else if(uf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo UF!");
			return false;
		}
		else if(email.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo E-Mail!");
			return false;
		}
		else
			return true;
	}
}