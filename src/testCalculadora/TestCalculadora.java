package testCalculadora;

import calculadora.RPN;
import junit.framework.TestCase;
import org.junit.*;


public class TestCalculadora   extends TestCase{
	@Test
	public void testCalculadora() {
		RPN test01 = new RPN("4 5 * 7 2 / - 3 %");
		assertEquals(1.5,test01.resultado( ));
		
		RPN test02 = new RPN("4 5 +");
		assertEquals(9.0,test02.resultado( ));
		
		RPN test03 = new RPN("5 4 -");
		assertEquals(1.0,test03.resultado( ));
		
		RPN test04 = new RPN("3 3 *");
		assertEquals(9.0,test04.resultado( ));
		
		RPN test05 = new RPN("4 2  /");
		assertEquals(2.0,test05.resultado( ));
		
		RPN test06 = new RPN("2 10 ^");
		assertEquals(1024.0,test06.resultado( ));
		
		RPN test07 = new RPN("4 3 %");
		assertEquals(1.0,test07.resultado( ));
		
	}
}


