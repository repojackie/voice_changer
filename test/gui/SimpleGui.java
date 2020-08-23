import javax.swing.*;

class SimpleGui
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JButton button = new JButton("Press");
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}
}
