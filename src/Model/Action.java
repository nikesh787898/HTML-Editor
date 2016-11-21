package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import File.FileManager;
import common.Data;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Action implements ActionListener,WindowListener,DocumentListener,MouseListener,WindowStateListener,TreeSelectionListener 
{
	Data commonData;
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)commonData.tree.getLastSelectedPathComponent();
		System.out.println(node);
		FileManager file=new FileManager();
		String data=file.getDataFromFile(new File(commonData.currentDirectory+"/"+node));
		commonData.ta.setText(data);
	}
	public void jFileChooserAction()
	{
		FilenameFilter filter=new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".html") || name.toLowerCase().endsWith(".css") || name.toLowerCase().endsWith(".php") || name.toLowerCase().endsWith(".asp") || name.toLowerCase().endsWith(".jsp");
			}
		};
		DefaultMutableTreeNode rootNode=new DefaultMutableTreeNode(commonData.currentDirectory);
		File arr[]=commonData.currentDirectory.listFiles(filter);
		DefaultMutableTreeNode arrChild[]=new DefaultMutableTreeNode[arr.length];
		for(int i=0;i<arrChild.length;i++)
		{
			String file=arr[i].getName();
			arrChild[i]=new DefaultMutableTreeNode(file);
			rootNode.add(arrChild[i]);
		}
		DefaultTreeModel model=new DefaultTreeModel(rootNode);
		commonData.tree.setModel(model);
		commonData.tree.getSelectionModel().addTreeSelectionListener(this);
	}
	
	@Override
	public void windowClosed(WindowEvent we)
	{
		int flag=JOptionPane.showConfirmDialog(commonData.frame, "Do u Want to Exit?");
		if(flag==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	@Override
	public void windowClosing(WindowEvent we)
	{
		int flag=JOptionPane.showConfirmDialog(commonData.frame, "Do u Want to Exit?");
		if(flag==JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	@Override
	public void windowDeactivated(WindowEvent we)
	{
		
	}
	@Override
	public void windowDeiconified(WindowEvent we)
	{
		
	}
	@Override
	public void windowIconified(WindowEvent we)
	{
		
	}
	@Override
	public void windowOpened(WindowEvent e)
	{
		
	}
	public Action(Data d)
	{
		this.commonData=d;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String key=ae.getActionCommand();
		if(key.equals("Code"))
		{
			commonData.dividerState=1.0;
			commonData.sp.setDividerLocation(commonData.dividerState);
		} else if(key.equals("Split"))
		{
			commonData.dividerState=0.5;
			commonData.sp.setDividerLocation(commonData.dividerState);
		} else if(key.equals("Design"))
		{
			commonData.dividerState=0.0;
			commonData.sp.setDividerLocation(commonData.dividerState);
		} else 
		{
			MenuFactory.getMenuAction(commonData,key);
		}
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		System.out.println("Change Update");
		commonData.threadFlag.flag=false;
	}
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		System.out.println("Change Update");
		commonData.threadFlag.flag=false;
		
		
	}
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		
		System.out.println("Change Update");
		commonData.threadFlag.flag=false;
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		
		JButton b=(JButton)me.getSource();
		b.setBackground(Color.blue);
	}
	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		JButton b=(JButton)me.getSource();
		b.setBackground(Color.BLUE);
		
	}
	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		JButton b=(JButton)me.getSource();
		b.setBackground(Color.green);
	}
	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		JButton b=(JButton)me.getSource();
		b.setBackground(Color.red);
		
	}
	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		JButton b=(JButton)me.getSource();
		b.setBackground(Color.green);
	}
	@Override
	public void windowStateChanged(WindowEvent arg0) {
		System.out.println("StateChanged");
		commonData.sp.setDividerLocation(commonData.dividerState);
		commonData.sp.repaint();
	}

	

}
