package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import views.TelaMenuPrincipal;
import views.TelaLogin;

public class Login {
	
	private static int tentativa = 0;
	private static int MAXIMOTENTATIVAS = 2;
	
	public static boolean checkLogin(JTextField login, String senha) {
		if(login.getText().equals("admin") && senha.equals("admin")) {
			JOptionPane.showMessageDialog(null, "Olá! \nSeja Bem Vindo ao Sistema Bicho da Mata!","Bicho da Mata",JOptionPane.NO_OPTION);
			TelaMenuPrincipal menu = new TelaMenuPrincipal();
			menu.setVisible(true);
			return true;
		}
		else if(tentativa < MAXIMOTENTATIVAS){
			JOptionPane.showMessageDialog(null, "Dados Inválidos", "Bicho da Mata", JOptionPane.OK_OPTION);
			tentativa++;
			limpaCampos(TelaLogin.txtUsuario, TelaLogin.txtSenha);
			return false;
		}	
		else {
			JOptionPane.showMessageDialog(null, "Tentativas Excedidas!", "Bicho da Mata", JOptionPane.OK_OPTION);
			System.exit(0);
		}
		return false;
	}
	
	public static void limpaCampos(JTextField login, JPasswordField senha) {
		login.setText("");
		senha.setText("");
		login.requestFocus();
	}
}
