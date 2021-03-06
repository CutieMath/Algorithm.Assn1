## Algorithm.Assn1
Algorithm and Analysis assignment one, in collaboration with <a href="https://github.com/CY1223">Chin</a>.  
The program implemented a Binary Space Partitioning (BSP) tree use Sequential Representation and Linked Representation.  
Varies operations can be performed.  
A test program will evaluate the time used to perform these operations on Sequential and Linked data stucture. 

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

 

**2. Evaluate the efficiency of Sequential and Linked representations**  
**First** run ``generation/DataGenerator.java`` to generate a BSP tree file.  
Use arguments ``<start of range> <end of range> <number of values to sample> <type of sampling>``  
``<type of sampling>`` here is ``with`` or ``without``, to represent sample without/with replacement. This concept from "Algorithm R" by Jeffrey Vitter, in paper "Random sampling without a reservoir".  
<br>
**Then** run ``TaskB.java`` to print out the comparison of Sequential and Linked representation execution time. 
