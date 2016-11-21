package Model;
import java.awt.Point;

import view.CustomFrame;

import common.Data;
import common.FlagForThread;
public class ResultThead extends Thread {
	private Data commonData;
	public ResultThead(Data commonData)
	{
		this.commonData=commonData;
		super.start();
	}
	public void run()
	{
		int i=0;
		CustomFrame frame=new CustomFrame(commonData);                            
		while(true)
		{
			if(commonData.threadFlag.flag==false)
			{
				//forResult
				System.out.println("thread Running");
				String data=commonData.ta.getText();
				commonData.pane.setText(data);
				commonData.threadFlag.flag=true;
				
				//for Intelsence
				
				System.out.println(commonData.sp.getDividerLocation());
				Point pt = commonData.ta.getCaret().getMagicCaretPosition();
				System.out.println(pt);
				if(pt!=null)
				{
					pt.x+=150;
					pt.y+=80;
					if((pt.x-30)>commonData.sp.getDividerLocation())
					{
						pt.x=commonData.sp.getDividerLocation()+15;
						pt.x=pt.x%commonData.ta.getWidth();
					}
					frame.setLocation(pt);
					frame.setSize(200,200);
					frame.setVisible(true);
				}
				
			}
			i++;
			if(i==100)
			{
				
					try
					{
						sleep(500);
						i=0;
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
			}
		}
	}
}
