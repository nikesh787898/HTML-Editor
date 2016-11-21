package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon image=new ImageIcon("image/panel.jpg");
		g.drawImage(image.getImage(),0,0,1100,300,null);
	}
}
