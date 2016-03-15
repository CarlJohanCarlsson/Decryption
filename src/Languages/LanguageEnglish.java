package Languages;

import java.util.ArrayList;
import java.util.List;

import TextCorpus.WordPair;

public class LanguageEnglish extends Languages {

	public LanguageEnglish(String alphabet) {
		super(alphabet);
		letterCombList = new ArrayList<WordPair>();
		generateSortedList();
	}
	
	public LanguageEnglish() {
		super("abcdefghijklmnopqrstuvwxyz");
		letterCombList = new ArrayList<WordPair>();
		generateSortedList();
	}

	@Override
	public void generateSortedList() {
		letterCombList.add(new WordPair("e", 12.702));
		letterCombList.add(new WordPair("t", 9.056 ));
		letterCombList.add(new WordPair("a", 8.167));
		letterCombList.add(new WordPair("o", 7.507));
		letterCombList.add(new WordPair("i",6.966));
		letterCombList.add(new WordPair("n",6.749));
		letterCombList.add(new WordPair("s", 6.327));
		letterCombList.add(new WordPair("h", 6.094));
		letterCombList.add(new WordPair("r", 5.987));
		letterCombList.add(new WordPair("d", 4.253));
		letterCombList.add(new WordPair("l", 4.025));
		letterCombList.add(new WordPair("c", 2.782));
		letterCombList.add(new WordPair("u", 2.758));
		letterCombList.add(new WordPair("m", 2.406));
		letterCombList.add(new WordPair("w", 2.361));
		letterCombList.add(new WordPair("f", 2.228));
		letterCombList.add(new WordPair("g", 2.015));
		letterCombList.add(new WordPair("y", 1.974));
		letterCombList.add(new WordPair("p", 1.929));
		letterCombList.add(new WordPair("b", 1.492 ));
		letterCombList.add(new WordPair("v", 0.978));
		letterCombList.add(new WordPair("k", 0.772));
		letterCombList.add(new WordPair("j", 0.153));
		letterCombList.add(new WordPair("x", 0.150));
		letterCombList.add(new WordPair("q", 0.095));
		letterCombList.add(new WordPair("z", 0.074));
	}

	@Override
	public void insertSortedList(List<WordPair> list) {
		this.letterCombList = list;
	}

}
