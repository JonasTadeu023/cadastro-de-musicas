package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;


import model.bean.Musica;

import model.dao.MusicaDAO;
import view.JFCadastrarMusica.SwingAction;
import view.JFCadastrarMusica.SwingAction_1;
import view.JFCadastrarMusica.SwingAction_2;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class JFAtualizarMusica extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textCantores;
	private JTextField textCompositores;
	private JTextField textDuracao;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarMusica frame = new JFAtualizarMusica(id);
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
	public JFAtualizarMusica(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atualizar Musica");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 163, 21);
		contentPane.add(lblNewLabel);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(10, 70, 228, 19);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textCantores = new JTextField();
		textCantores.setColumns(10);
		textCantores.setBounds(486, 70, 228, 19);
		contentPane.add(textCantores);
		
		textCompositores = new JTextField();
		textCompositores.setColumns(10);
		textCompositores.setBounds(248, 70, 228, 19);
		contentPane.add(textCompositores);
		
		JTextPane textLetra = new JTextPane();
		textLetra.setBounds(10, 132, 704, 254);
		contentPane.add(textLetra);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 47, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Compositores");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(248, 47, 151, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cantores");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(486, 48, 151, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Letra");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 111, 45, 13);
		contentPane.add(lblNewLabel_1_2);
		
		textDuracao = new JTextField();
		textDuracao.setBounds(10, 471, 163, 19);
		contentPane.add(textDuracao);
		textDuracao.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(10, 448, 45, 13);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Musica");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1_1.setBounds(266, 449, 116, 13);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JRadioButton rdbtnNacional = new JRadioButton("Nacional");
		rdbtnNacional.setBounds(276, 470, 103, 21);
		contentPane.add(rdbtnNacional);
		
		JRadioButton rdbtnExtrangeira = new JRadioButton("Extrangeira");
		rdbtnExtrangeira.setBounds(381, 470, 103, 21);
		contentPane.add(rdbtnExtrangeira);
		
		ButtonGroup Nacional = new ButtonGroup();
		Nacional.add(rdbtnExtrangeira);
		Nacional.add(rdbtnNacional);
		
		MusicaDAO mdao = new MusicaDAO();
		Musica m = mdao.read(id);
		
		JLabel lblId = new JLabel("0");
		lblId.setBounds(659, 17, 45, 13);
		contentPane.add(lblId);
		
		lblId.setText(String.valueOf(m.getMusica_id()));
		textTitulo.setText(m.getMusica_titulo());
		textCompositores.setText(m.getMusica_compositores());
		textCantores.setText(m.getMusica_cantores());
		textLetra.setText(m.getMusica_letra());
		String valor_float = String.valueOf(m.getMusica_duracao());
		textDuracao.setText(valor_float);
		if(m.isMusica_nacional() == true) {
			rdbtnNacional.setSelected(true);
		}else{
			rdbtnExtrangeira.setSelected(true);
		}
		
		
		JButton btnAtualizar = new JButton("atualizar");
		btnAtualizar.setAction(action);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Musica m = new Musica();
				MusicaDAO mdao = new MusicaDAO();
				m.setMusica_id(id);
				m.setMusica_titulo(textTitulo.getText());
				m.setMusica_compositores(textCompositores.getText());
				m.setMusica_cantores(textCantores.getText());
				m.setMusica_letra(textLetra.getText());
				m.setMusica_duracao(Float.parseFloat(textDuracao.getText()));
				
				if(rdbtnExtrangeira.isSelected()) {
					m.setMusica_nacional(false);
				}
				else if (rdbtnNacional.isSelected()) {
					m.setMusica_nacional(true);
				}
				mdao.update(m);
				
				
			}
		});
		btnAtualizar.setBounds(10, 528, 85, 21);
		contentPane.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textTitulo.setText(null);
				textCompositores.setText(null);
				textCantores.setText(null);
				textLetra.setText(null);
				textDuracao.setText(null);
				Nacional.clearSelection();
			}
		});
		btnLimpar.setAction(action_1);
		btnLimpar.setBounds(105, 528, 85, 21);
		contentPane.add(btnLimpar);
		
		JButton btnNewButton_2 = new JButton("cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(200, 528, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setBounds(634, 17, 15, 13);
		contentPane.add(lblNewLabel_2);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Atualizar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}