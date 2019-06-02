package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Fornecedor {

	public static void cliqueTrue(JTextField nome, JFormattedTextField cnpj, JTextField contato, JFormattedTextField telefone, JTextPane descricao, JTextField email, JButton editar, JButton salvar) {
		nome.setEditable(true);
		cnpj.setEditable(true);
		contato.setEditable(true);
		telefone.setEditable(true);
		descricao.setEditable(true);
		email.setEditable(true);
		editar.setVisible(true);
		salvar.setVisible(false);
	}
	
	public static void cliqueFalse(JTextField nome, JFormattedTextField cnpj, JTextField contato, JFormattedTextField telefone, JTextPane descricao, JTextField email, JButton editar, JButton salvar) {
		nome.setEditable(false);
		cnpj.setEditable(false);
		contato.setEditable(false);
		telefone.setEditable(false);
		descricao.setEditable(false);
		email.setEditable(false);
		editar.setVisible(false);
		salvar.setVisible(true);
	}
	
	public static void novo(JTextField nome, JFormattedTextField cnpj, JTextField contato, JFormattedTextField telefone, JTextPane descricao, JTextField email, JTextField data, JButton editar, JButton salvar, JList<String> listaNome){
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setText("");
		cnpj.setText("");
		contato.setText("");
		telefone.setText("");
		descricao.setText("");
		email.setText("");
		nome.setEditable(true);
		cnpj.setEditable(true);
		contato.setEditable(true);
		telefone.setEditable(true);
		descricao.setEditable(true);
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
	
	public static boolean verificacao(JTextField nome, JFormattedTextField cnpj, JTextField contato, JFormattedTextField celular, JTextPane descricao, JTextField email, JTextPane informacoes) {
		if(nome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo nome!");
			return false;
		}
		else if(cnpj.getText().charAt(18) == ' ') {
			JOptionPane.showMessageDialog(null, "Informe o CNPJ!");
			return false;
		}
		else if(contato.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo contato!");
			return false;
		}
		else if(celular.getText().charAt(13) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo telefone!");
			return false;
		}
		else if(email.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo E-Mail!");
			return false;
		}
		else if(informacoes.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo informações!");
			return false;
		}
		else
			return true;
	}
}
