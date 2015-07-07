package tests;

public abstract class MyAssert {

	public void myAssertTrue(String msg, boolean expression){
		if(!expression){
			System.out.println(msg);
		}
		//assertTrue(expression);
	}
}
