package igor.souza.paintshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.Test;

public class PaintShopTest extends TestCase {

	PaintShop paintShop = new PaintShop();
	ClassLoader classLoader = getClass().getClassLoader();
	String inputFilesFolder = "files" + File.separator;

	@Test
	public void testNonExistingFile() {
		try {
			paintShop.paintShop(new File("doesnotexist"));
			fail();
		} catch (FileNotFoundException e) {
			//expecting this
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testMalformedCustomers() {
		try {
			File file = new File(classLoader.getResource(inputFilesFolder + "malformedCustomers.txt").toURI());
			paintShop.paintShop(file);
			fail();
		} catch (InputMismatchException e) {
			// We are expecting this
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEmptyLineInInputFile() {
		try {
			File file = new File(classLoader.getResource(inputFilesFolder + "emptyLine.txt").toURI());
			paintShop.paintShop(file);
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {
			//expecting this
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testMissingNumberOfColors() {
		try {
			File file = new File(classLoader.getResource(inputFilesFolder + "missingNumberOfColors_invalid.txt").toURI());
			paintShop.paintShop(file);
			fail();
		} catch (NoSuchElementException e) {
			//expecting this
		} catch (Exception e) {
			fail();
		}
	}

	
}