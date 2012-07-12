package com.nlputil.gst;

/**
 * Class to store the Matched tile values
 * 
 * @author arunjayapal
 *
 */
public class MatchVals {
	public final int patternPostion;
	public final int textPosition;
	public final int length;
	public MatchVals(int p, int t, int l){
		this.patternPostion = p;
		this.textPosition = t;
		this.length = l;
	}
}
