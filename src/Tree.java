/**
 * Created by alvin2 on 11/2/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree
{
    ExpressionNode root;



    public static void insert(ExpressionNode node, int nodeVal)
    {

        if(node == null)
        {
            throw new IllegalArgumentException("null node");
        }

        if(nodeVal < asInt(node.symbol))
        {

            if(node.left != null)
            {
                insert(node.left, nodeVal);
            }
            else
            {
                node.left = new ExpressionNode(String.valueOf(nodeVal));
            }


        }
        else
        {
            if(node.right != null)
            {
                insert(node.right, nodeVal);
            }
            else
            {
                node.right = new ExpressionNode(String.valueOf(nodeVal));
            }

        }
    }

        // public method
    public boolean exists(int data) {
        return exists_recurse(root, data);
    }

    // internal recursive method
    private boolean exists_recurse(ExpressionNode node, int data) {
        if (node == null) return false;

        //Check to see if data is greater than or less
        //than current node's data
        int symbol = asInt(node.symbol);

        if (data < symbol) {
            return exists_recurse(node.left, data);
        } else if (data > symbol) {
            return exists_recurse(node.right, data);
        } else {
            return true;
        }
    }

    // remember: Charlyn chose to write this recursively
    // public method
    public int findMin() {
        return findMin_recurse(this.root);
    }

    // internal recursive method
    private int findMin_recurse(ExpressionNode node) {
        if (node == null) {
            throw new IllegalArgumentException("null node");
        }
        if (node.left == null) {
            return asInt(node.symbol);
        }

        return findMin_recurse(node.left);
    }

    // remember: Jorge wrote this iteratively
    public int findMax() {
        if (root == null) {
            throw new IllegalArgumentException("null node");
        }

        ExpressionNode node = root;
        while (node.right != null) {
            node = node.right;
        }

        return asInt(node.symbol);
    }

    // ONLY iterative; breadth-first search
    public void printBreadth() {
        if (root == null) return;

        Queue<ExpressionNode> queue = new ArrayDeque<ExpressionNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ExpressionNode node = queue.remove();
            System.out.print(node.symbol + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        //if you're here, then you've printed all the nodes
        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    // public method
    public void printPostfix() {
        printPostfix_recurse(root);

        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    // internal recursive method
    private void printPostfix_recurse(ExpressionNode node) {
        if (node == null) return;

        printPostfix_recurse(node.left);
        printPostfix_recurse(node.right);
        System.out.print(node.symbol + " ");
    }

    // public method
    public void printPrefix() {
        printPrefix_recurse(root);

        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    // internal recursive method
    private void printPrefix_recurse(ExpressionNode node) {
        if (node == null) return;

        System.out.print(node.symbol + " ");
        printPrefix_recurse(node.left);
        printPrefix_recurse(node.right);
    }

    // public method
    public void printInfix() {
        printInfix_recurse(root);

        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    // internal recursive method
    private void printInfix_recurse(ExpressionNode node) {
        if (node == null) return;

        printInfix_recurse(node.left);
        System.out.print(node.symbol + " ");
        printInfix_recurse(node.right);
    }

    private static int asInt(String s) {
        return Integer.parseInt(s);
    }
}


