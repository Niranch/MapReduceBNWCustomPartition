# MapReduceBNWCustomPartition
Map reduce code to analyze NationalNames big data dataset. 
Goal: To be able to get the most popular name in the given years in both male and female category.
Mapper class output - Year as key, custom writable(with name, gender, frequency) as value
Custom Partition class - Custom partition class is written to be able the split the map output into two partitions of female and male category. Two reducer will process the category separately.
Reducer-Input: y=Year as key, custom writable(with name, gender, frequency) as value
Reducer - Uses In memory processing to find which name has max frequency for each year
Two reduder files generated one for male, female category with list of year and a corresponding name that was most popular for that year. 
