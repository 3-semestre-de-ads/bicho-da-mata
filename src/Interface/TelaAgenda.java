package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaAgenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgenda frame = new TelaAgenda();
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
	public TelaAgenda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAgenda.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Agendamento", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(31, 66, 477, 385);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(25, 25, 92, 16);
		panel.add(lblVeterinrio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 55, 140, 22);
		panel.add(comboBox);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(25, 99, 56, 16);
		panel.add(lblCliente);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(25, 128, 140, 22);
		panel.add(comboBox_1);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(272, 25, 56, 16);
		panel.add(lblData);
		
		textField = new JTextField();
		textField.setBounds(272, 55, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(272, 99, 56, 16);
		panel.add(lblHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(272, 128, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(25, 163, 414, 209);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Descri\u00E7\u00E3o:");
		label.setBounds(0, 0, 81, 16);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 29, 365, 166);
		textPane.setBackground(new Color(153, 255, 153));
		panel_1.add(textPane);
		
		JLabel lblAgendaDeConsultas = new JLabel("Agenda de Consultas");
		lblAgendaDeConsultas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgendaDeConsultas.setBounds(30, 13, 231, 40);
		contentPane.add(lblAgendaDeConsultas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(520, 426, 97, 25);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Relat\u00F3rio");
		btnNewButton.setBounds(520, 378, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(740, 426, 97, 25);
		contentPane.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(631, 378, 97, 25);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(631, 426, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(740, 378, 97, 25);
		contentPane.add(btnSalvar);
		
		JLabel lblCliente_1 = new JLabel("Cliente:");
		lblCliente_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente_1.setBounds(520, 79, 56, 16);
		contentPane.add(lblCliente_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(581, 76, 241, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setBackground(Color.GRAY);
		list.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Lista", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		list.setBounds(554, 356, 268, -225);
		contentPane.add(list);
	}
}
