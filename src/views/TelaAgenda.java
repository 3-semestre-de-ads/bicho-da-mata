package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import controller.Agenda;
import model.BancoDeDados;
/**
 * Esta classe foi criada para que possa realizar o CRUD referente a agendamento de consultas dos animais da clínica Bicho da Mata.
 * @author mauri
 *
 */
public class TelaAgenda extends JFrame {

	private static final long serialVersionUID = 1L;
	public static  JPanel contentPane;
	public static  JFormattedTextField txtInicio;
	public static  JFormattedTextField txtTermino;
	public static  JTextField txtBusca;
	public static JDateChooser txtData;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");
	public static JComboBox<String> comboVet;
	public static JComboBox<String> comboCliente; 
	public static JTextField idClie;
	public static JTextField txtIdVet;
	public static JTextField idPet;
	public static JComboBox<String> comboPet;
	public static JComboBox<String> comboTipo;
	public static TextArea txtRecomendacao;
	public static TextArea txtDescricao;
	public static JList<String> list;
	public static JList<String> listVet;
	public static JList<String> listData;
	public static JList<String> listHora;
	public static JList<String> listId;
	public static JList<String> listTipo;
	public static JTextField idAgenda;

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
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public TelaAgenda() {

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAgenda.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Agenda");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1280, 709);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(30, 66, 512, 595);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Agendamento", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel);
		panel.setLayout(null);

		JCheckBox compareceu = new JCheckBox("Compareceu?");
		compareceu.setBounds(203, 36, 113, 25);
		panel.add(compareceu);
		compareceu.setBackground(Color.WHITE);
		compareceu.setForeground(Color.BLACK);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Agenda.verificacao(txtDescricao, txtRecomendacao, txtInicio, txtTermino, comboVet, comboCliente, comboPet, txtData) == true) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.editarAgenda(txtIdVet, idClie, idPet, Agenda.tipo(comboTipo), formatoBr.format(TelaAgenda.txtData.getDate()), txtInicio, txtTermino, Agenda.comparecimento(compareceu), txtRecomendacao, txtDescricao, idAgenda );
						banco.buscarAgendaLista(list, listVet, listData, listHora,listId,listTipo);
						banco.desconectar();
					}
				}
			}
		});
		btnEditar.setBounds(1102, 636, 97, 25);
		contentPane.add(btnEditar);
		btnEditar.setVisible(false);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setBounds(12, 83, 92, 16);
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblVeterinrio);

		comboVet = new JComboBox<String>();
		comboVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setIDVetAgenda(comboVet, txtIdVet);
					banco.desconectar();
				}
			}
		});

		comboVet.setBounds(12, 112, 222, 22);
		comboVet.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(comboVet);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 161, 56, 16);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblCliente);

		comboCliente = new JComboBox<String>();
		comboCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});

		comboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setCliente(comboCliente, idClie);
					banco.desconectar();
				}
			}
		});
		comboCliente.setBounds(12, 190, 222, 22);
		comboCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboCliente.setModel(new DefaultComboBoxModel(new String[] {}));
		panel.add(comboCliente);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(369, 13, 56, 16);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblData);

		txtInicio = new JFormattedTextField();
		try {
			txtInicio.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("##:##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}

		txtInicio.setBounds(274, 112, 101, 22);
		txtInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(txtInicio);
		txtInicio.setColumns(10);

		JLabel lblHora = new JLabel("Inicio:");
		lblHora.setBounds(274, 83, 56, 16);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblHora);

		txtTermino = new JFormattedTextField();
		try {
			txtTermino.setFormatterFactory(new DefaultFormatterFactory(
					new MaskFormatter("##:##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
		}
		txtTermino.setBounds(399, 112, 101, 22);
		txtTermino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(txtTermino);
		txtTermino.setColumns(10);

		JLabel lblTrmino = new JLabel("T\u00E9rmino:");
		lblTrmino.setBounds(399, 83, 68, 16);
		lblTrmino.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblTrmino);

		comboTipo = new JComboBox<String>();
		comboTipo.setBounds(62, 37, 101, 22);
		comboTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Consulta", "Cirurgia", "Vacina"}));
		panel.add(comboTipo);

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(12, 40, 56, 16);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblTipo);

		JLabel lblPet = new JLabel("Pet:");
		lblPet.setBounds(274, 161, 56, 16);
		lblPet.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblPet);

		comboPet = new JComboBox<String>();
		comboPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setIdPet(comboPet, idPet);
					banco.desconectar();
				}
			}
		});
		comboPet.setBounds(274, 190, 222, 22);
		panel.add(comboPet);

		txtData = new JDateChooser();
		txtData.setBounds(369, 37, 121, 22);
		txtData.setDate(new Date());
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(txtData);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 218, 484, 183);
		panel.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Recomenda\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(236, 23, 1, 1);
		panel_3.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);

		JLabel label = new JLabel("Descri\u00E7\u00E3o:");
		label.setBounds(10, 13, 81, 16);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(label);

		TextArea textArea = new TextArea();
		textArea.setBounds(10, 35, 440, 139);
		panel_1.add(textArea);

		txtRecomendacao = new TextArea();
		txtRecomendacao.setFont(new Font("Dialog", Font.BOLD, 16));
		txtRecomendacao.setBackground(new Color(153, 255, 153));
		txtRecomendacao.setBounds(10, 23, 464, 152);
		panel_3.add(txtRecomendacao);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 399, 484, 183);
		panel.add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(236, 23, 1, 1);
		panel_2.add(panel_4);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(10, 13, 81, 16);
		panel_4.add(label_1);

		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 35, 440, 139);
		panel_4.add(textArea_1);

		txtDescricao = new TextArea();
		txtDescricao.setFont(new Font("Dialog", Font.BOLD, 16));
		txtDescricao.setBackground(new Color(153, 255, 153));
		txtDescricao.setBounds(10, 23, 464, 152);
		panel_2.add(txtDescricao);

		JLabel lblAgendaDeConsultas = new JLabel("Agenda de Consultas");
		lblAgendaDeConsultas.setBounds(30, 13, 231, 40);
		lblAgendaDeConsultas.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAgendaDeConsultas);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(554, 636, 97, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnVoltar);

		JButton btnNewButton = new JButton("Relat\u00F3rio");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorio c = new TelaRelatorio();
				c.setVisible(true);
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setVetRelatorio(TelaRelatorio.comboVet);
					banco.desconectar();
				}
			}
		});
		btnNewButton.setBounds(993, 636, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exluir",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					if(banco.estaConectado() == true) {
						banco.excluirAgenda(idAgenda);
						banco.buscarAgendaLista(list, listVet, listData, listHora,listId,listTipo);
						banco.desconectar();
					}
				}
			}
		}
				);

		btnExcluir.setBounds(663, 636, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setVisible(true);
		btnSalvar.setBounds(1102, 636, 97, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "title",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					if(Agenda.verificacao(txtDescricao, txtRecomendacao, txtInicio, txtTermino, comboVet, comboCliente, comboPet, txtData) == true) {
						BancoDeDados banco = new BancoDeDados();
						banco.conectar();
						if(banco.estaConectado() == true) {
							banco.inserirAgenda(txtIdVet, idClie, idPet, Agenda.tipo(comboTipo), formatoBr.format(txtData.getDate()), txtInicio, txtTermino, Agenda.comparecimento(compareceu), txtRecomendacao, txtDescricao);
							JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
							banco.desconectar();
						}
					}
				}
			}});
		contentPane.add(btnSalvar);

		JLabel lblCliente_1 = new JLabel("Cliente:");
		lblCliente_1.setBounds(562, 79, 56, 16);
		lblCliente_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblCliente_1);

		txtBusca = new JTextField();
		txtBusca.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarAgendaLista(list, listVet, listData, listHora,listId,listTipo);
					banco.desconectar();
				}
			}
		});
		txtBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtBusca.setBounds(630, 76, 537, 22);
		txtBusca.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);

		idClie = new JTextField();
		idClie.setBounds(407, 25, 116, 22);
		idClie.setVisible(false);
		contentPane.add(idClie);
		idClie.setColumns(10);

		txtIdVet = new JTextField();
		txtIdVet.setBounds(535, 25, 116, 22);
		txtIdVet.setVisible(false);
		contentPane.add(txtIdVet);
		txtIdVet.setColumns(10);

		idPet = new JTextField();
		idPet.setVisible(false);
		idPet.setBounds(665, 25, 116, 22);
		contentPane.add(idPet);
		idPet.setColumns(10);

		list = new JList();
		list.setEnabled(false);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

			}

		});
		list.setBounds(591, 128, 158, 446);
		contentPane.add(list);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor.setBounds(591, 107, 56, 16);
		contentPane.add(lblTutor);

		listVet = new JList();
		listVet.setEnabled(false);
		listVet.setBounds(751, 128, 144, 447);
		contentPane.add(listVet);

		JLabel lblVeterinrio_1 = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio_1.setBounds(751, 110, 87, 16);
		contentPane.add(lblVeterinrio_1);

		listData = new JList();
		listData.setEnabled(false);
		listData.setBounds(907, 128, 97, 446);
		contentPane.add(listData);

		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData_1.setBounds(906, 107, 56, 16);
		contentPane.add(lblData_1);

		JLabel lblHora_1 = new JLabel("Hora:");
		lblHora_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora_1.setBounds(1016, 107, 56, 16);
		contentPane.add(lblHora_1);

		listHora = new JList();
		listHora.setEnabled(false);
		listHora.setBounds(1016, 128, 83, 446);
		contentPane.add(listHora);

		listTipo = new JList();
		listTipo.setEnabled(false);
		listTipo.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		}
				);

		listTipo.setBounds(1102, 128, 87, 446);
		contentPane.add(listTipo);

		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo_1.setBounds(1111, 107, 56, 16);
		contentPane.add(lblTipo_1);

		listId = new JList();
		listId.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.buscarAgenda(listId, txtData, compareceu, txtTermino, txtInicio, comboVet, comboCliente, comboPet, comboTipo, txtRecomendacao, txtDescricao, idAgenda);
					banco.desconectar();
				}

				listId.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2) {
							Agenda.editarTrue(txtDescricao, txtRecomendacao, txtInicio, txtTermino, btnEditar, btnSalvar);
						} else {
							Agenda.editarFalse(txtDescricao, txtRecomendacao, txtInicio, txtTermino, btnEditar, btnSalvar);
						}
					}
				});
			}
		});

		listId.setBounds(554, 128, 36, 447);
		contentPane.add(listId);

		idAgenda = new JTextField();
		idAgenda.setBounds(279, 25, 116, 22);
		idAgenda.setVisible(false);
		contentPane.add(idAgenda);
		idAgenda.setColumns(10);

		JButton btnFicha = new JButton("Ficha");
		btnFicha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFicha telaFicha = new TelaFicha();
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					banco.setFichaAgenda(comboPet, TelaFicha.txtDono, TelaFicha.txtNome, TelaFicha.txtAnimal);
					banco.setIDVet(comboVet, txtIdVet);
					banco.pesquisarVacina(TelaFicha.txtAnimal, TelaFicha.listVacina, TelaFicha.listData);
					telaFicha.setVisible(true);
					banco.setVet(TelaFicha.comboVet);
					banco.desconectar();
				}
			}
		});

		btnFicha.setBounds(884, 636, 97, 25);
		contentPane.add(btnFicha);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda.novo(txtDescricao, compareceu, txtRecomendacao, txtInicio, txtTermino, btnEditar, btnSalvar);
			}
		});
		btnNovo.setBounds(772, 636, 97, 25);
		contentPane.add(btnNovo);
	}
}