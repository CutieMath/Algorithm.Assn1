## Algorithm.Assn1
Algorithm and Analysis assignment one, in collaboration with <a href="https://github.com/CY1223">Chin</a>.  
The program implemented a Binary Space Partitioning (BSP) tree use Sequential Representation and Linked Representation.  
The program can perform varies operations on the BSP tree. Such as:  
- Create an empty tree  
- Set a root node for the tree  
- Split a node into two children nodes  
- Find a node in the tree  
- Find a parent node of a given node  
- Find children nodes of a given node  
- Print out all nodes in a certain order, including preorder, inorder and postorder.


### Operation  
**1. Perfrom operations**  
Run ``TreeTester.java`` with argument ``<implementation>``.  
The ``<implementation>`` can be chosen from ``seqtree`` and ``linktree`` to represent which implementation you want to use.  
The program will then enter interactive mode where you can type operation code. They are:  
``RN <nodeLable>`` - Sets a root node with the specified label.  
``SP <nodeLabel> <leftChild> <rightChild>`` - Splits the given node into two children with specified label.  
``FN <nodeLabel>`` - Finds a node with the specified label. The output will be true or false.  
``FP <nodeLabel>`` - Finds the parent node of the given node.  
``FC <nodeLabel>`` - Finds the children nodes of the given node.  
``TP`` - Prints all the nodes in preorder traversal.  
``TI`` - Prints all the nodes in inorder traversal.  
``TS`` - Prints all the nodes in postorder traversal.  
``Q`` - Quits the program. 

 

**2. Perform operations**  

