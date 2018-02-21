import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AReceber extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AReceber frame = new AReceber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtmes;
	private JTextField txttotal;
	

	/**
	 * Create the frame.
	 */
	public AReceber() {
		setMaximumSize(new Dimension(700, 500));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AReceber.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Paste-Black@2x.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 472);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(700, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteConnection.dbConnector();
		
		JLabel lblARecebere = new JLabel("A Receber");
		lblARecebere.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblARecebere.setBounds(10, 0, 116, 52);
		contentPane.add(lblARecebere);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(10, 65, 29, 20);
		contentPane.add(txt1);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(49, 65, 29, 20);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(88, 65, 46, 20);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(144, 65, 193, 20);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(347, 65, 86, 20);
		contentPane.add(txt5);
		
		JLabel label = new JLabel("Valor");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(344, 47, 89, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Empresa (Quem a pagar)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(144, 47, 190, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Ano");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(88, 47, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("M\u00EAs");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(49, 47, 29, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Dia");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(10, 47, 29, 14);
		contentPane.add(label_4);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				String query="insert into receber values (?,?,?,?,?)";
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
		btnSalvar.setBounds(443, 64, 89, 23);
		contentPane.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 152, 413, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblUseOPonto = new JLabel("Use o PONTO (.) para valor!");
		lblUseOPonto.setBounds(347, 20, 185, 20);
		contentPane.add(lblUseOPonto);
		
		JLabel lblNewLabel = new JLabel("Exibir os Recebimento do mes de numero: ");
		lblNewLabel.setBounds(20, 116, 245, 14);
		contentPane.add(lblNewLabel);
		
		txtmes = new JTextField();
		txtmes.setBounds(289, 113, 29, 20);
		contentPane.add(txtmes);
		txtmes.setColumns(10);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{String query="select * from receber where mes=?";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, txtmes.getText());
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
						
				
								
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnExibir.setBounds(358, 112, 75, 23);
		contentPane.add(btnExibir);
		
		txttotal = new JTextField();
		txttotal.setBounds(513, 173, 86, 20);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblTotalAReceber = new JLabel("Total A Receber");
		lblTotalAReceber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalAReceber.setBounds(503, 148, 133, 20);
		contentPane.add(lblTotalAReceber);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double count=0;
				for (int i=0; i<=table.getRowCount()-1;i++) {
				count+=Double.parseDouble(table.getValueAt(i, 4).toString());
				}
				String soma = Double.toString(count);
				txttotal.setText(soma);
							
								 
				
			}
		});
		btnTotal.setBounds(523, 202, 65, 23);
		contentPane.add(btnTotal);
	}
}
