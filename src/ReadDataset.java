
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class ReadDataset {
	
	protected List<double[]> features=new ArrayList<>();
	protected List<String> label=new ArrayList<>();
	 protected List<Double> latitudes=new ArrayList<>();
	 protected List<Double> longitude=new ArrayList<>();
	protected static int numberOfFeatures;
	
	public List<double[]> getFeatures()
	{
		return features;
	}
	
	public List<String> getLabel() 
	{
		return label;
	}
	
	void read(String s) throws NumberFormatException, IOException {
		
		File file=new File(s);
		
	try {
		
		BufferedReader readFile=new BufferedReader(new FileReader(file));
		String line;
		
		CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(readFile);      
		   for(CSVRecord record : parser) {
		  latitudes.add(Double.parseDouble(record.get("Latitude")));
		  longitude.add(Double.parseDouble(record.get("Longitude")));
		 }
		   numberOfFeatures = 2;
		   
		   for (int counter = 0; counter < latitudes.size(); counter++) { 
			   double[] feature = new double[2];
			   feature[0]=latitudes.get(counter);
			   feature[1]=longitude.get(counter);
			   features.add(feature);
		  }  

 
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


void display()
{
	Iterator<double[]> itr=features.iterator();
	Iterator<String> sitr=label.iterator();
	while(itr.hasNext())
	{ 
		double db[]=itr.next();
		for(int i=0; i<4;i++)
	{
		System.out.print(db[i]+" ");
	}	
		String s=sitr.next() ;
		System.out.println(s);
	}
	
}
}
