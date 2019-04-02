package basic_ds;

class Node {
	
	char data;
	Node left,right;
	
	Node(char data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class BuildTree {
	
	
	
	public Node buildTree(char in[], char pre[], int inStart, int inEnd, int preIndex)
	{
		if(inStart>inEnd)
			return null;
		
		Node root;
		
		root = new Node(pre[preIndex]);
		
		if(inStart == inEnd)
			return root;
		
		int inIndex = search(in,pre[preIndex]);
		
		root.left = buildTree(in, pre, inStart, inIndex-1, preIndex+1);
		root.right = buildTree(in, pre, inIndex+1, inEnd, preIndex+inIndex-inStart+1);
		
		return root;
	}
	
	public int search(char in[], char ch)
	{
		for(int i=0;i<in.length;i++)
		{
			if(in[i]==ch)
				return i;
		}
		
		return -1;
	}
	
	public void inorder(Node root) {
		
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' }; 
	    char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' };
	    
	    
	    Node root = new BuildTree().buildTree(in,pre,0,in.length-1,0);
	    
	    new BuildTree().inorder(root);
	}

}
