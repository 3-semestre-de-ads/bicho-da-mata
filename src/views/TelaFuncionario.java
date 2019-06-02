package views;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.Funcionario;
import model.BancoDeDados;
/**
 * Classe responsavel para ser o layout para receber o cadastro do funcionario bem como, estagiário, auxiliar , atendente e veterinário inserimos uma
 * API do carreios para buscar o CEP os metodos criados na classe BancaDeDados sera invocados para realizar o CRUD dessas informacoes.
 * @author mauri
 *
 */
public class TelaFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	ButtonGroup g1 = new ButtonGroup();
	public static JRadioButton opMasc = new JRadioButton("Masculino");
	public static JRadioButton opFem = new JRadioButton("Feminino");
	public static JPanel contentPane;
	public static JTextField txtNome;
	public static JFormattedTextField txtCpf;
	public static JFormattedTextField txtCep;
	public static JTextField txtRua;
	public static JTextField txtNum;
	public static JTextField txtBairro;
	public static JTextField txtCidade;
	public static JTextField txtComp;
	public static JFormattedTextField txtDataNasc;
	public static JFormattedTextField txtTel;
	public static JFormattedTextField txtCel;
	public static JTextField txtEmail;
	public static JTextField txtUf;
	public static JTextField txtBusca;
	public static JList<String> listName;
	public static JTextField txtID;
	public static JTextField txtCrmv;
	public static JComboBox<String> comboFuncao;
	public static JFormattedTextField txtValidade;
	public static JButton btnSalvar;
	public static JButton btnEditar;
	public static JLabel lblCrmv;
	public static JLabel lblValidade;


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
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaFuncionario() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFuncionario.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		setLocationRelativeTo(null);

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

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(12, 42, 189, 22);
		panel.add(txtNome);

		JLabel label_1 = new JLabel("Sexo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(12, 72, 56, 16);
		panel.add(label_1);

		JLabel label_2 = new JLabel("CPF");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(241, 23, 56, 16);
		panel.add(label_2);

		txtCpf = new JFormattedTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtCpf.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCpf.setColumns(10);
		txtCpf.setBounds(241, 42, 116, 22);
		panel.add(txtCpf);
		opMasc.setSelected(true);
		opMasc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		opMasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		opMasc.setFont(new Font("Tahoma", Font.BOLD, 13));
		opMasc.setBackground(Color.WHITE);
		opMasc.setBounds(12, 97, 98, 25);
		panel.add(opMasc);
		opFem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
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

		g1.add(opFem);
		g1.add(opMasc);

		JLabel label_3 = new JLabel("CEP:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(12, 131, 70, 16);
		panel.add(label_3);

		txtCep = new JFormattedTextField();
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtCep.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("#####-###")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Funcionario.webService(txtRua, txtBairro, txtCidade, txtUf, txtCep);
			}});

		txtCep.setColumns(10);
		txtCep.setBounds(12, 151, 84, 22);
		panel.add(txtCep);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogradouro.setBounds(12, 186, 116, 16);
		panel.add(lblLogradouro);

		txtRua = new JTextField();
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRua.setEditable(false);
		txtRua.setColumns(10);
		txtRua.setBounds(12, 203, 364, 22);
		panel.add(txtRua);

		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(12, 231, 56, 16);
		panel.add(label_5);

		txtNum = new JTextField();
		txtNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNum.setColumns(10);
		txtNum.setBounds(12, 253, 56, 22);
		panel.add(txtNum);

		JLabel label_6 = new JLabel("Bairro:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(83, 231, 56, 16);
		panel.add(label_6);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(85, 253, 144, 22);
		panel.add(txtBairro);

		JLabel label_7 = new JLabel("Cidade:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(241, 231, 56, 16);
		panel.add(label_7);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(241, 253, 163, 22);
		panel.add(txtCidade);

		JLabel label_8 = new JLabel("Complemento:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(12, 283, 98, 16);
		panel.add(label_8);

		txtComp = new JTextField();
		txtComp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtComp.setColumns(10);
		txtComp.setBounds(12, 301, 116, 22);
		panel.add(txtComp);

		JLabel label_9 = new JLabel("Data de Nascimento:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(241, 72, 144, 16);
		panel.add(label_9);

		txtDataNasc = new JFormattedTextField();
		txtDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtDataNasc.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtDataNasc.setColumns(10);
		txtDataNasc.setBounds(241, 98, 116, 22);
		panel.add(txtDataNasc);

		JLabel label_10 = new JLabel("Telefone:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(12, 335, 70, 16);
		panel.add(label_10);

		txtTel = new JFormattedTextField();
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtTel.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("(##)####-####")));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());

		}
		txtTel.setColumns(10);
		txtTel.setBounds(12, 359, 116, 22);
		panel.add(txtTel);

		JLabel label_11 = new JLabel("Celular:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(143, 335, 70, 16);
		panel.add(label_11);

		txtCel = new JFormattedTextField();
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtCel.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("(##)#####-####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCel.setColumns(10);
		txtCel.setBounds(143, 359, 116, 22);
		panel.add(txtCel);

		JLabel label_12 = new JLabel("E-Mail:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(12, 394, 56, 16);
		panel.add(label_12);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(12, 415, 247, 22);
		panel.add(txtEmail);

		JLabel label_13 = new JLabel("UF:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(416, 231, 56, 16);
		panel.add(label_13);

		txtUf = new JTextField();
		txtUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUf.setEditable(false);
		txtUf.setColumns(10);
		txtUf.setBounds(416, 253, 38, 22);
		panel.add(txtUf);

		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFuno.setBounds(114, 131, 56, 16);
		panel.add(lblFuno);

		txtCrmv = new JTextField();
		txtCrmv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCrmv.setVisible(false);
		txtCrmv.setBounds(241, 151, 84, 22);
		panel.add(txtCrmv);
		txtCrmv.setColumns(10);

		lblCrmv = new JLabel("CRMV:");
		lblCrmv.setVisible(false);
		lblCrmv.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCrmv.setBounds(241, 131, 56, 16);
		panel.add(lblCrmv);

		lblValidade = new JLabel("Validade:");
		lblValidade.setVisible(false);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValidade.setBounds(337, 131, 84, 16);
		panel.add(lblValidade);

		comboFuncao = new JComboBox();
		comboFuncao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Funcionario.funcaoSelecionada(comboFuncao, lblCrmv, txtCrmv, lblValidade, txtValidade);
			}
		});
		comboFuncao.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Auxiliar", "Estagi\u00E1rio", "Secret\u00E1ria(o)", "Veterin\u00E1rio(a)"}));
		comboFuncao.setBounds(114, 151, 116, 22);
		panel.add(comboFuncao);

		txtValidade = new JFormattedTextField();
		txtValidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtValidade.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtValidade.setVisible(false);
		txtValidade.setBounds(337, 151, 116, 22);
		panel.add(txtValidade);
		txtValidade.setColumns(10);

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

		txtBusca = new JTextField();
		txtBusca.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.pesquisarFuncionario(txtBusca, listName);;
					banco.desconectar();
				}
			}
		});
		txtBusca.setColumns(10);
		txtBusca.setBounds(122, 26, 232, 22);
		panel_1.add(txtBusca);

		listName = new JList();		
		listName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {


			}
		});
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarFuncionario(listName, txtNome, txtCpf, txtDataNasc, txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtID, txtValidade, opMasc, opFem, comboFuncao, txtCrmv);
					banco.desconectar();
				}
			}
		});
		listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Funcionario.cliqueTrue(txtNome, txtCpf, txtDataNasc, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, txtCrmv, txtValidade, btnEditar, btnSalvar);
				} else {
					Funcionario.cliqueFalse(txtNome, txtCpf, txtDataNasc, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, txtCrmv, txtValidade, btnEditar, btnSalvar);
				}
			}
		}
				);
		listName.setBounds(12, 58, 342, 303);
		panel_1.add(listName);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.setMnemonic('N');
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario.novo(txtNome, txtCpf, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, comboFuncao, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, txtCrmv, txtValidade, listName, btnEditar, btnSalvar);
			}
		});
		btnNovo.setBounds(526, 484, 97, 25);
		contentPane.add(btnNovo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(526, 522, 97, 25);
		contentPane.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.setMnemonic('X');
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exluir",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.excluirFuncionario(txtID);;
						Funcionario.novo(txtNome, txtCpf, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, comboFuncao, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, txtCrmv, txtValidade, listName, btnEditar, btnSalvar);
						banco.pesquisarFuncionario(txtBusca, listName);
						banco.desconectar();
					}
				}
			}
		});
		btnExcluir.setBounds(655, 522, 97, 25);
		contentPane.add(btnExcluir);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "title",JOptionPane.YES_OPTION);
				try {
					if (resposta == JOptionPane.YES_OPTION) {
						if(Funcionario.verificacao(txtNome, txtCpf, opMasc, opFem, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, txtCep, comboFuncao, txtCrmv, txtValidade, txtNum, txtCel, txtEmail) == true) {
							BancoDeDados banco = new BancoDeDados();
							banco.conectar();
							if(banco.estaConectado() == true) {
								if(banco.verificarCpf(txtCpf) == true) {
									banco.inserirFuncionario(txtNome, txtCpf, Funcionario.funcao(comboFuncao, txtValidade), txtCrmv, Funcionario.data(txtValidade), Funcionario.sexo(opMasc), Funcionario.data(txtDataNasc).intern(), txtCep, txtRua, txtNum, txtBairro , txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail);
									JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
									Funcionario.novo(txtNome, txtCpf, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, comboFuncao, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, txtCrmv, txtValidade, listName, btnEditar, btnSalvar);
									banco.pesquisarFuncionario(txtBusca, listName);
									banco.desconectar();
								}
							}
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}});
		btnSalvar.setBounds(795, 522, 97, 25);
		contentPane.add(btnSalvar);

		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFuncionrio.setBounds(12, 26, 192, 44);
		contentPane.add(lblFuncionrio);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setEditable(false);
		txtID.setEnabled(false);
		txtID.setBounds(549, 40, 116, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(795, 522, 97, 25);
		contentPane.add(btnEditar);
		btnEditar.setVisible(false);
		btnEditar.setMnemonic('E');

		btnEditar.setVisible(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Funcionario.verificacao(txtNome, txtCpf, opMasc, opFem, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, txtCep, comboFuncao, txtCrmv, txtValidade, txtNum, txtCel, txtEmail) == true) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						if(banco.verificarCpf(txtCpf) == true) {
							banco.editarFuncionario(txtDataNasc, txtValidade, opMasc, opFem, comboFuncao, txtNome, txtCpf, txtCrmv, txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtID);
							banco.pesquisarFuncionario(txtBusca, listName);
							banco.desconectar();
						}
					}
				}
			}
		});
	}
}