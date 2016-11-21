package File;
import java.io.*;

import common.Data;
public class FileManager {
	
	
	public void updateFontSetting(String newString) throws FileNotFoundException
	{
		File f=new File("fontsetting.txt");
		FileOutputStream fout=new FileOutputStream(f);
		PrintWriter pw=new PrintWriter(fout);
		pw.println(newString);
		pw.close();
	}
	public String getFontSetting() throws IOException
	{
		File f=new File("fontsetting.txt");
		FileInputStream fin=new FileInputStream(f);
		BufferedReader bis=new BufferedReader(new InputStreamReader(fin));
		String data=bis.readLine();
		bis.close();
		return data;
	}
	public String getDataFromFile(final File f)
	{
		final StringBuffer finalData=new StringBuffer("");
		if(f.isFile())
		{
			
					FileInputStream fin;
					try {
						byte []buffer=new byte[10240];
						fin = new FileInputStream(f);
						BufferedInputStream br=new BufferedInputStream(fin,buffer.length);
						int c=-1;
						while((c=br.read(buffer))!=-1)
						{
							
							finalData.append(new String(buffer,0,c));
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			return finalData.toString(); 
		}
		return "";
	}
}
