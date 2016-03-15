package Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import Languages.Languages;
import TextCorpus.Corpus;
import TextCorpus.WordPair;

 
public class GraphingData extends JPanel {
    private Map<String, WordPair> letterMap;
    private String alphabet;
    private List<WordPair> corpusLetterFreq;
    private int totLetters;
    private List<WordPair> sortedLetterFreqLanguage;
	
    final int intOffset = 20;
    
    
    
    public GraphingData(Languages lan, Corpus corpus){
    	sortedLetterFreqLanguage = lan.getFreqList();
    	letterMap = lan.getLetterMap();
    	alphabet = lan.getAlphabet();
    	totLetters = corpus.getTotalLetters();
    	sortedLetterFreqLanguage = lan.getFreqList();
    	corpusLetterFreq = corpus.transformMapToSortedList();
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int w = getWidth();
        int h = getHeight()/2;
        
        //First graph
        g2.draw(new Line2D.Double(intOffset, intOffset, intOffset, h-intOffset));
        g2.drawString("(%)", intOffset-10, intOffset);
        g2.draw(new Line2D.Double(intOffset, h-intOffset, w-intOffset+15, h-intOffset));
        double xInc = (double)(w - 2*intOffset)/(letterMap.size()-1)-1;
        double scale = (double)(h - 2*intOffset)/corpusLetterFreq.get(0).getCount();
        
        //Second graph
        g2.drawString("(%)", intOffset-10, h-intOffset+30);
        g2.draw(new Line2D.Double(intOffset, 2*h-intOffset, intOffset, h-intOffset));
        g2.draw(new Line2D.Double(intOffset, 2*h-intOffset, w-intOffset+15, 2*h-intOffset));
        
        // Paint the points in red
        g2.setPaint(Color.red);
        
        for(int i = 0; i < alphabet.length(); i++) {
        	String s = corpusLetterFreq.get(i).getLetter();
        	double x = (intOffset+15) + i*xInc;
            double y = h - intOffset - scale*(corpusLetterFreq.get(i).getCount());
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
            g2.drawString(s, (int)x, h-intOffset+15);
            String formatedValue= new DecimalFormat("#.#").format((float)corpusLetterFreq.get(i).getCount()*100/totLetters);
            g2.drawString(formatedValue, (int) x, (int) y-10);
        }
        scale = (double)(h - 2*intOffset)/sortedLetterFreqLanguage.get(0).getCount();
        for(int i = 0; i < alphabet.length(); i++) {
        	String s = sortedLetterFreqLanguage.get(i).getLetter();
        	double x = (intOffset+15) + i*xInc;
        	double y = 2*h-intOffset - scale*(sortedLetterFreqLanguage.get(i).getCount());
        	g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        	g2.drawString(s, (int)x, 2*h-intOffset+15);
        	String formatedValue= new DecimalFormat("#.#").format(sortedLetterFreqLanguage.get(i).getCount());
        	g2.drawString(formatedValue, (int) x, (int) y-10);
        }
    }
}