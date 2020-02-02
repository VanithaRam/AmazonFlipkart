package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileLibrary implements iFilePath
{
	public String getDataFromProperties(String key)
	{
		Properties propObj = new Properties();
		try
		{
			propObj.load(new FileInputStream(PROP_PATH));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return propObj.getProperty(key);	
	}
}
