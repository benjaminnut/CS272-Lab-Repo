
public class IntNodeTest {

	public static void main(String[] args) {
		
		IntNode testNode = new IntNode();
		
		IntNode cursorNode = new IntNode();
		
		IntNode nextTest = new IntNode(2, testNode); //IntNode objects with default and argument constructors
		
		testNode.setValue(1);
		
		System.out.println(testNode.getValue());
		
		String s = nextTest.toString();
		
		System.out.println(s); //toString method test
		
		cursorNode.setValue(3);
		
		testNode.setLink(cursorNode);
		
		System.out.println(testNode.getLink()); //mutator function tests
		
		nextTest.addNodeAfter(4); 
		
		s = nextTest.toString();  
		
		System.out.println(s); //test for addNodeAfter function
		
		nextTest.removeNodeAfter(); 
		
		s = nextTest.toString(); 
		
		System.out.println(s);  // test removeNodeAfter function
		
		System.out.println(IntNode.listLength(nextTest));
		
		System.out.println(IntNode.searcher(nextTest, 4));
	

	}

}
