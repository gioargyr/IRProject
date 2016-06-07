package configuration;

import java.io.File;

import org.junit.Test;

public class PropertiesSingletonTest {

	@Test
	public void testGetInstance() {
		PropertiesSingleton.getInstance();

	}

	@Test
	public void testConfiguration() {
		Configuration configuration = new Configuration("/home/kostas/file.txt");
		System.out.println(configuration.getAlgorithmClass());
	}

	@Test
	public void testConfigurationIntegrity() {
		Configuration configuration = new Configuration("/home/kostas/file.txt");
		
		File inputFile = configuration.getInputFile();
		
		System.out.println(inputFile.getName());

		//configuration.checkPropertiesIntegrity();

	}

}
