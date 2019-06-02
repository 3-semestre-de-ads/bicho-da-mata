package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFuncionario extends JFrame {
	JRadioButton opMasc = new JRadioButton("Masculino");
	JRadioButton opFem = new JRadioButton("Feminino");
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
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
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
	public TelaFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFuncionario.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(102, 51, 153));
		panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Funcion\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 83, 484, 464);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome Completo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 23, 116, 16);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 42, 189, 22);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Sexo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(12, 72, 56, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("CPF");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(241, 23, 56, 16);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 42, 116, 22);
		panel.add(textField_1);
		opMasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opMasc.isSelected()) {
					opFem.setSelected(false);
				}
			}
		});
		

		opMasc.setFont(new Font("Tahoma", Font.BOLD, 13));
		opMasc.setBackground(Color.WHITE);
		opMasc.setBounds(12, 97, 98, 25);
		panel.add(opMasc);
		opFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opFem.isSelected()) {
					opMasc.setSelected(false);
				}
			}
		});
		
		
		opFem.setFont(new Font("Tahoma", Font.BOLD, 13));
		opFem.setBackground(Color.WHITE);
		opFem.setBounds(114, 97, 127, 25);
		panel.add(opFem);
		
		JLabel label_3 = new JLabel("CEP:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(12, 131, 70, 16);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 151, 84, 22);
		panel.add(textField_2);
		
		JLabel label_4 = new JLabel("Rua:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(12, 186, 56, 16);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(12, 203, 364, 22);
		panel.add(textField_3);
		
		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(12, 231, 56, 16);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(12, 253, 56, 22);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("Bairro:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(83, 231, 56, 16);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(85, 253, 144, 22);
		panel.add(textField_5);
		
		JLabel label_7 = new JLabel("Cidade:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(241, 231, 56, 16);
		panel.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(241, 253, 163, 22);
		panel.add(textField_6);
		
		JLabel label_8 = new JLabel("Complemento:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(12, 283, 98, 16);
		panel.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(12, 301, 116, 22);
		panel.add(textField_7);
		
		JLabel label_9 = new JLabel("Data de Nascimento:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(241, 72, 144, 16);
		panel.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(241, 98, 116, 22);
		panel.add(textField_8);
		
		JLabel label_10 = new JLabel("Telefone:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(12, 335, 70, 16);
		panel.add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(12, 359, 116, 22);
		panel.add(textField_9);
		
		JLabel label_11 = new JLabel("Celular:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(143, 335, 70, 16);
		panel.add(label_11);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(143, 359, 116, 22);
		panel.add(textField_10);
		
		JLabel label_12 = new JLabel("E-Mail:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(12, 394, 56, 16);
		panel.add(label_12);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(12, 415, 247, 22);
		panel.add(textField_11);
		
		JLabel label_13 = new JLabel("UF:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(416, 231, 56, 16);
		panel.add(label_13);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(416, 253, 38, 22);
		panel.add(textField_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(526, 84, 366, 374);
		contentPane.add(panel_1);
		
		JLabel label_14 = new JLabel("Nome Completo:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_14.setBounds(12, 29, 104, 16);
		panel_1.add(label_14);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(122, 26, 232, 22);
		panel_1.add(textField_13);
		
		JList list = new JList();
		list.setBounds(351, 363, -344, -288);
		panel_1.add(list);
		
		JButton button = new JButton("Novo");
		button.setBounds(526, 488, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(526, 522, 97, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Deletar");
		button_2.setBounds(635, 522, 97, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Editar");
		button_3.setBounds(635, 488, 97, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Salvar");
		button_4.setBounds(744, 488, 97, 25);
		contentPane.add(button_4);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFuncionrio.setBounds(12, 26, 192, 44);
		contentPane.add(lblFuncionrio);
	}

}
