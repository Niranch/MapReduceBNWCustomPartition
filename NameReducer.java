import java.io.IOException;

import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;



public class NameReducer extends MapReduceBase implements
Reducer<Text,CustomNameFrequency,Text, Text> {

  private Text name = new Text();
  private String myname ="";
  public void reduce(Text key, Iterator<CustomNameFrequency> values,
	      OutputCollector<Text, Text> output, Reporter reporter)
	    	      throws IOException {
	  CustomNameFrequency myobj = new CustomNameFrequency();
	  
	  int max = 0;
	  
    while(values.hasNext())
    {
    	myobj=values.next();
    	if(myobj.getFrequency().get() > max)
    	{
    				
    		max=myobj.getFrequency().get();
    		name=myobj.getName();
    		myname=name.toString();
    		
    	}
    	
	}
   
    output.collect(key,new Text(myname));
  }
 }