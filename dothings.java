package filemap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class dothings {
    FileReader filereader;
    BufferedReader breader;
    File dir;
    static HashMap<Integer,String> map;
    Path filePath;
    Charset charset;
    
    public dothings() throws IOException
    {

	JFileChooser fileChoser=new JFileChooser(System.getProperty("user.dir",".")); 
	// this will by default open the user current directory to choose the file
	fileChoser.setAcceptAllFileFilterUsed(false);
	// this means not all file types will be shown. only files which match your filters defined will be shown
	fileChoser.addChoosableFileFilter(new FileNameExtensionFilter("*.text", "txt"));   // this will show only all txt file
	if ( fileChoser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) 
		{
	    	 filePath = Paths.get(fileChoser.getSelectedFile().getPath());
	         charset = StandardCharsets.UTF_8;
	         filePath.toUri();
        	String fileName = fileChoser.getSelectedFile().getPath(); // this gives the OS file path
        	dir = fileChoser.getSelectedFile(); // give the selected file in object format
        	System.out.println(fileName);
        	// default constructor
        	filereader = null;
		try {
		    filereader = new FileReader(dir);
		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} // read  the file
        	 breader = new BufferedReader(filereader);	
        	createmap();
        	parsefile();
		}
    
    }// end of constructor

    private void createmap() {
	map=new HashMap<Integer,String>();//Creating HashMap 
	// TODO Auto-generated method stub
    }
    private void parsefile() throws IOException {
	//final as we dont want to make any changes to it
	final List<String> lines = Files.readAllLines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8);
	for (String line:lines)
	    System.out.println(line);
	
	// following lines are useless
	Boolean filenotfinished=true;
	String currentline="";
	while (filenotfinished)
	    try {
		currentline=breader.readLine();
//		int pointeroffset=filereader.getFilePointer();
		// java.nio.file.Files.readAllLines(dir);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
} // end  of class