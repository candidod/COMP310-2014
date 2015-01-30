
public class BinaryTreeNode<DataType extends Comparable<DataType>> {
		DataType data;
		BinaryTreeNode<DataType> left, right;
		BinaryTreeNode(DataType data)
		{
			this.data = data;
		}
		void add(DataType moreData)
		{
			if (data.compareTo(moreData) <= 0)
			{
				if (right == null)
				{
					//create a node and call it a day
				}
				else
				{
					//keep looking recursively 
				}
				// goes to the right
			}
			else 
			{
				if (left == null)
				{
					//create a node and call it a day
				}
				else 
				{
					// keep looking recursively
				}
				//goes to the left
			}
		
			
			//figure out which side to place it
			//
			//put it there
			
		}
		public static void main (String [] args)
		{
			System.out.println("Hello". compareTo("World"));
		}
}
