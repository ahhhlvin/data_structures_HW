import java.util.Scanner;
import java.util.Stack;

/**
 * Created by alvin2 on 10/25/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class ExpressionTree
{


    public static void main(String[] args)
    {

        String expression = "a b + c d e + * *";

        Tree expressionTree = formExpressionTree(expression);


        Scanner input = new Scanner(expression);
        Stack<ExpressionNode> stack = new Stack<ExpressionNode>();

        while(input.hasNext())
        {
            // .next() does not read spaces in a string
            String symbol = input.next();
            ExpressionNode node = new ExpressionNode(symbol);

            if(isOperator(symbol))
            {
                node.left = stack.pop();
                node.right = stack.pop();
            }
            stack.push(node);


        }

        if(stack.size() != 1)
        {
            throw new IllegalStateException("invalid Stack");
        }



        // print out the parent AFTER printing out L and R children
        System.out.println("postfix: ");
        expressionTree.printPostfix();
        System.out.println("\n");

        // print out the parent BEFORE printing out L and R children
        System.out.println("prefix: ");
        expressionTree.printPrefix();
        System.out.println("\n");

        // print out parent BETWEEN children: L child --> parent --> R child
        System.out.println("infix: ");
        expressionTree.printInfix();
        System.out.println("\n");

        // print out each row by row from ROOT --> leaves
        System.out.println("breadth: ");
        expressionTree.printBreadth();
        System.out.println("\n");



        //////////////////////////////////   BINARY SEARCH TREES   ///////////////////////////////////////////////


        Tree BST = formBST();

        System.out.println("is '3' found?: " + BST.exists(3));
        System.out.println("is '15' found?: " + BST.exists(15));


        System.out.println("min: " + BST.findMin());
        System.out.println("max: " + BST.findMax());



    }




        private static void insert(ExpressionNode node, int nodeVal) {

            if (node == null) {
                throw new IllegalArgumentException("null node");
            }

            if (nodeVal < asInt(node.symbol)) {

                if (node.left != null) {
                    insert(node.left, nodeVal);
                } else {
                    node.left = new ExpressionNode(String.valueOf(nodeVal));
                }


            } else {
                if (node.right != null) {
                    insert(node.right, nodeVal);
                } else {
                    node.right = new ExpressionNode(String.valueOf(nodeVal));
                }

            }





    }
//
////    private static int findMin(ExpressionNode node) {
////        if (node == null) {
////            throw new IllegalArgumentException("null node");
////        }
////        if (node.left == null) {
////            return asInt(node.symbol);
////        }
////
////        return findMin(node.left);
////
////    }
////
////
////    private static int findMax(ExpressionNode root) {
////        if (root == null) {
////            throw new IllegalArgumentException ("null node");
////        }
////
////        ExpressionNode node = root;
////        while(node.right != null) {
////            node = node.right;
////        }
////
////        return asInt(node.symbol);
////
////    }
//
//    private static boolean exists(ExpressionNode node, int data)
//    {
//        if(node == null)
//        {
//            return false;
//        }
//
//        int symbol = asInt(node.symbol);
//        if(data < symbol)
//        {
//            // figure out what to do with boolean return value
//            return exists(node.left, data);
//        }
//        else if(data > symbol)
//        {
//            return exists(node.right, data);
//        }
//        else
//        {
//            return true;
//        }
//    }


    private static int asInt(String s)
    {
        return Integer.parseInt(s);
    }

    private static Tree formBST()
    {
        ExpressionNode ten = new ExpressionNode("10");
        ExpressionNode five = new ExpressionNode("5");
        ExpressionNode twelve = new ExpressionNode("12");
        ExpressionNode two = new ExpressionNode("2");
        ExpressionNode six = new ExpressionNode("6");
        ExpressionNode three = new ExpressionNode("3");
        ExpressionNode four = new ExpressionNode("4");

        three.right = four;
        two.right = three;
        five.left = two;
        five.right = six;
        ten.left = five;
        ten.right = twelve;

        Tree tree = new Tree();
        tree.root = ten;

        return tree;

    }

    private static Tree formExpressionTree(String expression) {
        Scanner input = new Scanner(expression);
        Stack<ExpressionNode> stack = new Stack<ExpressionNode>();

        while (input.hasNext()) {
            String symbol = input.next();
            ExpressionNode node = new ExpressionNode(symbol);

            if (isOperator(symbol)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }

            stack.push(node);
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("invalid stack");
        }

        ExpressionNode rootNode = stack.pop();

        Tree tree = new Tree();
        tree.root = rootNode;
        return tree;
    }


//    private static void printPostfix(ExpressionNode node)
//    {
//
//        if(node == null)
//        {
//            return;
//        }
//        printPostfix(node.left);
//        printPostfix(node.right);
//        System.out.print(node.symbol);
//
//    }
//
//    private static void printPrefix(ExpressionNode node)
//    {
//
//        if(node == null)
//        {
//            return;
//        }
//        System.out.print(node.symbol);
//        printPrefix(node.left);
//        printPrefix(node.right);
//
//    }
//
//
//    private static void printInfix(ExpressionNode node)
//    {
//
//        if(node == null)
//        {
//            return;
//        }
//        printInfix(node.left);
//        System.out.print(node.symbol);
//        printInfix(node.right);
//
//    }
//
//    private static void printBreadth(Tree root)
//    {
//        ArrayDeque<ExpressionNode> queue = new ArrayDeque<ExpressionNode>();
//
//        queue.add(root);
//        while(! queue.isEmpty())
//        {
//            ExpressionNode node = queue.remove();
//            System.out.print(node.symbol);
//            if(node.left != null)
//            {
//                queue.add(node.left);
//            }
//            if(node.right != null)
//            {
//                queue.add(node.right);
//            }
//        }
//    }


    private static boolean isOperator(String symbol)
    {
        return "+-/*".contains(symbol);
    }


}



