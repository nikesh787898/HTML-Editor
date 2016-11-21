package common;
import java.io.File;

import javax.sql.CommonDataSource;
import javax.swing.*;
/*
 * the class is singleton class , in whole project the data will be common for all 
 * the class file
 * */

import File.FileManager;
public class Data {
	
	//file
	
	public FileManager file=new FileManager();
	//Instance varible
	
	//Current Directory
	public File currentDirectory;
	
	
	//Jtree for file n Directory
	public JTree tree;
	
	public FlagForThread threadFlag=new FlagForThread(); //flag for ResultThread
	public JTextArea ta; //textarea for html code
	public JTextArea lineTextArea; 
	public JSplitPane sp;
	
	public JEditorPane pane; //editorpane for showing html result
	public JFrame frame; //main frame of the project
	public JButton newButton=new JButton("New");
	public JButton openButton=new JButton("Open");
	public JButton saveButton=new JButton("Save");
	public JButton settingButton=new JButton("Settings");
	public JButton helpButton=new JButton("Help");
	
	
	
	
	//for current state of the divider
	public double dividerState;
	
	public JButton codeButton=new JButton("Code");
	public JButton DesignButton=new JButton("Design");
	public JButton splitButton=new JButton("Split");
	
	
	
	//static varibles
	private static Data d; //singleton object
	
	
	
	
	
	
	
	
	private Data()   //private constructor 
	{
		
	}
	static  //static block for singleton class
	{
		d=new Data();
	}
	static public Data getInstance()
	{
		return d;
	}
}
