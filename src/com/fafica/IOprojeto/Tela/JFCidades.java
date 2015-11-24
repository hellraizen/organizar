package com.fafica.IOprojeto.Tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.fafica.IOprojeto.arquivoIO.LeituraArquivo;
import com.fafica.IOprojeto.ordenador.Ordenar;

public class JFCidades extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCidades frame = new JFCidades();
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
	public JFCidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Ler Arquivo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lerArquivoEntrada();
					listar(lerArquivoEntrada());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});

		JButton btnOrdenar = new JButton("Ordenar");

		JButton btnListaEncadeada = new JButton("Lista Encadeada");
		btnListaEncadeada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		JButton btnSalvarEIo = new JButton("Salvar e I/o");

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 230,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOrdenar, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnListaEncadeada, GroupLayout.PREFERRED_SIZE, 230,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvarEIo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(23)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnOrdenar, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnListaEncadeada, GroupLayout.PREFERRED_SIZE, 47,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSalvarEIo,
												GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(16, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)));

		table = new JTable();
		String[] cabecalho = new String[] { "Id", "Cidade" };
		Object[][] tabela = {};
		defaultCidade = new DefaultTableModel(tabela, cabecalho);
		table.setModel(defaultCidade);

		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	private String[] lerArquivoEntrada() throws IOException {
		String caminho = JOptionPane.showInputDialog("Caminho Path Do Txt");

		LeituraArquivo ler = new LeituraArquivo();
		String[] cidadesMatris = ler.leitura(caminho);

		return cidadesMatris;

	}

	private String[] ordenador() throws IOException {
		Ordenar ordenador = new Ordenar();
		String[] ordenado = ordenador.ordenar(lerArquivoEntrada());

		return ordenado;

	}

	private void listar(String[] array) {
		this.limparTabelaCliente();
		int i = 0;
		for (String cidade : array) {
			Vector vector = new Vector();
			i++;
			vector.add(i);
			vector.add(cidade);

			defaultCidade.addRow(vector);
		}
	}

	private void limparTabelaCliente() {
		defaultCidade.setNumRows(0);
	}

}
