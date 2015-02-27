import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeNodeTest {

	@Test
	public void nonTestMethod() {
		
	}
	@Test
	public void testAdd() {
		BinaryTreeNode<String> tree =
				new BinaryTreeNode<String>("dog");
		tree.add("cat");
		tree.add("fish");
		tree.add("turtle");
		tree.add("snake");
		tree.remove("fish");
		/*
		assertEquals("cat", tree.left.data);
		assertEquals("fish", tree.right.data);
		assertEquals("turtle", tree.right.right.data);
		assertEquals("snake", tree.right.right.left.data);
		*/
		assertEquals("cat",tree.left.data);
		assertEquals("turtle",tree.right.data);
		assertEquals("snake", tree.right.left.data);
		
		
	}

}