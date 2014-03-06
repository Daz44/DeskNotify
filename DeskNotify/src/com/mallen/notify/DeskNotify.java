package com.mallen.notify;

import java.awt.Color;

public class DeskNotify {
	/**
	Used to set the URL that is opened when you click on the notification
	*/
	public void setUrl(String s){
		NotifyFrame nf = new NotifyFrame();
		nf.url = s;
		
	}
	/**
	Used to set the Color of the Dialog
	*/
	public void setColor(int r, int g, int b){
		NotifyPanel np = new NotifyPanel();
		np.bg = new Color(r,g,b);
	}
	public DeskNotify(){
		NotifyFrame nf = new NotifyFrame();
		NotifyPanel np = new NotifyPanel();
		
		np.Init();
		nf.drawFrame();
	}
	/**
	 Draws a notification dialog on the users screen
	 String text - Body of the notification dialog
	 */
	public void notify(String text){
		NotifyFrame nf = new NotifyFrame();
		NotifyPanel np = new NotifyPanel();
		
		
		
		String[] noteParse = text.split("");
		String notificationtext = text;
		
		if(noteParse.length < 40){} else {
		notificationtext = "";
		for(int i = 0; i < 40; i++){
			notificationtext += noteParse[i];
		}
			notificationtext += "...";
		}
		
		np.notify = notificationtext;
		nf.fadeIn();
		
		try{
			Thread.sleep(5000);
			nf.fadeOut();
		}catch(Exception e){}		
		
	}
}
