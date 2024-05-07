package a9;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.*;

class LoginFrame extends JDialog {
	
    private static LoginFrame v;
  //  JFrame parent;
    public static LoginFrame V(JFrame parent) {
    	if (v == null)
    		v = new LoginFrame(parent);
    	return v;
    }
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField();

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    


    private LoginFrame() {
        this(null);
    }

    private LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
       
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        getContentPane().add(panel);
		
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//note how we get the password text from JTextPassword
            	String strPassword = String.valueOf(txtPassword.getPassword());
            	String strUsername = txtUsername.getText().trim();
            	
                
                if (verifyLogin(strPassword, strPassword)) {
                    parent.setVisible(true);
                    //Uncomment when MainWindow is ready (or Whatever you call the Main Frame for the application)
                    //((MainWindow) parent).endableAll(); 
                    setVisible(false);
                } else {
                	//play around with the options
                	JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE );

                }
            }

			private boolean verifyLogin(String strPassword, String strPass) {
				//write the logic here
					return true;
			}
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtPassword.setText("");
            	txtUsername.setText("");
                setVisible(false);
            
            }
        });
    }
}