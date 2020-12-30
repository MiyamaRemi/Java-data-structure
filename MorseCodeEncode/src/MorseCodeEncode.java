import java.io.File;  
import java.io.BufferedReader;   
import java.io.FileReader;  

public class MorseCodeEncode {
	static String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....",
			"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
			"..-","...-",".--","-..-","-.--","--..",".----","..---","...--","....-",
			".....","-....","--...","---..","----.","-----"};
	static char[] morseChar = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
			'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5',
			'6','7','8','9','0'};
	
	public static String txtToString(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            //构造一个BufferedReader类来读取文件
            String str = null;
            while((str = br.readLine()) != null){
                result.append(System.lineSeparator()+str);
                }
            br.close();    
            }catch(Exception e){
                e.printStackTrace();
        }
        return result.toString();
    }

	
    public static void main(String[] args) {
    	File file = new File("C:\\eclipse-workspace\\encode.txt");
    	String Str = txtToString(file);
    	String[] morseWords = Str.split("   ");

    	for(int i=0;i<morseWords.length;i++) {//i为单词的位置
    		String[] morseLetter = morseWords[i].split(" ");
    		char[] letter = new char[morseLetter.length];
    		
    		for(int k=0;k<morseLetter.length;k++)//k为一个单词内字母的位置
    		    for(int j=0;j<morseCode.length;j++) {
    		        if(morseLetter[k].equals(morseCode[j]) == true) {
    			        letter[k] = morseChar[j];
    			    	System.out.print(letter[k]);
    			        break;
    			        }
    			    }
    		System.out.print(" ");
    	}
    }
}
