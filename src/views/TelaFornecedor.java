package views;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.Fornecedor;
import model.BancoDeDados;
/**
 * Esta classe foi criado para realizar o cadastro dos fornecedores da clinica bicho da mata, com a finalidade de organizar o contato com os fornecedores
 * pois atualmente a clinica utilzia uma agenda comum para armazenamento dos dados.
 * @author mauri
 *
 */
public class TelaFornecedor extends JFrame {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
	public static JPanel contentPane;
	public static JTextField txtNome;
	public static JFormattedTextField txtCnpj;
	public static JFormattedTextField txtTelefone;
	public static JTextField txtContato;
	public static JTextPane txtDescricao;
	public static JTextField txtData;
	public static JTextField txtID;
	public static JTextField txtEmail;
	public static JTextField txtBusca;
	public static JList<String> listName;
	public static JScrollPane scroll;
	public static JButton btnEditar;
	public static JButton tbnSalvar;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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
	public TelaFornecedor() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFornecedor.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Fornecedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 78, 495, 474);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome da Empresa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 20, 128, 26);
		panel.add(lblNewLabel);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCnpj.setBounds(264, 20, 128, 26);
		panel.add(lblCnpj);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setBounds(12, 44, 219, 22);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtCnpj = new JFormattedTextField();
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtCnpj.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("###.###.###/####-##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(264, 44, 219, 22);
		panel.add(txtCnpj);

		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try {
			txtTelefone.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("(##)#####-####")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(264, 102, 219, 22);
		panel.add(txtTelefone);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(264, 79, 128, 26);
		panel.add(lblCelular);

		txtContato = new JTextField();
		txtContato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtContato.setColumns(10);
		txtContato.setBounds(12, 102, 219, 22);
		panel.add(txtContato);

		JLabel lblContato = new JLabel("Contato:");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContato.setBounds(12, 76, 128, 26);
		panel.add(lblContato);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 204, 466, 247);
		panel.add(panel_1);

		txtDescricao = new JTextPane();
		txtDescricao.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDescricao.setToolTipText("");

		txtDescricao.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		txtDescricao.setBackground(new Color(153, 255, 153));
		txtDescricao.setBounds(12, 25, 442, 203);
		panel_1.add(txtDescricao);

		JLabel lblProdutos = new JLabel("Informa\u00E7\u00F5es:");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProdutos.setBounds(12, 0, 164, 23);
		panel_1.add(lblProdutos);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(12, 131, 128, 26);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(12, 160, 219, 22);
		panel.add(txtEmail);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFornecedor.setBounds(35, 13, 164, 38);
		contentPane.add(lblFornecedor);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(390, 6, 140, 59);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		txtData = new JTextField();
		txtData.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {

			}
		});

		txtData.setEditable(false);
		txtData.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtData.setBounds(12, 24, 116, 22);
		panel_2.add(txtData);
		Date d = new Date();
		txtData.setText(formatoBr.format(d));

		txtData.setColumns(10);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setBounds(599, 24, 116, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(565, 78, 366, 374);
		contentPane.add(panel_3);

		JLabel label = new JLabel("Nome Completo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 29, 104, 16);
		panel_3.add(label);

		txtBusca = new JTextField();
		txtBusca.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.pesquisarFornecedor(txtBusca, listName);
					banco.desconectar();
				}
			}
		});
		txtBusca.setColumns(10);
		txtBusca.setBounds(122, 26, 232, 22);
		panel_3.add(txtBusca);

		listName = new JList<String>();
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarFornecedor(listName, txtDescricao, txtData, txtNome, txtCnpj, txtContato, txtTelefone, txtEmail, txtID);
					banco.desconectar();
				}
			}
		});
		listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Fornecedor.cliqueTrue(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, btnEditar, tbnSalvar);
				} else {
					Fornecedor.cliqueFalse(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, btnEditar, tbnSalvar);
				}
			}
		});
		listName.setBounds(12, 58, 342, 303);
		panel_3.add(listName);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNovo.setMnemonic('N');
				btnNovo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Fornecedor.novo(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, txtData, btnEditar, tbnSalvar, listName);
					}
				});
			}
		});
		btnNovo.setMnemonic('N');
		btnNovo.setBounds(565, 478, 97, 25);
		contentPane.add(btnNovo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setMnemonic('V');
		btnVoltar.setBounds(565, 516, 97, 25);
		contentPane.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "title",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {

					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.excluirFornecedor(txtID);
						Fornecedor.novo(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, txtData, btnEditar, tbnSalvar, listName);
						banco.pesquisarFornecedor(txtBusca, listName);
						banco.desconectar();
					}
				}
			}
		});
		btnExcluir.setMnemonic('X');
		btnExcluir.setBounds(703, 516, 97, 25);
		contentPane.add(btnExcluir);

		tbnSalvar = new JButton("Salvar");
		tbnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tbnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "title",JOptionPane.YES_OPTION);
				try {

					if (resposta == JOptionPane.YES_OPTION) {
						if(Fornecedor.verificacao(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, txtDescricao) == true) {
							BancoDeDados banco = new BancoDeDados();
							banco.conectar();
							if(banco.estaConectado() == true) {
								if(banco.verificarCnpj(txtCnpj) == true) {
									banco.inserirContato(Fornecedor.data(txtData).intern(), txtNome, txtCnpj, txtContato, txtTelefone, txtEmail, txtDescricao);
									Fornecedor.novo(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, txtData, btnEditar, tbnSalvar, listName);
									banco.pesquisarFornecedor(txtBusca, listName);
									banco.desconectar();
								}
							}
						}
					}
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Erro: " + ee.toString());
				}
			}});

		tbnSalvar.setMnemonic('S');
		tbnSalvar.setBounds(834, 516, 97, 25);
		contentPane.add(tbnSalvar);
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(834, 516, 97, 25);
		contentPane.add(btnEditar);
		btnEditar.setMnemonic('E');
		btnEditar.setVisible(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente editar?", "Editar",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					if(Fornecedor.verificacao(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, txtDescricao) == true) {
						BancoDeDados banco = new BancoDeDados();
						banco.conectar();
						if(banco.estaConectado() == true) {
							if(banco.verificarCnpj(txtCnpj) == true) {
								banco.editarFornecedor(txtData, txtNome, txtCnpj, txtContato, txtTelefone, txtEmail, txtDescricao, txtID);
								banco.pesquisarFornecedor(txtBusca, listName);
								Fornecedor.cliqueTrue(txtNome, txtCnpj, txtContato, txtTelefone, txtDescricao, txtEmail, btnEditar, tbnSalvar);
								banco.desconectar();
							}
						}
					}
				}
			}
		});
	}	
}