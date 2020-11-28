package online.cx.javabasic.tree;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/23 14:41
 */
public class TreeTraversal {

    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }


    public void postOrder (TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }

    public String postOrder(String preOrder, String inOrder){

        if(preOrder.isEmpty()){
            return "";
        }
        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);

        return
            postOrder(
                preOrder.substring(1, 1 + rootIndex),
                inOrder.substring(0, rootIndex)) +
            postOrder(
                preOrder.substring(1, 1 + rootIndex),
                inOrder.substring(0, rootIndex)) +
            rootValue;
    }


    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();
        TreeCreator creator = new TreeCreator();

        TreeNode root = creator.createSampleTree();

        traversal.preOrder(root);
        System.out.println();

        traversal.inOrder(root);
        System.out.println();
        traversal.postOrder(root);
        System.out.println();
        System.out.println("==========");

        TreeNode tree = creator.createTree("ABDEGCF", "DBGEACF");
        traversal.postOrder(tree);

    }
}
