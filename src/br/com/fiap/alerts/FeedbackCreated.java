package br.com.fiap.alerts;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.fiap.view.Menu;

public class FeedbackCreated extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackCreated frame = new FeedbackCreated();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FeedbackCreated() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FEEDBACK CADASTRADO");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 35, 184, 25);
		contentPane.add(lblNewLabel);

		JButton voltarBtn = new JButton("VOLTAR ");
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Menu().setVisible(true);
				dispose();
			}
		});
		voltarBtn.setFont(new Font("SansSerif", Font.PLAIN, 12));
		voltarBtn.setBounds(50, 100, 85, 25);
		contentPane.add(voltarBtn);

		JLabel lblObrigado = new JLabel("OBRIGADO!");
		lblObrigado.setHorizontalAlignment(SwingConstants.CENTER);
		lblObrigado.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblObrigado.setBounds(0, 58, 184, 25);
		contentPane.add(lblObrigado);
	}

}
