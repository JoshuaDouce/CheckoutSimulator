import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class WelcomeScreenUI extends JFrame {

	private JPanel contentPane;
	private SupermarketSystem supermarketSystem;
	private JPasswordField pwdPassword;
	private static JTextField userIdNoTxt;
	private static String IdNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreenUI frame = new WelcomeScreenUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public WelcomeScreenUI(){
		super();
		initGUI();
		supermarketSystem = new SupermarketSystem();
	}

	/**
	 * Create the frame.
	 */
	public void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
				
		contentPane.add(panel);
		
		JLabel lblWelcomeMessage = new JLabel("Welcome to JD's supermarket");
		lblWelcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeMessage.setPreferredSize(new Dimension(400, 50));
		
		userIdNoTxt = new JTextField();
		userIdNoTxt.setText("Enter user ID no");
		userIdNoTxt.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setPreferredSize(new Dimension(100, 22));
		pwdPassword.setColumns(10);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 5));
		panel.add(lblWelcomeMessage);
		panel.add(userIdNoTxt);
		panel.add(pwdPassword);
		
		JButton btnPressToEnter = new JButton("Press to enter");
		panel.add(btnPressToEnter);
		btnPressToEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//try {
					StaffDatabase sd1 = supermarketSystem.getStaffDatabase();
					String userId = userIdNoTxt.getText();
					StaffMember s1 = sd1.getStaff(userId);
					@SuppressWarnings("deprecation")
					String password =  pwdPassword.getText();
						if(s1.getStaffPassword().startsWith(password)){
							CheckGUI check1 = new CheckGUI(WelcomeScreenUI.this);
							check1.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(null, "Incorrect password");
						}
				//} catch (NullPointerException e) {
				//	JOptionPane.showMessageDialog(null, "Incorrect username");
				//}
			}
		});
		}

	
	public static String getIdNo(){
		IdNo = userIdNoTxt.getText();
		return IdNo;
	}

	public SupermarketSystem getSupermarketSystem() {
		
		return supermarketSystem;
	}
}