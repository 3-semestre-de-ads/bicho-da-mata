package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVacina extends JFrame {

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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaVacina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaVacina.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Vacinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 586);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 66, 186, 22);
		panel.add(comboBox);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(280, 30, 164, 23);
		panel.add(lblData);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(280, 66, 186, 22);
		panel.add(comboBox_1);
		
		JLabel label = new JLabel("Veterin\u00E1rio:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 101, 164, 23);
		panel.add(label);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(12, 137, 186, 22);
		panel.add(comboBox_2);
		
		JLabel label_1 = new JLabel("Veterin\u00E1rio:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(280, 101, 164, 23);
		panel.add(label_1);
		
		JComboBox comboBox_3 = new JComboBox();
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
		
		JList list = new JList();
		list.setBounds(840, 434, -289, -299);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(544, 492, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(653, 492, 97, 25);
		contentPane.add(btnExcluir);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(761, 492, 97, 25);
		contentPane.add(btnNovo);
		
		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setBounds(544, 454, 97, 25);
		contentPane.add(btnRelatrio);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(653, 454, 97, 25);
		contentPane.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(761, 454, 97, 25);
		contentPane.add(btnSalvar);
	}

}