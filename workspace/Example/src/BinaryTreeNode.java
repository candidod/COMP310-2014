
public class BinaryTreeNode
	<DataType extends Comparable<DataType>>
	{
	DataType data;
	BinaryTreeNode<DataType> left, right, parent;
	BinaryTreeNode(DataType data) {
		this.data = data;
		this.parent = null;
	}
	private BinaryTreeNode(DataType data, BinaryTreeNode<DataType> parent)
	{
		this.data=data;
		this.parent = parent;
	}
	
	void add(DataType moreData) {
		// figure out which side to place it
		BinaryTreeNode<DataType> node = findNode(moreData);
		if(node.data.compareTo(moreData) <= 0 )
		{
			node.right = new BinaryTreeNode<DataType>(moreData);
		
		}
		else
			node.left = new BinaryTreeNode<DataType>(moreData);
	}
	boolean contains(DataType data)
	{
		BinaryTreeNode<DataType> node = findNode(data);
		return false;
		
	}
	
	boolean remove (DataType item)
	{
		BinaryTreeNode<DataType> node = findNode(item);
		if(!node.data.equals(item))
		{
			return false;
		}
		 if (node.left == null && node.right == null)
		{
			 if(node.parent != null)
			 {
				 if (node.parent.left == node)
				 {
					 node.parent.left = null;
				 }
				 else
					 node.parent.right = null;
			 }
		}
		return false;
	
	}
	// Can you write this function?
	// Hint: try doing what you do in the add function
	//Return a node with the data in it or the parent of that node or something close to the data.
	BinaryTreeNode<DataType> findNode(DataType data)
	{
		int result = this.data.compareTo(data);
		if (result < 0) {//if the data we are looking for is not in this node
			if (right == null) 
			{
				return this;
			} 
			else 
			{
				return right.findNode(data);
			}
		} 
		else if (result == 0)
		{
			return this;
		}
			
			if (left == null) 
			{
				return this; //if the data we are looking for is not in this node
			} 
			else
			{
				return left.findNode(data);
			}
			
		}
	public static void main(String[] args) {
		System.out.println("Hello".compareTo("World"));
	}
}
