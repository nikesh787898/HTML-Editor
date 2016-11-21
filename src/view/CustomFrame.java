package view;

import java.awt.Frame;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import common.Data;
public class CustomFrame extends JFrame
{
	Data commonData;
	JList<String> optionList=new JList<>();
	public CustomFrame(Data commonData)
	{
		DefaultListModel<String> model=new DefaultListModel<>();
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some");
		model.addElement("Hello");
		model.addElement("Some"); 
		add(new JScrollPane(new JList<String>(model)));
		this.commonData=commonData;
		setUndecorated(true);
		setOpacity(0.9f);
	}
}