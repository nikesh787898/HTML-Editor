package Run;
import javax.swing.UIManager;

import Model.IntelSenceThread;
import Model.ResultThead;

import common.Data;
import view.*;
public class RunFile {
	public static void main(String args[]) throws Exception
	{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		Data data=Data.getInstance();
		new Design(data);
		new ResultThead(data);
		//new IntelSenceThread(data);
	}
}
