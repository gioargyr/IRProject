package configuration;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testGetWeights() {
		Configuration configuration=new Configuration("/home/kostas/Desktop/file.txt");
		
		System.out.println(configuration.getWeights());
	}

}
