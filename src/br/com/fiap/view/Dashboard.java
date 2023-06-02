package br.com.fiap.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.model.Feedback;
import br.com.fiap.repository.FeedbackDAO;

import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private FeedbackDAO fbDAO = new FeedbackDAO();
	private JButton resolverBtn;
	private JButton btnVoltar;
	private JButton apagarBtn;
	private JLabel lblDataEntrada;
	private JLabel lblDataResoluo;
	private JLabel lblMotivo;
	private JLabel lblId;
	private JLabel lblAssunto;
	private JLabel lblMensagem;
	private JLabel lblStatus;
	public DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/br/com/fiap/icon/dashico.png")));
		setTitle("Feedbacks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 500);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setFont(new Font("SansSerif", Font.BOLD, 11));
		model = (DefaultTableModel) table.getModel();
		table.setBounds(22, 72, 664, 317);
		model.addColumn("ID");
		model.addColumn("Data Entrada");
		model.addColumn("Data Saida");
		model.addColumn("Motivo");
		model.addColumn("Assunto");
		model.addColumn("Conteudo");
		model.addColumn("Status");
		preencherTabela();
		contentPane.add(table);
		


		JLabel headerLabel = new JLabel("LISTA DE FEEDBACKS");
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(10, 23, 688, 14);
		contentPane.add(headerLabel);

		JButton alterarBtn = new JButton("ALTERAR");
		alterarBtn.setBackground(new Color(240, 240, 240));
		
		alterarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				editar();
				limparTabela();
				try {
					preencherTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		alterarBtn.setBounds(22, 400, 100, 24);

		contentPane.add(alterarBtn);

		resolverBtn = new JButton("RESOLVER");
		resolverBtn.setBackground(new Color(240, 240, 240));
		resolverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				resolver();
				limparTabela();
				try {
					preencherTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		resolverBtn.setBounds(132, 400, 100, 24);
		contentPane.add(resolverBtn);

		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Menu().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(586, 400, 100, 24);
		contentPane.add(btnVoltar);

		apagarBtn = new JButton("APAGAR");
		apagarBtn.setBackground(new Color(240, 240, 240));
		apagarBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					apagar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				limparTabela();
				try {
					preencherTabela();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		apagarBtn.setBounds(476, 400, 100, 24);
		contentPane.add(apagarBtn);

		
		
		JLabel errorLabel = new JLabel("CLIQUE NO ID PARA EXECUTAR AS AÇÕES");
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
		errorLabel.setBounds(242, 405, 224, 14);
		contentPane.add(errorLabel);

		lblDataEntrada = new JLabel("DATA ENTRADA");
		lblDataEntrada.setBounds(116, 48, 91, 14);
		contentPane.add(lblDataEntrada);

		lblDataResoluo = new JLabel("DATA SAIDA");
		lblDataResoluo.setBounds(216, 48, 91, 14);
		contentPane.add(lblDataResoluo);

		lblMotivo = new JLabel("MOTIVO");
		lblMotivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotivo.setBounds(285, 48, 91, 14);
		contentPane.add(lblMotivo);

		lblId = new JLabel("ID");
		lblId.setBounds(21, 48, 50, 14);
		contentPane.add(lblId);

		lblAssunto = new JLabel("ASSUNTO");
		lblAssunto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssunto.setBounds(386, 48, 91, 14);
		contentPane.add(lblAssunto);

		lblMensagem = new JLabel("MENSAGEM");
		lblMensagem.setBounds(500, 48, 91, 14);
		contentPane.add(lblMensagem);

		lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(595, 48, 91, 14);
		contentPane.add(lblStatus);

	}

	private void preencherTabela() throws SQLException {
		List<Feedback> fbList = fbDAO.selectAll();

		try {
			for (Feedback fb : fbList) {

				model.addRow(new Object[] { fb.getId(), dateFormat.format(fb.getDataEntrada()), fb.getDataSaida(),
						fb.getMotivo(), fb.getAssunto(), fb.getConteudo(), fb.getStatus() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void editar() {
		Object objetoDaLinha = (Object) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {

			Integer id = (Integer) objetoDaLinha;
			String msg = (String) model.getValueAt(table.getSelectedRow(), 5);
			String status = (String) model.getValueAt(table.getSelectedRow(), 6);
			Feedback fb = new Feedback();
			fb.setStatus(status);

			if (!fb.getStatus().equals("Resolvido")) {
				fb.setId(id);
				System.out.println(status);
				fb.setConteudo(msg);
				this.fbDAO.update(fb);
				JOptionPane.showMessageDialog(this, "Item alterado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(this, "Feedback resolvido, impossivel alterar");

			}

		} else {
			JOptionPane.showMessageDialog(this, "Selecione o ID antes de apertar o botão");
		}

	}

	private void apagar() throws SQLException {
		Object objetoDaLinha = (Object) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			this.fbDAO.delete(id);
			model.removeRow(table.getSelectedRow());
		} else {
			JOptionPane.showMessageDialog(this, "Selecione o ID antes de apertar o botão");
		}
	}

	private void resolver() {
		Object objetoDaLinha = (Object) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		if (objetoDaLinha instanceof Integer) {
			Integer id = (Integer) objetoDaLinha;
			Feedback fb = new Feedback();
			fb.setId(id);
			this.fbDAO.resolver(fb);
		} else {
			JOptionPane.showMessageDialog(this, "Selecione o ID antes de apertar o botão");
		}

	}

	private void limparTabela() {
		model.getDataVector().clear();
	}
}
