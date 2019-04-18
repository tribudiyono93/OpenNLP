import java.io.FileInputStream; 
import java.io.InputStream; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel;  

public class TokenizerMEExample { 
  
   public static void main(String args[]) throws Exception{     
     
      String sentence = "Hi. How are you? Welcome to Tutorialspoint. " 
            + "We provide free tutorials on various technologies"; 
       
      //Loading the Tokenizer model 
      InputStream inputStream = new FileInputStream("/home/tribudiyono93/Documents/OpenNLPModel/en-token.bin"); 
      TokenizerModel tokenModel = new TokenizerModel(inputStream); 
       
      //Instantiating the TokenizerME class 
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
       
      //Tokenizing the given raw text 
      String tokens[] = tokenizer.tokenize(sentence);       
          
      //Printing the tokens  
      for (String a : tokens) 
         System.out.println(a); 
   } 
} 