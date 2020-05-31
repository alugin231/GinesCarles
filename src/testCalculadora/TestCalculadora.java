package testCalculadora;

import calculadora.RPN;
import junit.framework.TestCase;
import org.junit.*;


public class TestCalculadora   extends TestCase{
	@Test
	public void testCalculadora() {
		RPN test01 = new RPN("4 5 * 7 2 / - 3 %");
		assertEquals(1.5,test01.resultado( ));
	}
}


