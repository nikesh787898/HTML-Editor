package view;
import common.Data;
import Model.Action;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

public class Design {
	private Data commonData;
	public Design(Data commonData)
	{
		this.commonData=commonData;
		commonData.ta=new JTextArea();
		commonData.lineTextArea=new JTextArea();
		createDesing();
		
		//look n feel of the  menu buttons
		commonData.newButton.setBackground(Color.green);
		commonData.openButton.setBackground(Color.green);
		commonData.saveButton.setBackground(Color.green);
		commonData.settingButton.setBackground(Color.green);
		commonData.helpButton.setBackground(Color.green);
	}
	private JScrollPane treePanel()
	{
		 
		DefaultMutableTreeNode outerTreeNode=new DefaultMutableTreeNode("Files And Directory");
		commonData.tree=new JTree(outerTreeNode);
		commonData.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		return new JScrollPane(commonData.tree);
	}
	void createDesing()
	{
		commonData.frame=new JFrame("Bodacious Web Designer");
		commonData.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image=new ImageIcon("image/icon.jpg");
		commonData.frame.setIconImage(image.getImage());
		
		//adding windowListener
		commonData.frame.addWindowListener(new Action(this.commonData));
		
		//adding windowStateListener
		commonData.frame.addWindowStateListener(new Action(commonData));
		
		commonData.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//commonData.frame.setSize(700,600);
		//adding document listener to the textarea ta of the common data
		commonData.ta.getDocument().addDocumentListener(new Action(this.commonData));
		
		//set font of the textarea
		String fontSetting = null;
		try {
			fontSetting = commonData.file.getFontSetting();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String arr[]=fontSetting.split(",");
		if(arr[2].equals("bold"))
		{
			commonData.ta.setFont(new Font(arr[1],Font.BOLD,Integer.parseInt(arr[0])));
		}
		else if(arr[2].equals("italic"))
		{
			commonData.ta.setFont(new Font(arr[1],Font.ITALIC,Integer.parseInt(arr[0])));
		}
		else
		{
			commonData.ta.setFont(new Font(arr[1],Font.PLAIN,Integer.parseInt(arr[0])));
		}
		JPanel menuPanel=new JPanel();
		menuPanel.setLayout(new BorderLayout());
		//Panel for drag n drop and code
		
		JPanel optionPanel=new ImagePanel();
		//adding mouse listener to the menu button
		commonData.newButton.addMouseListener(new Action(commonData));
		commonData.openButton.addMouseListener(new Action(commonData));
		commonData.saveButton.addMouseListener(new Action(commonData));
		commonData.settingButton.addMouseListener(new Action(commonData));
		commonData.helpButton.addMouseListener(new Action(commonData));
		
		
		//adding actionlistener to the menuButton
		commonData.newButton.addActionListener(new Action(commonData));
		commonData.openButton.addActionListener(new Action(commonData));
		commonData.saveButton.addActionListener(new Action(commonData));
		commonData.settingButton.addActionListener(new Action(commonData));
		commonData.helpButton.addActionListener(new Action(commonData));
		
		//***=======================***
		
		//panel for split ,code and design mode button
		
		JPanel subMenuPanel =new ImagePanel();
		subMenuPanel.add(commonData.codeButton);
		subMenuPanel.add(commonData.splitButton);
		subMenuPanel.add(commonData.DesignButton);
		commonData.codeButton.addActionListener(new Action(commonData));
		commonData.splitButton.addActionListener(new Action(commonData));
		commonData.DesignButton.addActionListener(new Action(commonData));
		
		//***=====================***
		optionPanel.add(commonData.newButton);
		optionPanel.add(commonData.openButton);
		optionPanel.add(commonData.saveButton);
		optionPanel.add(commonData.settingButton);
		optionPanel.add(commonData.helpButton);
		menuPanel.add(optionPanel,"West");
		menuPanel.add(subMenuPanel);
		commonData.pane=new JEditorPane();
		JScrollPane scrollPane=new JScrollPane(commonData.pane);
		commonData.pane.setContentType("text/html");
		commonData.pane.setEditable(false);
		commonData.lineTextArea.setEditable(false);
		JPanel editorPanel=new JPanel();
		editorPanel.setLayout(new BorderLayout());
		editorPanel.add(new JScrollPane(commonData.ta));
		editorPanel.add(commonData.lineTextArea,"West");
		commonData.sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,editorPanel,scrollPane );
		
		//setting divider size JSplitPane and divider color
		commonData.sp.setDividerSize(3);
				
		/******* ==============****/
		editorPanel.setPreferredSize(new Dimension(200,200));
		JScrollPane treePanel=treePanel();
		
		treePanel.setMinimumSize(new Dimension(1000,1000));
		commonData.sp.setMinimumSize(new Dimension(1000,1000));
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,treePanel,commonData.sp);
		splitPane.setOneTouchExpandable(true);
		commonData.frame.add(splitPane);
		commonData.frame.add(menuPanel,"North");
		
		//adding tree panel to the frame
		/*                   ===============*/
		commonData.frame.setVisible(true);
	}
}
