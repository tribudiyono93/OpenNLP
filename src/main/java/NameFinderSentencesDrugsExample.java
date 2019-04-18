import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class NameFinderSentencesDrugsExample {
	public static void main(String args[]) throws Exception{        
	      
	      //Loading the tokenizer model 
	      InputStream inputStreamTokenizer = new  FileInputStream("/home/tribudiyono93/Documents/OpenNLPModel/en-token.bin");
	      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
	       
	      //Instantiating the TokenizerME class 
	      TokenizerME tokenizer = new TokenizerME(tokenModel); 
	       
	      //Tokenizing the sentence in to a string array 
	      String sentence = "Augmentin-Duo is a penicillin antibiotic that contains two medicines.amoxicillin trihydrate and potassium clavulanate. They work together to kill certain types of bacteria and are used to treat certain types of bacterial infections."; 
	      String tokens[] = tokenizer.tokenize(sentence); 
	       
	      //Loading the NER-person model 
	      InputStream inputStreamNameFinder = new FileInputStream("src/main/resources/en-drugs.bin");       
	      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
	      
	      //Instantiating the NameFinderME class 
	      NameFinderME nameFinder = new NameFinderME(model);       
	      
	      //Finding the names in the sentence 
	      Span nameSpans[] = nameFinder.find(tokens);        
	      
	      //Printing the names and their spans in a sentence 
	      for(Span s: nameSpans)        
	         System.out.println(s.toString()+"  "+tokens[s.getStart()]);      
	   } 
}
