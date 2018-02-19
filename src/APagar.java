import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class APagar extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTable tbreceber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APagar frame = new APagar();
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
	public APagar() {
		setMaximumSize(new Dimension(700, 500));
		setTitle("Cad. Contas a Pagar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAPagar = new JLabel("A Pagar");
		lblAPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAPagar.setBounds(10, 0, 91, 39);
		contentPane.add(lblAPagar);
		
		txt1 = new JTextField();
		txt1.setBounds(10, 57, 29, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(49, 57, 29, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(88, 57, 46, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setBounds(10, 39, 29, 14);
		contentPane.add(lblDia);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setBounds(49, 39, 29, 14);
		contentPane.add(lblMs);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setBounds(88, 39, 46, 14);
		contentPane.add(lblAno);
		
		txt4 = new JTextField();
		txt4.setBounds(144, 57, 193, 20);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		JLabel lblEmpresaquemA = new JLabel("Empresa (Quem a pagar)");
		lblEmpresaquemA.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresaquemA.setBounds(144, 39, 190, 14);
		contentPane.add(lblEmpresaquemA);
		
		txt5 = new JTextField();
		txt5.setBounds(347, 57, 86, 20);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setBounds(344, 39, 89, 14);
		contentPane.add(lblValor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 423, 253);
		contentPane.add(scrollPane);
		
		tbreceber = new JTable();
		scrollPane.setViewportView(tbreceber);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(347, 87, 86, 23);
		contentPane.add(btnSalvar);
	}

}
