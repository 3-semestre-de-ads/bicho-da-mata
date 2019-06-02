package interfaces;

import connection.BancoDeDados;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	public static JComboBox<Object> comboVacina;
	public static JList<String> listVacina;
	public static JComboBox<Object> comboVet;
	public static JTextField txtIdVacina;
	public static JList<String> list;
	public static JList<String> list_2;
	public static JTextField txtIdVet;
	public static JTextPane txtDia;
	public static JTextPane txtHistorico;
	public static JTextField txtIdFicha;
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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFicha() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Bicho da Mata - Pet's");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFicha.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


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
		txtPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
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

		txtDia = new JTextPane();
		txtDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDia.setBackground(new Color(153, 255, 153));
		txtDia.setBounds(12, 343, 302, 97);
		panel_1.add(txtDia);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor.setBounds(13, 34, 56, 16);
		panel_1.add(lblTutor);

		txtDono = new JTextField();
		txtDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDono.setEnabled(false);
		txtDono.setEditable(false);
		txtDono.setColumns(10);
		txtDono.setBounds(13, 58, 172, 22);
		panel_1.add(txtDono);

		JLabel lblPet = new JLabel("Pet:");
		lblPet.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPet.setBounds(244, 34, 56, 16);
		panel_1.add(lblPet);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setEditable(true);
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

		comboVet = new JComboBox<Object>();
		comboVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.idVeterinario(comboVet, txtIdVet);
				banco.desconectar();
			}
		});
		comboVet.setBounds(244, 122, 172, 22);
		panel_1.add(comboVet);

		JLabel lblHistrico = new JLabel("Hist\u00F3rico:");
		lblHistrico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHistrico.setBounds(333, 174, 71, 16);
		panel_1.add(lblHistrico);

		txtHistorico = new JTextPane();
		txtHistorico.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtHistorico.setBackground(new Color(153, 255, 153));
		txtHistorico.setBounds(333, 203, 221, 237);
		panel_1.add(txtHistorico);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(254, 93, 99, 16);
		panel_1.add(lblVeterinrio);

		comboVacina = new JComboBox<Object>();
		comboVacina.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboVacina.setModel(new DefaultComboBoxModel<Object>(new String[] {"CANINOS", "V10", "VR", "VG", "VP", "VL", "FELINOS", "V4", "VR"}));
		comboVacina.setBounds(80, 157, 105, 22);
		panel_1.add(comboVacina);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.pesquisarVacina(txtAnimal, listVacina, listData);
				banco.desconectar();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				
				String s = JOptionPane.showInputDialog("Data?");
				String dia = s.substring(0,2);
				String mes = s.substring(3,5);
				String ano = s.substring(6);
				String datasql = ano+"-"+mes+"-"+dia;
				
				banco.conectar();
				banco.inserirVacina(comboVacina, Integer.parseInt(txtAnimal.getText()), datasql);
				banco.desconectar();
			}
		});
		btnAdd.setBounds(157, 192, 85, 25);
		panel_1.add(btnAdd);

		listVacina = new JList<String>();
		listVacina.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.inserirVacinaId(listVacina, txtIdVacina);
				banco.desconectar();
			}
		});
		listVacina.setValueIsAdjusting(true);
		listVacina.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listVacina.setBounds(12, 203, 56, 98);
		panel_1.add(listVacina);

		listData = new JList<String>();
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

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.deletarVacina(txtIdVacina);
				banco.pesquisarVacina(txtAnimal, listVacina, listData);
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeletar.setBounds(157, 230, 85, 25);
		panel_1.add(btnDeletar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(457, 121, 97, 25);
		panel_1.add(btnEditar);
		btnEditar.setMnemonic('E');

		JButton btnNovo = new JButton("Novo");
		btnNovo.setMnemonic('N');

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtData.setText(formatoBr.format(c));
				txtDia.setText("");
				txtHistorico.setText("");
				txtPeso.setText("");

			}
		});
		btnNovo.setBounds(600, 478, 97, 25);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "Slavar",JOptionPane.YES_OPTION);
				try {
					if (resposta == JOptionPane.YES_OPTION) {
						BancoDeDados banco = new BancoDeDados();
						
						String dia = txtData.getText().substring(0,2);
						String mes = txtData.getText().substring(3,5);
						String ano = txtData.getText().substring(6);
						String datasql1 = ano+"-"+mes+"-"+dia;
						
						banco.conectar();
						banco.inserirFicha(txtAnimal, txtIdVacina, txtIdVet, datasql1, txtPeso, txtDia, txtHistorico);
						banco.desconectar();
					}else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Ficha não Salva");
					}
				}catch (Exception e1) {

				}}});
		btnSalvar.setBounds(834, 478, 97, 63);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic('X');
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.pesquisarVacina(txtAnimal, listVacina, listData);
				banco.desconectar();
			}
		});
		btnExcluir.setBounds(725, 497, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(600, 516, 97, 25);
		contentPane.add(btnVoltar);


		listName = new JList<String>();
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.pesquisarAnimal(txtDono, listName, listData, list);;
				banco.desconectar();
			}
		});
		listName.setBounds(12, 430, 195, 81);
		contentPane.add(listName);

		txtAnimal = new JTextField();
		txtAnimal.setEnabled(false);
		txtAnimal.setEditable(false);
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
				banco.pesquisarFicha(txtNome, list, list_2);
			}
		});
		txtBusca.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBusca.setColumns(10);
		txtBusca.setBounds(72, 26, 254, 22);
		panel_2.add(txtBusca);

		list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.buscarFicha(list, txtNome, txtPeso, txtDia, txtHistorico, comboVet, txtIdFicha);
				banco.desconectar();
			}
		});
		list.setValueIsAdjusting(true);
		list.setBounds(27, 76, 129, 318);
		panel_2.add(list);

		JLabel label_2 = new JLabel("Pet");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(27, 47, 56, 16);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Data");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(166, 47, 56, 16);
		panel_2.add(label_3);

		list_2 = new JList<String>();
		list_2.setValueIsAdjusting(true);
		list_2.setEnabled(false);
		list_2.setBounds(168, 76, 108, 318);
		panel_2.add(list_2);

		txtIdVacina = new JTextField();
		txtIdVacina.setBounds(283, 0, 116, 22);
		contentPane.add(txtIdVacina);
		txtIdVacina.setColumns(10);

		txtIdVet = new JTextField();
		txtIdVet.setBounds(711, 21, 116, 22);
		contentPane.add(txtIdVet);
		txtIdVet.setColumns(10);

		txtClie = new JTextField();
		txtClie.setBounds(558, 21, 116, 22);
		contentPane.add(txtClie);
		txtClie.setEnabled(false);
		txtClie.setEditable(false);
		txtClie.setColumns(10);

		txtIdFicha = new JTextField();
		txtIdFicha.setBounds(283, 34, 116, 22);
		contentPane.add(txtIdFicha);
		txtIdFicha.setColumns(10);
	}
}
