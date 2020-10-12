package br.com.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.db.ClienteTemporario;
import br.com.db.HibernateUtil;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHibrida {

	private static JFrame frmTransferir;
	private JLabel labelSaldo;
	private JLabel labelConta;
	private JLabel labelNomeCliente;
	private JLabel labelCifrao;
	private JLabel labelNumeroConta;
	private JLabel lblNewLabel;
	private JTextField contaDestinoTextField;
	private JTextField valorTextField;
	private ClienteTemporario clienteTemporario;
	private JLabel lblValor;
	private String textoHibrido;
	private TelaUtil telaUtil;
	private static TelaPrincipal telaPrincipal;
	/**
	 * Launch the application.
	 */
	public void iniciaTela(TelaHibrida telaHibrida) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					telaHibrida.frmTransferir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param clienteTemporario 
	 * @param acao 
	 */
	public TelaHibrida(String acao, ClienteTemporario clienteTemporario) {
		telaUtil = new TelaUtil();
		this.textoHibrido = acao;
		this.clienteTemporario = clienteTemporario;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransferir = new JFrame();
		frmTransferir.setTitle(textoHibrido);
		frmTransferir.setBounds(100, 100, 450, 200);
		frmTransferir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTransferir.getContentPane().setLayout(null);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 170);
		frmTransferir.getContentPane().add(panel);
		panel.setLayout(null);
		
		labelSaldo = new JLabel(String.valueOf(clienteTemporario.getSaldo()));
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelSaldo.setBounds(302, 11, 122, 14);
		panel.add(labelSaldo);
		
		labelConta = new JLabel("Conta:");
		labelConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelConta.setBounds(10, 30, 46, 14);
		panel.add(labelConta);
		
		labelNomeCliente = new JLabel(clienteTemporario.getNome());
		labelNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNomeCliente.setBounds(10, 11, 288, 14);
		panel.add(labelNomeCliente);
		
		labelCifrao = new JLabel("R$");
		labelCifrao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelCifrao.setBounds(274, 11, 26, 14);
		panel.add(labelCifrao);
		
		labelNumeroConta = new JLabel(String.valueOf(clienteTemporario.getNumeroConta()));
		labelNumeroConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNumeroConta.setBounds(54, 31, 46, 14);
		panel.add(labelNumeroConta);
		
		lblNewLabel = new JLabel("Conta Destino");
		lblNewLabel.setBounds(10, 58, 90, 14);
		panel.add(lblNewLabel);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(247, 58, 90, 14);
		panel.add(lblValor);
		
		contaDestinoTextField = new JTextField();
		contaDestinoTextField.setBounds(101, 55, 86, 20);
		panel.add(contaDestinoTextField);
		contaDestinoTextField.setColumns(10);
		
		JButton btnNewButton = new JButton(textoHibrido);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaUtil.efetuaAcaoHibrida(Double.parseDouble(valorTextField.getText()), clienteTemporario, textoHibrido);
			
				
			}
		});
		btnNewButton.setBounds(10, 86, 414, 54);
		panel.add(btnNewButton);
		
		valorTextField = new JTextField();
		valorTextField.setColumns(10);
		valorTextField.setBounds(338, 55, 86, 20);
		panel.add(valorTextField);
		
		
	}
	
	public static void acaoBemSucedida(ClienteTemporario clienteTemporario) {
		frmTransferir.dispose();
		telaPrincipal = new TelaPrincipal(clienteTemporario);
		telaPrincipal.iniciaTela(telaPrincipal);
	}
	
}
