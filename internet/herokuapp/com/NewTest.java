package internet.herokuapp.com;

//import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException {
	  InputStreamReader f = new InputStreamReader(System.in);
	  int a = f.read();
	  File file = new File("a.txt");
	  FileOutputStream fw = new FileOutputStream(file);
	  
	  OutputStreamWriter w = new OutputStreamWriter(fw);
	  f.close();
	  
	  w.write(a);
	  w.close();
	  
	  
  }
}
