import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleDataStream;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

/**
 * NER Training in OpenNLP with Name Finder Training Java Example
 * 
 * @author www.tutorialkart.com
 */
public class DrugsClassifierTrainer {

	static String onlpModelPath = "src/main/resources/en-drugs.bin";
	// training data set
	static String trainingDataFilePath = "src/main/resources/drugsdetails.txt";

	public static void main(String[] args) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		ObjectStream<String> lineStream = new PlainTextByLineStream(new FileInputStream(trainingDataFilePath), charset);
		ObjectStream<NameSample> sampleStream = new NameSampleDataStream(lineStream);
		TokenNameFinderModel model = null;
		HashMap<String, Object> mp = new HashMap<String, Object>();
		try {
			// model = NameFinderME.train("en","drugs", sampleStream,
			// Collections.<String,Object>emptyMap(),100,4) ;
			model = NameFinderME.train("en", "drugs", sampleStream, Collections.emptyMap());
		} finally {
			sampleStream.close();
		}
		BufferedOutputStream modelOut = null;
		try {
			modelOut = new BufferedOutputStream(new FileOutputStream(onlpModelPath));
			model.serialize(modelOut);
		} finally {
			if (modelOut != null)
				modelOut.close();
		}
	}

}