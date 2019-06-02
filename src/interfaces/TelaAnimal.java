package interfaces;

import connection.BancoDeDados;
//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
//import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
//import javax.xml.crypto.Data;
import javax.swing.UIManager;
import java.awt.Toolkit;
//import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
//import java.awt.Window.Type;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
/**
 * Esta classe sera utilizada para receber todas as informacoes importante que se refere ao animal a ser tratado pela clinica;
 * um metodo criado pela classe BancoDeDados sera responsavel pelo CRUD a ser enviado junto ao banco de dados.
 * @author mauri
 *
 */
public class TelaAnimal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
	public static JRadioButton opMacho = new JRadioButton("Macho");
	public static JRadioButton opFemea = new JRadioButton("F\u00EAmea");
	public static JRadioButton opSim = new JRadioButton("Sim");
	public static JRadioButton opNao = new JRadioButton("N\u00E3o");
	public static JPanel contentPane;
	public static JTextField txtNome;
	public static JTextField txtRaca;
	public static JTextField txtEspecie;
	public static JTextField txtNascimento;
	public static JTextField txtCor;
	public static JTextField txtBuscaDono;
	public static JTextField txtDono;
	public static JTextField txtClie;
	public static JList<String> list;
	public static JList<String> listName;
	public static JList<String> list2;
	public static JTextField txtAnimal;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	public static final ButtonGroup buttonGroup1 = new ButtonGroup();
	public static JTextField txtDataFicha;
	public static JTextArea txtObs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnimal frame = new TelaAnimal();
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
	public TelaAnimal() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Bicho da Mata - Pet's");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAnimal.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Animal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 58, 512, 480);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblDono = new JLabel("Dono:");
		lblDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDono.setBounds(12, 62, 56, 16);
		panel.add(lblDono);

		JLabel lblRaa = new JLabel("Nome:");
		lblRaa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaa.setBounds(296, 62, 56, 16);
		panel.add(lblRaa);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNome.setBounds(295, 86, 172, 22);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblRaa_1 = new JLabel("Ra\u00E7a:");
		lblRaa_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaa_1.setBounds(296, 133, 56, 16);
		panel.add(lblRaa_1);

		txtRaca = new JTextField();
		txtRaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRaca.setColumns(10);
		txtRaca.setBounds(295, 157, 172, 22);
		panel.add(txtRaca);

		JLabel lblEspcie = new JLabel("Esp\u00E9cie:");
		lblEspcie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspcie.setBounds(13, 133, 56, 16);
		panel.add(lblEspcie);

		txtEspecie = new JTextField();
		txtEspecie.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(12, 157, 172, 22);
		panel.add(txtEspecie);

		JLabel label = new JLabel("Sexo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 202, 56, 16);
		panel.add(label);



		opMacho.setFont(new Font("Tahoma", Font.BOLD, 13));
		opMacho.setBackground(Color.WHITE);
		opMacho.setBounds(12, 227, 78, 25);
		buttonGroup.add(opMacho);
		panel.add(opMacho);


		opFemea.setFont(new Font("Tahoma", Font.BOLD, 13));
		opFemea.setBackground(Color.WHITE);
		opFemea.setBounds(109, 227, 127, 25);
		buttonGroup.add(opFemea);
		panel.add(opFemea);



		opNao.setFont(new Font("Tahoma", Font.BOLD, 13));
		opNao.setBackground(Color.WHITE);
		opNao.setBounds(373, 227, 127, 25);
		buttonGroup1.add(opNao);
		panel.add(opNao);

		JLabel lblCastrado = new JLabel("Castrado?");
		lblCastrado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCastrado.setBounds(296, 202, 87, 16);
		panel.add(lblCastrado);


		opSim.setFont(new Font("Tahoma", Font.BOLD, 13));
		opSim.setBackground(Color.WHITE);
		opSim.setBounds(296, 227, 73, 25);
		buttonGroup1.add(opSim);
		panel.add(opSim);

		JLabel label_1 = new JLabel("Data de Nascimento:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(12, 272, 144, 16);
		panel.add(label_1);

		txtNascimento = new JTextField();
		txtNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNascimento.setColumns(10);
		txtNascimento.setBounds(12, 301, 172, 22);
		panel.add(txtNascimento);

		JLabel lblDataDeNascimcorento = new JLabel("Cor:");
		lblDataDeNascimcorento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimcorento.setBounds(296, 272, 144, 16);
		panel.add(lblDataDeNascimcorento);

		txtCor = new JTextField();
		txtCor.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCor.setColumns(10);
		txtCor.setBounds(296, 301, 171, 22);
		panel.add(txtCor);

		txtDono = new JTextField();
		txtDono.setEditable(false);
		txtDono.setEnabled(false);
		txtDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDono.setBounds(12, 86, 172, 22);
		panel.add(txtDono);
		txtDono.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(372, 0, 140, 59);
		panel.add(panel_2);

		txtDataFicha = new JTextField();
		txtDataFicha.setToolTipText("Data de Hoje");
		txtDataFicha.setText("04/04/2019");
		txtDataFicha.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDataFicha.setEditable(false);
		txtDataFicha.setColumns(10);
		txtDataFicha.setBounds(12, 24, 116, 22);
		panel_2.add(txtDataFicha);

		JLabel lblObs = new JLabel("Obs:");
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObs.setBounds(12, 336, 56, 16);
		panel.add(lblObs);

		txtObs = new JTextArea();
		txtObs.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtObs.setBackground(new Color(0, 153, 102));
		txtObs.setBounds(12, 358, 488, 75);
		panel.add(txtObs);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(403, 442, 97, 25);
		panel.add(btnEditar);
		btnEditar.setVisible(false);
		btnEditar.setMnemonic('E');
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseija realmente editar?", "Editar", JOptionPane.YES_NO_OPTION );
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					banco.editarAnimal(opMacho, opFemea, opSim, opNao, Integer.parseInt(txtAnimal.getText()), txtNome.getText(), txtEspecie.getText(), txtRaca.getText(), txtNascimento.getText(), txtCor.getText(), txtDataFicha.getText(), txtObs.getText());;
					banco.pesquisarAnimal(txtDono, list, listName, list2);
					banco.desconectar();

				}
				else {
					JOptionPane.showMessageDialog(null, txtNome.getText()+ " N�o Editado");
				}
			}});


		JLabel lblAnimal = new JLabel("Animal");
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnimal.setBounds(12, 13, 134, 32);
		contentPane.add(lblAnimal);
		Date d = new Date();

		JButton btnNovo = new JButton("Novo");
		btnNovo.setMnemonic('N');
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtEspecie.setText("");
				opSim.setSelected(false);
				opMacho.setSelected(false);
				txtNascimento.setText("");
				txtCor.setText("");
				txtRaca.setText("");
				txtObs.setText("");
				txtNome.setEditable(true);
				txtEspecie.setEditable(true);
				txtRaca.setEditable(true);
				txtObs.setEditable(true);
				opMacho.setEnabled(true);
				opFemea.setEnabled(true);
				opSim.setEnabled(true);
				opNao.setEnabled(true);
				txtNascimento.setEditable(true);
				txtCor.setEditable(true);
				btnEditar.setVisible(false);
				txtDataFicha.setText(formatoBr.format(d));

			}
		});
		btnNovo.setBounds(557, 457, 97, 25);
		contentPane.add(btnNovo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setMnemonic('S');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Salvar?", "Salvar",JOptionPane.YES_OPTION);
				try {
					if (resposta == JOptionPane.YES_OPTION) {
						BancoDeDados banco = new BancoDeDados();
						banco.conectar();
						banco.salvarAnimal(opMacho, opFemea, opSim, opNao, Integer.parseInt(txtClie.getText()), txtNome.getText(), txtEspecie.getText(), txtRaca.getText(), txtNascimento.getText(), txtCor.getText(), txtDataFicha.getText(), txtObs.getText());
						banco.pesquisarAnimal(txtDono, list, listName, list2);
						banco.desconectar();
						
						txtNome.setText("");
						txtEspecie.setText("");
						opSim.setSelected(false);
						opMacho.setSelected(false);
						txtNascimento.setText("");
						txtCor.setText("");
						txtRaca.setText("");
						txtObs.setText("");

					} else if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Cadastro n�o Salvo");

					}

				} catch (Exception ee) {


				}}});
		btnSalvar.setBounds(805, 457, 97, 63);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic('X');
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Exluir",JOptionPane.YES_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					BancoDeDados banco = new BancoDeDados();
					banco.conectar();
					banco.excluirAnimal(Integer.parseInt(txtAnimal.getText()));
					banco.pesquisarAnimal(txtDono, list, listName, list2);
					banco.desconectar();

					txtNome.setText("");
					txtEspecie.setText("");
					opSim.setSelected(false);
					opMacho.setSelected(false);
					txtNascimento.setText("");
					txtCor.setText("");
					txtRaca.setText("");
					txtObs.setText("");
					txtNome.setEditable(true);
					txtEspecie.setEditable(true);
					txtRaca.setEditable(true);
					txtObs.setEditable(true);
					opMacho.setEnabled(true);
					opFemea.setEnabled(true);
					opSim.setEnabled(true);
					opNao.setEnabled(true);
					txtNascimento.setEditable(true);
					txtCor.setEditable(true);
					btnEditar.setVisible(true);
					txtDataFicha.setText(formatoBr.format(d));

				}else if (resposta == JOptionPane.NO_OPTION) {

				}

			}});
		btnExcluir.setBounds(682, 495, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(557, 495, 97, 25);
		contentPane.add(btnVoltar);

		txtClie = new JTextField();
		txtClie.setBounds(557, 21, 116, 22);
		contentPane.add(txtClie);
		txtClie.setEnabled(false);
		txtClie.setEditable(false);
		txtClie.setColumns(10);

		txtAnimal = new JTextField();
		txtAnimal.setVisible(true);
		txtAnimal.setEnabled(false);
		txtAnimal.setEditable(false);
		txtAnimal.setBounds(399, 21, 116, 22);
		contentPane.add(txtAnimal);
		txtAnimal.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(536, 59, 366, 374);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);

		JLabel label_2 = new JLabel("Dono:");
		label_2.setBounds(27, 29, 56, 16);
		panel_1.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtBuscaDono = new JTextField();
		txtBuscaDono.setBounds(72, 26, 282, 22);
		panel_1.add(txtBuscaDono);
		txtBuscaDono.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.pesquisarAnimal(txtDono, list, listName, list2);
				banco.desconectar();
			}
		});
		txtBuscaDono.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBuscaDono.setColumns(10);

		list = new JList<String>();
		list.setEnabled(false);
		list.setBounds(142, 76, 126, 285);
		panel_1.add(list);
		list.setValueIsAdjusting(true);


		listName = new JList<String>();
		listName.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		listName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					txtNome.setEditable(true);
					txtEspecie.setEditable(true);
					txtRaca.setEditable(true);
					txtObs.setEditable(true);
					opMacho.setEnabled(true);
					opFemea.setEnabled(true);
					opSim.setEnabled(true);
					opNao.setEnabled(true);
					txtNascimento.setEditable(true);
					txtCor.setEditable(true);
					btnEditar.setVisible(true);
					txtDataFicha.setText(formatoBr.format(d));
				}else {
					txtNome.setEditable(false);
					txtEspecie.setEditable(false);
					txtRaca.setEditable(false);
					txtObs.setEditable(false);
					opMacho.setEnabled(false);
					opFemea.setEnabled(false);
					opSim.setEnabled(false);
					opNao.setEnabled(false);
					txtNascimento.setEditable(false);
					txtCor.setEditable(false);
					btnEditar.setVisible(false);
				}
			}
		});
		listName.setBounds(27, 76, 103, 285);
		panel_1.add(listName);

		JLabel lblNome = new JLabel("Pet");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(27, 47, 56, 16);
		panel_1.add(lblNome);

		JLabel lblPet = new JLabel("Tutor");
		lblPet.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPet.setBounds(142, 47, 56, 16);
		panel_1.add(lblPet);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(270, 47, 56, 16);
		panel_1.add(lblData);

		list2 = new JList<String>();
		list2.setValueIsAdjusting(true);
		list2.setEnabled(false);
		list2.setBounds(270, 76, 84, 285);
		panel_1.add(list2);

		JButton btnFicha_1 = new JButton("Ficha");
		btnFicha_1.setMnemonic('F');
		btnFicha_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFicha telaFicha = new TelaFicha();
				BancoDeDados banco = new BancoDeDados();	
				banco.conectar();
				banco.fichaAnimal(list, txtDono, txtClie, txtAnimal);
				//banco.idVeterinario(comboVet, txtIdVet);
				//banco.pesquisarVacina();
				telaFicha.setVisible(true);
				//banco.setVet();
				banco.desconectar();
			}
		});
		btnFicha_1.setBounds(682, 457, 97, 25);
		contentPane.add(btnFicha_1);
		listName.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.pesquisarAnimal(txtDono, list, listName, list2);
				banco.desconectar();
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

			}
		});
	}
}
