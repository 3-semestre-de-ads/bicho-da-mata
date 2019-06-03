package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Classe destinada para o agendamento exclusivo das vacinas dos animais da clínica bicho da mata, haverá um alerta que avisará
 * quando a data da vacina estiver se aproximando.
 * @author mauri
 *
 */
public class TelaVacina extends JFrame {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVacina frame = new TelaVacina();
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
	public TelaVacina() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaVacina.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Vacinas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 586);
		setLocationRelativeTo(null);
		toFront();
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(28, 71, 504, 446);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Veterin\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 30, 164, 23);
		panel.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(12, 66, 186, 22);
		panel.add(comboBox);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(280, 30, 164, 23);
		panel.add(lblData);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(280, 66, 186, 22);
		panel.add(comboBox_1);

		JLabel lblCliente_1 = new JLabel("Cliente:");
		lblCliente_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente_1.setBounds(12, 101, 164, 23);
		panel.add(lblCliente_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(12, 137, 186, 22);
		panel.add(comboBox_2);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(280, 101, 164, 23);
		panel.add(lblHora);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(280, 137, 186, 22);
		panel.add(comboBox_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 180, 466, 253);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(153, 255, 153));
		textPane.setBounds(12, 37, 442, 203);
		panel_1.add(textPane);

		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(12, 1, 164, 23);
		panel_1.add(label_2);

		JLabel lblVacinasAplicar = new JLabel("Vacinas \u00E0 Aplicar");
		lblVacinasAplicar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVacinasAplicar.setBounds(28, 27, 217, 31);
		contentPane.add(lblVacinasAplicar);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(543, 83, 57, 23);
		contentPane.add(lblCliente);

		textField = new JTextField();
		textField.setBounds(612, 83, 234, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JList<String> list = new JList<String>();
		list.setBounds(840, 434, -289, -299);
		contentPane.add(list);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(544, 492, 97, 25);
		contentPane.add(btnNewButton);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.setBounds(653, 492, 97, 25);
		contentPane.add(btnExcluir);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovo.setBounds(761, 492, 97, 25);
		contentPane.add(btnNovo);

		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRelatrio.setBounds(544, 454, 97, 25);
		contentPane.add(btnRelatrio);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEditar.setBounds(653, 454, 97, 25);
		contentPane.add(btnEditar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(761, 454, 97, 25);
		contentPane.add(btnSalvar);
	}
}