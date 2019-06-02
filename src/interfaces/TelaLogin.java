package interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import utilitarios.MinhaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;

import javax.management.timer.TimerMBean;
import javax.swing.ImageIcon;

/**
 * Esta Classe sera desenvolvida para realizar a seguranca desse sistema, somente quem tiver cadastrado o usuario e senha conseguira acessar o sistema, 
 * dessa forma evitara que qualquer pessoa consiga mannusear este sistema.
 * @author mauri
 *
 */
public class TelaLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	/**
	 * 
	 */
	

 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Login");
		setAlwaysOnTop(true);
		setForeground(Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 323, 274);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsurio.setBounds(45, 24, 56, 16);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(45, 88, 56, 16);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 53, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setMnemonic('E');
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	
			if(checkLogin(txtUsuario.getText(), new String (txtSenha.getPassword()))) {
				
			JOptionPane.showMessageDialog(btnEntrar, "Bem Vindo ao Sistema!","Bicho da Mata",JOptionPane.NO_OPTION);
			MenuPrincipal menu = new MenuPrincipal();
			menu.setVisible(true);
			dispose();
			}
			else {
				
				JOptionPane.showMessageDialog(btnEntrar, "Dados Invalidos", "Bicho da Mata", JOptionPane.OK_OPTION);
			}
			
			
				
			}});
	
		btnEntrar.setBounds(169, 112, 97, 33);
		contentPane.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 117, 116, 22);
		contentPane.add(txtSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setMnemonic('S');
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(169, 158, 97, 25);
		contentPane.add(btnSair);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		label.setBounds(140, 13, 157, 94);
		contentPane.add(label);
		
		
		
		JLabel lblData = new JLabel("07/03/2019 00:51:29");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(78, 196, 188, 30);
		contentPane.add(lblData);
		Date d = new Date();
		lblData.setText(formatoBr.format(d));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo.png")));
		label_1.setBounds(0, 0, 317, 247);
		contentPane.add(label_1);
		
	}
	public boolean checkLogin(String login, String senha) {
		return login.equals("admin") && senha.equals("admin");
	}
}
