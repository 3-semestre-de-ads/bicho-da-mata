package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import WebService.WebServiceCep;;

public class Cliente {

	public static void novo(JTextField nome, JFormattedTextField cpf, JFormattedTextField cep, JFormattedTextField nascimento, JTextField rua, JTextField numero, JTextField bairro, JTextField cidade, JTextField uf, JTextField complemento, JFormattedTextField telefone, JFormattedTextField celular, JTextField email, JTextField data, JButton salvar, JButton editar, JList<String> listaNome) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
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
		nome.setEditable(true);
		cpf.setEditable(true);
		nascimento.setEditable(true);
		cep.setEditable(true);
		numero.setEditable(true);
		complemento.setEditable(true);
		telefone.setEditable(true);
		celular.setEditable(true);
		email.setEditable(true);
		data.setText(formatoBr.format(new Date()));
		salvar.setVisible(true);
		editar.setVisible(false);
		listaNome.clearSelection();
	}

	public static String data(JTextField data) {
		String dia = data.getText().substring(0,2);
		String mes = data.getText().substring(3,5);
		String ano = data.getText().substring(6);
		return ano + "-" + mes + "-" + dia;
	}

	public static String sexo(JRadioButton masculino) {
		if (masculino.isSelected()) {
			return "Masculino";
		}else
			return "Feminino";
	}

	public static void webService(JTextField cep, JTextField rua, JTextField bairro, JTextField cidade, JTextField uf) {
		WebServiceCep webService = WebServiceCep.searchCep(cep.getText());
		if (webService.wasSuccessful()) {
			rua.setText(webService.getLogradouro());
			bairro.setText(webService.getBairro());
			cidade.setText(webService.getCidade());
			uf.setText(webService.getUf());
			rua.setEditable(false);
			bairro.setEditable(false);
			cidade.setEditable(false);
			uf.setEditable(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "CEP NÃO LOCALIZADO");
			rua.setEditable(true);
			bairro.setEditable(true);
			cidade.setEditable(true);
			uf.setEditable(true);
		}
	}
	
	public static void cliqueTrue(JTextField nome, JTextField cpf, JTextField nascimento, JTextField cep, JTextField numero, JTextField complemento, JTextField telefone, JTextField celular, JTextField email, JButton editar, JButton salvar, JTextField data) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setEditable(true);
		cpf.setEditable(true);
		nascimento.setEditable(true);
		cep.setEditable(true);
		numero.setEnabled(true);
		complemento.setEnabled(true);
		telefone.setEnabled(true);
		celular.setEnabled(true);
		email.setEditable(true);
		editar.setVisible(true);
		salvar.setVisible(false);
		data.setText(formatoBr.format(new Date()));
	}
	
	public static void cliqueFalse(JTextField nome, JTextField cpf, JTextField nascimento, JTextField cep, JTextField numero, JTextField complemento, JTextField telefone, JTextField celular, JTextField email, JButton editar, JButton salvar, JTextField data) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setEditable(false);
		cpf.setEditable(false);
		nascimento.setEditable(false);
		cep.setEditable(false);
		numero.setEnabled(false);
		complemento.setEnabled(false);
		telefone.setEnabled(false);
		celular.setEnabled(false);
		email.setEditable(false);
		editar.setVisible(false);
		salvar.setVisible(true);
		data.setText(formatoBr.format(new Date()));
	}
	public static boolean verificacao(JTextField nome, JFormattedTextField cpf, JRadioButton masculino, JRadioButton feminino, JFormattedTextField nascimento, JTextField rua, JTextField bairro, JTextField cidade, JTextField uf, JFormattedTextField cep, JTextField numero, JFormattedTextField celular, JTextField email) {
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
		else if(email.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo E-Mail!");
			return false;
		}
		else
			return true;
	}
}