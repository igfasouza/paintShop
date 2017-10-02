package igor.souza.paintshop;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateTestFile {


	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.err.println("Number of arguments is incorrect. "
					+ "Please provide the path for the small dataset file as the first argument and the large dataset as the second argument!");
			System.exit(1);
		}
		
		String smallDatasetPath = args[0];
		String largeDatasetPath = args[1];
		
		generateSmallDataset(smallDatasetPath);
		generateLargeDatasetPath(largeDatasetPath);

	}

	public static void generateSmallDataset(String path) throws FileNotFoundException{

		PrintWriter writer = new PrintWriter(path);

		Random randomGenerator = new Random();

		int numberOfTest = 10;
		writer.println(numberOfTest);
		
		for (int i = 0; i < numberOfTest; i++) {
			
			int numberOfColours = randomGenerator.nextInt(10)+1;
			writer.println(numberOfColours);
			int numberOfCostomer = randomGenerator.nextInt(10)+1;
			writer.println(numberOfCostomer);
			
			for (int j = 0; j < numberOfCostomer; j++) {
				
				int numberColoursCustumerLike = randomGenerator.nextInt(numberOfColours)+1;
				writer.print(numberColoursCustumerLike);
				
				boolean oneMatte = false;
				for (int k = 0; k < numberColoursCustumerLike; k++) {
					
					int colours = randomGenerator.nextInt(numberOfColours)+1;
					int type = randomGenerator.nextInt(2)+1;
					if(type == 1 && !oneMatte){
						writer.print(" " + colours + " " + "1");
						oneMatte = true;
					}else{
						writer.print(" " + colours + " " + "0");
					}
				}
				writer.println("");
			}
		}
		writer.close();
	}
	
	public static void generateLargeDatasetPath(String path) throws FileNotFoundException{
		
		PrintWriter writer = new PrintWriter(path);

		Random randomGenerator = new Random();

		int numberOfTest = 5;
		writer.println(numberOfTest);
		
		for (int i = 0; i < numberOfTest; i++) {
			
			int numberOfColours = randomGenerator.nextInt(2000)+1;
			writer.println(numberOfColours);
			int numberOfCostomer = randomGenerator.nextInt(2000)+1;
			writer.println(numberOfCostomer);
			
			for (int j = 0; j < numberOfCostomer; j++) {
				
				int numberColoursCustumerLike = randomGenerator.nextInt(numberOfColours)+1;
				writer.print(numberColoursCustumerLike);
				
				boolean oneMatte = false;
				for (int k = 0; k < numberColoursCustumerLike; k++) {
					
					int colours = randomGenerator.nextInt(numberOfColours)+1;
					int type = randomGenerator.nextInt(2)+1;
					if(type == 1 && !oneMatte){
						writer.print(" " + colours + " " + "1");
						oneMatte = true;
					}else{
						writer.print(" " + colours + " " + "0");
					}
				}
				writer.println("");
			}
		}
		writer.close();
	}
	
}