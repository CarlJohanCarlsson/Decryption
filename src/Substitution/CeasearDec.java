package Substitution;
import java.util.Map;

import Languages.LanguageEnglish;
import Languages.Languages;
import TextCorpus.WordPair;

public class CeasearDec {
	
	/**
	 * Ceasar encryption, replacing every word in the text with the letter Nth jumps forward, F(N)=A+N, B+N,C+N so if N=3 -> A->D, B->E, C->F...
	 * This means that the text is easily reversed aswell just by iterating N
	 * @param text	The text which will be modified
	 * @param chrjmp	Number of steps (N= chrjmp)
	 * @return	Returns modified text
	 */
	public String ceasarDecrypt(String txt2Decrypt, Languages lan, int chrjmp){
		char[] charTxt = txt2Decrypt.toLowerCase().toCharArray();
		char[] charAlphabet = lan.getAlphabet().toCharArray();
		/*	Have to iterate through the alphabet and can not use ASCII lookup, as it will only work for english.*/
		if(chrjmp>charAlphabet.length)chrjmp-=charAlphabet.length;
		if(chrjmp*-1>charAlphabet.length)chrjmp+=charAlphabet.length;
		for(int i = 0; i < charTxt.length;i++){
			for(int j = 0;j<charAlphabet.length;j++){
				if(charTxt[i] == charAlphabet[j]){
					int tmp = chrjmp+j;
					tmp += (tmp<0?charAlphabet.length:0);	//Handling a negative modulo
					tmp = tmp%charAlphabet.length;
					charTxt[i] = charAlphabet[tmp];
					break;
				}
			}
		}
		return new String(charTxt);
	}
	
	/**
	 * Ceasar encryption, replacing every word in the text with the letter Nth jumps forward, F(N)=A+N, B+N,C+N so if N=3 -> A->D, B->E, C->F...
	 * This means that the text is easily reversed aswell just by iterating N
	 * This method can only be used for english letters.
	 * @param text	The text which will be modified
	 * @param chrjmp	Number of steps (N= chrjmp)
	 * @return	Returns modified text
	 */
	public String ceasarDecrypt(String text2Decrypt, LanguageEnglish lan, int chrjmp){
		if(chrjmp>26)chrjmp-=26;
		if(chrjmp*-1>26)chrjmp+=26;
		char[] charArray = text2Decrypt.toCharArray();
		for(int i=0;i<text2Decrypt.length();i++){
			char c = charArray[i];
			if(c >= 'a' && c <= 'z'&&Character.isLetter(c)){
				int tmp = c%'a';
				tmp = (tmp+chrjmp+((tmp+chrjmp)<0?26:0))%26;	//Handling a negative modulo
				c=(char) ((char)tmp+'a');
				charArray[i] = c;
			}
			else if(c >= 'A' && c <= 'Z'&&Character.isLetter(c)){
				int tmp = c%'A';
				tmp = (tmp+chrjmp+((tmp+chrjmp)<0?26:0))%26;	//Handling a negative modulo
				c=(char) ((char)tmp+'A');
				charArray[i] = c;
			}
		}
		return new String(charArray);
	}

}
