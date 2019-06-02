package controller;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Agenda {

	public static String tipo(JComboBox<String> tipo) { 
		if (tipo.getSelectedItem().equals("Consulta")) {
			return "Consulta";
		}
		else if (tipo.getSelectedItem().equals("Cirurgia")) {
			return "Cirurgia";

		}
		else if (tipo.getSelectedItem().equals("Vacina")) {
			return "Vacina";
		}
		else
			return null;
	}

	public static int comparecimento(JCheckBox comparecimento) {
		if (comparecimento.isSelected() == true) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void novo(TextArea descricao, JCheckBox comparecimento, TextArea recomendacao, JFormattedTextField inicio, JFormattedTextField termino, JButton editar, JButton salvar) {
		descricao.setText("");
		comparecimento.setSelected(false);
		recomendacao.setText("");
		termino.setText("");
		inicio.setText("");
		descricao.setEditable(true);
		recomendacao.setEditable(true);
		inicio.setEditable(true);
		termino.setEditable(true);
		salvar.setVisible(true);
		editar.setVisible(false);
	}
	
	public static void editarTrue(TextArea descricao, TextArea recomendacao, JFormattedTextField inicio, JFormattedTextField termino, JButton editar, JButton salvar) {
		descricao.setEditable(true);
		recomendacao.setEditable(true);
		inicio.setEditable(true);
		termino.setEditable(true);
		editar.setVisible(true);
		salvar.setVisible(false);
	}
	
	public static void editarFalse(TextArea descricao, TextArea recomendacao, JFormattedTextField inicio, JFormattedTextField termino, JButton editar, JButton salvar) {
		descricao.setEditable(false);
		recomendacao.setEditable(false);
		inicio.setEditable(false);
		termino.setEditable(false);
		editar.setVisible(false);
		salvar.setVisible(true);
	}
	
	public static boolean verificacao(TextArea descricao, TextArea recomendacao, JFormattedTextField inicio, JFormattedTextField termino, JComboBox<String> veterinario, JComboBox<String> cliente, JComboBox<String> pet, JDateChooser data) {
		if(inicio.getText().charAt(3) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo inicio!");
			return false;
		}
		else if(termino.getText().charAt(3) == ' ') {
			JOptionPane.showMessageDialog(null, "Preencha o campo término!");
			return false;
		}
		else if(veterinario.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o veterinário!");
			return false;
		}
		else if(cliente.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o cliente!");
			return false;
		}
		else if(pet.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o animal!");
			return false;
		}
		else if(recomendacao.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo recomendação!");
			return false;
		}
		else if(descricao.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo descrição!");
			return false;
		}
		else
			return true;
	}
}