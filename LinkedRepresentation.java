import java.io.*;


/**
 * Linked Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016. 
 * @author Yongli Ren, 2019.
 */
public class LinkedRepresentation<T> implements BSPTree<T> {


    //Create an inner class Node with value and two pointers
    @SuppressWarnings("hiding")
	private class treeNode<T>{

        /** Stored value of node. */
        protected T value;

        /** Reference to left and right node. */
        protected treeNode<T> left;
        protected treeNode<T> right;

        //constructor
        public treeNode (T value){
            this.value = value;
            this.left = null;
            this.right = null;
        }



        /** Setter */
        public void setLeftFromLabel(T leftLabel){
            treeNode<T> new_left = new treeNode(leftLabel);
            left = new_left;
        }


        public void setRightFromLabel(T rightLabel){
            treeNode<T> new_right = new treeNode(rightLabel);
            right = new_right;

        }
    }// end of inner class Node



    protected int length;
    protected treeNode<T> root;



    /**
     * Constructs empty tree.
     */
    public LinkedRepresentation() {

        root = null;
        length = 0;

    } // end of LinkedRepresentation()

    @Override
    public void setRootNode(T nodeLabel) {


        if(root == null || !root.value.equals(nodeLabel)) {
            root = new treeNode<>(nodeLabel);
            length ++;
        }
        else if(root.value.equals(nodeLabel)){
            System.err.print("The root node has already been set up in the tree");
        }

    } // end of setRootNode()



    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {

        if(findNode(srcLabel)){

            treeNode<T> srcNode = findHelperN(root, srcLabel);

            srcNode.setLeftFromLabel(leftChild);
            srcNode.setRightFromLabel(rightChild);

            length += 2;

        } else {

            System.err.print("The root node is not in the tree.");

        }

    } // end of splitNode


    private treeNode<T> findHelperN (treeNode<T> current, T nodeLabel){

        if(current == null){
            return null;
        }

        if(current.value.equals(nodeLabel)){
            return current;

        }else{

            treeNode<T> found = findHelperN(current.right, nodeLabel);
            if (found == null){
                found = findHelperN(current.left, nodeLabel);
            }

            return found;
        }
    } // end of findHelperN




    @Override
    public boolean findNode(T nodeLabel) {

        if(findHelper(root, nodeLabel)){
            return true;
        }
        return false;


    } // end of findNode



    private boolean findHelper(treeNode<T> current, T nodeLabel){

        if(current == null){
            return false;
        }
        if(current.value.equals(nodeLabel)){
            return true;

        } else {
            return (findHelper(current.right, nodeLabel) || findHelper(current.left, nodeLabel));
        }

    } // end of findHelper






    @Override
    public String findParent(T nodeLabel) {

        treeNode<T> parentN;
        String parent;

        // If the node is the root
        if(nodeLabel.equals(root.value)){
            return String.valueOf(nodeLabel);
        }

        if(findNode(nodeLabel)){

            parentN = parentHelper(root, nodeLabel);
            parent = String.valueOf(parentN.value);
            return nodeLabel + " " + parent;

        }

        System.err.print("The node is not in the tree");
        return null;


    } // end of findParent




    private treeNode<T> parentHelper(treeNode<T> parent, T childLabel) {

        if(parent.left == null || parent.right == null){
            // Parent (referred to as findParent) would be null if it's children is null
            // the function thus can call itself again to travel to another node.
            return null;
        }

        if(parent.left.value.equals(childLabel) || parent.right.value.equals(childLabel)){
            return parent;

        }else{

            treeNode<T> findParent = parentHelper(parent.right, childLabel);
            if(findParent == null){
                findParent = parentHelper(parent.left, childLabel);
            }
            return findParent;
        }

    }// end of parentHelper




    @Override
    public String findChildren(T nodeLabel) {

        String leftChild = null;
        String rightChild = null;

        if(findHelper(root, nodeLabel)) {

            treeNode<T> current = findHelperN(root, nodeLabel);

            if(current.right != null || current.left != null) {

                leftChild = String.valueOf(current.left.value);
                rightChild = String.valueOf(current.right.value);
                return nodeLabel + " " + leftChild + " " + rightChild;
            }
            return String.valueOf(nodeLabel);
        }

        System.err.println("The node is not in the tree.");
        return null;

    } // end of findParent




    @Override
    public void printInPreorder(PrintWriter writer) {

        writer.print(preOrder(root));

    } // end of printInPreorder

    private String preOrder(treeNode<T> current){

        String st = "";

        if(current != null){
            st += (current.value + " ");
            st += preOrder(current.left);
            st += preOrder(current.right);
        }

        return st;

    } // end of helper method





    @Override
    public void printInInorder(PrintWriter writer) {

        writer.print(inOrder(root));

    } // end of printInInorder


    private String inOrder(treeNode<T> current){

        String st = "";

        if(current != null){
            st += inOrder(current.left);
            st += (current.value + " ");
            st += inOrder(current.right);
        }

        return st;

    }// end of helper method




    @Override
    public void printInPostorder(PrintWriter writer) {

        writer.print(postOrder(root));

    } // end of printInPostorder

    private String postOrder(treeNode<T> current){

        String st = "";

        if(current != null){
            st += postOrder(current.left);
            st += postOrder(current.right);
            st += (current.value + " ");
        }

        return st;

    } // end of helper method


} // end of class LinkedRepresentation
