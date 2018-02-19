import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Home() {
		connection=sqliteConnection.dbConnector();
		
		setTitle("Home - Sys");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoad = new JButton("Extrato");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="Select * from logintb";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1) {
					e1.printStackTrace();
					
					
				}
			}
		});
		btnLoad.setBounds(485, 21, 89, 23);
		contentPane.add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 55, 240, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAReceber = new JButton("A Receber");
		btnAReceber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AReceber receb=new AReceber();
				receb.setVisible(true);
				
				
			}
		});
		btnAReceber.setBounds(25, 21, 89, 23);
		contentPane.add(btnAReceber);
		
		JButton btnAPagar = new JButton("A Pagar");
		btnAPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				APagar pag=new APagar();
				pag.setVisible(true);
			
			}
		});
		btnAPagar.setBounds(124, 21, 89, 23);
		contentPane.add(btnAPagar);
	}
}
