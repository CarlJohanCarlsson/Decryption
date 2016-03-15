package Graphics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Languages.Languages;

public class Input {
	private Languages lan;

	
	public Input(Languages lan){
		this.lan = lan;
	}
	
	public Input(){
	}
	
	public int inputConsole(){
		int transString = -1;
		try (BufferedReader in  = new BufferedReader(new InputStreamReader(System.in))){
			while(in!=null){
				System.out.println("Press a letter to be replaced and then enter.");
				String tmp = in.readLine();
				
				int tmp1 = lan.transformInputToInt(tmp);
				System.out.println(tmp1);
				System.out.println("What letter shall ["+tmp+"] be replaced with? ");
				transString = lan.transformInputToInt(in.readLine());
				System.out.println(transString);
				transString-=tmp1;
				transString*=-1;
				break;
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transString;
	}
}