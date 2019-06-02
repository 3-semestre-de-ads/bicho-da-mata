package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Ficha;
import model.BancoDeDados;

/**
 * A Classe TelaFicha sera o layout para realizar a inserção dos dados do resultado de cada consulta, atraves dos metodos invocados na classe BancoDeDados
 * sera possivel realizar o CRUD desses informacoes.
 * @author mauri
 *
 */
public class TelaFicha extends JFrame {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");

	public static JPanel contentPane;
	public static JTextField txtPeso;
	public static JTextField txtClie;
	public static JList<String> listName;
	public static JList<String> listData;
	public static JTextField txtAnimal;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	public static final ButtonGroup buttonGroup1 = new ButtonGroup();
	public static JTextField txtDono;
	public static JTextField txtNome;
	public static JTextField txtData;
	public static JTextField txtBusca;
	public static JComboBox<String> comboVacina;
	public static JList<String> listVacina;
	public static JComboBox<String> comboVet;
	public static JTextField txtIdVacina;
	public static JList<String> list;
	public static JList<String> list_2;
	public static JTextField txtIdVet;
	public static JTextField txtIdFicha;
	public static TextArea txtHistorico;
	public static TextArea txtDia;
	public static JButton btnEditar;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFicha frame = new TelaFicha();
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
	public TelaFicha() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Bicho da Mata - Pet's");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFicha.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				if(Ficha.verificacao(txtDia, txtHistorico, txtPeso, comboVet) == true) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.editarFicha(txtAnimal, txtIdVet, txtPeso, txtDia, txtHistorico, txtIdFicha);
						banco.desconectar();
					}
				}
			}}
				);
		btnEditar.setVisible(false);
		btnEditar.setBounds(818, 516, 97, 25);
		contentPane.add(btnEditar);
		btnEditar.setMnemonic('E');

		JLabel lblAnimal = new JLabel("Ficha Cl\u00EDnica do Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnimal.setBounds(22, 13, 245, 32);
		contentPane.add(lblAnimal);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Ficha Cl\u00EDnica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(22, 58, 566, 453);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeso.setBounds(12, 93, 56, 16);
		panel_1.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPeso.setColumns(10);
		txtPeso.setBounds(12, 122, 116, 22);
		panel_1.add(txtPeso);

		JLabel lblVacinas = new JLabel("Vacinas:");
		lblVacinas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVacinas.setBounds(12, 157, 71, 16);
		panel_1.add(lblVacinas);

		JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiagnstico.setBounds(12, 314, 99, 16);
		panel_1.add(lblDiagnstico);

		txtDia = new TextArea();
		txtDia.setFont(new Font("Monospaced", Font.BOLD, 12));
		setForeground(new Color(255, 000, 51));
		txtDia.setBackground(new Color(153, 255, 153));
		txtDia.setBounds(12, 343, 302, 97);
		panel_1.add(txtDia);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor.setBounds(13, 34, 56, 16);
		panel_1.add(lblTutor);

		txtDono = new JTextField();
		txtDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDono.setEditable(false);
		txtDono.setColumns(10);
		txtDono.setBounds(13, 58, 172, 22);
		panel_1.add(txtDono);

		JLabel lblPet = new JLabel("Pet:");
		lblPet.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPet.setBounds(244, 34, 56, 16);
		panel_1.add(lblPet);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(244, 58, 172, 22);
		panel_1.add(txtNome);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(426, 0, 140, 59);
		panel_1.add(panel);

		txtData = new JTextField();
		txtData.setToolTipText("Data da ultima atualiza\u00E7\u00E3o");
		Date c = new Date();
		txtData.setText(formatoBr.format(c));
		txtData.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(12, 24, 116, 22);
		panel.add(txtData);

		comboVet = new JComboBox<String>();
		comboVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setIDVet(comboVet, txtIdVet);
					banco.desconectar();
				}
			}
		});
		comboVet.setBounds(244, 122, 172, 22);
		panel_1.add(comboVet);

		JLabel lblHistrico = new JLabel("Hist\u00F3rico:");
		lblHistrico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHistrico.setBounds(333, 174, 71, 16);
		panel_1.add(lblHistrico);

		txtHistorico = new TextArea();
		txtHistorico.addMouseListener(new MouseAdapter() {
		});
		txtHistorico.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtHistorico.setBackground(new Color(153, 255, 153));
		txtHistorico.setBounds(333, 203, 221, 237);
		panel_1.add(txtHistorico);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(254, 93, 99, 16);
		panel_1.add(lblVeterinrio);

		comboVacina = new JComboBox<String>();
		comboVacina.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboVacina.setModel(new DefaultComboBoxModel(new String[] {"CANINOS", "V10", "VR", "VG", "VP", "VL", "FELINOS", "V4", "VR"}));
		comboVacina.setBounds(80, 157, 105, 22);
		panel_1.add(comboVacina);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.inserirVacina(comboVacina, txtAnimal, Ficha.data(JOptionPane.showInputDialog("Data?")));
					banco.pesquisarVacina(txtAnimal, listVacina, listData);
					banco.desconectar();
				}
			}
		});
		btnAdd.setBounds(157, 192, 85, 25);
		panel_1.add(btnAdd);

		listVacina = new JList();
		listVacina.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.inserirVacinaId(listVacina, txtIdVacina);
					banco.desconectar();
				}
			}
		});
		listVacina.setValueIsAdjusting(true);
		listVacina.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listVacina.setBounds(12, 203, 56, 98);
		panel_1.add(listVacina);

		listData = new JList();
		listData.setEnabled(false);
		listData.setBounds(72, 203, 73, 98);
		panel_1.add(listData);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(72, 186, 56, 16);
		panel_1.add(lblData);

		JLabel lblVacina = new JLabel("Vacina:");
		lblVacina.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVacina.setBounds(12, 186, 56, 16);
		panel_1.add(lblVacina);

		JButton btnDeletar = new JButton("Del");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.deletarVacina(txtIdVacina);
					banco.pesquisarVacina(txtAnimal, listVacina, listData);
					banco.desconectar();
				}
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeletar.setBounds(157, 230, 85, 25);
		panel_1.add(btnDeletar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.setMnemonic('N');

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ficha.novo(txtData, txtDia, txtHistorico, txtPeso, comboVet, btnEditar, list);
			}
		});
		btnNovo.setBounds(600, 478, 97, 25);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "Slavar",JOptionPane.YES_OPTION);
				try {
					if(Ficha.verificacao(txtDia, txtHistorico, txtPeso, comboVet) == true) {
						if (resposta == JOptionPane.YES_OPTION) {
							BancoDeDados banco = new BancoDeDados();
							banco.conectar();
							if(banco.estaConectado() == true) {
								banco.inserirFicha(txtAnimal, txtIdVacina, txtIdVet, Ficha.data(txtData.getText()), txtPeso, txtDia, txtHistorico);
								banco.desconectar();
							}
						}
					}else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Ficha não Salva");
						System.out.println(list.getSelectedValue() + "  " + formatoBr.format(new Date()));
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro: " + e1.toString());
				}}});
		btnSalvar.setBounds(818, 516, 97, 25);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.setMnemonic('X');
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "title",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.excluirFicha(txtIdFicha);
						banco.pesquisarVacina(txtAnimal, listVacina, listData);
						banco.pesquisarFicha(txtNome, list, list_2);
						banco.desconectar();
					}
				}
			}
		});
		btnExcluir.setBounds(709, 516, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(600, 516, 97, 25);
		contentPane.add(btnVoltar);

		listName = new JList();
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarAnimal(listName, TelaAnimal.txtClie, TelaAnimal.txtDono, TelaAnimal.txtAnimal, TelaAnimal.txtNome, TelaAnimal.txtEspecie, TelaAnimal.txtRaca, TelaAnimal.txtNascimento, TelaAnimal.txtCor, TelaAnimal.txtObs, TelaAnimal.opMacho, TelaAnimal.opFem, TelaAnimal.opSim, TelaAnimal.opNao);
					banco.desconectar();
				}
			}
		});
		listName.setBounds(12, 430, 195, 81);
		contentPane.add(listName);

		txtAnimal = new JTextField();
		txtAnimal.setEnabled(false);
		txtAnimal.setEditable(false);
		txtAnimal.setVisible(false);
		txtAnimal.setBounds(426, 23, 116, 22);
		contentPane.add(txtAnimal);
		txtAnimal.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(593, 58, 338, 407);
		contentPane.add(panel_2);

		JLabel lblTutor_2 = new JLabel("Tutor:");
		lblTutor_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor_2.setBounds(27, 29, 56, 16);
		panel_2.add(lblTutor_2);

		txtBusca = new JTextField();
		txtBusca.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.pesquisarFicha(txtNome, list, list_2);
					banco.desconectar();
				}
			}
		});
		txtBusca.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBusca.setColumns(10);
		txtBusca.setBounds(72, 26, 254, 22);
		panel_2.add(txtBusca);

		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Ficha.cliqueTrue(btnEditar, txtPeso, txtHistorico, txtDia, comboVet);
				} else {
					Ficha.cliqueFalse(btnEditar, txtPeso, txtHistorico, txtDia, comboVet);
				}
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarFicha(list, txtNome, txtPeso, txtDia, txtHistorico, comboVet, txtIdFicha , txtIdVet);
					banco.desconectar();
				}
			}
		});
		list.setValueIsAdjusting(true);
		list.setBounds(27, 76, 129, 318);
		panel_2.add(list);

		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData_1.setBounds(27, 47, 56, 16);
		panel_2.add(lblData_1);

		JLabel lblPet_1 = new JLabel("Pet:");
		lblPet_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPet_1.setBounds(166, 47, 56, 16);
		panel_2.add(lblPet_1);

		list_2 = new JList();
		list_2.setValueIsAdjusting(true);
		list_2.setEnabled(false);
		list_2.setBounds(168, 76, 108, 318);
		panel_2.add(list_2);

		txtIdVacina = new JTextField();
		txtIdVacina.setEnabled(false);
		txtIdVacina.setVisible(false);
		txtIdVacina.setEnabled(false);
		txtIdVacina.setBounds(283, 0, 116, 22);
		contentPane.add(txtIdVacina);
		txtIdVacina.setColumns(10);

		txtIdVet = new JTextField();
		txtIdVet.setEnabled(false);
		txtIdVet.setVisible(false);
		txtIdVet.setBounds(711, 21, 116, 22);
		contentPane.add(txtIdVet);
		txtIdVet.setColumns(10);

		txtClie = new JTextField();
		txtClie.setBounds(558, 21, 116, 22);
		contentPane.add(txtClie);
		txtClie.setVisible(false);
		txtClie.setEnabled(false);
		txtClie.setEditable(false);
		txtClie.setColumns(10);

		txtIdFicha = new JTextField();
		txtIdFicha.setVisible(false);
		txtIdFicha.setEnabled(false);
		txtIdFicha.setEditable(false);
		txtIdFicha.setBounds(283, 34, 116, 22);
		contentPane.add(txtIdFicha);
		txtIdFicha.setColumns(10);
	}
}