import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmSystemaAdm;
	private JTextField usertxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSystemaAdm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JPasswordField passtxt;
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmSystemaAdm = new JFrame();
		frmSystemaAdm.setTitle("Systema - ADM");
		frmSystemaAdm.setBounds(100, 100, 242, 341);
		frmSystemaAdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemaAdm.getContentPane().setLayout(null);
		
		usertxt = new JTextField();
		usertxt.setBounds(101, 196, 86, 20);
		frmSystemaAdm.getContentPane().add(usertxt);
		usertxt.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="select * from logintb where User=? and Pass=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, usertxt.getText());
					pst.setString(2, passtxt.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()) {
						count=count+1;
												
					}
					if (count==1)
					{
						JOptionPane.showMessageDialog(null, "Logado com Sucesso!");	
						
						frmSystemaAdm.dispose();
						Home home=new Home();
						home.setVisible(true);
						
						
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Usuario Duplicado!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorreto");
					}
					rs.close();
					pst.close();
				}catch(Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
		});
		btnLogin.setBounds(98, 259, 89, 23);
		frmSystemaAdm.getContentPane().add(btnLogin);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(45, 199, 46, 14);
		frmSystemaAdm.getContentPane().add(lblUser);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(45, 231, 46, 14);
		frmSystemaAdm.getContentPane().add(lblPass);
		
		JLabel lblLoginSystema = new JLabel("Login - Systema");
		lblLoginSystema.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSystema.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		lblLoginSystema.setBounds(10, 11, 206, 49);
		frmSystemaAdm.getContentPane().add(lblLoginSystema);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-warning@2x.png")));
		label.setBounds(10, 62, 206, 109);
		frmSystemaAdm.getContentPane().add(label);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(101, 227, 86, 20);
		frmSystemaAdm.getContentPane().add(passtxt);
	}
}
