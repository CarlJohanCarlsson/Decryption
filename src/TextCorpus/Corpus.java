package TextCorpus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import Languages.Languages;

public class Corpus {
	private int nrOfLetters;
	private Languages lan;
	private Map<String, WordPair> letterMap;
	private String text;

	/** 
	 * @param file The file to read and analyze
	 * @param lan The language to use.
	 */
	public Corpus(String file, Languages lan){
		this.lan = lan;
		this.letterMap = lan.getLetterMap();
		try {
			readTextFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		countLetterFrequency(text);
	}
	
	/** 
	 * If no file is going to be used.
	 * @param lan The language to use.
	 */
	public Corpus(Languages lan){
		this.lan = lan;
		this.letterMap = lan.getLetterMap();
	}
	
	public void readTextFile(String file) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			text = sb.toString();
			br.close();
		} 
	}
	
	/**
	 * Returns the amount of letters in the text in total.
	 */
	public int getTotalLetters(){
		return nrOfLetters;
	}
	
	public String getText(){
		return text;
	}
	
	public Map<String, WordPair> getLetterMap(){
		return letterMap;
	}
	
	/**
	 * Counts the amounts of letters in the provided text.
	 * @param text
	 */
	public void countLetterFrequency(String text){
		for(char c : text.toCharArray()){
			String s = String.valueOf(c).toLowerCase();
			if(letterMap.containsKey(s)){	//Have already set all the keys
				letterMap.get(s).incrementFreq();
				nrOfLetters++;	//Only interested in words
			}
		}
	}
	
	public List<WordPair> transformMapToSortedList(){
		char[] alphabet = lan.getAlphabet().toCharArray();
		List<WordPair> list = new ArrayList<WordPair>();
		for(int i = 0; i < alphabet.length; i++){
			WordPair tmp = letterMap.get(String.valueOf(alphabet[i]));
			list.add(tmp);
		}
		Collections.sort(list, new CompareWordFrequency());
		return list;
	}
	
	public class CompareWordFrequency implements Comparator<WordPair>{

		@Override
		public int compare(WordPair o1, WordPair o2) {
			return o1.getCount() > o2.getCount() ? -1 : o1.getCount() == o2.getCount() ? 0 : 1;
		}	
	}
}
