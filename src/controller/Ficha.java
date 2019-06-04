package controller;

import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ficha {

	public static String data(String data) {
		String dia = data.substring(0,2);
		String mes = data.substring(3,5);
		String ano = data.substring(6);
		return ano + "-" + mes + "-" + dia;
	}
	
	public static void novo(JTextField data, TextArea dia, TextArea historico, JTextField peso, JComboBox<String> veterinario, JButton editar, JList<String> lista) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		data.setText(formatoBr.format(new Date()));
		dia.setText("");
		historico.setText("");
		peso.setText("");
		dia.setEditable(true);
		historico.setEditable(true);
		peso.setEditable(true);
		veterinario.setEditable(true);
		editar.setVisible(false);
		lista.getDropTarget();
	}
	
	public static void cliqueTrue(JButton editar, JTextField peso, TextArea historico, TextArea dia, JComboBox<String> veterinario) {
		editar.setVisible(true);
		peso.setEditable(true);
		historico.setEditable(true);
		dia.setEditable(true);
		veterinario.setEditable(true);
	}
	
	public static void cliqueFalse(JButton editar, JTextField peso, TextArea historico, TextArea dia, JComboBox<String> veterinario) {
		editar.setVisible(false);
		peso.setEditable(false);
		historico.setEditable(false);
		dia.setEditable(false);
		veterinario.setEditable(false);
	}
	
	public static void abrirReceita(JTextField nome, JTextField dono, JComboBox<String> veterinario, JTextField pet, JTextField tutor, JTextField vet) {
		pet.setText(nome.getText());
		tutor.setText(dono.getText());
		vet.setText(veterinario.getSelectedItem().toString());
	}
	
	public static boolean verificacao(TextArea dia, TextArea historico, JTextField peso, JComboBox<String> veterinario) {
		if(peso.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Preencha o campo peso!");
			return false;
		}
		else if(veterinario.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(null, "Informe o veterinário(a)!");
			return false;
		}
		else if(historico.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Preencha o campo histórico!");
			return false;
		}
		else if(dia.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Preencha o campo diagnóstico!");
			return false;
		}
		else
			return true;
	}
}