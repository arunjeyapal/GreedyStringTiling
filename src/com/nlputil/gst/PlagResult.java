package com.nlputil.gst;

import java.util.ArrayList;

/**
 * Class for the result of the comparison of two texts for plagiarism.
 * Getter and setter methods here
 *  
 * @author arunjayapal
 */

public class PlagResult {
	public ArrayList<MatchVals> tiles;
	public float similarity;
	public int id1;
	public int id2;
	public int id1StringLength;
	public int id2StringLength;
	public String algName;
	public String normName;
	public boolean suspectedPlagiarism;
	
	public PlagResult(int id1, int id2){
		this.tiles = new ArrayList<MatchVals>();
		this.similarity = (float) 0.0;
		this.id1 = id1;
		this.id2 = id2;
		this.id1StringLength = Integer.toString(id1).length();
		this.id2StringLength = Integer.toString(id2).length();
		this.algName = "";
		this.normName = "";
		this.suspectedPlagiarism = false;
	}
	
	/**
	 * Set tiles found in the Test for plagiarism.
	 * @param tiles
	 */
	public void setTiles(ArrayList<MatchVals> tiles){
		if(tiles.getClass() != new ArrayList<MatchVals>().getClass())
			 System.out.println("NoValidArgumentError: tiles must be of type list");
		else
			this.tiles = tiles;
	}
	
	/**
	 * Get tiles found in the Test for plagiarism.
	 * @return tiles
	 */
	public ArrayList<MatchVals> getTiles(){
		return this.tiles;
	}
	
	/**
	 * Set similarity calculated in the Test for plagiarism.
	 * @param similarity
	 */
	public void setSimilarity(float similarity){
        if (! (0 <= similarity) && (similarity <= 1))
            System.out.println("OutOfRangeError: Similarity value should be out of range 0 to 1.0");
        else
            this.similarity = similarity;
	}
	
	/**
	 * Get similarity calculated in the Test for plagiarism.
	 * @return similarity value
	 */
	public float getSimilarity(){
		return this.similarity;
	}
	
	/**
	 * Set identifier for each compared text.
	 * @param i
	 * @param j
	 */
    public void setIdentifier(int i, int j){
        this.id1 = i;
        this.id2 = j;
    }
	
    /**
     * Get the identifier for the compared texts.
     * @return identifiers
     */
    public Identifiers getIdentifier(){
        if (this.id1 == 0 || this.id2 == 0)
            System.out.println("NoIdentifierSetError: One or both identifier were not set.");
        return (new Identifiers(this.id1, this.id2));
    }
    
    /**
     * Checks if the given identifier is one of the identifier of this result.
     * @param id
     * @return True or False
     */
    public boolean containsIdentifier(String id){
        return (id.equals(this.id1) || id.equals(this.id2));
    }
    
    /**
     * Set the string length of the identifier strings. Important for Visualization.
     * @param id1StringLength
     * @param id2StringLength
     */
    public void setIdStringLength(int id1StringLength, int id2StringLength){
        this.id1StringLength = id1StringLength;
        this.id2StringLength = id2StringLength;
    }
    
    /**
     * Get the string length of the identifier strings as a List[id1strlength, id2strlenght].
     *       Important for Visualization.
     * @return String lengths of id1 and id2
     */
    public StringLengths getIdStringLength(){
        return (new StringLengths(this.id1StringLength, this.id2StringLength));
    }
    
    /**
     * set boolean value: True means there is plagiarism suspicion other False
     * @param value
     */
    public void setSuspectedPlagiarism(boolean value){
        this.suspectedPlagiarism = value;
	}
    
    /**
     * Returns boolean value indicating if there is plagiarism suspcicion.
     * @return boolean value
     */
    public boolean isSuspectPlagiarism(){
        return this.suspectedPlagiarism;
    }
    
    /**
     * Sets the algorithm id used for the comparison.
     * @param algName
     */
    public void setAlgorithmName(String algName){
        this.algName = algName;
    }
    
    /**
     * Gets the algorithm id used for the comparison.
     * @return algorithm name
     */
    public String getAlgorithmName(){
        return this.algName;
    }
    
    /**
     * Sets the normalizer id used for the comparison.
     */
    public void setNormalizerName(String normName){
        this.normName = normName;
    }
    
    /**
     * Gets the normalizer id used for the comparison.
     * @return Normalizer name
     */
    public String getNormalizerName(){
        return this.normName;
    }
    
    /**
     * Method to compare if this object is equal to another one:  this == other
     * @param other object
     * @return True or False
     */
    public boolean __eq__(PlagResult other){
        if (other.equals(null))
            return false;
        else if ((this.getIdentifier().equals(other.getIdentifier())) && (this.getSimilarity() == other.getSimilarity()) && (this.getTiles().equals(other.getTiles())) && (this.getIdStringLength() == other.getIdStringLength()))
            return true;
        return false;
    }
  
    /**
     * Method to compare if this object ist NOT equal with another object: this != other
     * @param other
     * @return
     */
    public boolean __ne__(PlagResult other){
        return (! this.__eq__(other));
    }
    
    /**
     * Returns the informal string representation of this PlagResult object.
     * @return String
     */
    public String __str__(){
    	String val = "PlagResult:\n"
                + " Identifier: " + this.getIdentifier().toString() + '\n'
                + " Similarity: " + this.getSimilarity() + '\n'
                + " Tiles: " + this.getTiles() + "\n"
                + " supected Plagiarism: " + this.isSuspectPlagiarism() + '\n';
        return val;
    }
  
    /**
     * Returns the form string representation of this PlagResult object.
     * @return String
     */
    public String __repr__(){
        return this.getIdentifier().toString()+" "+this.getSimilarity()+" "+
                this.getTiles()+" "+this.isSuspectPlagiarism();
    }
}
