package Model;

import common.Data;

import view.HelpFrame;
import view.NewFrame;
import view.OpenFrame;
import view.SettingFrame;

public class MenuFactory {
	
	static SettingFrame settingFrame;
	static NewFrame newFrame;
	static OpenFrame openFrame;
	static HelpFrame helpFrame;
	
	public static void getMenuAction(Data commonData,String key)
	{
		if(settingFrame==null)
		{
			settingFrame=new SettingFrame(commonData);
		}
		if(openFrame==null)
		{
			openFrame=new OpenFrame(commonData);
		}
		if(helpFrame==null)
		{
			helpFrame=new HelpFrame(commonData);
		}
		if(newFrame==null)
		{
			newFrame=new NewFrame(commonData);
		}
		if(key.equals("New"))
		{
			newFrame.show();
		}else if(key.equals("Open"))
		{
			openFrame.show();
		}else if(key.equals("Save"))
		{
			
		}else if(key.equals("Settings"))
		{
			settingFrame.show();
		}else if(key.equals("Help"))
		{
			helpFrame.show();
		}
	}

}
