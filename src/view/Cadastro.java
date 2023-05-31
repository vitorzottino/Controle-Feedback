package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import alerts.UserCreated;
import model.Feedback;
import repository.FeedbackDAO;
import java.awt.Toolkit;

public class Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField assuntoTxt;
	private FeedbackDAO dao = new FeedbackDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Cadastro() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/imgs/dashico.png")));
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel headerLabel = new JLabel("FORMULÁRIO DE CADASTRO");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 12));
		headerLabel.setBounds(10, 11, 414, 14);
		contentPane.add(headerLabel);

		JLabel motivoLabel = new JLabel("MOTIVO: ");
		motivoLabel.setFont(new Font("Calibri", Font.BOLD, 12));
		motivoLabel.setBounds(105, 65, 56, 14);
		contentPane.add(motivoLabel);

		assuntoTxt = new JTextField();
		assuntoTxt.setBackground(new Color(240, 240, 240));
		assuntoTxt.setColumns(10);
		assuntoTxt.setBounds(105, 157, 223, 20);
		contentPane.add(assuntoTxt);

		JComboBox<String> motivoBox = new JComboBox<String>();
		motivoBox.setBackground(new Color(240, 240, 240));
		motivoBox.setMaximumRowCount(2);
		motivoBox.setModel(new DefaultComboBoxModel(new String[] { "Reclamacao", "Sugestao" }));
		motivoBox.setFont(new Font("SansSerif", Font.BOLD, 11));
		motivoBox.setBounds(105, 78, 223, 29);
		contentPane.add(motivoBox);

		JLabel assuntoLabel = new JLabel("ASSUNTO:");
		assuntoLabel.setFont(new Font("Calibri", Font.BOLD, 12));
		assuntoLabel.setBounds(105, 142, 52, 15);
		contentPane.add(assuntoLabel);

		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(128, 0, 0));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		errorLabel.setBounds(105, 321, 223, 14);
		contentPane.add(errorLabel);

		JLabel mensagemLabel = new JLabel("MENSAGEM: ");
		mensagemLabel.setFont(new Font("Calibri", Font.BOLD, 12));
		mensagemLabel.setBounds(105, 200, 67, 15);
		contentPane.add(mensagemLabel);

		JTextArea mensagemTxt = new JTextArea();
		mensagemTxt.setBackground(new Color(240, 240, 240));
		mensagemTxt.setBounds(105, 214, 223, 79);
		contentPane.add(mensagemTxt);

		JButton enviarBtn = new JButton("ENVIAR");
		enviarBtn.setBackground(new Color(240, 240, 240));
		enviarBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

		enviarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (assuntoTxt.getText().isBlank() || assuntoLabel.getText().isBlank()) {
					errorLabel.setText("PREENCHA TODOS OS CAMPOS!");
				} else {
					Feedback fb = new Feedback();
					fb.setMotivo(motivoBox.getSelectedItem().toString());
					fb.setAssunto(assuntoTxt.getText());
					fb.setConteudo(mensagemTxt.getText());

					try {
						dao.insert(fb);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new UserCreated().setVisible(true);
					dispose();
				}
			}
		});
		enviarBtn.setBounds(105, 370, 223, 23);
		contentPane.add(enviarBtn);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnVoltar.setBounds(105, 404, 223, 23);
		contentPane.add(btnVoltar);

	}
}
