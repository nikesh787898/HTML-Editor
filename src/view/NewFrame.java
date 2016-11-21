package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import common.Data;

public class NewFrame implements ActionListener,WindowListener
{
	private JFrame frame=new JFrame("New");
	private JTabbedPane tabbedPane=new JTabbedPane();
	private Data commData;
	public void setFrame()
	{
		frame.setSize(500,500);
		frame.setBounds(450,120, 500, 500);
		frame.setBackground(Color.red);
		frame.setResizable(false);
		frame.addWindowListener(this);
	}
	public  NewFrame(Data commData)
	{
		this.commData=commData;
		setFrame();
	}
	public void show()
	{
		commData.frame.setEnabled(false);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		commData.frame.setEnabled(true);
		commData.frame.toFront();
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		commData.frame.setEnabled(true);
		commData.frame.toFront();
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
