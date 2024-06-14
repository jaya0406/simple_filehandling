package filehandling.basics_of_filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Basics_filehandling_concepts_text_file
{
	String fp=System.getProperty("user.dir") +"\\NewDir\\NewFile.txt";
	
	public void createNewFolder()//to create new dir(folder)
	{
		String filepath="C:\\Users\\SIVAGAMI\\eclipse-workspace\\basics_of_filehandling\\NewDir";
		
		File f = new File(filepath);
		if(f.exists())
		{
			System.out.println("Given dir is Existed!!!");// verifying whether the folder existed...
		}
		else
		{
			f.mkdirs();
			System.out.println("Created...");
		}
	}

	public void createNewFile() throws IOException//to create new FILE
	{
		//String fp="C:\\Users\\SIVAGAMI\\eclipse-workspace\\basics_of_filehandling\\NewDir\\NewFile.txt";//creating new text file...
		
		File f = new File(fp);
		
		if(f.createNewFile())
		{
			System.out.println("New File Created....");
		}
		else
		{
			System.out.println("Error!!");
		}
	}
	
	public void delefile()// to delete file
	{
		File f2 = new File(fp);
		
		if(f2.exists())//if this file --NewFile.txt is exist..
		{
			if(f2.delete())
			{
			System.out.println("File deleted Sucessfully....");
			}
			else
			{
				System.out.println("Error....");
			}
		}
	}
	
	public void toWrite() throws IOException//to write into the text file
	{
		String texttowrite="Hello I'm Jayalakshmi!!!";
		
		File f1 = new File(fp);
		FileWriter fw = new FileWriter(f1);
		
		fw.write(texttowrite);
		fw.close();//crucial to close the file after writing....
		System.out.println("Done!!!");
	}
	
	public void toReadfromfileusingFileREader() throws IOException
	{
		File f3 = new File(fp);
		FileReader fr = new FileReader(f3);//Reads Byte by byte from file only from text file...returns integer value(ASCII value of the character)
		//BufferedReader bf = new BufferedReader(fr);//reads line by line from file....(String by String)
		int i = 0;
		
		while((i=fr.read())!=-1)//reads file using file reader
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print((char)i);//type casting int to char
		}
		
		
	}
	
	public void toReadfromfileusingFileInputStream() throws IOException
	{
		File f3 = new File(fp);
		FileInputStream fis = new FileInputStream(f3);//Reads Byte by byte from file...returns integer value(ASCII value of the character)
		
		int i = 0;
		
		while((i=fis.read())!=-1)//reads file using file reader
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print((char)i);
		}
		
		
	}
	
	public void toReadfromfileusingBufferedReader() throws IOException 
	{
		File f3 = new File(fp);
		FileReader fr = new FileReader(f3);//Reads Byte by byte from file...returns integer value(ASCII value of the character)
		BufferedReader bf = new BufferedReader(fr);//reads line by line from file....(String by String)--accompany with file reader or file input stream
		
		String get;
		while((get=bf.readLine())!=null)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("\n"+get);
		}
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Basics_filehandling_concepts_text_file bfc = new Basics_filehandling_concepts_text_file();
		//bfc.createNewFolder();
		//bfc.createNewFile();
		//bfc.toWrite();
		//bfc.delefile();
		bfc.toReadfromfileusingFileREader();
		bfc.toReadfromfileusingFileInputStream();
		bfc.toReadfromfileusingBufferedReader();
	}

}
