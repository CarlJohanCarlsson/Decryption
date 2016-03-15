package Languages;
import java.util.ArrayList;
import java.util.List;

import TextCorpus.WordPair;


public class LanguageSwedish extends Languages{
	
	public LanguageSwedish(String alphabet) {
		super(alphabet);
		generateSortedList();
	}
	
	public LanguageSwedish(){
		super("abcdefghijklmnopqrstuvwxyzåäö");
		letterCombList = new ArrayList<WordPair>();
		//generateLetterMap();
		generateSortedList();
	}
	
	/**
	 * From wikipedia/bokstavsfrekvens
	 * Yes, its ugly. 
	 */
	public void generateSortedList(){
		letterCombList.add(new WordPair("e", 10.149));
		letterCombList.add(new WordPair("a", 9.383 ));
		letterCombList.add(new WordPair("n", 8.542));
		letterCombList.add(new WordPair("r", 8.431));
		letterCombList.add(new WordPair("t", 7.691));
		letterCombList.add(new WordPair("s", 6.590));
		letterCombList.add(new WordPair("i", 5.817));
		letterCombList.add(new WordPair("l", 5.275));
		letterCombList.add(new WordPair("d", 4.702));
		letterCombList.add(new WordPair("o", 4.482));
		letterCombList.add(new WordPair("m", 3.471));
		letterCombList.add(new WordPair("k", 3.140));
		letterCombList.add(new WordPair("g", 2.862));
		letterCombList.add(new WordPair("v", 2.415));
		letterCombList.add(new WordPair("h", 2.090));
		letterCombList.add(new WordPair("f", 2.027));
		letterCombList.add(new WordPair("u", 1.919));
		letterCombList.add(new WordPair("p", 1.839));
		letterCombList.add(new WordPair("ä", 1.797));
		letterCombList.add(new WordPair("b", 1.535 ));
		letterCombList.add(new WordPair("c", 1.486));
		letterCombList.add(new WordPair("å", 1.338));
		letterCombList.add(new WordPair("ö", 1.305));
		letterCombList.add(new WordPair("y", 0.708));
		letterCombList.add(new WordPair("j", 0.614));
		letterCombList.add(new WordPair("x", 0.159));
		letterCombList.add(new WordPair("w", 0.142));
		letterCombList.add(new WordPair("z", 0.070));
		letterCombList.add(new WordPair("q", 0.020));
	}

	

	@Override
	public void insertSortedList(List<WordPair> list) {
		this.letterCombList = list;
	}
}
