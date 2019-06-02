package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCalculadora extends JFrame {

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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCalculadora() {
		setTitle("Bicho da Mata - Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCalculadora.class.getResource("/imagens/fundoBichoBanco.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 351);
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
		txbDoseFarmaco_1.setBounds(190, 98, 87, 22);
		panel.add(txbDoseFarmaco_1);
		txbDoseFarmaco_1.setColumns(10);

		JComboBox cbxUnidadeDose = new JComboBox();
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
		txbConcentracaoFarmaco_1.setToolTipText("");
		txbConcentracaoFarmaco_1.setColumns(10);
		txbConcentracaoFarmaco_1.setBounds(190, 158, 87, 22);
		panel.add(txbConcentracaoFarmaco_1);

		JComboBox cbxUnidadeConcentracao = new JComboBox();
		cbxUnidadeConcentracao.setModel(new DefaultComboBoxModel(new String[] {"G", "Mg", "Mcg", "%"}));
		cbxUnidadeConcentracao.setBounds(289, 158, 70, 22);
		panel.add(cbxUnidadeConcentracao);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(12, 227, 97, 25);
		panel.add(btnVoltar);

		JLabel lblRes = new JLabel("Resposta");
		lblRes.setBounds(400, 248, 177, 37);
		contentPane.add(lblRes);
		lblRes.setFont(new Font("Tahoma", Font.BOLD, 20));
		/**
		 * Após clicar no botao calcular o programa verificará os campos textBox e os Combobox para aplicar as formulas necessarias para realizar a conversao
		 * dos medicamento. as formulas foram adiquiridas no site http://www.prontupet.com/calculadora/index.htm.
		 */
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					double n1 = Double.parseDouble(txbConcentracaoFarmaco_1.getText());
					double n2 = Double.parseDouble(txbDoseFarmaco_1.getText());
					double n3 = Double.parseDouble(txbPesoAnimal_1.getText());

					double PesoAnimal = 0, DoseFarmaco = 0, ConcentracaoFarmaco = 0;
					double Medicacao = 0;

					if (n1 == 0 || n2 == 0 || n3 == 0)
					{
						JOptionPane.showMessageDialog(null, "Campos Inválidos");
					}

				else
					{
						PesoAnimal = Double.parseDouble(txbPesoAnimal_1.getText());
						DoseFarmaco = Double.parseDouble(txbDoseFarmaco_1.getText());
						ConcentracaoFarmaco = Double.parseDouble(txbConcentracaoFarmaco_1.getText());

						if (PesoAnimal <= 0 || DoseFarmaco <= 0 || ConcentracaoFarmaco <= 0)
							JOptionPane.showMessageDialog(null, "Impossível realizar calculos com números negativos");
						else
						{
							if (cbxUnidadeDose.getSelectedItem() == "Mg" && cbxUnidadeConcentracao.getSelectedItem() == "G")
							{
								Medicacao = (PesoAnimal * DoseFarmaco) / (1000 / ConcentracaoFarmaco);
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mg" && cbxUnidadeConcentracao.getSelectedItem() == "Mg")
							{
								Medicacao = (PesoAnimal * DoseFarmaco) / ConcentracaoFarmaco;
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mg" && cbxUnidadeConcentracao.getSelectedItem() == "Mcg")
							{
								Medicacao = (PesoAnimal * DoseFarmaco) / (ConcentracaoFarmaco * 0.001);
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mg" && cbxUnidadeConcentracao.getSelectedItem() == "%")
							{
								Medicacao = (PesoAnimal * DoseFarmaco) / (ConcentracaoFarmaco * 10);
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mcg" && cbxUnidadeConcentracao.getSelectedItem() == "G")
							{
								Medicacao = (PesoAnimal * (DoseFarmaco * 0.001)) / (1000 / ConcentracaoFarmaco);
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mcg" && cbxUnidadeConcentracao.getSelectedItem() == "Mg")
							{
								Medicacao = (PesoAnimal * (DoseFarmaco * 0.001)) / ConcentracaoFarmaco;
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mcg" && cbxUnidadeConcentracao.getSelectedItem() == "Mcg")
							{
								Medicacao = (PesoAnimal * (DoseFarmaco * 0.001)) / (ConcentracaoFarmaco * 0.001);
							}
							else if (cbxUnidadeDose.getSelectedItem() == "Mcg" && cbxUnidadeConcentracao.getSelectedItem() == "%")
							{
								Medicacao = (PesoAnimal * (DoseFarmaco * 0.001)) / (ConcentracaoFarmaco * 10);
							}

							if (cbxUnidadeConcentracao.getSelectedItem() == "" || cbxUnidadeDose.getSelectedItem() == "")
							{
								JOptionPane.showMessageDialog(null, "Unidades Inválidas!");
							}
							
							else

								lblRes.setText(Medicacao + "ML");
							
						}
					}
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro de conversão!");
				}
				
				
		}


	});
		btnCalcular.setBounds(262, 227, 97, 25);
		panel.add(btnCalcular);

	}
}
