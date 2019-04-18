import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSSample; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer;  

public class PosTaggerProbs { 
   
   public static void main(String args[]) throws Exception{ 
      
      //Loading Parts of speech-maxent model       
      InputStream inputStream = new FileInputStream("/home/tribudiyono93/Documents/OpenNLPModel/en-pos-maxent.bin"); 
      POSModel model = new POSModel(inputStream); 
       
      //Creating an object of WhitespaceTokenizer class  
      WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
       
      //Tokenizing the sentence 
      String sentence = "Hi welcome to Tutorialspoint"; 
      String[] tokens = whitespaceTokenizer.tokenize(sentence); 
       
      //Instantiating POSTaggerME class 
      POSTaggerME tagger = new POSTaggerME(model); 
             
      //Generating tags 
      String[] tags = tagger.tag(tokens);       
      
      //Instantiating the POSSample class 
      POSSample sample = new POSSample(tokens, tags);  
      System.out.println(sample.toString());
      
      //Probabilities for each tag of the last tagged sentence. 
      double [] probs = tagger.probs();       
      System.out.println("  ");       
      
      //Printing the probabilities  
      for(int i = 0; i<probs.length; i++) 
         System.out.println(probs[i]); 
   } 
}      