import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txttotal;

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
	Connection connection=null;
	private JTextField txtmes;
	/**
	 * Create the frame.
	 */
	public APagar() {
		connection=sqliteConnection.dbConnector();
		
		setMaximumSize(new Dimension(700, 500));
		setTitle("Cad. Contas a Pagar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 443);
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
				
				try {
					
					String query="insert into pagar values (?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txt1.getText());
					pst.setString(2, txt2.getText());
					pst.setString(3, txt3.getText());
					pst.setString(4, txt4.getText());
					pst.setString(5, txt5.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Salvo");
					txt1.setText("");
					txt2.setText("");
					txt3.setText("");
					txt4.setText("");
					txt5.setText("");
					
				}catch(Exception e1) {
					e1.printStackTrace();
				
				}
			}
		});
		btnSalvar.setBounds(347, 87, 86, 23);
		contentPane.add(btnSalvar);
		
		txttotal = new JTextField();
		txttotal.setBounds(495, 140, 86, 20);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("Total a Pagar");
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAPagar.setBounds(495, 117, 86, 14);
		contentPane.add(lblTotalAPagar);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double count=0;
				for (int i=0; i<=tbreceber.getRowCount()-1;i++) {
				count+=Double.parseDouble(tbreceber.getValueAt(i, 4).toString());
				}
				String soma = Double.toString(count);
				txttotal.setText(soma);
			}
		});
		btnTotal.setBounds(495, 171, 89, 23);
		contentPane.add(btnTotal);
		
		JLabel lblExibirOsPagamentos = new JLabel("Exibir os Pagamentos do mes de numero: ");
		lblExibirOsPagamentos.setBounds(10, 121, 245, 14);
		contentPane.add(lblExibirOsPagamentos);
		
		txtmes = new JTextField();
		txtmes.setColumns(10);
		txtmes.setBounds(249, 118, 29, 20);
		contentPane.add(txtmes);
		
		JButton button = new JButton("Exibir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{String query="select * from pagar where mes=?";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, txtmes.getText());
				ResultSet rs=pst.executeQuery();
				tbreceber.setModel(DbUtils.resultSetToTableModel(rs));
				
						
				
								
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(288, 113, 75, 23);
		contentPane.add(button);
	}

}
