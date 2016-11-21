package Model;

import java.awt.Point;

import view.CustomFrame;

import common.Data;

public class IntelSenceThread extends Thread {
	
	Data commonData;
	public IntelSenceThread(Data commonData)
	{
		this.commonData=commonData;
		start();
	}
	public void run()
	{
		CustomFrame frame=new CustomFrame(commonData);
		while(true)
		{
			if(commonData.threadFlag.flag==false)
			{
				System.out.println("Thread Running IntelSence");
				Point pt = commonData.ta.getCaret().getMagicCaretPosition();
				System.out.println(pt);
				if(pt!=null)
				{
					pt.x+=150;
					pt.y+=80;
					frame.setLocation(pt);
					frame.setSize(200,200);
					frame.setVisible(true);
				}
				commonData.threadFlag.flag=true;
			}
		}
	}

}
