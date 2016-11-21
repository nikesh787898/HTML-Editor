package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import common.Data;

public class SettingFrame implements ActionListener,WindowListener{
	private JFrame frame=new JFrame("Settings");
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
	private class ComboBoxFontTypeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ae) {
			try
			{
				String data=commData.file.getFontSetting();
				String arr[]=data.split(",");
				JComboBox<String> box=(JComboBox<String>)ae.getSource();
				String selectedItem=(String)box.getSelectedItem();
				String newString=arr[0]+","+selectedItem+","+arr[2];
				if(arr[2].equals("bold"))
				{
					commData.ta.setFont(new Font(selectedItem,Font.BOLD,Integer.parseInt(arr[0])));
				}
				else if(arr[2].equals("italic"))
				{
					commData.ta.setFont(new Font(selectedItem,Font.ITALIC,Integer.parseInt(arr[0])));
				}
				else
				{
					commData.ta.setFont(new Font(selectedItem,Font.PLAIN,Integer.parseInt(arr[0])));
				}
				commData.file.updateFontSetting(newString);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}
	}
	private class ComboBoxFontSizeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) {
			try
		{
		String data=commData.file.getFontSetting();
		String arr[]=data.split(",");
		JComboBox<String> box=(JComboBox<String>)ae.getSource();
		String selectedItem=(String)box.getSelectedItem();
		String newString=selectedItem+","+arr[1]+","+arr[2];
		if(arr[2].equals("bold"))
		{
			commData.ta.setFont(new Font(arr[1],Font.BOLD,Integer.parseInt(selectedItem)));
		}
		else if(arr[2].equals("italic"))
		{
			commData.ta.setFont(new Font(arr[1],Font.ITALIC,Integer.parseInt(selectedItem)));
		}
		else
		{
			commData.ta.setFont(new Font(arr[1],Font.PLAIN,Integer.parseInt(selectedItem)));
		}
		commData.file.updateFontSetting(newString);
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	private class ComboBoxTextTypeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae) {
			try
			{
				String data=commData.file.getFontSetting();
				String arr[]=data.split(",");
			JComboBox<String> box=(JComboBox<String>)ae.getSource();
			String selectedItem=(String)box.getSelectedItem();
			System.out.println(selectedItem);
			String newString=arr[0]+","+arr[1]+","+selectedItem;
			if(selectedItem.equals("plain"))
			{
				commData.ta.setFont(new Font(arr[1],Font.PLAIN,Integer.parseInt(arr[0])));
			}
			if(selectedItem.equals("bold"))
			{
				System.out.println("bold");
				commData.ta.setFont(new Font(arr[1],Font.BOLD,Integer.parseInt(arr[0])));
			}
			if(selectedItem.equals("italic"))
			{
				commData.ta.setFont(new Font("Serif",Font.ITALIC,Integer.parseInt(arr[0])));
			}
			commData.file.updateFontSetting(newString);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	public  SettingFrame(Data commData)
	{
		this.commData=commData;
		//tabbedpane
		JPanel EditorPanel=new JPanel();
		EditorPanel.setLayout(new GridLayout(4,0));
		JPanel fontSizePane=new JPanel();
		fontSizePane.add(new JLabel("Font Size:"));
		Vector<String> font=new Vector<String>();
		for(int i=2;i<50;i++)
		{
			font.add(i+"");
		}
		JComboBox<String> fontSize=new JComboBox<>(font);
		fontSize.addActionListener(new ComboBoxFontSizeListener());
		fontSizePane.add(fontSize);
		Vector<String> fontType=new Vector<>();
		String arr[]=new String[]{"Serif"};
		arr=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i=0;i<arr.length;i++)
		{
			fontType.add(arr[i]);
		}
		JComboBox<String> comFontType=new JComboBox<>(fontType);
		comFontType.addActionListener(new ComboBoxFontTypeListener());
		
		//FontType Panel
		JPanel fontTypePanel=new JPanel();
		fontTypePanel.add(new JLabel("Font Type : "));
		fontTypePanel.add(comFontType);
		
		//textType Panel
		JPanel textType=new JPanel();
		Vector<String> textTypeVector=new Vector<>();
		String type[]=new String[]{"plain","bold","italic"};
		for(int i=0;i<type.length;i++)
		{
			textTypeVector.add(type[i]);
		}
		JComboBox<String> comtextType=new JComboBox<>(textTypeVector);
		comtextType.addActionListener(new ComboBoxTextTypeListener());
		textType.add(new JLabel("Text Type"));
		textType.add(comtextType);
		EditorPanel.add(fontSizePane);
		EditorPanel.add(fontTypePanel);
		EditorPanel.add(textType);
		tabbedPane.addTab("Editor", EditorPanel);
		frame.add(tabbedPane);
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
		commData.frame.setEnabled(true);
		frame.setVisible(false);
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
