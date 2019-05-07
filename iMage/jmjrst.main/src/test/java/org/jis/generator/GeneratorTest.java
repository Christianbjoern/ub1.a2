package org.jis.generator;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;


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
	
	/**
	 * Testing whether rotateImage is returning the same image for the
	 * rotating argument 0.0.
	 */
	@Test
	public void testRotateImage0Rotation() {
		
		rotImage = generator.rotateImage(image, 0.0);
		
		int y = 0;	//y-coordinate for pixel
		int x = 0;	//x-coordinate for pixel
		
		while (y < rotImage.getHeight()) {
			while (x < rotImage.getWidth()) {
				assertEquals(image.getRGB(x, y), rotImage.getRGB(x, y));
				x++;
			}
			y++;
			x = 0;	//Resetting x-parameter.
		}
	}
	
	/**
	 * Testing whether rotateImage is returning null for the argument null.
	 */
	@Test
	public void testRotateImageNullImage() {
		
		assertEquals(generator.rotateImage(null, 0.0), null);
		
	}
	
	/**
	 * Testing whether the argument 0.42 as second argument (rotation) will
	 * throw a IllegalArgumentException (as expected).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRotateImageIllegalArgument() {
		
		generator.rotateImage(image, 0.42);
		
	}
	
	

}
