package configuration;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {

	private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

	private String algorithmClass = null;
	private String analyzerClass = null;
	private String outputClass = null;
	private String processorClass = null;

	private File inputFile;
	private Properties props = null;

	private String filePath = null;

	public Configuration(String filePath) {

		this.filePath = filePath;
		props = PropertiesSingleton.getInstance();

		analyzerClass = props.getProperty(Constants.analyzerClass);

		algorithmClass = props.getProperty(Constants.algorithmClass);

		outputClass = props.getProperty(Constants.outputClass);
		processorClass = props.getProperty(Constants.processorClass);

		if (!checkPropertiesIntegrity())
			System.exit(-1);

	}

	public String getAnalyzerClass() {
		return analyzerClass;
	}

	public String getAlgorithmClass() {
		return algorithmClass;
	}

	public String getOutputClass() {
		return outputClass;
	}

	public String getProcessorClass() {
		return processorClass;
	}

	public File getInputFile() {
		return inputFile;
	}

	private boolean isPathValid(String path) {

		try {

			Paths.get(path);
			inputFile = new File(path);

			if (!inputFile.exists())
				return false;
			

		} catch (InvalidPathException | NullPointerException ex) {

			return false;
		}
		
		return true;
	}

	protected Boolean checkPropertiesIntegrity() {

		boolean confHealth = true;

		if (filePath == null || filePath.trim().equals("") || isPathValid(filePath) == false) {

			logger.error("file path either is not provided or does not exist");
			confHealth = false;
		}

		if (processorClass == null || processorClass.trim().equals("")) {

			logger.error("no valid irp.processing.algorigthm.class value");
			confHealth = false;
		}
		if (algorithmClass == null || algorithmClass.trim().equals("")) {

			logger.error("no valid irp.processing.algorigthm.class value");
			confHealth = false;
		}
		if (outputClass == null || outputClass.trim().equals("")) {

			logger.error("no valid irp.processing.algorigthm.class value");
			confHealth = false;
		}

		if (analyzerClass == null || analyzerClass.trim().equals("")) {

			logger.error("no valid irp.processing.analyzer value");
			confHealth = false;
		}

		if (confHealth)
			logger.info("Config file is ok.");

		return confHealth;
	}

}
