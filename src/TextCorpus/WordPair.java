package TextCorpus;


public class WordPair{
	private String letter;
	private double count;
	private int index;
	
	public WordPair(String letter, double count, int index){
		this.letter = letter;
		this.count = count;
		this.index = index;
	}
	
	public WordPair(String letter, double count){
		this.letter = letter;
		this.count = count;
		this.index = -1;
	}
	
	public String getLetter(){
		return letter;
	}
	
	public double getCount(){
		return count;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void incrementFreq(){
		count++;
	}
	
	public void setCount(double i){
		this.count = i;
	}
}
