package online.cx.javabasic.tree;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/23 16:15
 */
public class InOrder {

    public TreeNode next(TreeNode node){
        if(node == null){
            return null;
        }
        if(node.getRight() != null){
            return first(node.getRight());
        }else{
            while(node.getParent() != null && node.getParent().getRight() == node) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    private TreeNode first(TreeNode node) {
        if(node == null){return null;}

        TreeNode curNode = node;
        while (curNode.getLeft() != null){
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    public void traverse(TreeNode root){
        for(TreeNode node = first(root);
            node != null;
            node = next(node)){
            System.out.print(node.getValue());
        }
        System.out.println();

    }


    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();

        InOrder inOrder = new InOrder();

        TreeNode sampleTree = creator.createSampleTree();

        inOrder.traverse(sampleTree);
    }
}
