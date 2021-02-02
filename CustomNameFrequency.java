import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;


public class CustomNameFrequency implements Writable
  {

   private Text name;
   private Text gender;
   private IntWritable frequency;

   //Default Constructor
   public CustomNameFrequency() 
   {
    this.name = new Text();
    this.frequency = new IntWritable();   
    this.gender=new Text();
   }

   //Custom Constructor
   public CustomNameFrequency(IntWritable frequency, Text name, Text gender) 
   {
    this.name = name;
    this.frequency = frequency;   
    this.gender=gender;
   }

   //Setter method to set the values
   public void set(IntWritable frequency, Text name, Text gender)
   {
    this.name = name;
    this.frequency = frequency; 
    this.gender=gender;
   }

   //to get name
   public Text getName()
   {
    return name; 
   }
   public IntWritable getFrequency()
   {
	   return frequency;
   }
   public Text getGender()
   {
	   return gender;
   }
   
   
   
   //overriding default readFields method. 
   //It de-serializes the byte stream data
   public void readFields(DataInput in) throws IOException 
   {
    name.readFields(in);
    frequency.readFields(in);  
    gender.readFields(in);
   }

   
   //It serializes object data into byte stream data
   public void write(DataOutput out) throws IOException 
   {
    name.write(out);
    frequency.write(out);   
    gender.write(out);
   }
   
  
 }