import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *	Button list:
 *		- Record/stop
 *		- Browse [for files]
 *		- Effect drop-down list [implement effects as pluggable modules?]
 *
 */
public class RecorderWindow
{
	private JFrame mainFrame;
	private JPanel controlPanel;

	public RecorderWindow()
	{
		prepareGUI();
	}
	
	public static void main(String[] args)
	{
		RecorderWindow recorderWindow = new RecorderWindow();
		recorderWindow.addInteraction();
	}

	private void prepareGUI()
	{
		mainFrame = new JFrame("Voice Changer Application");
		mainFrame.setSize(250, 250);
		mainFrame.setLayout(new GridLayout(4, 1));
		mainFrame.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent windowEvent)
					{
						System.exit(0);
					}
				});

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}

	private void addInteraction()
	{
		/**
		 *	Here is where I shall the buttons and drop down stuff. 
		 *
		 *	TO DO!!!
		 */

		// record start/stop button 
		JButton recordButton = new JButton("Record");
		recordButton.setActionCommand("Record");
		recordButton.addActionListener(new ButtonClickListener());
		controlPanel.add(recordButton);

		// file chooser	
		JButton fileButton = new JButton("Choose file");
		fileButton.setActionCommand("FC");
		fileButton.addActionListener(new ButtonClickListener());
		controlPanel.add(fileButton);

		// effects drop-down list
		String[] effectsList = {"Effect1", "Effect2", "Effect3"};
		JComboBox<String> effectsMenu = new JComboBox<String>(effectsList);
		effectsMenu.setSelectedIndex(0);
		effectsMenu.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						JComboBox combo = (JComboBox) event.getSource();
						String selected = (String) combo.getSelectedItem();

						if (selected.equals("Effect1"))
						{
							System.out.println("Effect1");
							// plug in for effect 1
						} else if (selected.equals("Effect2"))
						{
							System.out.println("Effect2");
							// plug in for effect 2
						} else if (selected.equals("Effect3"))
						{
							System.out.println("Effect3");
							// plug in for effect 3
						} else
						{
							System.out.println("Something went wrong");
						}
					}
				});
		controlPanel.add(effectsMenu);

		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();

			if (command.equals("Record"))
			{
				System.out.println("Record");
				// METHOD TO BEGIN RECORDING
				if (((JButton)e.getSource()).getText().equals("Record"))
				{
					((JButton)e.getSource()).setText("STOP");
				} else 
				{
					((JButton)e.getSource()).setText("Record");
				}				
				// change the button label to have it stop recording
			} else if (command.equals("FC"))
			{
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					System.out.println("The chosen file is: " + fc.getSelectedFile().getName());
				}

				System.out.println("Choosing a file");
			} else 
			{
				System.out.println("Something went wrong");
			}
		}
	}
}
