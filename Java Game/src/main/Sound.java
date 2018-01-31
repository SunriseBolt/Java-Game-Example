package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Sound {
	public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav")),
								  GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav")),
								  BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}
