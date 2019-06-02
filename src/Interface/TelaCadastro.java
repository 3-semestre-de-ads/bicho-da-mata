package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import WebService.WebServiceCep;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JList;
import java.awt.Toolkit;

public class TelaCadastro extends JFrame {
	JRadioButton opMasc = new JRadioButton("Masculino");
	JRadioButton opFem = new JRadioButton("Feminino");
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField textField_1;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtUf;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalvar = new JButton("Novo");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnSalvar.setBounds(526, 440, 97, 25);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Salvar");
		btnEditar.setBounds(744, 440, 97, 25);
		contentPane.add(btnEditar);

		JButton btnVoltar = new JButton("Dados do Animal");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnimal animal = new TelaAnimal();
				animal.setVisible(true);
			}
		});
		btnVoltar.setBounds(744, 474, 138, 25);
		contentPane.add(btnVoltar);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCliente.setBounds(12, 0, 86, 35);
		contentPane.add(lblCliente);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(102, 51, 153));
		panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 35, 484, 464);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeCompleto.setBounds(12, 23, 116, 16);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setBounds(12, 42, 189, 22);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(12, 72, 56, 16);
		panel.add(lblSexo);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(241, 23, 56, 16);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(241, 42, 116, 22);
		panel.add(textField);
		textField.setColumns(10);



	
		opMasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {
				if(opMasc.isSelected()) {
					opFem.setSelected(false);
				}
			}
		}
				);
		opMasc.setFont(new Font("Tahoma", Font.BOLD, 13));
		opMasc.setBackground(new Color(255, 255, 255));
		opMasc.setBounds(12, 97, 98, 25);
		panel.add(opMasc);

	
		opFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (opFem.isSelected()) {
					opMasc.setSelected(false);
				}

			}
		});

		opFem.setFont(new Font("Tahoma", Font.BOLD, 13));
		opFem.setBackground(new Color(255, 255, 255));
		opFem.setBounds(114, 97, 127, 25);
		panel.add(opFem);


		JLabel lblEndereo = new JLabel("CEP:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereo.setBounds(12, 131, 70, 16);
		panel.add(lblEndereo);

		txtCep = new JTextField();
		txtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				WebServiceCep webService = WebServiceCep.searchCep(txtCep.getText());
				if (webService.wasSuccessful()) {
					txtRua.setText(webService.getLogradouro());
					txtBairro.setText(webService.getBairro());
					txtCidade.setText(webService.getCidade());
					txtUf.setText(webService.getUf());
				}else {
					JOptionPane.showMessageDialog(null, "CEP não localizado.");
				}
			}
		});
		txtCep.setBounds(12, 151, 84, 22);
		panel.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua.setBounds(12, 186, 56, 16);
		panel.add(lblRua);

		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setBounds(12, 203, 364, 22);
		panel.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNmero.setBounds(12, 231, 56, 16);
		panel.add(lblNmero);

		textField_1 = new JTextField();
		textField_1.setBounds(12, 253, 56, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBairro.setBounds(83, 231, 56, 16);
		panel.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBounds(85, 253, 144, 22);
		panel.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(241, 231, 56, 16);
		panel.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBounds(241, 253, 163, 22);
		panel.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(12, 283, 98, 16);
		panel.add(lblComplemento);

		textField_4 = new JTextField();
		textField_4.setBounds(12, 301, 116, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimento.setBounds(241, 72, 144, 16);
		panel.add(lblDataDeNascimento);

		textField_5 = new JTextField();
		textField_5.setBounds(241, 98, 116, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(12, 335, 70, 16);
		panel.add(lblTelefone);

		textField_6 = new JTextField();
		textField_6.setBounds(12, 359, 116, 22);
		panel.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(143, 335, 70, 16);
		panel.add(lblCelular);

		textField_7 = new JTextField();
		textField_7.setBounds(143, 359, 116, 22);
		panel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(12, 394, 56, 16);
		panel.add(lblEmail);

		textField_8 = new JTextField();
		textField_8.setBounds(12, 415, 247, 22);
		panel.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUf.setBounds(416, 231, 56, 16);
		panel.add(lblUf);

		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setBounds(416, 253, 38, 22);
		panel.add(txtUf);
		txtUf.setColumns(10);

		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar_1.setBounds(526, 474, 97, 25);
		contentPane.add(btnVoltar_1);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(526, 36, 366, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNomeCompleto_1 = new JLabel("Nome Completo:");
		lblNomeCompleto_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeCompleto_1.setBounds(12, 29, 104, 16);
		panel_1.add(lblNomeCompleto_1);

		textField_2 = new JTextField();
		textField_2.setBounds(122, 26, 232, 22);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JList listBusca = new JList();
		listBusca.setBounds(351, 363, -344, -288);
		panel_1.add(listBusca);

		JButton btnNovo = new JButton("Editar");
		btnNovo.setBounds(635, 440, 97, 25);
		contentPane.add(btnNovo);

		JButton btnApagar = new JButton("Deletar");
		btnApagar.setBounds(635, 474, 97, 25);
		contentPane.add(btnApagar);
	}
}
