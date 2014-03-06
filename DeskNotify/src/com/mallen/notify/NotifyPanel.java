package com.mallen.notify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NotifyPanel extends JPanel {
	static Color bg = new Color(50, 200, 255);
	private static NotifyFrame nf = new NotifyFrame();
	
	public static ImageIcon RedditIcoII;
	public static Image RedditIco;
	public static String notify;
	 Font UIFont = new Font("Verdana", Font.PLAIN, nf.width/125);
	
	
	public void Init(){
		/**
		Core Library Method -- Ignore
		*/
		try {
		setOpaque(false);
		RedditIcoII  = new ImageIcon(getToolkit().getImage(getClass().getResource("/res/Alien.png")));
		RedditIco = RedditIcoII.getImage();
		} catch(Exception e){e.printStackTrace();}
	}
	public void paint(Graphics g){
	super.paint(g);
	
	g.setColor(bg);
	g.fillRect(0, 0, nf.width/4, nf.width/32);
	
	g.drawImage(RedditIco, (nf.width/4)-(nf.width/60), (nf.width/32)-(nf.width/60), (nf.width/75), (nf.width/75), this);
	
	g.setFont(UIFont);
	g.setColor(Color.WHITE);
	g.drawString(notify, 15, ((nf.width/4)/30)+(nf.width/125));
	
	try {
		Thread.sleep(100);
	}catch(Exception e){}
	
	repaint();
	}
}
