package entry;

import org.apache.lucene.analysis.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import configuration.Configuration;
import hashing.HashDistance;
import hashing.SimHash;
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
		String processorClassString = configuration.getProcessorClass();
		String hashingAlgorithm = configuration.getHashingAlgorithm();
		String hashingDistance = configuration.getHashDistance();

		Analyzer analyzer = (Analyzer) ClassObjectCreation.createClassObject(analyzerClassString);
		logger.info("Analyzer class is:" + analyzerClassString);

		IRTextAnalysisAlgorithm textAnalysisAlgorithm = (IRTextAnalysisAlgorithm) ClassObjectCreation
				.createClassObject(algorithmClassString);
		logger.info("Text analysis algorithm class is:" + algorithmClassString);

		SimHash ha = (SimHash) ClassObjectCreation.createClassObject(hashingAlgorithm);
		logger.info("Hashing algorithm class is:" + hashingAlgorithm);

		HashDistance hashDistance = (HashDistance) ClassObjectCreation.createClassObject(hashingDistance);
		logger.info("Hashing distance algorithm class is:" + hashingDistance);

		Processor processor = (Processor) ClassObjectCreation.createClassObject(processorClassString);

		Output result = processor.process(configuration.getInputFile(), textAnalysisAlgorithm, analyzer, ha,
				hashDistance);
		logger.info(result.toString());

	}

}
