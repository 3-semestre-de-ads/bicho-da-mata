package interfaces;

import connection.BancoDeDados;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import WebService.WebServiceCep;
import utilitarios.Genero;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
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
	public static JComboBox<Object> comboFuncao;
	public static JFormattedTextField txtValidade;
	

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaFuncionario() {

		setResizable(false);
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

		txtNome = new JTextField();
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
		try {
			txtCpf.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			e.printStackTrace();
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
		try {
			txtCep.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("#####-###")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				WebServiceCep webService = WebServiceCep.searchCep(txtCep.getText());
				try {
					if (webService.wasSuccessful()) {
						txtRua.setText(webService.getLogradouro());
						txtBairro.setText(webService.getBairro());
						txtCidade.setText(webService.getCidade());
						txtUf.setText(webService.getUf());
						txtRua.setEditable(false);
						txtBairro.setEditable(false);
						txtCidade.setEditable(false);
						txtUf.setEditable(false);
					}else {
						JOptionPane.showMessageDialog(null, "CEP NÃO LOCALIZADO");
						txtRua.setEditable(true);
						txtBairro.setEditable(true);
						txtCidade.setEditable(true);
						txtUf.setEditable(true);
					}
				} catch (Exception e) {

				}
			}});

		txtCep.setColumns(10);
		txtCep.setBounds(12, 151, 84, 22);
		panel.add(txtCep);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogradouro.setBounds(12, 186, 116, 16);
		panel.add(lblLogradouro);

		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setColumns(10);
		txtRua.setBounds(12, 203, 364, 22);
		panel.add(txtRua);

		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(12, 231, 56, 16);
		panel.add(label_5);

		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(12, 253, 56, 22);
		panel.add(txtNum);

		JLabel label_6 = new JLabel("Bairro:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(83, 231, 56, 16);
		panel.add(label_6);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(85, 253, 144, 22);
		panel.add(txtBairro);

		JLabel label_7 = new JLabel("Cidade:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(241, 231, 56, 16);
		panel.add(label_7);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(241, 253, 163, 22);
		panel.add(txtCidade);

		JLabel label_8 = new JLabel("Complemento:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(12, 283, 98, 16);
		panel.add(label_8);

		txtComp = new JTextField();
		txtComp.setColumns(10);
		txtComp.setBounds(12, 301, 116, 22);
		panel.add(txtComp);

		JLabel label_9 = new JLabel("Data de Nascimento:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(241, 72, 144, 16);
		panel.add(label_9);

		txtDataNasc = new JFormattedTextField();
		try {
			txtDataNasc.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtDataNasc.setColumns(10);
		txtDataNasc.setBounds(241, 98, 116, 22);
		panel.add(txtDataNasc);

		JLabel label_10 = new JLabel("Telefone:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(12, 335, 70, 16);
		panel.add(label_10);

		txtTel = new JFormattedTextField();
		txtTel.setText("(19)3392-5758");
		try {
			txtTel.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("(##)####-####")));
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		txtTel.setColumns(10);
		txtTel.setBounds(12, 359, 116, 22);
		panel.add(txtTel);

		JLabel label_11 = new JLabel("Celular:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(143, 335, 70, 16);
		panel.add(label_11);

		txtCel = new JFormattedTextField();
		try {
			txtCel.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("(##)#####-####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCel.setColumns(10);
		txtCel.setBounds(143, 359, 116, 22);
		panel.add(txtCel);

		JLabel label_12 = new JLabel("E-Mail:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(12, 394, 56, 16);
		panel.add(label_12);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(12, 415, 247, 22);
		panel.add(txtEmail);

		JLabel label_13 = new JLabel("UF:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(416, 231, 56, 16);
		panel.add(label_13);

		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setColumns(10);
		txtUf.setBounds(416, 253, 38, 22);
		panel.add(txtUf);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setVisible(false);
		btnEditar.setMnemonic('E');
		btnEditar.setBounds(375, 414, 97, 25);
		panel.add(btnEditar);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFuno.setBounds(114, 131, 56, 16);
		panel.add(lblFuno);
		
		txtCrmv = new JTextField();
		txtCrmv.setVisible(false);
		txtCrmv.setBounds(241, 151, 84, 22);
		panel.add(txtCrmv);
		txtCrmv.setColumns(10);
		
		JLabel lblCrmv = new JLabel("CRMV:");
		lblCrmv.setVisible(false);
		lblCrmv.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCrmv.setBounds(241, 131, 56, 16);
		panel.add(lblCrmv);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setVisible(false);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValidade.setBounds(337, 131, 84, 16);
		panel.add(lblValidade);
		
		comboFuncao = new JComboBox<Object>();
		comboFuncao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			
				if (comboFuncao.getSelectedItem() .equals("Veterinário")) {
					lblCrmv.setVisible(true);
					txtCrmv.setVisible(true);
					txtCrmv.setEditable(true);
					lblValidade.setVisible(true);
					txtValidade.setVisible(true);
				}else {
					lblCrmv.setVisible(false);
					txtCrmv.setVisible(false);
					txtCrmv.setText("");
					lblValidade.setVisible(false);
					txtValidade.setVisible(false);
					txtValidade.setText("01/01/0001");
				}
			}
		});
		comboFuncao.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Auxiliar", "Estagi\u00E1rio", "Secret\u00E1ria(o)", "Veterin\u00E1rio"}));
		comboFuncao.setBounds(114, 151, 116, 22);
		panel.add(comboFuncao);
		
		txtValidade = new JFormattedTextField();
		try {
			txtValidade.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtValidade.setVisible(false);
		txtValidade.setBounds(337, 151, 116, 22);
		panel.add(txtValidade);
		txtValidade.setColumns(10);
		
		
		btnEditar.setVisible(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.editarFuncionario(txtDataNasc, txtValidade, opMasc, opFem, comboFuncao, txtNome, txtCpf, txtCrmv, txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtID);
				banco.pesquisarFuncionario(txtBusca, listName);
				banco.desconectar();
			}
		});

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
				banco.pesquisarFuncionario(txtBusca, listName);
				banco.desconectar();
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
				banco.pesquisarFuncionario(txtBusca, listName);
				banco.desconectar();
			}
		});
		listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					txtNome.setEditable(true);
					txtCpf.setEditable(true);
					txtDataNasc.setEditable(true);
					txtCep.setEditable(true);
					txtNum.setEditable(true);
					txtComp.setEditable(true);
					txtTel.setEditable(true);
					txtCel.setEditable(true);
					txtEmail.setEditable(true);
					btnEditar.setVisible(true);
					txtCrmv.setEditable(true);
					txtValidade.setEditable(true);

				} else {
					txtNome.setEditable(false);
					txtCpf.setEditable(false);
					txtDataNasc.setEditable(false);
					txtCep.setEditable(false);
					txtNum.setEditable(false);
					txtComp.setEditable(false);
					txtTel.setEditable(false);
					txtCel.setEditable(false);
					txtEmail.setEditable(false);
					btnEditar.setVisible(false);
					txtRua.setEditable(false);
					txtBairro.setEditable(false);
					txtCidade.setEditable(false);
					txtUf.setEditable(false);
					comboFuncao.setEditable(false);
					txtCrmv.setEditable(false);
					txtValidade.setEditable(false);
				}
			}
		}
				);
		listName.setBounds(12, 58, 342, 303);
		panel_1.add(listName);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setMnemonic('N');
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCpf.setText("");
				txtCep.setText("");
				txtDataNasc.setText("");
				txtRua.setText("");
				txtNum.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtUf.setText("");
				txtComp.setText("");
				txtTel.setText("");
				txtCel.setText("");
				txtEmail.setText("");
				txtCrmv.setText("");
				txtValidade.setText("");
				txtTel.setText("(19)3392-5758");
				comboFuncao.setSelectedItem("Secretária(o)");
				txtNome.setEditable(true);
				txtCpf.setEditable(true);
				txtDataNasc.setEditable(true);
				txtCep.setEditable(true);
				txtNum.setEditable(true);
				txtComp.setEditable(true);
				txtTel.setEditable(true);
				txtCel.setEditable(true);
				txtEmail.setEditable(true);
				txtValidade.setEditable(true);
			}
		});
		btnNovo.setBounds(526, 484, 97, 25);
		contentPane.add(btnNovo);


		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(526, 522, 97, 25);
		contentPane.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic('X');
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exluir",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {

					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					banco.excluirFuncionario(txtID);
					txtNome.setText("");
					txtCpf.setText("");
					txtCep.setText("");
					txtDataNasc.setText("");
					txtRua.setText("");
					txtNum.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					txtUf.setText("");
					txtComp.setText("");
					txtTel.setText("");
					txtCel.setText("");
					txtEmail.setText("");
					banco.pesquisarFuncionario(txtBusca, listName);
					banco.desconectar();
				} else if (resposta == JOptionPane.NO_OPTION) {

				}
			}
		});
		btnExcluir.setBounds(655, 503, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "title",JOptionPane.YES_OPTION);
				try {
					if (resposta == JOptionPane.YES_OPTION) {
						BancoDeDados banco = new BancoDeDados();
						
						String dia = TelaFuncionario.txtDataNasc.getText().substring(0,2);
						String mes = TelaFuncionario.txtDataNasc.getText().substring(3,5);
						String ano = TelaFuncionario.txtDataNasc.getText().substring(6);
						String datasql = ano+"-"+mes+"-"+dia;
						
						String dia2 = TelaFuncionario.txtValidade.getText().substring(0,2);
						String mes2 = TelaFuncionario.txtValidade.getText().substring(3,5);
						String ano2 = TelaFuncionario.txtValidade.getText().substring(6);
						String validade = ano2+"-"+mes2+"-"+dia2;
						String d = null;
						if (opMasc.isSelected()) {
							d = "Masculino";
						}else if (opFem.isSelected()) {
							d = "Feminino";
						}
						
						String c = null;
						if (comboFuncao.getSelectedItem() .equals("Veterinário")) {
							c = "Veterinário";
						}
						if (comboFuncao.getSelectedItem() .equals("Auxiliar")) {
							c = "Auxiliar";
							txtValidade.setText("01/01/0001");
						}
						if (comboFuncao.getSelectedItem() .equals("Estagiário")) {
							c = "Estagiário";
						}
						
						if (comboFuncao.getSelectedItem() .equals("Secretária(o)")) {
							c = "Secretária(o)";
							txtValidade.setText("01/01/0001");
						}
						banco.conectar();
						banco.inserirFuncionario(txtNome.getText(), txtCpf.getText(),c, txtCrmv.getText(),validade, d, datasql.intern(), txtCep.getText(), txtRua.getText(), txtNum.getText(), txtBairro.getText() , txtCidade.getText(), txtUf.getText(), txtComp.getText(), txtTel.getText(), txtCel.getText(), txtEmail.getText());
						
						JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");

						txtNome.setText("");
						txtCpf.setText("");
						txtCep.setText("");
						txtDataNasc.setText("");
						txtRua.setText("");
						txtNum.setText("");
						txtBairro.setText("");
						txtCidade.setText("");
						txtUf.setText("");
						txtComp.setText("");
						txtTel.setText("");
						txtCel.setText("");
						txtEmail.setText("");
						txtValidade.setText("");
						txtCrmv.setText("");
						comboFuncao.setSelectedItem("Secretária(o)");
						banco.pesquisarFuncionario(txtBusca, listName);
						banco.desconectar();
					} else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Cadastro não Salvo");
					
					}

				} catch (Exception e) {

				}
			}});
		btnSalvar.setBounds(795, 484, 97, 63);
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
	}
}