
/*
Prob.: Serialize and deserialize a binary tree
Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. 
Complete the functions
serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. 
Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. 
Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> tree=new ArrayList<>();
        preorder(tree,root);
        return tree;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        int[] i={0};
        return deSerializeHelper(arr,i);
    }
    private void preorder(ArrayList<Integer> tree,Node root)
    {
        if(root==null)
        {
            tree.add(-1);
            return;
        }
        tree.add(root.data);
        preorder(tree,root.left);
        preorder(tree,root.right);
    }
    private Node deSerializeHelper(ArrayList<Integer> arr,int[] i)
    {
        int data=arr.get(i[0]);
        if(data==-1)
        {
            i[0]++;
            return null;
        }
        Node root=new Node(data);
        i[0]++;
        root.left=deSerializeHelper(arr,i);
        root.right=deSerializeHelper(arr,i);
        
        return root;
    }
};
