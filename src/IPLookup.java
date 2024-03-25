import javax.swing.*;
import java.awt.event.*;
import java.net.*;

class IPLookup extends JFrame implements ActionListener {// Initialing class and inheriting JFrame properties by using
															// ActionListerner interface
	JLabel label = new JLabel("Enter URL:"); // declaring JLabel
	JTextField text_field = new JTextField(); // declaring Text Field
	JButton find = new JButton("Find IP"); // declaring JButton

	IPLookup() { // Creating contructor
		this.setTitle("IP Finder"); // setting up title for frame
		this.setSize(300, 300); // setting dimensions for frame
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Creating exit button
		this.setLayout(null); // declaring the position of the components inside the frame
		this.setVisible(true); // Setting Visibility status of to true

		label.setBounds(150, 120, 200, 40); // setting boundaries for our label

		text_field.setBounds(50, 200, 400, 30); // setting boundaries for our text field

		find.setBounds(150, 300, 200, 40); // setting boundaries for our button
		find.addActionListener(this); // making button to response for user actions

		this.add(label);// adding label component to frame
		this.add(text_field);// adding text_field component to frame
		this.add(find);// adding find component to frame
	}

	@Override // instructing the compiler to over ride the superclass
	public void actionPerformed(ActionEvent e) {
		String url = text_field.getText(); // declaring url and initializing the user entered value from text_field
		try {
			InetAddress IA = InetAddress.getByName(url); // Getting Inetaddress
			String IP = IA.getHostAddress(); // Getting IP Adress from Inet adress
			JOptionPane.showMessageDialog(this, IP); // Printing IP adress
		} catch (UnknownHostException UE) { // Catching the error whenever wrong host address given by user
			JOptionPane.showMessageDialog(this, "IP not found. Check url !");
		}
	}

}