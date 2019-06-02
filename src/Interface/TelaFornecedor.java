package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private JTextField txtTelefone;
	private JTextField txtContato;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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
	public TelaFornecedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaFornecedor.class.getResource("/imagens/fundoBichoBanco.png")));
		setTitle("Bicho da Mata - Fornecedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Dados do Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 78, 495, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da Empresa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 20, 128, 26);
		panel.add(lblNewLabel);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCnpj.setBounds(266, 20, 128, 26);
		panel.add(lblCnpj);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 55, 219, 22);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(264, 55, 219, 22);
		panel.add(txtCnpj);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(264, 135, 219, 22);
		panel.add(txtTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(266, 100, 128, 26);
		panel.add(lblTelefone);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(12, 135, 219, 22);
		panel.add(txtContato);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContato.setBounds(12, 100, 128, 26);
		panel.add(lblContato);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 181, 466, 253);
		panel.add(panel_1);
		
		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setBackground(new Color(153, 255, 153));
		txtDescricao.setBounds(12, 37, 442, 203);
		panel_1.add(txtDescricao);
		
		JLabel lblProdutos = new JLabel("Produtos:");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProdutos.setBounds(12, 1, 164, 23);
		panel_1.add(lblProdutos);
		
		JLabel label = new JLabel("Cliente:");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(556, 91, 57, 23);
		contentPane.add(label);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(625, 91, 234, 22);
		contentPane.add(textField_4);
		
		JList list = new JList();
		list.setBounds(853, 429, -289, -299);
		contentPane.add(list);
		
		JButton button = new JButton("Relat\u00F3rio");
		button.setBounds(557, 449, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setBounds(666, 449, 97, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Salvar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			BancoDeDados banco = new BancoDeDados();
			banco.conectar();
			banco.inserirContato(txtNome.getText(), txtCnpj.getText(), txtContato.getText(), txtTelefone.getText(), txtDescricao.getText());
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
			banco.desconectar();
			dispose();
			}
		});
		button_2.setBounds(774, 449, 97, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Novo");
		button_3.setBounds(774, 487, 97, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Excluir");
		button_4.setBounds(666, 487, 97, 25);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Voltar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setBounds(557, 487, 97, 25);
		contentPane.add(button_5);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFornecedor.setBounds(35, 13, 164, 38);
		contentPane.add(lblFornecedor);
	}

}
