package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Musica;
import model.dao.MusicaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JFListarMusica extends JFrame {

	private JPanel contentPane;
	private JTable JTMusicas;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarMusica frame = new JFListarMusica();
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
	public JFListarMusica() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJtable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Musicas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 259, 22);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 42, 726, 305);
		contentPane.add(scrollPane);
		
		JTMusicas = new JTable();
		JTMusicas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Titulo", "Cantores", "Compositores", "Letra","Duração", "Origem"
				}
			));
		scrollPane.setViewportView(JTMusicas);
		
		JButton btnCadastrar = new JButton("New button");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFCadastrarMusica cm = new JFCadastrarMusica();
				cm.setVisible(true);
				readJtable();
			}
		});
		btnCadastrar.setAction(action);
		btnCadastrar.setBounds(10, 422, 85, 21);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("New button");
		btnAlterar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(JTMusicas.getSelectedRow() != -1) {
				JFAtualizarMusica am = new JFAtualizarMusica((int)JTMusicas.getValueAt(JTMusicas.getSelectedRow(), 0 ));
				am.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Selecione uma linha");
			}
			readJtable();
			}
		});
		btnAlterar.setAction(action_1);
		btnAlterar.setBounds(105, 422, 85, 21);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("New button");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JTMusicas.getSelectedRow() != -1) {	
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o Musica selecionado", "Deletar", JOptionPane.YES_NO_OPTION);
					if(opcao == 0) {
						MusicaDAO dao = new MusicaDAO();
						Musica c = new Musica();
						c.setMusica_id((int) JTMusicas.getValueAt(JTMusicas.getSelectedRow(), 0));
						dao.delete(c);
					}
				}
					else {
						JOptionPane.showMessageDialog(null,"Selecione uma linha");
					}
				readJtable();
				}
			});
		readJtable();
		btnDeletar.setAction(action_2);
		btnDeletar.setBounds(200, 422, 85, 21);
		contentPane.add(btnDeletar);
		
		JButton btnCancelar = new JButton("New button");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setAction(action_3);
		btnCancelar.setBounds(295, 422, 85, 21);
		contentPane.add(btnCancelar);
		readJtable();
	}
	public void readJtable() {
		DefaultTableModel modelo = (DefaultTableModel) JTMusicas.getModel();
		modelo.setNumRows(0);
		MusicaDAO mDAO = new MusicaDAO();
		for(Musica m: mDAO.read()) {
			String boleano = null;
			if(m.isMusica_nacional() == true) {
				boleano = ("Nacional");
			}
			else {
				boleano = ("Extrangeira");
			}
			modelo.addRow(new Object[] {
					m.getMusica_id(),
					m.getMusica_titulo(),
					m.getMusica_cantores(),
					m.getMusica_compositores(),
					m.getMusica_letra(),
					m.getMusica_duracao(),
					boleano
			});
		}
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Atualizar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Deletar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
