package views;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import controller.Receita;
import model.BancoDeDados;
import javax.swing.SwingConstants;

public class TelaReceita extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField txtTutor;
	public static JTextField txtVet;
	public static JTextField txtPet;
	public static JDateChooser txtRetorno;
	public static TextArea txtReceita;
	public static List lista;
	public static List lista1;
	public static SimpleDateFormat formatoBr = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReceita frame = new TelaReceita();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
				}
			}
		});
	}

	public TelaReceita() {
		
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 934, 620);
		setLocationRelativeTo(null);
		toFront();

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTutor.setBounds(12, 96, 56, 16);
		contentPane.add(lblTutor);

		txtTutor = new JTextField();
		txtTutor.setEditable(false);
		txtTutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTutor.setColumns(10);
		txtTutor.setBounds(10, 120, 172, 22);
		contentPane.add(txtTutor);

		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceita.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblReceita.setBounds(277, 11, 362, 59);
		contentPane.add(lblReceita);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 155, 916, 405);
		contentPane.add(panel);

		JLabel label_1 = new JLabel("Informa\u00E7\u00F5es:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(12, 0, 164, 23);
		panel.add(label_1);

		txtReceita = new TextArea();
		txtReceita.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtReceita.setBackground(new Color(153, 255, 153));
		txtReceita.setBounds(12, 31, 882, 399);
		panel.add(txtReceita);

		JButton btnGerarReceita = new JButton("Gerar Receita");
		btnGerarReceita.setMnemonic('G');
		btnGerarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDeDados banco = new BancoDeDados();
				banco.conectar();
				if(banco.estaConectado() == true) {
					if(Receita.verificacao(txtRetorno, txtReceita) == true) {
						banco.gerarReceita(txtRetorno, txtVet, txtPet, txtReceita);;
						banco.desconectar();
					}
				}
			}
		});
		btnGerarReceita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGerarReceita.setBounds(754, 118, 129, 25);
		contentPane.add(btnGerarReceita);

		JLabel lblVeterinrio = new JLabel("Veterin\u00E1rio:");
		lblVeterinrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVeterinrio.setBounds(354, 96, 106, 16);
		contentPane.add(lblVeterinrio);

		txtVet = new JTextField();
		txtVet.setEditable(false);
		txtVet.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtVet.setColumns(10);
		txtVet.setBounds(354, 120, 174, 22);
		contentPane.add(txtVet);

		txtPet = new JTextField();
		txtPet.setEditable(false);
		txtPet.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPet.setColumns(10);
		txtPet.setBounds(192, 120, 152, 22);
		contentPane.add(txtPet);

		JLabel label_3 = new JLabel("Pet:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(192, 96, 56, 16);
		contentPane.add(label_3);

		txtRetorno = new JDateChooser();
		txtRetorno.setBounds(538, 120, 101, 22);
		contentPane.add(txtRetorno);

		JLabel lblRetorno = new JLabel("Retorno:");
		lblRetorno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRetorno.setBounds(538, 96, 63, 16);
		contentPane.add(lblRetorno);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setMnemonic('V');
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(647, 119, 97, 25);
		contentPane.add(btnVoltar);
	}
}
