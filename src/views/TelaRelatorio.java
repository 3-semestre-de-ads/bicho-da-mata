package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import model.BancoDeDados;

public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");
	public static JDateChooser txtInicio;
	public static JDateChooser txtFinal;
	public static JComboBox<String> comboVet;
	public static JComboBox<String> comboTipo;
	public static JComboBox<String> comboReal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaRelatorio() {

		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 317);
		setLocationRelativeTo(null);
		toFront();

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRelatrio = new JLabel("Relat\u00F3rios");
		lblRelatrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelatrio.setBounds(12, 13, 164, 38);
		contentPane.add(lblRelatrio);

		JLabel lblVeterinrio = new JLabel("Data Inicio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(12, 67, 81, 16);
		contentPane.add(lblVeterinrio);

		JLabel lblClientes = new JLabel("Data Final:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClientes.setBounds(254, 67, 103, 16);
		contentPane.add(lblClientes);

		txtInicio = new JDateChooser();
		txtInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtInicio.setBounds(95, 64, 109, 22);
		contentPane.add(txtInicio);

		txtFinal = new JDateChooser();
		txtFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFinal.setBounds(325, 64, 109, 22);
		contentPane.add(txtFinal);

		JButton btnPesquisar = new JButton("Gerar Relat\u00F3rio");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.gerarRelatorio(txtInicio, txtFinal, comboReal, comboTipo, comboVet);
					banco.desconectar();
				}
			}
		});
		btnPesquisar.setBounds(297, 207, 137, 25);
		contentPane.add(btnPesquisar);

		comboVet = new JComboBox<String>();
		comboVet.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboVet.setBounds(12, 144, 192, 22);
		contentPane.add(comboVet);

		comboTipo = new JComboBox<String>();
		comboTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Consulta", "Cirurgia", "Vacina"}));
		comboTipo.setBounds(254, 144, 180, 22);
		contentPane.add(comboTipo);

		comboReal = new JComboBox<String>();
		comboReal.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboReal.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Realizado", "N\u00E3o Realizado"}));
		comboReal.setBounds(12, 208, 128, 22);
		contentPane.add(comboReal);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/imagens/Relatorio.png")));
		lblNewLabel.setBounds(469, 46, 281, 211);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Atendimento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 179, 109, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Veterin\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 115, 94, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(254, 115, 56, 16);
		contentPane.add(lblNewLabel_3);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(188, 207, 97, 25);
		contentPane.add(btnVoltar);
	}
}