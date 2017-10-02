package igor.souza.paintshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PaintShop {

	public static void main(String[] args) throws Exception {
		try{
			
			if (args.length != 1) {
				System.err.println("Number of arguments is incorrect. "
						+ "Please provide the path for the dataset file");
				System.exit(1);
			}
			paintShop(new File(args[0]));
			
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(InputMismatchException e){
			System.out.println("File is malformed");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("File contem empty lines");
		}catch(NoSuchElementException e){
			System.out.println("File contem wrong number of colluns");
		}catch(Exception e){
			System.out.println("an error has occurred. please contact your system administrator ");
		}
	}

	public static void paintShop(File filePath) 
			throws FileNotFoundException, InputMismatchException, ArrayIndexOutOfBoundsException, NoSuchElementException{

		Scanner sc = new Scanner(filePath);
		int numTest = sc.nextInt();
		for (int numberTestCase = 1; numberTestCase <= numTest; numberTestCase++) {

			int numberPaints = sc.nextInt();
			int numberCustomers = sc.nextInt();

			boolean[][] canUse = new boolean[numberCustomers][numberPaints];
			int[] matte = new int[numberCustomers];
			int[] numberCanUse = new int[numberCustomers];

			for (int customer = 0; customer < numberCustomers; customer++) {
				matte[customer] = -1;
				for (int type = 0; type < numberPaints; type++) {
					canUse[customer][type] = false;
				}

				int numberPaintsCustomerLikes = sc.nextInt();
				for (int f = 0; f < numberPaintsCustomerLikes; f++) {
					int paintNumber = sc.nextInt() - 1;
					if (sc.nextInt() == 1) {
						matte[customer] = paintNumber;
					} else {
						canUse[customer][paintNumber] = true;
						numberCanUse[customer]++;
					}
				}
			}
			System.out.println("Case #" + numberTestCase + ":" + process(matte, canUse, numberCanUse, numberPaints, numberCustomers));
		}

	}

	public static String process(int[] matte, boolean[][] canUse, int[] numberCanUse, int numberPaints, int numberCustomers) {
		int[] result = new int[numberPaints] ;
		boolean[] visited = new boolean[numberCustomers];
		boolean possible = true;
		boolean found;

		do {
			found = false;
			for (int i = 0; i < numberCustomers; i++) {
				if (numberCanUse[i] == 0 && !visited[i]) {
					visited[i] = true;
					found = true;
					if (matte[i] == -1) {
						possible = false;
						break;
					} else {
						result[matte[i]] = 1;
						for (int j = 0; j < numberCustomers; j++) {
							if (canUse[j][matte[i]]) {
								numberCanUse[j]--;
								canUse[j][matte[i]] = false;
							}
						}
					}
				}
			}
		} while (found && possible);

		if (possible) {
			return arrayToString(result);
		} else {
			return " IMPOSSIBLE";
		}
	}

	private static String arrayToString(int[] res) {
		StringBuilder str = new StringBuilder();
		for (int r: res) {
			str.append(' ');
			str.append(r);
		}
		return str.toString();
	}

}