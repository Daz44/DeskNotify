package com.mallen.notify;

import java.awt.Color;

public class DeskNotify {
	public void setUrl(String s){
		NotifyFrame nf = new NotifyFrame();
		nf.url = s;
	}
	public void setColor(int r, int b, int g){
		NotifyPanel np = new NotifyPanel();
		np.bg = new Color(r,b,g);
	}
	public DeskNotify(){
		NotifyFrame nf = new NotifyFrame();
		NotifyPanel np = new NotifyPanel();
		
		np.Init();
		nf.drawFrame();
	}
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
