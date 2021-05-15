package com.ds.tree.bst;


public class BinarySearchTree {

    TreeNode root = null;

    /* @Builder
     @Getter*/
    private static class TreeNode {
        private Integer data;
        TreeNode leftChild, rightChild;

        TreeNode(Integer data) {
            this.data = data;
            leftChild = rightChild = null;
        }

        public Integer getData() {
            return data;
        }
    }

    public void addData(Integer data){
        root = addNode(data,root);
    }

    private TreeNode addNode(Integer data, TreeNode root) {

        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        //traverse the tree
        if (data < root.data)     //insert in the left subtree
            root.leftChild = addNode( data,root.leftChild);
        else if (data > root.data)    //insert in the right subtree
            root.rightChild = addNode(data,root.rightChild);
        // return pointer
        return root;
    }

    public void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    private void inorder_Recursive(TreeNode root) {
        if (root != null) {
            inorder_Recursive(root.leftChild);
            System.out.print(root.data + " ");
            inorder_Recursive(root.rightChild);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree tree=new BinarySearchTree();
        tree.addData(45);
        tree.addData(10);
        tree.addData(7);
        tree.addData(12);
        tree.addData(90);
        tree.addData(50);

        tree.inorder();

    }

}
