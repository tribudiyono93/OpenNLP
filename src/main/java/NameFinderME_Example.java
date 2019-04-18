import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.util.Span;  

public class NameFinderME_Example { 
   public static void main(String args[]) throws Exception{ 
      //Loading the NER - Person model       
	   InputStream inputStream = new FileInputStream("/home/tribudiyono93/Documents/OpenNLPModel/en-ner-person.bin"); 
      TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
      
      //Instantiating the NameFinder class 
      NameFinderME nameFinder = new NameFinderME(model); 
    
      //Getting the sentence in the form of String array  
      String [] sentence = new String[]{ 
         "Mike", 
         "and", 
         "Smith", 
         "are", 
         "good", 
         "friends" 
      }; 
       
      //Finding the names in the sentence 
      Span nameSpans[] = nameFinder.find(sentence); 
       
      //Printing the spans of the names in the sentence 
      for(Span s: nameSpans) 
         System.out.println(s.toString() +"  " + sentence[s.getStart()]);    
   }    
}      