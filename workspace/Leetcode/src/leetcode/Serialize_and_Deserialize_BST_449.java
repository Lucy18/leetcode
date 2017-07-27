package leetcode;

public class Serialize_and_Deserialize_BST_449 {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {     
    	if(root==null){
    		return "";
    	}
    	if(root.left==null&&root.right==null){
    		return "["+root.val+"]";
    	}
    	else if(root.right==null){
    		return "["+root.val+"("+serialize(root.left)+")]";
    	}
    	else{
    		return "["+root.val+"("+serialize(root.left)+","+serialize(root.right)+")]";
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {        
    	if(data==null||data.equals("")){
    		return null;
    	}
    	if(!data.contains("(")){
    		data=data.substring(1,data.length()-1);//把两侧的[ ]剥掉
    		int val=Integer.parseInt(data);
    		return new TreeNode(val);
    	}
    	int index=data.indexOf('(');
    	String valString=data.substring(1,index);
        String subRootString=data.substring(index+1,data.length()-2);//去掉(和)]
     	int val=Integer.parseInt(valString);
     	TreeNode root=new TreeNode(val);
     	
    	int i=0;//i是要得出当前括号所对应逗号的index
    	int countLeft=0;
    	while(i<subRootString.length()){
    		if(subRootString.charAt(i)=='['){
    			countLeft++;
    		}
    		else if(subRootString.charAt(i)==']'){
    			countLeft--;
    		}
    		else if(countLeft==0&&subRootString.charAt(i)==','){
    			break;
    		}
    		i++;
    	}
        if(i==subRootString.length()){//说明当前括号没有对应逗号，即当前只有左结点
        	root.left=deserialize(subRootString);
        }
        else{
        	String left=subRootString.substring(0, i);
        	String right=subRootString.substring(i+1);
        	root.left=deserialize(left);
        	root.right=deserialize(right);
        }
    	return root;   	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serialize_and_Deserialize_BST_449 s=new Serialize_and_Deserialize_BST_449();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.left=new TreeNode(5);
		String data=s.serialize(root);
		System.out.println(data);
		TreeNode node=s.deserialize(data);
		System.out.println(node.val);
	}

}
