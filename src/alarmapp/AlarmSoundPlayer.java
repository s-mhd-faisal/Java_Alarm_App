package alarmapp;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AlarmSoundPlayer {
	private Clip clip;
	
	public void playSound() {
		try {
			File file = new File("C:\\Users\\faiza\\eclipse-workspace\\Java_Alarm_App\\giorno_theme.wav");
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			clip.start();
			
		}catch(IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			System.out.println("Error playing the audio" + e.getMessage());
		}
	}
	
	public void stopSound() {
		if(clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
		}
	}
}