package alarmapp;

import javax.swing.*;
public class AlarmFrame {

	public AlarmFrame() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Alarm App");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String args[]){
		new AlarmFrame();
	}
	
}
