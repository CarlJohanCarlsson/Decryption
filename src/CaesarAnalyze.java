import Substitution.CeasearDec;
import TextCorpus.*;
import Graphics.*;
import Languages.*;


public class CaesarAnalyze {	
	
	public static void main(String[] args) {
		CeasearDec cd = new CeasearDec();
		
		Languages lan = new LanguageSwedish();	//Choose what kind of language to use when decrypting.
		//Languages lan = new LanguageEnglish();
		
		Corpus corpus = new Corpus(".\\Textfiles\\Caesarfile.txt",lan);
		String s1 =corpus.getText();
		
		corpus.countLetterFrequency(s1);
		
		//Prints out a two graphs, the upper graph is the letters most common in the text
		//The graph below is the most common words in the language provided.
		new Screen(new GraphingData(lan,corpus));
		
		//Read input from console
		int nrStepsToShift = new Input(lan).inputConsole();
		
		//Prints out the answer to console
		System.out.println(cd.ceasarDecrypt(s1, lan, nrStepsToShift));
	}
}