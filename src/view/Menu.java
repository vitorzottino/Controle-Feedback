package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(105, 134, 223, 20);
		contentPane.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RECLAMAÇÃO", "SUGESTÃO"}));
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		comboBox.setBounds(105, 78, 223, 22);
		contentPane.add(comboBox);
		
		JLabel lblAssunto = new JLabel("ASSUNTO:");
		lblAssunto.setFont(new Font("Calibri", Font.BOLD, 12));
		lblAssunto.setBounds(105, 121, 52, 15);
		contentPane.add(lblAssunto);
		
		JLabel lblMensagem = new JLabel("MENSAGEM: ");
		lblMensagem.setFont(new Font("Calibri", Font.BOLD, 12));
		lblMensagem.setBounds(105, 165, 67, 15);
		contentPane.add(lblMensagem);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(105, 181, 223, 79);
		contentPane.add(textArea);
	}
}
