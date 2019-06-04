package controller;

import java.awt.TextArea;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Receita {

	public static boolean verificacao(JDateChooser retorno, TextArea receita) {
		if(retorno.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Informe uma data para retorno!");
			return false;
		}
		else if(receita.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha a receita!");
			return false;
		}
		else
			return true;
	}
}