package com.sist.shooting;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;

public class GraphicObject {
	 BufferedImage img = null;
	 int x=0, y=0;
	 
	 public GraphicObject(String name) {
		 
		 try {
			 img = ImageIO.read(new File(name));
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 public void update() {}
	 
	 public void draw(Graphics g) {
		 g.drawImage(img,x,y,null);
	 }
	 
	 public void keyPressed(KeyEvent event) {}
}
