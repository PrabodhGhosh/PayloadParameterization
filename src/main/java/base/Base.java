package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
	public static Properties prop;
	public static FileInputStream fis; 
	public static String HomeDir;
	
	public static void initialize() throws IOException
	{
		HomeDir= System.getProperty("user.dir");
		String AbsolutePath= "\\src\\main\\java\\config\\config.properties";
		
		String filepath= HomeDir+AbsolutePath;
		
		fis = new FileInputStream(filepath);
		
		prop= new Properties();
		prop.load(fis);
	}

}
