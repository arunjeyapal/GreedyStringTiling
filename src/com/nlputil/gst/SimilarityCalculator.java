package com.nlputil.gst;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to compute similarity between the source file 
 * and the plagiarized file
 * 
 * @author arunjayapal
 */
public class SimilarityCalculator {
	
	/**
	 * Calculates Similarity and returns list [similarity:float, suspectedPlagiarism:bool]
	 * 
	 * 2* Sum(length of each tile) / (length of document1 + length of document2)
	 * 
	 * @param s1List
	 * @param s2List
	 * @param tiles
	 * @param threshold
	 * @return similarityValue, suspectedPlagiarism
	 */
	public static SimVal calcSimilarity(List<String> s1List, List<String> s2List, ArrayList<MatchVals> tiles, float threshold ){
		float similarity = sim(s1List, s2List, tiles);
		boolean suspPlag = false;
		
		if(similarity >= threshold)
			suspPlag = true;
		
		return (new SimVal(similarity, suspPlag));
	}

	/**
	 * Returns similarity value for token of text A and B and the similary tiles covered.
	 * @param s1List
	 * @param s2List
	 * @param tiles
	 * @return similarityValue
	 */
	private static float sim(List<String> s1List,
			List<String> s2List, ArrayList<MatchVals> tiles) {
		
		return ((float)(2*coverage(tiles))/(float)(s1List.size()+s2List.size()));
	}

	/**
	 * Sum of length of all tiles
	 * @param tiles
	 * @return
	 */
	private static int coverage(ArrayList<MatchVals> tiles) {
		int accu = 0;
		for (MatchVals tile : tiles){
			accu += tile.length;
		}	
		return accu;
	}
	
}
