package TextCorpus;


public class WordPair{
	private String letter;
	private double count;
	
	public WordPair(String letter, double count){
		this.letter = letter;
		this.count = count;
	}
	
	public String getLetter(){
		return letter;
	}
	
	public double getCount(){
		return count;
	}
	
	public void incrementFreq(){
		count++;
	}
	
	public void setCount(double i){
		this.count = i;
	}
}
