package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.Calculadora;
/**
 * Nesta classe sera desenvolvida uma calculadora de doses de medicamentos que os veterinarios utilizam 
 * para saber qual a dose necessaria para cada animal de acordo com o seu peso, dose do farmaco e concentracao.
 * @author mauri
 *
 */

public class TelaCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txbPesoAnimal_1;
	private JTextField txbDoseFarmaco_1;
	private JTextField txbConcentracaoFarmaco_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCalculadora frame = new TelaCalculadora();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaCalculadora() {
		
		setResizable(false);
		setTitle("Bicho da Mata - Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCalculadora.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 602, 351);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCalculadora.class.getResource("/imagens/CelularBichoDaMata.png")));
		label.setBounds(390, 13, 182, 230);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Calculadora de Doses", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 371, 272);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPeso = new JLabel("Peso do Animal:");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPeso.setBounds(12, 42, 129, 16);
		panel.add(lblPeso);

		txbPesoAnimal_1 = new JTextField();
		txbPesoAnimal_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txbPesoAnimal_1.setBounds(190, 39, 87, 22);
		panel.add(txbPesoAnimal_1);
		txbPesoAnimal_1.setColumns(10);

		JLabel lblKgs = new JLabel("Kgs");
		lblKgs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKgs.setBounds(303, 42, 56, 16);
		panel.add(lblKgs);

		JLabel lblDoseDoFrmaco = new JLabel("Dose do F\u00E1rmaco:");
		lblDoseDoFrmaco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoseDoFrmaco.setBounds(12, 101, 129, 16);
		panel.add(lblDoseDoFrmaco);

		txbDoseFarmaco_1 = new JTextField();
		txbDoseFarmaco_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txbDoseFarmaco_1.setBounds(190, 98, 87, 22);
		panel.add(txbDoseFarmaco_1);
		txbDoseFarmaco_1.setColumns(10);

		JComboBox<String> cbxUnidadeDose = new JComboBox<String>();
		cbxUnidadeDose.setModel(new DefaultComboBoxModel(new String[] {"Mg", "Mcg"}));
		cbxUnidadeDose.setToolTipText("");
		cbxUnidadeDose.setBounds(289, 98, 70, 22);
		panel.add(cbxUnidadeDose);
		cbxUnidadeDose.getSelectedItem();

		JLabel lblConcentraoDoFrmaco = new JLabel("Concentra\u00E7\u00E3o do F\u00E1rmaco:");
		lblConcentraoDoFrmaco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConcentraoDoFrmaco.setBounds(12, 161, 189, 16);
		panel.add(lblConcentraoDoFrmaco);

		txbConcentracaoFarmaco_1 = new JTextField();
		txbConcentracaoFarmaco_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txbConcentracaoFarmaco_1.setToolTipText("");
		txbConcentracaoFarmaco_1.setColumns(10);
		txbConcentracaoFarmaco_1.setBounds(190, 158, 87, 22);
		panel.add(txbConcentracaoFarmaco_1);

		JComboBox cbxUnidadeConcentracao = new JComboBox();
		cbxUnidadeConcentracao.setModel(new DefaultComboBoxModel(new String[] {"G", "Mg", "Mcg", "%"}));
		cbxUnidadeConcentracao.setBounds(289, 158, 70, 22);
		panel.add(cbxUnidadeConcentracao);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(12, 227, 97, 25);
		panel.add(btnVoltar);

		JLabel lblRes = new JLabel("");
		lblRes.setBounds(400, 248, 177, 37);
		contentPane.add(lblRes);
		lblRes.setFont(new Font("Tahoma", Font.BOLD, 20));
		/**
		 * Após clicar no botao calcular o programa verificará os campos textBox e os Combobox para aplicar as formulas necessarias para realizar a conversao
		 * dos medicamento. as formulas foram adiquiridas no site http://www.prontupet.com/calculadora/index.htm.
		 */
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCalcular.setMnemonic('C');
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculadora.calcular(txbConcentracaoFarmaco_1, txbDoseFarmaco_1, txbPesoAnimal_1, cbxUnidadeDose, cbxUnidadeConcentracao, lblRes);
			}
		});
		btnCalcular.setBounds(262, 227, 97, 25);
		panel.add(btnCalcular);
	}
}