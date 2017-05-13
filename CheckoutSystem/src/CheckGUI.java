import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListModel;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JLabel;

public class CheckGUI extends JFrame {
	
	private DefaultListModel<String> basket = new DefaultListModel<String>();
	private SupermarketSystem supermarketSystem;
	private int checkNum;
	private String idNo;
	private Boolean ageChecked;
	private JPanel contentPane;
	private JPanel barcodePanel;
	private JPanel buttonPanel;
	private JPanel checkoutNoPanel;
	private JPanel productListPanel;
	private JTextField paymentAmountTextField;
	private JTextField barcodeTextField;
	private JTextField totalCostTextField;
	private JScrollPane productScrollPane;
	private JList<String> productList;
	private JButton scanButton;
	private JButton five;
	private JButton ten;
	private JButton fifteen;
	private JButton twenty;
	private JButton payButton;
	private JButton btnClearButton;
	private JButton btnLineVoid;
	private JLabel lblCheckoutNo;
	private JLabel lblCheckNum;
	private JLabel lblIdTag;
	private JLabel lblUserNo;
	private JButton btnManagerFunctions;
	private WelcomeScreenUI wScreen;
	
	public CheckGUI(WelcomeScreenUI wScreen){
		super();
		this.wScreen = wScreen;
		setResizable(false);
		setPreferredSize(new Dimension(455, 315));
		initGUI();
		supermarketSystem = wScreen.getSupermarketSystem();
		ageChecked = false;
		productList.setModel(basket);
	}
	
	/**
	 * Create the frame.
	 */
	public void initGUI() {
		setIdNo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 315);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		productListPanel = new JPanel();
		contentPane.add(productListPanel, BorderLayout.CENTER);
		productListPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 6));
		
		productScrollPane = new JScrollPane();
		productListPanel.add(productScrollPane);
		productScrollPane.setPreferredSize(new Dimension(200, 150));
		
		totalCostTextField = new JTextField();
		totalCostTextField.setPreferredSize(new Dimension(100, 22));
		totalCostTextField.setEditable(true);
		productListPanel.add(totalCostTextField);
		
		ListModel<String> productListModel = new DefaultComboBoxModel<String> (new String[] { "Item One", "Item Two" });
	
		productList = new JList<String>();
		productScrollPane.setViewportView(productList);
		productList.setModel(productListModel);
		
		barcodePanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) barcodePanel.getLayout();
		flowLayout_1.setHgap(13);
		contentPane.add(barcodePanel, BorderLayout.SOUTH);
		
		barcodeTextField = new JTextField();
		barcodeTextField.setEditable(true);
		barcodePanel.add(barcodeTextField);
		barcodeTextField.setColumns(10);
		barcodeTextField.setPreferredSize(new Dimension(399, 24));
		
		scanButton = new JButton("Scan Item");
		scanButton.setPreferredSize(new Dimension(120, 27));
		barcodePanel.add(scanButton);
		scanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcode = barcodeTextField.getText();
				SupermarketSystem supermarketSystem = wScreen.getSupermarketSystem();
				CheckoutSystem checkoutSystem = supermarketSystem.getCheckoutSystem();
				Checkout checkout = checkoutSystem.getCheckout(checkNum);
				ProductDatabase pd1 = supermarketSystem.getProductDatabase();
				Product p1 = pd1.getProduct(barcode);
				String product = p1.toString();
		        Boolean restricted = p1.getAgeRestricted();
		
		        if(restricted == true && ageChecked == false){
		        	String txtPerceivedAge = JOptionPane.showInputDialog("Enter the customers perceived age");
		        	int perceivedAge = Integer.parseInt(txtPerceivedAge);
		        		if(perceivedAge >= 25){
		        			checkout.scan(p1);
		    				basket.addElement(product);
		    				barcodeTextField.setText("");
		    				double cost = checkout.totalCost();
		    				String newTotalCost = String.valueOf(cost);
		    				totalCostTextField.setText(newTotalCost);
		    				ageChecked = true;
		        		}
		        		else{
		        		String txtShownAge = JOptionPane.showInputDialog("Ask customer for id and enter shown id age");
		        		int shownAge = Integer.parseInt(txtShownAge);
		        			if(shownAge >= 18){
		        				checkout.scan(p1);
		        				basket.addElement(product);
		        				barcodeTextField.setText("");
		        				double cost = checkout.totalCost();
		        				String newTotalCost = String.valueOf(cost);
		        				totalCostTextField.setText(newTotalCost);
		        				ageChecked = true;
		        				}
		        			else{}
		        			}
		        		}	        		
		        else{
		    	checkout.scan(p1);
				basket.addElement(product);
				barcodeTextField.setText("");
				double cost = checkout.totalCost();
				String newTotalCost = String.valueOf(cost);
				totalCostTextField.setText(newTotalCost);	
		        	}
		        }
		});
		scanButton.setEnabled(true);
		
		btnManagerFunctions = new JButton("Manager Functions");
		btnManagerFunctions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagmentUI managmentUI = new ManagmentUI();
				managmentUI.setVisible(true);
			}
		});
		barcodePanel.add(btnManagerFunctions);
		
		buttonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setHgap(20);
		contentPane.add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setPreferredSize(new Dimension(220, 220));
		
		btnClearButton = new JButton("Clear");
		btnClearButton.setEnabled(true);
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear this transaction ", 
						                      "Warning", 0);
				if (reply == JOptionPane.YES_OPTION) {
					clearCheckout();
			        }
			        else {
			        }
			}
		});
		
		btnLineVoid = new JButton("Line void");
		btnLineVoid.setEnabled(true);
		btnLineVoid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textLineNo = JOptionPane.showInputDialog("Which line would you like to remove");
				int lineNo = Integer.parseInt(textLineNo);
				lineNo = lineNo -1;
				basket.remove(lineNo);
				CheckoutSystem checkoutSystem = supermarketSystem.getCheckoutSystem();
				Checkout checkout = checkoutSystem.getCheckout(checkNum);
				checkout.removeProduct(lineNo);
				double cost = checkout.totalCost();
				String newTotalCost = String.valueOf(cost);
				totalCostTextField.setText(newTotalCost);	
			}
		});
		btnLineVoid.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(btnLineVoid);
		btnClearButton.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(btnClearButton);
		
		five = new JButton();
		five.setEnabled(true);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay(5);
				clearCheckout();
			}
		});
		
		
		five.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(five);
		five.setText("£5");
		
		ten = new JButton();
		ten.setEnabled(true);
		ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay(10);
				clearCheckout();
			}
		});
		ten.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(ten);
		ten.setText("£10");
		
		fifteen = new JButton();
		fifteen.setEnabled(true);
		fifteen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay(15);
				clearCheckout();
			}
		});
		fifteen.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(fifteen);
		fifteen.setText("£15");
		
		twenty = new JButton();
		twenty.setEnabled(true);
		twenty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay(20);
				clearCheckout();
			}
		});
		twenty.setPreferredSize(new Dimension(85, 25));
		buttonPanel.add(twenty);
		twenty.setText("£20");
		
		paymentAmountTextField = new JTextField();
		buttonPanel.add(paymentAmountTextField);
		paymentAmountTextField.setColumns(10);
		paymentAmountTextField.setEditable(true);
		
		payButton = new JButton("Pay");
		payButton.setEnabled(true);
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountPayedText = paymentAmountTextField.getText();
				double amountPayed = Double.parseDouble(amountPayedText);
				pay(amountPayed);
				clearCheckout();
				paymentAmountTextField.setText("");
			}
		});
		buttonPanel.add(payButton);
		
		checkoutNoPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) checkoutNoPanel.getLayout();
		flowLayout_2.setHgap(30);
		contentPane.add(checkoutNoPanel, BorderLayout.NORTH);	
		
		lblIdTag = new JLabel("User ID:");
		checkoutNoPanel.add(lblIdTag);
		
		lblUserNo = new JLabel(idNo);
		checkoutNoPanel.add(lblUserNo);
		
		lblCheckoutNo = new JLabel("Checkout No:");
		checkoutNoPanel.add(lblCheckoutNo);
		
		lblCheckNum = new JLabel("     ");
		checkoutNoPanel.add(lblCheckNum);
		
		checkoutSelection();
		
	}
	
	public void clearCheckout(){
		CheckoutSystem checkoutSystem = supermarketSystem.getCheckoutSystem();
		basket.clear();
		totalCostTextField.setText("");
		Checkout checkout = checkoutSystem.getCheckout(checkNum);
		checkout.clearBasket();
	}
	
	public void printReceipt(){
		CheckoutSystem checkoutSystem = supermarketSystem.getCheckoutSystem();
		Checkout checkout = checkoutSystem.getCheckout(checkNum);
		String costText = totalCostTextField.getText();
		checkout.listBasket();
		System.out.println("Total price: " + costText);
	}
	
	public void pay(double payment){
		CheckoutSystem checkoutSystem = supermarketSystem.getCheckoutSystem();
		int reply = JOptionPane.showConfirmDialog(null, "Does the cutomer have a loyalty card ", 
                  "Alert", 0);
		if (reply == JOptionPane.YES_OPTION) {
			String customerNumber = JOptionPane.showInputDialog("Enter customer number");
			supermarketSystem.addLoyaltyPoints(customerNumber, checkNum);
		}
		else {
		}
		Checkout checkout = checkoutSystem.getCheckout(checkNum);
		double amountDue = checkout.totalCost();
		checkout.payCash(amountDue);
		double change = payment - amountDue;
		String changeString = String.valueOf(change);
		JOptionPane.showMessageDialog(null, "Change due: " + changeString);
		printReceipt();
		System.out.println("Change: " + change);
		ageChecked = false;
	}
	
	public void checkoutSelection(){
			String txtCheckoutNumber = JOptionPane.showInputDialog("Select your checkout");
			lblCheckNum.setText(txtCheckoutNumber);
			int currentCheckout = Integer.parseInt(txtCheckoutNumber);
			checkNum = currentCheckout;
			checkNum = checkNum -1;
			}
	
	public void setIdNo(){
		idNo = WelcomeScreenUI.getIdNo();
	}
}
