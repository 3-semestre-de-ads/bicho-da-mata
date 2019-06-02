package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.BancoDeDados;

import javax.swing.SwingConstants;

/**
 * Classe criada com o propósito de ser o Menu Principal do projeto, os botoes criado nesta classe direcionara para as funcionalidades do sistema.
 * @author mauri
 *
 */
public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");

	private JPanel contentPane;
	private JLabel lblData;
	public static JLabel lblData1;
	final static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TelaMenuPrincipal frame = new TelaMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenuPrincipal() {
		// Data
		Date hoje = new Date();

		String dataExtenso = formatador.format(hoje);

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
							lblData1.setText(format.format(tempo));
						}catch (Exception e) {

						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
					}
				}
			};

			timer.scheduleAtFixedRate(tarefa, 0, 1000);
		}

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMenuPrincipal.class.getResource("/imagens/fundoBichoBanco.png")));
		setType(Type.POPUP);
		setTitle("Bicho Da Mata");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(500, 200, 785, 572);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bicho da Mata; Cl\u00EDnica Veterin\u00E1ria - Rua R\u00EAmulo Zoppi, 108 - Vila Georgina, Indaiatuba - SP, 13333-090 - Tel.(19)3392-5758", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 153, 102)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblData1 = new JLabel();
		lblData1.setHorizontalAlignment(SwingConstants.CENTER);
		lblData1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData1.setText(format.format(tempo));
		lblData1.setBounds(331, 484, 97, 27);
		contentPane.add(lblData1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dia a Dia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(34, 110, 236, 122);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Agenda");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setMnemonic('A');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					TelaAgenda agenda = new TelaAgenda();
					agenda.setVisible(true);
					banco.setVetAgenda(TelaAgenda.comboVet);
					banco.setClieAgenda(TelaAgenda.comboCliente);
					banco.buscarAnimalAgenda(TelaAgenda.comboCliente, TelaAgenda.comboPet);
					banco.setIDVetAgenda(TelaAgenda.comboVet, TelaAgenda.txtIdVet);
					banco.setCliente(TelaAgenda.comboCliente, TelaAgenda.idClie);
					banco.setIdPet(TelaAgenda.comboPet, TelaAgenda.idPet);
					banco.desconectar();
				}
			}
		});
		btnNewButton.setBounds(10, 27, 204, 35);
		panel.add(btnNewButton);

		JButton btnCalculadora = new JButton("Calculadora");
		btnCalculadora.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalculadora.setMnemonic('C');
		btnCalculadora.setBounds(10, 75, 204, 35);
		panel.add(btnCalculadora);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gerenciamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 204, 102)), "Gerenciamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(34, 289, 236, 171);
		panel_2.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnFuncionario = new JButton("Funcion\u00E1rio");
		btnFuncionario.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFuncionario.setMnemonic('F');
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario func = new TelaFuncionario();
				func.setVisible(true);
				TelaFuncionario.txtValidade.setText("01/01/0001");
			}
		});
		btnFuncionario.setBounds(10, 75, 204, 35);
		panel_2.add(btnFuncionario);

		JButton btnClientes = new JButton("Cliente");
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClientes.setMnemonic('E');
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente cliente = new TelaCliente();
				cliente.setVisible(true);
			}
		});
		btnClientes.setBounds(10, 27, 204, 35);
		panel_2.add(btnClientes);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFornecedor.setMnemonic('R');
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFornecedor fornecedor = new TelaFornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedor.setBounds(10, 123, 204, 35);
		panel_2.add(btnFornecedor);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSair.setMnemonic('S');
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(672, 497, 97, 38);
		contentPane.add(btnSair);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(252, 24, 492, 449);
		lblNewLabel.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/imagens/LOGO FINAL.jpg")));
		contentPane.add(lblNewLabel);

		lblData = new JLabel();
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setText(dataExtenso);
		lblData.setBounds(245, 497, 269, 38);
		contentPane.add(lblData);

		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCalculadora calc = new TelaCalculadora();
				calc.setVisible(true);
			}
		});
	}
}