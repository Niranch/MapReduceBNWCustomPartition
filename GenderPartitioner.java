
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Partitioner;


public class GenderPartitioner extends MapReduceBase implements Partitioner< Text, CustomNameFrequency >
   {
	   
   @Override
      public int getPartition(Text key, CustomNameFrequency value, int numReduceTasks)
      {
    	 CustomNameFrequency partobj = new CustomNameFrequency();
    	 partobj=value;
    	 String gender = "test";    	
    	 gender = partobj.getGender().toString();    	
    	     
         if(numReduceTasks == 0)
         {
            return 0;
         }
         
         if(gender.charAt(0)=='F')
         {
            return 0;
         }
         else if(gender.charAt(0)=='M')
         {
            return 1 % numReduceTasks;
         }
         else
         {
            return 2 % numReduceTasks;
         }
      }
	}
   