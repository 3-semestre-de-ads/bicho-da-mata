package interfaces;

import connection.BancoDeDados;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
/**
 * Esta classe foi criada para que possa realizar o CRUD referente a agendamento de consultas dos animais da clínica Bicho da Mata.
 * @author mauri
 *
 */
public class TelaAgenda extends JFrame {

	private static final long serialVersionUID = 1L;
	public static  JPanel contentPane;
	public static  JTextField txtInicio;
	public static  JTextField txtTermino;
	public static  JTextField txtBusca;
	public static JDateChooser txtData;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");
	public static JComboBox<Object> comboVet;
	public static JComboBox<Object> comboCliente; 
	public static JTextField idClie;
	public static JTextField txtIdVet;
	public static JTextField idPet;
	public static JComboBox<Object> comboPet;
	public static JComboBox<Object> comboTipo;
	public static TextArea txtRecomendacao;
	public static TextArea txtDescricao;
	public static JList<String> list;
	public static JList<String> listVet;
	public static JList<String> listData;
	public static JList<String> listHora;
	
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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaAgenda() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAgenda.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 709);
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
		
		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setBounds(12, 83, 92, 16);
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblVeterinrio);
		
		comboVet = new JComboBox<Object>();
		comboVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
			 	banco.idVeterinarioAgenda(comboVet, txtIdVet);
			 	banco.desconectar();
			}
		});
		comboVet.setBounds(12, 112, 222, 22);
		comboVet.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(comboVet);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 161, 56, 16);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblCliente);
		
		comboCliente = new JComboBox<Object>();
		comboCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			
			}
		});
		comboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.clienteAgenda(comboCliente, idClie);
				banco.buscarAnimalAgenda(comboCliente, comboPet);
				banco.desconectar();
			}
		});
		comboCliente.setBounds(12, 190, 222, 22);
		comboCliente.setEditable(true);
		comboCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboCliente.setModel(new DefaultComboBoxModel(new String[] {"Mauricio Tomesani Furlan"}));
		panel.add(comboCliente);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(369, 13, 56, 16);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblData);
		
		txtInicio = new JTextField();
		txtInicio.setBounds(274, 112, 101, 22);
		txtInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(txtInicio);
		txtInicio.setColumns(10);
		
		JLabel lblHora = new JLabel("Inicio:");
		lblHora.setBounds(274, 83, 56, 16);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblHora);
		
		txtTermino = new JTextField();
		txtTermino.setBounds(399, 112, 101, 22);
		txtTermino.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(txtTermino);
		txtTermino.setColumns(10);
		
		JLabel lblTrmino = new JLabel("T\u00E9rmino:");
		lblTrmino.setBounds(399, 83, 68, 16);
		lblTrmino.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblTrmino);
		
		comboTipo = new JComboBox();
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
		
		comboPet = new JComboBox();
		comboPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BancoDeDados banco = new BancoDeDados();
			banco.conectar();
			banco.idPet(comboPet, idPet);
			banco.desconectar();
			}
		});
		comboPet.setBounds(274, 190, 222, 22);
		comboPet.setBackground(Color.WHITE);
		comboPet.setForeground(Color.BLACK);
		panel.add(comboPet);
		
		txtData = new JDateChooser();
		txtData.setBounds(369, 37, 121, 22);
		txtData.getDate();
		txtData.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(txtData);
		
		JCheckBox compareceu = new JCheckBox("Compareceu?");
		compareceu.setBounds(203, 36, 113, 25);
		panel.add(compareceu);
		compareceu.setBackground(Color.WHITE);
		compareceu.setForeground(Color.BLACK);
		
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
		txtRecomendacao.setBackground(new Color(0, 153, 102));
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
		txtDescricao.setBackground(new Color(0, 153, 102));
		txtDescricao.setBounds(10, 23, 464, 152);
		panel_2.add(txtDescricao);
		
		JLabel lblAgendaDeConsultas = new JLabel("Agenda de Consultas");
		lblAgendaDeConsultas.setBounds(30, 13, 231, 40);
		lblAgendaDeConsultas.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblAgendaDeConsultas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(554, 636, 97, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Relat\u00F3rio");
		btnNewButton.setBounds(554, 588, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(772, 636, 97, 25);
		contentPane.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(663, 588, 97, 25);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(663, 636, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(772, 588, 97, 25);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();

				String data =  formatoBr.format(TelaAgenda.txtData.getDate());
				
				String c = null;
				if (comboTipo.getSelectedItem() .equals("Consulta")) {
					c = "Consulta";
				}
				if (comboTipo.getSelectedItem() .equals("Cirurgia")) {
					c = "Cirurgia";
				
				}
				if (comboTipo.getSelectedItem() .equals("Vacina")) {
					c = "Vacina";
				}
				
				int comp;
				if (compareceu.isSelected() == true) {
					comp = 1;
				}else {
					comp = 0;
				}
				
				banco.conectar();
				banco.inserirAgenda(txtIdVet, idClie, idPet, c, data, txtInicio, txtTermino, comp, txtRecomendacao, txtDescricao);
				banco.desconectar();
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
				banco.buscarAgendaLista(list, listVet, listData, listHora);
				banco.desconectar();
			}
		});
		txtBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtBusca.setBounds(630, 76, 241, 22);
		txtBusca.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);
		
		idClie = new JTextField();
		idClie.setBounds(302, 25, 116, 22);
		idClie.setVisible(false);
		contentPane.add(idClie);
		idClie.setColumns(10);
		
		txtIdVet = new JTextField();
		txtIdVet.setBounds(469, 25, 116, 22);
		txtIdVet.setVisible(false);
		contentPane.add(txtIdVet);
		txtIdVet.setColumns(10);
		
		idPet = new JTextField();
		idPet.setBounds(603, 13, 116, 22);
		idPet.setVisible(false);
		contentPane.add(idPet);
		idPet.setColumns(10);
		
		list = new JList();
		list.setBounds(554, 129, 158, 446);
		contentPane.add(list);
		
		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor.setBounds(554, 108, 56, 16);
		contentPane.add(lblTutor);
		
		listVet = new JList();
		listVet.setEnabled(false);
		listVet.setBounds(714, 129, 144, 447);
		contentPane.add(listVet);
		
		JLabel lblVeterinrio_1 = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio_1.setBounds(714, 111, 87, 16);
		contentPane.add(lblVeterinrio_1);
		
		listData = new JList();
		listData.setEnabled(false);
		listData.setBounds(870, 129, 97, 446);
		contentPane.add(listData);
		
		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData_1.setBounds(869, 108, 56, 16);
		contentPane.add(lblData_1);
		
		JLabel lblHora_1 = new JLabel("Hora:");
		lblHora_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora_1.setBounds(979, 108, 56, 16);
		contentPane.add(lblHora_1);
		
		listHora = new JList();
		listHora.setEnabled(false);
		listHora.setBounds(979, 129, 83, 446);
		contentPane.add(listHora);
	}
}
