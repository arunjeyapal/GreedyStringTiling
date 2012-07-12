package com.nlputil.gst;

/**
 * Class to store the similarity parameters
 * 
 * @author arunjayapal
 *
 */
public class SimVal {
	public final float similarity;
	public final boolean suspPlag;
	public SimVal(float similarity, boolean suspPlag){
		this.similarity = similarity;
		this.suspPlag = suspPlag;
	}
}
