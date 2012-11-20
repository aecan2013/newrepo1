package UI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBorrowerDialog extends JFrame implements ActionListener{
	JTextField borrowerID = new JTextField();
	JTextField password = new JTextField();
	JTextField name = new JTextField();
	JTextField address = new JTextField();
	JTextField phone = new JTextField();
	JTextField emailAddress = new JTextField();
	JTextField sinOrStNo = new JTextField();
	JTextField expiryDate = new JTextField();
	String[] types = {"Student", "Faculty", "Staff"};
	JComboBox type = new JComboBox(types);
	
	static String returnToClerkDialogString = "Return to Clerk Dialog";
	static String add = "Add";
	
	public AddBorrowerDialog(String name)
	{
		super (name);

		
	}
	
	private void addComponentsToPane(final Container pane)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11, 2));
		
		panel.add(new Label("Add a Borrower"));
		panel.add(new Label(""));
		
		panel.add(new Label("Borrower ID"));
		panel.add(borrowerID);
		
		panel.add(new Label("password"));
		panel.add(password);
		
		panel.add(new Label("name"));
		panel.add(name);
		
		panel.add(new Label("address"));
		panel.add(address);
		
		panel.add(new Label("phone"));
		panel.add(phone);
		
		panel.add(new Label("emailAddress"));
		panel.add(emailAddress);
		
		panel.add(new Label("Sin or Student Number"));
		panel.add(sinOrStNo);
		
		panel.add(new Label("Expiry Date"));
		panel.add(expiryDate);
		
		panel.add(new Label("Type"));
		panel.add(type);
		
		JButton returnToUserDialog = new JButton(returnToClerkDialogString);
		returnToUserDialog.setActionCommand(returnToClerkDialogString);
		returnToUserDialog.addActionListener(this);
		
		JButton addButton = new JButton(add);
		addButton.setActionCommand(add);
		addButton.addActionListener(this);
		
		panel.add(returnToUserDialog);
		panel.add(addButton);
		
		pane.add(panel);
	}
    public static void createAndShowGUI() {
        //Create and set up the window.
        AddBorrowerDialog frame = new AddBorrowerDialog("Add Borrower Dialog");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (AddBorrowerDialog.returnToClerkDialogString.equals(arg0.getActionCommand()))
		{
			this.dispose();
		}else if (add.equals(arg0.getActionCommand()))
		{
			//doSomeWithing
		}
		
	}
	
	private void createBorrower()
	{
	
	}
	
}
