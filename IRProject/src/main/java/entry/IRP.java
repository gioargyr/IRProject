package entry;

import org.apache.lucene.analysis.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import configuration.Configuration;
import output.Output;
import processing.Processor;
import textanalysis.IRTextAnalysisAlgorithm;
import utilities.ClassObjectCreation;

public class IRP {
	private static final Logger logger = LoggerFactory.getLogger(IRP.class);

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration(args[0]);
		String algorithmClassString = configuration.getAlgorithmClass();
		String analyzerClassString = configuration.getAnalyzerClass();
		String outputClassString = configuration.getOutputClass();
		String processorClassString = configuration.getProcessorClass();

		Analyzer analyzer = (Analyzer) ClassObjectCreation.createClassObject(analyzerClassString);
		logger.info("Analyzer class is:" + analyzerClassString);

		IRTextAnalysisAlgorithm textAnalysisAlgorithm = (IRTextAnalysisAlgorithm) ClassObjectCreation
				.createClassObject(algorithmClassString);
		logger.info("Text analysis algorithm class is:" + algorithmClassString);

		Output output = (Output) ClassObjectCreation.createClassObject(outputClassString);
		logger.info("Output class is:" + outputClassString);

		Processor processor = (Processor) ClassObjectCreation.createClassObject(processorClassString);

		processor.process(configuration.getInputFile(), textAnalysisAlgorithm, analyzer, output);

	}

}
