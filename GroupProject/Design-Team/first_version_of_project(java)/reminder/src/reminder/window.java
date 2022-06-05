package reminder;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class window extends JFrame{

	public void initWindow() {
		this.setTitle("Reminder");
		this.setSize(600,400);
		this.setLocation(200,200);
		this.setVisible(true);
	}

	public void SetText(JLabel text, String str) {
		text.setText(str);
		text.setSize(0,0);
		text.setLocation(0,0);
	}

	
	public static void main(String[] args) {
		
		
	}

}
