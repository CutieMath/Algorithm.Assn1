import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * Sequential Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class SequentialRepresentation<T> implements BSPTree<T> {


    private T[] treeArray;
    private int capacity = 100;


    /**
     * Constructs empty graph.
     */
    @SuppressWarnings("unchecked")
	public SequentialRepresentation() {

        // Create a generic array with fixed array capacity
        this.treeArray = (T[])new Object[capacity];

    } // end of SequentialRepresentation()




    @Override
    public void setRootNode(T nodeLabel) {

        // set root node at the first element in array
        if(treeArray[0] == null || !treeArray[0].equals(nodeLabel) ) {
            treeArray[0] = nodeLabel;
        }

        else if(treeArray[0].equals(nodeLabel)){
            System.err.print("The root node has already been set up in the tree");
        }


    } // end of setRootNode()





    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {

        boolean find = false;

        for(int i = 0; i < treeArray.length; i ++){
            if( srcLabel.equals(treeArray[i])){
                if(2 * i + 1 >= treeArray.length || 2 * i + 2 >= treeArray.length);
                    treeArray = Arrays.copyOf(treeArray, treeArray.length + 4);

                set_left(leftChild, i);
                set_right(rightChild, i);
                find = true;
                break;
            }
        }

        if (find == false) {
            System.err.print("Root node is not in the array");
        }

    } // end of splitNode


    // Helper methods for splitNode
    public void set_left(T leftChild, int index){

        int newPosition = 2 * index + 1;
        treeArray[newPosition] = leftChild;

    }

    public void set_right(T rightChild, int index){

        int newPosition = 2 * index + 2;
        treeArray[newPosition] = rightChild;

    }// end of helper methods





    @Override
    public boolean findNode(T nodeLabel) {

        boolean condition = false;

        for(int i = 0; i < treeArray.length; i ++){
            if(nodeLabel.equals(treeArray[i])) {
                condition = true;
                return condition;
            }
        }

        return condition;
    } // end of findNode




    @Override
    public String findParent(T nodeLabel) {

        int parent_index;
        String parent_node = null;

        for (int i = 0; i < treeArray.length; i++) {
            if (nodeLabel.equals(treeArray[i])) {

                if(i == 0){
                    return (String)nodeLabel;
                }

                else if (i % 2 == 0) {

                    parent_index = (i - 2) / 2;
                    parent_node = String.valueOf(treeArray[parent_index]);
                    return nodeLabel + " " + parent_node;

                } else {

                    parent_index = (i - 1) / 2;
                    parent_node = String.valueOf(treeArray[parent_index]);
                    return nodeLabel + " " + parent_node;

                }
            }
        }

        System.err.print("The node is not on the array");
        return null;

    }    // end of findParent






    @Override
    public String findChildren(T nodeLabel) {

        String leftChild;
        String rightChild;


        for(int i = 0; i < treeArray.length; i ++){

            if(nodeLabel.equals(treeArray[i])){

                if((2 * i + 1) > treeArray.length || (2 * i + 2) > treeArray.length){
                    return String.valueOf(nodeLabel);
                }

                leftChild = String.valueOf(treeArray[2 * i + 1]);
                rightChild = String.valueOf(treeArray[2 * i + 2]);

                return nodeLabel + " " + leftChild + " " + rightChild;
            }
        }

        System.err.println("The node is not in the array.");
        return null;
    } // end of findParent




    @Override
    public void printInInorder(PrintWriter writer) {

        writer.print(inOrder(0));

    } // end of printInPreorder



    public String inOrder(int root_index){

        String st = "";

        if(treeArray[root_index] != null ) {
            st += (inOrder(2 * root_index + 1));
            st += (treeArray[root_index] + " ");
            st += (inOrder(2 * root_index + 2));
        }

        return st;
    }// end of helper method




    @Override
    public void printInPreorder(PrintWriter writer) {

        writer.print(preOrder(0));

    } // end of printInInorder


    public String preOrder(int root_index){

        String st = "";

        if(treeArray[root_index] != null){
            st += (treeArray[root_index] + " ");
            st += preOrder(2 * root_index + 1);
            st += preOrder(2 * root_index + 2);
        }

        return st;
    } // end of helper method




    @Override
    public void printInPostorder(PrintWriter writer) {

        writer.print(postOrder(0));

    } // end of printInPostorder


    public String postOrder(int root_index){

        String st = "";

        if(treeArray[root_index] != null){
            st += postOrder(root_index * 2 + 1);
            st += postOrder(root_index * 2 + 2);
            st += (treeArray[root_index] + " ");
        }

        return st;
    }// end of helper method



} // end of class SequentialRepresentation