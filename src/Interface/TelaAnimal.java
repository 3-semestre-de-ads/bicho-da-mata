package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAnimal extends JFrame {
	JRadioButton opMacho = new JRadioButton("Macho");
	JRadioButton opFem = new JRadioButton("F\u00EAmea");
	JRadioButton opSim = new JRadioButton("Sim");
	JRadioButton opNao = new JRadioButton("N\u00E3o");
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnimal frame = new TelaAnimal();
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
	public TelaAnimal() {
		setTitle("Bicho da Mata - Pet's");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAnimal.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 58, 512, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDono = new JLabel("Dono:");
		lblDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDono.setBounds(12, 36, 56, 16);
		panel.add(lblDono);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 60, 184, 22);
		panel.add(comboBox);
		
		JLabel lblRaa = new JLabel("Nome:");
		lblRaa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaa.setBounds(270, 36, 56, 16);
		panel.add(lblRaa);
		
		textField = new JTextField();
		textField.setBounds(269, 60, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblRaa_1 = new JLabel("Ra\u00E7a:");
		lblRaa_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaa_1.setBounds(270, 107, 56, 16);
		panel.add(lblRaa_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(269, 131, 116, 22);
		panel.add(textField_1);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie:");
		lblEspcie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspcie.setBounds(13, 107, 56, 16);
		panel.add(lblEspcie);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 131, 116, 22);
		panel.add(textField_2);
		
		JLabel label = new JLabel("Sexo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 176, 56, 16);
		panel.add(label);
		

		opMacho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opMacho.isSelected()) {
					opFem.setSelected(false);
				}
			}
		});
		opMacho.setFont(new Font("Tahoma", Font.BOLD, 13));
		opMacho.setBackground(Color.WHITE);
		opMacho.setBounds(12, 201, 98, 25);
		panel.add(opMacho);
		

		opFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opFem.isSelected()) {
					opMacho.setSelected(false);
				}
			}
		});
		opFem.setFont(new Font("Tahoma", Font.BOLD, 13));
		opFem.setBackground(Color.WHITE);
		opFem.setBounds(114, 201, 127, 25);
		panel.add(opFem);
		

		opNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNao.isSelected()) {
					opSim.setSelected(false);
				}
			}
		});
		opNao.setFont(new Font("Tahoma", Font.BOLD, 13));
		opNao.setBackground(Color.WHITE);
		opNao.setBounds(372, 201, 127, 25);
		panel.add(opNao);
		
		JLabel lblCastrado = new JLabel("Castrado?");
		lblCastrado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCastrado.setBounds(270, 176, 87, 16);
		panel.add(lblCastrado);
		

		opSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opSim.isSelected()) {
					opNao.setSelected(false);
				}
			}
		});
		opSim.setFont(new Font("Tahoma", Font.BOLD, 13));
		opSim.setBackground(Color.WHITE);
		opSim.setBounds(270, 201, 98, 25);
		panel.add(opSim);
		
		JLabel label_1 = new JLabel("Data de Nascimento:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(12, 246, 144, 16);
		panel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(12, 272, 116, 22);
		panel.add(textField_3);
		
		JLabel lblDataDeNascimcorento = new JLabel("Cor:");
		lblDataDeNascimcorento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimcorento.setBounds(270, 246, 144, 16);
		panel.add(lblDataDeNascimcorento);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(270, 272, 116, 22);
		panel.add(textField_4);
		
		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnimal.setBounds(12, 13, 134, 32);
		contentPane.add(lblAnimal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Ficha Cl\u00EDnica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(536, 59, 354, 317);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeso.setBounds(13, 25, 56, 16);
		panel_1.add(lblPeso);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(12, 49, 116, 22);
		panel_1.add(textField_5);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(200, 25, 56, 16);
		panel_1.add(lblData);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(199, 49, 116, 22);
		panel_1.add(textField_6);
		
		JLabel lblVacinas = new JLabel("Vacinas:");
		lblVacinas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVacinas.setBounds(13, 84, 71, 16);
		panel_1.add(lblVacinas);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(153, 255, 153));
		textPane.setBounds(13, 113, 302, 71);
		panel_1.add(textPane);
		
		JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiagnstico.setBounds(12, 197, 99, 16);
		panel_1.add(lblDiagnstico);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(153, 255, 153));
		textPane_1.setBounds(12, 226, 302, 71);
		panel_1.add(textPane_1);
		
		JLabel label_2 = new JLabel("Dono:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(22, 389, 56, 16);
		contentPane.add(label_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(73, 389, 354, 22);
		contentPane.add(textField_7);
		
		JLabel lblAnimal_1 = new JLabel("Animal:");
		lblAnimal_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnimal_1.setBounds(468, 389, 56, 16);
		contentPane.add(lblAnimal_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(536, 386, 354, 22);
		contentPane.add(textField_8);
		
		JList list = new JList();
		list.setBounds(881, 507, -824, -82);
		contentPane.add(list);
		
		JButton button = new JButton("Novo");
		button.setBounds(575, 524, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBounds(684, 524, 97, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salvar");
		button_2.setBounds(793, 524, 97, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Deletar");
		button_3.setBounds(468, 524, 97, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Voltar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_4.setBounds(12, 524, 97, 25);
		contentPane.add(button_4);
	}
}
