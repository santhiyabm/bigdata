package pigdemo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.pig.ExecType;
import org.apache.pig.PigServer;
import org.apache.pig.backend.executionengine.ExecException;

public class PigDemo {
   public static void main(String[] args) throws ExecException {
      
      PigServer pigServer = new PigServer(ExecType.MAPREDUCE);
       //System.out.println("wel1");
      try {
         // /home/cloudera/workspace/pigdemo/src/pigdemo/script/test.pig
         //pigServer.registerJar("/mylocation/tokenize.jar");
         File file=new File("/home/cloudera/workspace/bigproject/output");
         
        if(file.isDirectory())
        {
            File[] ff=file.listFiles();
   for (File f : ff) {
           f.delete();
        }
   file.delete();
    System.out.println("deleted");
        }
      }
      catch(Exception e)
      {
          
      }
      try{
          runMyQuery(pigServer);
          File file=new File("/home/cloudera/workspace/bigproject/output");
         
        if(file.isDirectory())
        {
            File[] ff=file.listFiles();
            File c=new File("/home/cloudera/workspace/bigproject/output/part-00000");
            FileReader fr=new FileReader(c);
            String value="";
            BufferedReader br=new BufferedReader(fr);
            while((value=br.readLine())!=null)
            {
                System.out.println("check"+value);
            }
            
   
        }
         
         //pigServer.registerScript("/home/cloudera/workspace/pigdemo/src/pigdemo/script/test.pig");      //runMyQuery(pigServer);
         //System.out.println("wel");
         //Properties props = new Properties();
          //System.out.println("wel");
         //props.setProperty("fs.default.name", "hdfs://localhost:8020");
        } 
      catch (IOException e) {
          System.out.println(e);
        }
   }
   
   public static void runMyQuery(PigServer pigServer) throws IOException {        
      //pigServer.registerQuery("input1 = LOAD '/input' as (line:chararray);");
      String i="amaz-lap";
      pigServer.registerQuery("amazon = load '/home/cloudera/workspace/bigproject/amazon/"+i+"' USING PigStorage(',') as (id:chararray,name:chararray,core:chararray,ram:chararray,color:chararray,price:long,rating:float,review:chararray);");
pigServer.registerQuery("laptop = FOREACH amazon generate name;");
 
pigServer.registerQuery("store laptop into '/home/cloudera/workspace/bigproject/output';");
 
 
/*pigServer.registerQuery("words = foreach input1 generate FLATTEN(TOKENIZE(line)) as word;");
 
pigServer.registerQuery("word_groups = group words by word;");
 
pigServer.registerQuery("word_count = foreach word_groups generate group, COUNT(words);");
 
pigServer.registerQuery("ordered_word_count = order word_count by group desc;");
 
pigServer.registerQuery("store ordered_word_count into '/wct_output';");*/
 
   }
}