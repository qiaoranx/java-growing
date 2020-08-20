package com.company;

public class BinaryTree {
    public static void main(String[] args) {
        HNode root=new HNode(1,"ZS");
        BTree tree=new BTree();
        tree.setRoot(root);
        HNode right=new HNode(3,"AA");
        root.setLeft(new HNode(2,"WW"));
        root.setRight(right);
        right.setRight(new HNode(4,"WQ"));
        right.setLeft(new HNode(5,"rt"));
        HNode h=tree.preQuery(5);
        System.out.println(h==null?"没找到":h.getNo()+" ; "+h.getName());
        tree.preOrder();
        tree.delete(3);
        System.out.println("==================");
        tree.preOrder();

    }
}
class BTree{
    private HNode root;

    public void setRoot(HNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root!=null){
            root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public HNode preQuery(int no){
        if(this.root!=null){
            return root.query(no);
        }else{
            System.out.println("二叉树为空");
        }
        return null;
    }

    public void delete(int id){
        if(this.root==null){
            return;
        }
        if(this.root.getNo()==id){
            root.setLeft(null);
            root.setRight(null);
            return;
        }
       this.root.delete(id);
    }


}

//
class HNode{
    private int no;
    private String name;
    private HNode right;
    private HNode left;

    public HNode(int no, String name ) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HNode getRight() {
        return right;
    }

    public void setRight(HNode right) {
        this.right = right;
    }

    public HNode getLeft() {
        return left;
    }

    public void setLeft(HNode left) {
        this.left = left;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //前序遍历查找
    public HNode query(int no){
        if(this.no==no){
            return this;
        }
        HNode node=null;
        if(this.left!=null){
            node=this.left.query(no);
        }
        if(node!=null){
            return node;
        }
        if(this.right!=null){
            return this.right.query(no);
        }
        return null;
    }

    //删除不分前中后序，只能指向被删除的上一个节点，单向二叉树
    public void delete(int id){
        if(this.left!=null&&this.left.no==id){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==id){
            this.right=null;
            return;
        }
        //递归
        if(this.left!=null){
            this.left.delete(id);
        }

        if(this.right!=null){
            this.right.delete(id);
        }
    }

    public void infix(){
        if(this.left!=null){
            this.left.infix();
        }
        System.out.println(this);

        if(this.right!=null){
            this.right.infix();
        }
    }

    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}