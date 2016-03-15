import Substitution.CeasearDec;
import TextCorpus.*;
import Graphics.*;
import Languages.*;


public class CaesarAnalyze {	
	
	public static void main(String[] args) {
		Languages lan = new LanguageSwedish();
		//Languages lan = new LanguageEnglish();
		Corpus corpus = new Corpus(".\\Textfiles\\Caesarfile.txt",lan);
		String s1 =corpus.getText();
		corpus.countLetterFrequency(s1);
		new Screen(new GraphingData(lan,corpus));
		int nrStepsToShift = new Input(lan).inputConsole();
		CeasearDec cd = new CeasearDec();
		System.out.println(nrStepsToShift);
		System.out.println(cd.ceasarDecrypt(s1, new LanguageEnglish(), nrStepsToShift));
		//System.out.println(cd.ceasarDecrypt(s1, new LanguageEnglish(), nrStepsToShift));
	}
}