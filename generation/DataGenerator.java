import java.io.*;
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Generates collection of integers from sampling a uniform distribution.
 * 
 * @author jkcchan
 */
public class DataGenerator
{
	/** Program name. */
	protected static final String progName = "DataGenerator";
	
	/** Start of integer range to generate values from. */
	protected int mStartOfRange;
	/** End of integer range to generate values from. */
	protected int mEndOfRange;
	/** Random generator to use. */
	Random mRandGen;
	
	
	/**
	 * Constructor.
	 * 
	 * @param startOfRange Start of integer range to generate values.
	 * @param endOfRange End of integer range to generate values.
	 * @throws IllegalArgumentException If range of integers is inappropriate
	 */
	public DataGenerator(int startOfRange, int endOfRange) throws IllegalArgumentException {
		if (startOfRange < 0 || endOfRange < 0 || startOfRange > endOfRange) {
			throw new IllegalArgumentException("startOfRange or endOfRange is invalid.");
		}
		mStartOfRange = startOfRange;
		mEndOfRange = endOfRange;
		// use current time as seed
		mRandGen = new Random(System.currentTimeMillis());
	} // end of DataGenerator()
	
	
	/**
	 * Generate one sample, using sampling with replacement.
	 */
	public int sampleWithReplacement() {
		return mRandGen.nextInt(mEndOfRange - mStartOfRange + 1) + mStartOfRange;
	} // end of sampleWithReplacement()
	
	
	/**
	 * Generate 'sampleSize' number of samples, using sampling with replacement.
	 * 
	 * @param sampleSize Number of samples to generate.
	 */
	public int[] sampleWithReplacement(int sampleSize) {
		int[] samples = new int[sampleSize];
		
		for (int i = 0; i < sampleSize; i++) {
			samples[i] = sampleWithReplacement();
		}
		
		return samples;
	} // end of sampleWithReplacement()
	
	
	/**
	 * Sample without replacement, using "Algorithm R" by Jeffrey Vitter, in paper "Random sampling without a reservoir".
	 * This algorithm has O(size of range) time complexity.
	 * 
	 * @param sampleSize Number of samples to generate.
	 * @throws IllegalArgumentException When sampleSize is greater than the valid integer range.
	 */
	public int[] sampleWithOutReplacement(int sampleSize) throws IllegalArgumentException {
	    int populationSize = mEndOfRange - mStartOfRange + 1;
	    
	    if (sampleSize > populationSize) {
	    	throw new IllegalArgumentException("SampleSize cannot be greater than populationSize for sampling without replacement.");
	    }
	    
	    int[] samples = new int[sampleSize];
	    // fill it with initial values in the range
	    for (int i = 0; i < sampleSize; i++) {
	    	samples[i] = i + mStartOfRange;
	    }
	    
	    // replace
	    for (int j = sampleSize; j < populationSize; j++) {
	    	int t = mRandGen.nextInt(j+1);
	    	if (t < sampleSize) {
	    		samples[t] = j + mStartOfRange;
	    	}
	    }

	   return samples;
	} // end of sampleWithOutReplacement()
	
	
	/**
	 * Error message.
	 */
	public static void usage() {
		System.err.println(progName + ": <start of range to sample from> <end of range to sample from> <number of values to sample> <type of sampling>");
		System.exit(1);
	} // end of usage()
	
	
	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		
		// check correct number of command line arguments
		if (args.length != 4) {
			usage();
		}
		
	
		try {
			// integer range
			int startOfRange = Integer.parseInt(args[0]);
			int endOfRange = Integer.parseInt(args[1]);
			
			// number of values to sample
			int sampleSize = Integer.parseInt(args[2]);
			
			// type of sampling
			String samplingType = args[3];
			
			DataGenerator gen = new DataGenerator(startOfRange, endOfRange);
			
			int[] samples = null;
			switch (samplingType) {
				// sampling with replacement
				case "with":
					samples = gen.sampleWithReplacement(sampleSize);
					break;
				// sampling without replacement
				case "without":
					samples = gen.sampleWithOutReplacement(sampleSize);
					break;
				default:
					System.err.println(samplingType + " is an unknown sampling type.");
					usage();
			}
			PrintWriter writer = new PrintWriter("7000Nodes.txt", "UTF-8");
			  for(int i = 0; i < samples.length; i++) {
		        	int currNode= samples[i];
		        	if(i==0) {
		        		writer.println(currNode);
		        		writer.println(currNode+" "+ samples[2*i+1]+" "+ samples[2*i+2]);
		        		System.out.println(currNode);
		        		System.out.println(currNode+" "+ samples[2*i+1]+" "+ samples[2*i+2]);
		        	}else
		        	{
		        		try {
		        		writer.println(currNode+" "+ samples[2*i+1]+" "+ samples[2*i+2]);
		        		}catch (Exception e){
		        			
		        		}
		        	}

		        }
			  writer.close();
			// print out samples
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			usage();
		}
		
	} // end of main()
} // end of class DataGenerator
