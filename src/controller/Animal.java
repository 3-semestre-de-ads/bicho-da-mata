package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Animal {

	public static void novo(JTextField nome, JTextField especie, JRadioButton sim, JRadioButton nao, JRadioButton macho, JRadioButton femea, JTextField nascimento, JTextField cor, JTextField raca, JTextArea observacao, JButton editar, JButton salvar, JTextField dataFicha, JList<String> listaNome) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setText("");
		especie.setText("");
		nao.setSelected(false);
		sim.setSelected(false);
		macho.setSelected(false);
		femea.setSelected(false);
		nascimento.setText("");
		cor.setText("");
		raca.setText("");
		observacao.setText("");
		nome.setEditable(true);
		especie.setEditable(true);
		raca.setEditable(true);
		observacao.setEditable(true);
		macho.setEnabled(true);
		femea.setEnabled(true);
		sim.setEnabled(true);
		nao.setEnabled(true);
		nascimento.setEditable(true);
		cor.setEditable(true);
		editar.setVisible(false);
		salvar.setVisible(true);
		dataFicha.setText(formatoBr.format(new Date()));
		listaNome.clearSelection();
	}

	public static void cliqueTrue(JTextField nome, JTextField especie, JRadioButton sim, JRadioButton nao, JRadioButton macho, JRadioButton femea, JTextField nascimento, JTextField cor, JTextField raca, JTextArea observacao, JButton editar, JButton salvar, JTextField dataFicha) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setEditable(true);
		especie.setEditable(true);
		raca.setEditable(true);
		observacao.setEditable(true);
		macho.setEnabled(true);
		femea.setEnabled(true);
		sim.setEnabled(true);
		nao.setEnabled(true);
		nascimento.setEditable(true);
		cor.setEditable(true);
		editar.setVisible(true);
		salvar.setVisible(false);
		dataFicha.setText(formatoBr.format(new Date()));
	}

	public static void cliqueFalse(JTextField nome, JTextField especie, JRadioButton sim, JRadioButton nao, JRadioButton macho, JRadioButton femea, JTextField nascimento, JTextField cor, JTextField raca, JTextArea observacao, JButton editar, JButton salvar, JTextField dataFicha) {
		SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
		nome.setEditable(false);
		especie.setEditable(false);
		raca.setEditable(false);
		observacao.setEditable(false);
		macho.setEnabled(false);
		femea.setEnabled(false);
		sim.setEnabled(false);
		nao.setEnabled(false);
		nascimento.setEditable(false);
		cor.setEditable(false);
		editar.setVisible(false);
		salvar.setVisible(true);
		dataFicha.setText(formatoBr.format(new Date()));
	}

	public static String data(JTextField data) {
		String dia = data.getText().substring(0,2);
		String mes = data.getText().substring(3,5);
		String ano = data.getText().substring(6);
		return ano + "-" + mes + "-" + dia;
	}

	public static String castrado(JRadioButton sim) {
		if (sim.isSelected()) {
			return "Sim";
		}else
			return "Nao";
	}

	public static String sexo(JRadioButton macho) {
		if (macho.isSelected()) {
			return "Macho";
		}else
			return "Femea";
	}

	public static boolean verificacao(JTextField nome, JTextField especie, JRadioButton sim, JRadioButton nao, JRadioButton macho, JRadioButton femea, JTextField nascimento, JTextField cor, JTextField raca, JTextArea observacao) {
		if(nome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo nome!");
			return false;
		}
		else if(especie.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo especie!");
			return false;
		}
		else if(raca.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo raça!");
			return false;
		}
		else if(macho.isSelected() == false && femea.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Informe se o animal é macho ou fêmea!");
			return false;
		}
		else if(sim.isSelected() == false && nao.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Informe se o animal é castrado!");
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
		else if(cor.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo cor!");
			return false;
		}
		else if(observacao.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo observação!");
			return false;
		}
		else
			return true;
	}
}