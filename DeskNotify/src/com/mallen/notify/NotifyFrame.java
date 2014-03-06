package com.mallen.notify;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;

public class NotifyFrame extends MouseAdapter {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = (int) screenSize.getWidth();
	public static int height = (int) screenSize.getHeight();
	public static String url = "www.google.com";
	
	private static JFrame jf = new JFrame();
	public void drawFrame(){
		jf.setTitle("DeskNotify");
		jf.setType(javax.swing.JFrame.Type.UTILITY);
		jf.setSize(width/4, width/32);
		
		jf.setUndecorated(true);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setAlwaysOnTop(true);
		jf.setFocusable(false);
		
		jf.add(new NotifyPanel());
		jf.addMouseListener(this);
		
		jf.setLocation(20, 20);
		
	}
	public void mouseClicked(MouseEvent e){
        try {
        	Desktop.getDesktop().browse(new URL("http://" + url).toURI());
		} catch (Exception e2){}
	}
	/**
	Core Library Method -- Ignore
	*/
	public void fadeIn(){
		 URL url = getClass().getResource("/res/alert.wav");
         AudioClip clip = java.applet.Applet.newAudioClip(url);
         clip.play();
		
         
		jf.setOpacity(0);
		setVisible(true);
		
		for(int i = 0; i < 100; i++){
			jf.setOpacity(i/100f);
			try {
				 Thread.sleep(10);
			}catch(Exception e ){}
		}
	}
	/**
	Core Library Method -- Ignore
	*/
	public void fadeOut(){
		jf.setOpacity(1);
		for(int i = 100; i > 0; i--){
			jf.setOpacity(i/100f);
			try {
				 Thread.sleep(10);
			}catch(Exception e ){}
		}
		setVisible(false);
	}
	/**
	Core Library Method -- Ignore
	*/
	private void setVisible(boolean bool){	
		jf.setVisible(bool);
	}
	public static void main(String[] args){
		DeskNotify dn = new DeskNotify();
		dn.setColor(255, 190, 100);
		dn.setUrl("www.google.com");
		dn.notify("This is a test notification!");
	}
}
