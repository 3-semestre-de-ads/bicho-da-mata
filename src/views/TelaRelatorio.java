package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import service.BancoDeDados;

public class TelaRelatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");
	public static JDateChooser txtInicio;
	public static JDateChooser txtFinal;
	public static JLabel somaVacinas;
	public static JTable tblResult;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 709);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRelatrio = new JLabel("Relat\u00F3rios");
		lblRelatrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelatrio.setBounds(12, 13, 164, 38);
		contentPane.add(lblRelatrio);

		JLabel lblVeterinrio = new JLabel("Data Inicio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(12, 67, 81, 16);
		contentPane.add(lblVeterinrio);

		JLabel lblClientes = new JLabel("Data Final:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClientes.setBounds(254, 67, 103, 16);
		contentPane.add(lblClientes);

		JDateChooser txtInicio = new JDateChooser();
		txtInicio.setBounds(95, 64, 109, 22);
		contentPane.add(txtInicio);

		JDateChooser txtFinal = new JDateChooser();
		txtFinal.setBounds(325, 64, 109, 22);
		contentPane.add(txtFinal);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datainicio =  formatoBr.format(txtInicio.getDate());
				String datafinal = formatoBr.format(txtFinal.getDate());
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				banco.gerarRelatorio(datainicio , datafinal, somaVacinas);
				banco.relatorio(datainicio, datafinal, tblResult);
				banco.desconectar();
			}
		});
		btnPesquisar.setBounds(501, 63, 97, 25);
		contentPane.add(btnPesquisar);

		JLabel lblTotalDeAtendimentos = new JLabel("Total de Vacinas no per\u00EDodo:");
		lblTotalDeAtendimentos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDeAtendimentos.setBounds(12, 564, 204, 16);
		contentPane.add(lblTotalDeAtendimentos);

		JLabel lblTotalDeConsultas = new JLabel("Total de Consultas no per\u00EDodo:");
		lblTotalDeConsultas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDeConsultas.setBounds(12, 535, 204, 16);
		contentPane.add(lblTotalDeConsultas);

		JLabel lblTotalDeCirurgia = new JLabel("Total de Cirurgia no per\u00EDodo:");
		lblTotalDeCirurgia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDeCirurgia.setBounds(12, 594, 204, 16);
		contentPane.add(lblTotalDeCirurgia);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(226, 535, 56, 16);
		contentPane.add(lblNewLabel);

		somaVacinas = new JLabel("New label");
		somaVacinas.setBounds(226, 564, 390, 16);
		contentPane.add(somaVacinas);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(226, 594, 56, 16);
		contentPane.add(lblNewLabel_2);

		tblResult = new JTable();

		tblResult.setBounds(37, 146, 561, 346);
		contentPane.add(tblResult);
	}
}
