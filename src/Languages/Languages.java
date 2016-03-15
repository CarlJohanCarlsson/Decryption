package Languages;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TextCorpus.WordPair;


public abstract class Languages{
	protected List<WordPair> letterCombList;
	protected String alphabet;
	protected Map<String, WordPair> letterMap;
	
	
	public Languages(String alphabet){
		this.alphabet = alphabet;
		letterCombList = new ArrayList<WordPair>();
		generateLetterMap();
	}
	
	/**
	 * Returns a list with letters and the number of times they appear in an average text, in percentage (example 5.34). 
	 * @return
	 */
	public List<WordPair> getFreqList(){
		return letterCombList;
	}
	
	public String getAlphabet(){
		return alphabet;
	}
	
	public Map<String, WordPair> getLetterMap(){
		return letterMap;
	}
	
	/**
	 * Generates a map with every letter in the provided alphabet.
	 * @return
	 */
	protected void generateLetterMap(){
		letterMap = new HashMap<String,WordPair>();
		for(char c : alphabet.toCharArray()){
			String s = String.valueOf(c);
			letterMap.put(s, new WordPair(s, 0));
		}
	}
	
	public int transformInputToInt(String s){
		char[] a = alphabet.toCharArray();
		for(int i = 0; i<alphabet.length();i++){
			if(a[i] == s.charAt(0)){
				return i;
			}
		}
		return -1;
	}
	
	public abstract void generateSortedList();
	
	public abstract void insertSortedList(List<WordPair> list);
}
