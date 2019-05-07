package org.jis.generator;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

/**
 * Testclass for testing method of GeneratorTest.
 * 
 * @author Marco Kugler
 *
 */
public class GeneratorTest {
	
	private Generator generator;
	private BufferedImage image;
	private BufferedImage rotImage;
	
	/**
	 * Setting up an object of Generator for the test cases. Also reading the
	 * image.jpg from src/test/resources into "image"-variable.
	 * 
	 * @throws IOException If file nout found.
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
	
	/**
	 * Testing whether the values for width and height is switched after rotating
	 * the image for 90 degrees. Also testing whether the image is staying the same rotated
	 * image after rotating.
	 */
	@Test
	public void testRotateImage90Rotation() {
		
		//Rotating the image for 90 degrees.
		rotImage = generator.rotateImage(image, Math.PI / 2);
		
		//First comparing the height and width before and after rotating.
		assertEquals(rotImage.getHeight(), image.getWidth());
		assertEquals(rotImage.getWidth(), image.getHeight());
		
		/*
		 * Then comparing the RGB-values of each image before and after rotating to see
		 * whether it's the same image.
		 */
		int y = 0;	//y-coordinate for pixel
		int x = 0;	//x-coordinate for pixel
		int yRotated = image.getHeight() - 1;	//y-coordinate in rotated image
		
		//Loop running over every pixel of images and comparing the RGB-value.
		while (y < image.getHeight()) {
			
			while (x < image.getWidth()) {
				assertEquals(image.getRGB(x, y), rotImage.getRGB(yRotated, x));
				x++;
			}
			x = 0;
			y++;
			yRotated--;
		}
	}
	
	/**
	 * Testing whether the values for width and height is switched after rotating
	 * the image for 270 degrees. Also testing whether the image is staying the same rotated
	 * image after rotating.
	 */
	@Test
	public void TestRotateImage270Rotation() {
		
		//Rotating the image for 270 degrees.
		rotImage = generator.rotateImage(image, 3 * (Math.PI / 2));
		
		//First comparing height, width before and after.
		assertEquals(rotImage.getHeight(), image.getWidth());
		assertEquals(rotImage.getWidth(), image.getHeight());
		
		/*
		 * Then comparing the RGB-values of each image before and after rotating to see
		 * whether it's the same image.
		 */
		int y = 0;	//y-coordinate for pixel
		int x = 0;	//x-coordinate for pixel
		int xRotated = image.getWidth() - 1;	//x-coordinate in rotated image
		
		while (y < image.getHeight()) {
			
			while (x < image.getWidth()) {
				assertEquals(image.getRGB(x, y), rotImage.getRGB(y, xRotated));
				xRotated--;
				x++;
			}
			y++;
			x = 0;	//Resetting x-parameter.
			xRotated = image.getWidth() - 1;
		}
	}
	
	
	
	

}
