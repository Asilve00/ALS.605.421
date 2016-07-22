import java.util.Vector;

public class Q1{

	private Vector<Double[]> bucket;
	private Vector<Double> ranges;
	private int bkCt;
	public Double[] inValues;
	public Double[][] sortedValues;
	public int setSize;
	
	
	public Q1(Double[] x){
		
		this.bucket = new Vector<Double[]>();
		this.ranges = new Vector<Double>();
		this.inValues = x;
		setSize = inValues.length;
		setRanges();
		bkCt = ranges.size();
	}
	

	/* Method sets the bucket's individual bucket values
	 **/
	
	private void setRanges(){
		double i;
		int j = 0;
		for(i=0.0; i<1;i++){
			ranges.set(j, i);
			j++;
		}
	}
	
	/*Takes an array of unsorted doubles and drops them into the correct
	 buckets to be sorted*/
	public void distribute(){
		int i,j;
		//Cycles through the entire set of values
			for(i=0;i<inValues.length;i++){
				for(j=0;j<bkCt;j++){
					
			}
		
		}
	
	/*Sorts values in the individual buckets from smallest to largest*/
	public void sortValues(){
		int i;
		for(i=0; i<buckets.length; i++){
			buckets[i].list.sort(null);
		}
	}
}
}
