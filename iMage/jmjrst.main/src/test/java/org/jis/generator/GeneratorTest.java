package org.jis.generator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;


public class GeneratorTest {
	
	private Generator generator;
	private BufferedImage image;
	private BufferedImage rotImage;
	
	/**
	 * Setting up an object of Generator for the test cases. Also reading the
	 * image.jpg from src/test/resources into "image"-variable.
	 * 
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException {
		
		 generator = new Generator(null, 0);
		 image = ImageIO.read(new File("src/test/resources/image.jpg"));
		 rotImage = null;
		 
	}

}
