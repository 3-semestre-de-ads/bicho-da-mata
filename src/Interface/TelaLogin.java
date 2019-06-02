package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

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
		setBackground(Color.WHITE);
		setTitle("Login");
		setAlwaysOnTop(true);
		setForeground(Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsurio.setBounds(107, 42, 56, 16);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(107, 105, 56, 16);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(78, 70, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	
			if(checkLogin(txtUsuario.getText(), new String (txtSenha.getPassword()))) {
				
			JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema!","Bicho da Mata",JOptionPane.NO_OPTION);
			MenuPrincipal menu = new MenuPrincipal();
			menu.setVisible(true);
			dispose();
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Dados Invalidos", "Bicho da Mata", JOptionPane.OK_OPTION);
			}
			
			
				
			}});
		
		btnEntrar.setBounds(88, 170, 97, 25);
		contentPane.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(78, 134, 116, 22);
		contentPane.add(txtSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(88, 208, 97, 25);
		contentPane.add(btnSair);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		label.setBounds(206, 70, 157, 94);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo.png")));
		label_1.setBounds(0, 0, 381, 247);
		contentPane.add(label_1);
	}
	public boolean checkLogin(String login, String senha) {
		return login.equals("admin") && senha.equals("admin");
	}
}
