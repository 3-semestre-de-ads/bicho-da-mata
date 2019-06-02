package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

import controller.Cliente;
import model.BancoDeDados;
/**
 * Nesta classe sera feita todo o layout para receber os dados importantes para o cadastro do cliente junto a clinica.
 * alguns metodos criados na classe BancoDeDados que sera invocados para realizar o CRUD dessas informacoes.
 * @author mauri
 *
 */
public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
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
	public static JTextField txtData;
	public static JTextField txtID;
	public static JList<String> listName;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	public static JButton btnEditar;
	public static JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public TelaCliente() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCliente.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Cliente");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.setMnemonic('N');
		btnNovo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cliente.novo(txtNome, txtCpf, txtCep, txtDataNasc, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtData, btnSalvar, btnEditar, listName);
			}
		});
		btnNovo.setBounds(536, 474, 97, 25);
		contentPane.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "Slavar",JOptionPane.YES_OPTION);
				try {
					if (resposta == JOptionPane.YES_OPTION) {
						if(Cliente.verificacao(txtNome, txtCpf, opMasc, opFem, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, txtCep, txtNum, txtCel, txtEmail) == true) {
							BancoDeDados banco = new BancoDeDados();
							banco.conectar();
							if(banco.estaConectado() == true) {
								if(banco.verificarCpf(txtCpf) == true) {
									banco.inserirCliente(Cliente.data(txtData), txtNome, txtCpf, Cliente.sexo(opMasc), Cliente.data(txtDataNasc), txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail);
									JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
									banco.pesquisarCliente(txtBusca, listName);
									banco.desconectar();
								}
							}
						}
					}else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Cadastro não Salvo");
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro: " + e1.toString());
				}
			}});
		btnSalvar.setBounds(795, 512, 97, 25);
		contentPane.add(btnSalvar);

		JButton btnVoltar = new JButton("Cadastrar Pet's");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setMnemonic('C');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnimal animal = new TelaAnimal();
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setClienteAnimal(listName, TelaAnimal.txtDono, TelaAnimal.txtClie);
					animal.setVisible(true);
					banco.desconectar();
				}
			}
		});
		btnVoltar.setBounds(667, 474, 126, 25);
		contentPane.add(btnVoltar);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCliente.setBounds(12, 0, 86, 35);
		contentPane.add(lblCliente);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(102, 51, 153));
		panel.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 35, 484, 517);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeCompleto.setBounds(12, 36, 116, 16);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setBounds(12, 52, 189, 22);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(12, 92, 56, 16);
		panel.add(lblSexo);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(213, 36, 56, 16);
		panel.add(lblNewLabel);

		txtCpf = new JFormattedTextField();
		try {
			txtCpf.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCpf.setToolTipText("S\u00F3 pode haver um \u00FAnico CPF por cadastro");
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpf.setBounds(213, 52, 116, 22);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		buttonGroup.add(opMasc);
		opMasc.setFont(new Font("Tahoma", Font.BOLD, 13));

		opMasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args) {

			}
		}
				);
		opMasc.setBackground(new Color(255, 255, 255));
		opMasc.setBounds(12, 110, 98, 25);
		panel.add(opMasc);
		buttonGroup.add(opFem);
		opFem.setFont(new Font("Tahoma", Font.BOLD, 13));

		opFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		}
				);
		opFem.setBackground(new Color(255, 255, 255));
		opFem.setBounds(114, 110, 84, 25);
		buttonGroup.add(opFem);
		panel.add(opFem);

		JLabel lblEndereo = new JLabel("CEP:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereo.setBounds(12, 144, 70, 16);
		panel.add(lblEndereo);

		txtCep =  new JFormattedTextField();
		try {
			txtCep.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("#####-###")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Cliente.webService(txtCep, txtRua, txtBairro, txtCidade, txtUf);
			}
		}
				);

		txtCep.setBounds(12, 163, 84, 22);
		panel.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblRua = new JLabel("Logradouro:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua.setBounds(12, 198, 84, 16);
		panel.add(lblRua);

		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRua.setBounds(12, 216, 364, 22);
		panel.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNmero.setBounds(12, 251, 56, 16);
		panel.add(lblNmero);

		txtNum = new JTextField();
		txtNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNum.setBounds(12, 270, 56, 22);
		panel.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBairro.setBounds(80, 251, 56, 16);
		panel.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBairro.setBounds(80, 270, 144, 22);
		panel.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(241, 251, 56, 16);
		panel.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCidade.setBounds(241, 270, 163, 22);
		panel.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(12, 314, 98, 16);
		panel.add(lblComplemento);

		txtComp = new JTextField();
		txtComp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtComp.setBounds(12, 333, 116, 22);
		panel.add(txtComp);
		txtComp.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimento.setBounds(213, 92, 144, 16);
		panel.add(lblDataDeNascimento);

		txtDataNasc = new JFormattedTextField();
		try {
			txtDataNasc.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}

		txtDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDataNasc.setBounds(213, 111, 116, 22);
		panel.add(txtDataNasc);
		txtDataNasc.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(12, 378, 70, 16);
		panel.add(lblTelefone);

		txtTel = new JFormattedTextField();
		txtTel.setText("(19)3392-5758");
		try {
			txtTel.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("(##)####-####")));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTel.setBounds(12, 397, 116, 22);
		panel.add(txtTel);
		txtTel.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(143, 378, 70, 16);
		panel.add(lblCelular);

		txtCel = new JFormattedTextField();
		try {
			txtCel.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("(##)#####-####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}

		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCel.setBounds(140, 397, 116, 22);
		panel.add(txtCel);
		txtCel.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(12, 445, 56, 16);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setBounds(12, 461, 247, 22);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUf.setBounds(416, 251, 56, 16);
		panel.add(lblUf);

		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUf.setBounds(416, 270, 38, 22);
		panel.add(txtUf);
		txtUf.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(344, 0, 140, 59);
		panel.add(panel_2);

		txtData = new JTextField();
		txtData.setToolTipText("Data de Hoje");
		txtData.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtData.setEditable(false);
		Date d = new Date();
		txtData.setText(formatoBr.format(d));
		txtData.setColumns(10);
		txtData.setBounds(12, 24, 116, 22);

		panel_2.add(txtData);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setVisible(false);
		txtID.setBounds(356, 442, 116, 22);
		panel.add(txtID);
		txtID.setColumns(10);

		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar_1.setMnemonic('V');
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar_1.setBounds(536, 512, 97, 25);
		contentPane.add(btnVoltar_1);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(526, 35, 366, 423);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		listName = new JList<String>();
		listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Cliente.cliqueTrue(txtNome, txtCpf, txtDataNasc, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, btnEditar, btnSalvar, txtData);
				} else {
					Cliente.cliqueFalse(txtNome, txtCpf, txtDataNasc, txtCep, txtNum, txtComp, txtTel, txtCel, txtEmail, btnEditar, btnSalvar, txtData);
				}
			}
		});
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarCliente(listName, txtData, txtNome, txtCpf, txtDataNasc, txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtID, opMasc, opFem);
					banco.desconectar();
				}
			}
		});
		listName.setFont(new Font("Tahoma", Font.BOLD, 13));
		listName.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

		listName.setBounds(12, 58, 342, 303);
		panel_1.add(listName);

		JLabel lblNomeCompleto_1 = new JLabel("Nome:");
		lblNomeCompleto_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeCompleto_1.setBounds(12, 29, 104, 16);
		panel_1.add(lblNomeCompleto_1);

		txtBusca = new JTextField();
		txtBusca.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.pesquisarCliente(txtBusca, listName);
					banco.desconectar();
				}
			}
		});
		txtBusca.setBounds(58, 26, 296, 22);
		panel_1.add(txtBusca);
		txtBusca.setColumns(10);

		JButton btnApagar = new JButton("Excluir");
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnApagar.setMnemonic('X');
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "title",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.excluirCliente(txtID);
						banco.pesquisarCliente(txtBusca, listName);
						banco.desconectar();
					}
				}
			}});
		btnApagar.setBounds(667, 512, 97, 25);
		contentPane.add(btnApagar);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(795, 512, 97, 25);
		contentPane.add(btnEditar);
		btnEditar.setVisible(false);
		btnEditar.setMnemonic('E');
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseija realmente editar?", "Editar", JOptionPane.YES_NO_OPTION );
				if (resposta == JOptionPane.YES_OPTION) {
					if(Cliente.verificacao(txtNome, txtCpf, opMasc, opFem, txtDataNasc, txtRua, txtBairro, txtCidade, txtUf, txtCep, txtNum, txtCel, txtEmail) == true) {
						BancoDeDados banco = new BancoDeDados();
						banco.conectar();
						if(banco.estaConectado() == true) {
							if(banco.verificarCpf(txtCpf) == true) {
								banco.editarCliente(txtDataNasc, txtData, opMasc, opFem, txtNome, txtCpf, txtCep, txtRua, txtNum, txtBairro, txtCidade, txtUf, txtComp, txtTel, txtCel, txtEmail, txtID);
								banco.pesquisarCliente(txtBusca, listName);
								banco.desconectar();
							}
						}
					}
				}
			}
		});
	}
}