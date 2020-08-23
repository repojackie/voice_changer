import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * FURTHER RESEARCH TO CONSIDER:
 *
 * .addActionListener() <--- what do you need for this?
 *
 */
public class SwingControlDemo 
{
	// the main components of our GUI
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	// default constructor 
	public SwingControlDemo()
	{
		prepareGUI();
	}

	/**
	 * Main
	 */
	public static void main(String[] args)
	{
		SwingControlDemo swingControlDemo = new SwingControlDemo();
		swingControlDemo.showEventDemo();
	}

	// constructed by constructor :)
	private void prepareGUI ()
	{
		mainFrame = new JFrame("Java SWING Example");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);

		/**
		 * Just adding the close operation via weird abstract
		 * classes
		 */
		mainFrame.addWindowListener(new WindowAdapter() 
				{
					public void windowClosing(WindowEvent windowEvent)
					{
						System.exit(0);
					}
				});

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	/**
	 * This is what the main function runs
	 */
	private void showEventDemo()
	{
		headerLabel.setText("Control in action: Button");

		JButton okButton = new JButton("OK");
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");

		// adding listeners to the buttons 
		okButton.addActionListener(new ButtonClickListener());
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());

		// adding buttons to the control panel
		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);

		mainFrame.setVisible(true);
	}

	/**
	 * Button click listener class, responsible for maintaining 
	 * clicks.
	 */
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();

			if (command.equals("OK"))
			{
				statusLabel.setText("Ok button clicked");
			} else if (command.equals("Submit") )
			{
				statusLabel.setText("Submit Button clicked");
			} else
			{
				statusLabel.setText("Cancel button clicked");
			}
		}
	}
}
