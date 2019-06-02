package views;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Login;
import javax.swing.SwingConstants;

/**
 * Esta Classe sera desenvolvida para realizar a seguranca desse sistema, somente quem tiver cadastrado o usuario e senha conseguira acessar o sistema, 
 * dessa forma evitara que qualquer pessoa consiga mannusear este sistema.
 * @author mauri
 *
 */
public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatoBr = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat formatoBr1 = new SimpleDateFormat("dd/MM/yyyy");
	public static JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField txtSenha;
	public static JLabel lblData;
	final static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

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
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}
		});

		Timer timer = null;
		Date tempo = new Date();

		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				@SuppressWarnings("deprecation")
				public void run() {
					try {
						if (tempo.getSeconds() == 60) {
							tempo.setMinutes(tempo.getMinutes() + 1);
							tempo.setSeconds(0);
						}
						if (tempo.getMinutes() == 60) {
							tempo.setHours(tempo.getHours() + 1);
							tempo.setMinutes(0);
						}

						tempo.setSeconds(tempo.getSeconds() + 1);

						try {
							lblData.setText(format.format(tempo));
						}
						catch(NullPointerException error) {

						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, 0, 1000);
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Login");
		setAlwaysOnTop(false);
		setForeground(Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(800, 300, 323, 274);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsurio.setBounds(45, 24, 56, 16);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(42, 88, 56, 16);
		contentPane.add(lblSenha);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 53, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setMnemonic('E');
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Login.checkLogin(txtUsuario, new String (txtSenha.getPassword())) == true) {
					dispose();
				}
			}});

		btnEntrar.setBounds(22, 158, 97, 33);
		contentPane.add(btnEntrar);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 117, 116, 22);
		contentPane.add(txtSenha);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setMnemonic('S');
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(200, 158, 97, 33);
		contentPane.add(btnSair);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/LogoAnimais.png")));
		label.setBounds(140, 13, 157, 94);
		contentPane.add(label);

		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setText(format.format(new Date()));
		lblData.setBounds(169, 196, 97, 30);
		contentPane.add(lblData);

		JLabel lblDia = new JLabel();
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDia.setBounds(68, 196, 97, 30);
		Date data = new Date();
		lblDia.setText(formatoBr1.format((data)));
		contentPane.add(lblDia);

		JLabel lblAewwww = new JLabel("");
		lblAewwww.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/fundo.png")));
		lblAewwww.setBounds(0, 0, 317, 247);
		contentPane.add(lblAewwww);
	}
}