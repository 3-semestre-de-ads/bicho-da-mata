package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagens/fundoBichoBanco.png")));
		setType(Type.POPUP);
		setTitle("Bicho Da Mata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bicho da Mata; Cl\u00EDnica Veterin\u00E1ria - Rua R\u00EAmulo Zoppi, 108 - Vila Georgina, Indaiatuba - SP, 13333-090 - Tel.(19)3392-5758", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 153, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dia a Dia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(34, 77, 236, 162);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnVacinasDoDia = new JButton("Vacinas Di\u00E1rias");
		btnVacinasDoDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVacina vacina = new TelaVacina();
				vacina.setVisible(true);
		
			}
		});
		btnVacinasDoDia.setBounds(10, 66, 204, 35);
		panel.add(btnVacinasDoDia);
		
		JButton btnNewButton = new JButton("Agenda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAgenda agenda = new TelaAgenda();
				agenda.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 18, 204, 35);
		panel.add(btnNewButton);
		
		JButton btnCalculadora = new JButton("Calculadora");
		btnCalculadora.setBounds(10, 114, 204, 35);
		panel.add(btnCalculadora);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gerenciamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 204, 102)), "Gerenciamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(34, 289, 236, 171);
		panel_2.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnFuncionrio = new JButton("Funcion\u00E1rio");
		btnFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario func = new TelaFuncionario();
				func.setVisible(true);
			}
		});
		btnFuncionrio.setBounds(10, 75, 204, 35);
		panel_2.add(btnFuncionrio);
		
		JButton btnClientes = new JButton("Cliente");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro cliente = new TelaCadastro();
				cliente.setVisible(true);
			}
		});
		btnClientes.setBounds(10, 27, 204, 35);
		panel_2.add(btnClientes);
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFornecedor fornecedor = new TelaFornecedor();
				fornecedor.setVisible(true);
				
			}
		});
		btnFornecedor.setBounds(10, 123, 204, 35);
		panel_2.add(btnFornecedor);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(647, 435, 97, 38);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(252, 24, 492, 449);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagens/LOGO FINAL.jpg")));
		contentPane.add(lblNewLabel);
		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCalculadora calc = new TelaCalculadora();
				calc.setVisible(true);
			}
			
			
		});
	}
}
