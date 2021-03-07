package solutions;
import java.awt.Frame;
import java.util.Random;
import javax.swing.JOptionPane;

public class P06_Twister 
{
	public static void main(String[] args) 
	{
		String[] sides = new String[] { "Left", "Right" }; 
		String[] bodyParts = new String[] { "Foot", "Hand" };
		String[] colors = new String[] { "Yellow", "Blue", "Green", "Red" };
		Random random = new Random();
		
		String message = "";
		int index = random.nextInt(sides.length);
		message += sides[index] + " ";
		index = random.nextInt(bodyParts.length);
		message += bodyParts[index] + " on a ";
		index = random.nextInt(colors.length);
		message += colors[index] + " spot";
		
		JOptionPane.showMessageDialog(new Frame(), message);
	}
}
