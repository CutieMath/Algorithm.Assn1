import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class TaskB {

	public static void linktreeTime(BSPTree<String> linktree) {

		String inputFilename = "1k-0to5000-without.txt";
		String delimiter = " ";
		String line1;
		String[] splitContent;
		String srcLabel, leftChild, rightChild;
		boolean hasRoot = false;

		if (inputFilename != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
				while ((line1 = reader.readLine()) != null) {
					splitContent = line1.split(delimiter);
					if (!hasRoot) {
						linktree.setRootNode(splitContent[0]);
						hasRoot = true;
						continue;
					}
					srcLabel = splitContent[0];
					leftChild = splitContent[1];
					rightChild = splitContent[2];
					linktree.splitNode(srcLabel, leftChild, rightChild);
				}
			} catch (FileNotFoundException ex) {
				System.err.println("File not found.");
			} catch (IOException ex) {
				System.err.println("Cannot open file. ");
			} catch (Exception e) {
				System.err.println("Error");
				e.printStackTrace();
			}
		}
	}

	public static void seqtreeTime(BSPTree<String> seqtree) {

		String inputFilename = "1k-0to5000-without.txt";
		String delimiter = " ";
		String line1;
		String[] splitContent;
		String srcLabel, leftChild, rightChild;
		boolean hasRoot = false;

		if (inputFilename != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
				while ((line1 = reader.readLine()) != null) {
					splitContent = line1.split(delimiter);
					if (!hasRoot) {
						seqtree.setRootNode(splitContent[0]);
						hasRoot = true;
						continue;
					}
					srcLabel = splitContent[0];
					leftChild = splitContent[1];
					rightChild = splitContent[2];
					seqtree.splitNode(srcLabel, leftChild, rightChild);
				}
			} catch (FileNotFoundException ex) {
				System.err.println("File not found.");
			} catch (IOException ex) {
				System.err.println("Cannot open file. ");
			} catch (Exception e) {
				System.err.println("Error");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		BSPTree<String> linktree = new LinkedRepresentation<>();
		BSPTree<String> seqtree = new SequentialRepresentation<>();

		/**
		 * Scenario 1
		 */
		System.out.println("Scenario 1: Grow BSP Tree\n");

		// Linked representation
		long startTimeLK = System.nanoTime();
		linktreeTime(linktree);
		long endTimeLK = System.nanoTime();

		double estimatedTimeLK = ((double) (endTimeLK - startTimeLK)) / Math.pow(10, 9);
		System.out.println(
				"The time taken is:  " + String.format("%.7f", estimatedTimeLK) + " sec for Linked representation; ");

		// Sequential representation
		long startTimeSQ = System.nanoTime();
		seqtreeTime(seqtree);
		long endTimeSQ = System.nanoTime();

		double estimatedTimeSQ = ((double) (endTimeSQ - startTimeSQ)) / Math.pow(10, 9);
		System.out.println("The time taken is:  " + String.format("%.7f", estimatedTimeSQ)
				+ " sec for Sequential representation. \n\n");

		/**
		 * Scenario 2
		 */
		System.out.println("Scenario 2: Finding a node.");

		// link
		long startTimeFNLK = System.nanoTime();
		linktree.findNode("3158145");
		long endTimeFNLK = System.nanoTime();

		double estimatedTimeFNLK = ((double) (endTimeFNLK - startTimeFNLK)) / Math.pow(10, 9);
		System.out.println("The time taken to FN is:  " + String.format("%.7f", estimatedTimeFNLK)
				+ " sec for Linked representation.");

		// seq
		long startTimeFNSQ = System.nanoTime();
		seqtree.findNode("3158145");
		long endTimeFNSQ = System.nanoTime();

		double estimatedTimeFNSQ = ((double) (endTimeFNSQ - startTimeFNSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to FN is:  " + String.format("%.7f", estimatedTimeFNSQ)
				+ " sec for Sequential representation.\n\n");

		System.out.println("Scenario 2: Find parent node.");

		// link
		long startTimeFPLK = System.nanoTime();
		linktree.findParent("3158145");
		long endTimeFPLK = System.nanoTime();

		double estimatedTimeFPLK = ((double) (endTimeFPLK - startTimeFPLK)) / Math.pow(10, 9);
		System.out.println("The time taken to FP is:  " + String.format("%.7f", estimatedTimeFPLK)
				+ " sec for Linked representation.");

		// seq
		long startTimeFPSQ = System.nanoTime();
		seqtree.findParent("3158145");
		long endTimeFPSQ = System.nanoTime();

		double estimatedTimeFPSQ = ((double) (endTimeFPSQ - startTimeFPSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to FP is:  " + String.format("%.7f", estimatedTimeFPSQ)
				+ " sec for Sequential representation.\n\n");

		System.out.println("Scenario 2: Find Children node.");

		// link
		long startTimeFCLK = System.nanoTime();
		linktree.findChildren("3158145");
		long endTimeFCLK = System.nanoTime();

		double estimatedTimeFCLK = ((double) (endTimeFCLK - startTimeFCLK)) / Math.pow(10, 9);
		System.out.println("The time taken to FC is:  " + String.format("%.7f", estimatedTimeFCLK)
				+ " sec for Linked representation.");

		// seq
		long startTimeFCSQ = System.nanoTime();
		seqtree.findChildren("3158145");
		long endTimeFCSQ = System.nanoTime();

		double estimatedTimeFCSQ = ((double) (endTimeFCSQ - startTimeFCSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to FC is:  " + String.format("%.7f", estimatedTimeFCSQ)
				+ " sec for Sequential representation.\n\n");

		/**
		 * Scenario 3 Traversal
		 */

		/** Preorder */
		System.out.println("Scenario 3: Traversal the tree. \n\n A: Preorder Traversal");

		PrintWriter writerLK = new PrintWriter(System.out);
		PrintWriter writerSQ = new PrintWriter(System.out);

		// link
		long startTimePreLink = System.nanoTime();
		linktree.printInPreorder(writerLK);
		long endTimePreLink = System.nanoTime();

		double estimatedPreLK = ((double) (endTimePreLink - startTimePreLink)) / Math.pow(10, 9);
		System.out.println("The time taken to do Preorder is:  " + String.format("%.7f", estimatedPreLK)
				+ " sec for Linked representation");

		// seq
		long startTimePreSQ = System.nanoTime();
		seqtree.printInPreorder(writerSQ);
		long endTimePreSQ = System.nanoTime();

		double estimatedPreSQ = ((double) (endTimePreSQ - startTimePreSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to do Preorder is:  " + String.format("%.7f", estimatedPreSQ)
				+ " sec for Sequential representation");

		/** In Order */
		System.out.println("\n\nB: Inorder Traversal ");

		// link
		long startTimeInLK = System.nanoTime();
		linktree.printInInorder(writerLK);
		long endTimeInLK = System.nanoTime();

		double estimatedInLK = ((double) (endTimeInLK - startTimeInLK)) / Math.pow(10, 9);
		System.out.println("The time taken to do Inorder is:  " + String.format("%.7f", estimatedInLK)
				+ " sec for Linked representation");

		// seq
		long startTimeInSQ = System.nanoTime();
		seqtree.printInInorder(writerSQ);
		long endTimeInSQ = System.nanoTime();

		double estimatedInSQ = ((double) (endTimeInSQ - startTimeInSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to do Inorder is:  " + String.format("%.7f", estimatedInSQ)
				+ " sec for Sequential representation");

		/** Post Order */
		System.out.println("\n\nB: Postorder Traversal");

		// link
		long startTimePoLK = System.nanoTime();
		linktree.printInPostorder(writerLK);
		long endTimePoLK = System.nanoTime();

		double estimatedPoLK = ((double) (endTimePoLK - startTimePoLK)) / Math.pow(10, 9);
		System.out.println("The time taken to do Postorder is:  " + String.format("%.7f", estimatedPoLK)
				+ " sec for Linked representation");

		// seq
		long startTimePoSQ = System.nanoTime();
		seqtree.printInPostorder(writerSQ);
		long endTimePoSQ = System.nanoTime();

		double estimatedPoSQ = ((double) (endTimePoSQ - startTimePoSQ)) / Math.pow(10, 9);
		System.out.println("The time taken to do Postorder is:  " + String.format("%.7f", estimatedPoSQ)
				+ " sec for Sequential representation");

	}
}
