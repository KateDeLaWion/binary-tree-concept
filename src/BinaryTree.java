import javax.print.DocFlavor;

// This is the Binary Tree being set here:
//                          50
//                 25                 75
//             15      30                      85

// 1 of 2 classes.  Create a class to put in all new data in Binary Tree from Node class
// and traverse
// and main
public class BinaryTree {

    // declare root using Node class that I created in another class
    Node root;

    // adding incoming node data into each node   function
    public void addNode(int key, String name){
        Node newNode = new Node(key,name);

        if(root == null){     // if there is a root, but no value
            root = newNode;
        } else {
            Node focusNode = root;     // make the focusNode the root
            Node parent;            // declare a future parent
            while(true){          // an infinite loop until all data are filled in
                parent = focusNode;  // set parent to focusNode which is the root
                if(key < focusNode.key){   // if the key should go on the left or right side of parent.
                    focusNode = focusNode.leftChild;  // now focusNode becomes the leftChild
                    if(focusNode == null){   // to make sure leftChild is empty.
                        parent.leftChild = newNode;  // put the data in the leftChild
                        return;   // jump out of the loop
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                     parent.rightChild = newNode;
                     return;
                    }
                }

            }
        }
    }


    // In order traverse   function
    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild); // function calling itself forms a loop
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }


    // Pre order traverse   function
    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild); // function calling itself forms a loop
            preOrderTraverseTree(focusNode.rightChild);
        }
    }


    // Post order traverse   function
    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild); // function calling itself forms a loop
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }


    // main function
    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"Vice Pres");
        theTree.addNode(15,"Office Manager");
        theTree.addNode(30,"Secretary");
        theTree.addNode(75,"Sales Manager");
        theTree.addNode(85,"Salesman 1");

//        theTree.inOrderTraverseTree(theTree.root);

        theTree.preOrderTraverseTree(theTree.root);

//        theTree.postOrderTraverseTree(theTree.root);

    }

}



//  2 of 2 classes. Create a separate Node class to feed each Node's data into the Binary tree Class
    class Node{

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    // constructor
    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    // Not necessaritly, but it is nice to print the node name and  key-value
    public String toString(){
        return name + " has a key " + key;
    }


    }


