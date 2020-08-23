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
	private JPanel buttonPanel;

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
		controlPanel.setLayout(new FlowLayout);

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
	}
}
