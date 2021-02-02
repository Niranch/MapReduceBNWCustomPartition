import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.util.logging.Logger;

public class NameMapper extends MapReduceBase implements
Mapper<LongWritable, Text, Text, CustomNameFrequency> {
	 CustomNameFrequency myobj = new CustomNameFrequency();
	 IntWritable frequency = new IntWritable();
	 Text name = new Text();
	 Text gender = new Text();
	 Logger maplog = Logger.getLogger(NameMapper.class.getName());
	 
@Override
	  
	public void map(LongWritable key, Text value,
	      OutputCollector<Text, CustomNameFrequency> output, Reporter reporter)
	      throws IOException {
	
    String[] words = value.toString().split(",") ;
    //maplog.info(words[1]);  
    try
    {
    	 frequency.set(Integer.parseInt(words[4]));
    	 name.set(words[1]); 
    	 gender.set(words[3]);
    	 myobj.set(frequency,name,gender);
    	 //maplog.info(name+" "+frequency+" "+gender);
    	 output.collect(new Text(words[2]),myobj);
    }catch(Exception e){}
   
  }
}