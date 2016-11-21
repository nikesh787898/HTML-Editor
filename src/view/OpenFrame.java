package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Model.Action;

import common.Data;

public class OpenFrame 
{
	private Data commonData;
	public OpenFrame(Data commData)
	{
		this.commonData=commData;
		
	}
	public void show()
	{
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option=fileChooser.showOpenDialog(commonData.frame);
		if(option==JFileChooser.APPROVE_OPTION)
		{
			 File file = fileChooser.getSelectedFile();
			 commonData.currentDirectory=file;
			 new Action(commonData).jFileChooserAction();
		}
		fileChooser.setVisible(true);
	}
}
