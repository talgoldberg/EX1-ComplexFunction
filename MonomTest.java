package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testGetComp() {
		
	}

	@Test
	void testMonomDoubleInt() {
		Monom mon = new Monom(3,4);
		assertEquals(3, mon.get_coefficient());
		assertEquals(4, mon.get_power());
	}

	@Test
	void testMonomMonom() {
		Monom mon = new Monom(3,5);
		Monom m1 = new Monom(mon);
		assertEquals(mon.toString(), m1.toString());
	}

	@Test
	void testMonomString() {
		
	}

	@Test
	void testGet_power() {
		Monom mon = new Monom(3,2);
		assertEquals(2, mon.get_power());
	}

	@Test
	void testGet_coefficient() {
		Monom mon = new Monom(3,2);
		assertEquals(3, mon.get_coefficient());
	}

	@Test
	void testDerivative() {
		Monom[] mon = {new Monom("3x^10"),new Monom("x^10"),new Monom("10x^0"),new Monom("1x^1")};
		Monom[] mon_derivative = {new Monom("30x^9"),new Monom("10x^9"),new Monom("0"),new Monom("1")};
		for(int i=0; i < mon.length;i++)
		{
			assertEquals(mon_derivative[i].toString(), mon[i].derivative().toString());
		}
	}

	@Test
	void testIsZero() {
		
	}

	@Test
	void testF() {
		Monom m = new Monom(2.7,4);
		double a;
		a=m.f(3);
		assertEquals(a,218.70000000000002);
		
		
	}

	@Test
	void testAdd() {
		Monom m = new Monom(2.7,4);
		Monom m1=new Monom(2.5,4);
		m.add(m1);
		String actual =m.toString(); 
		String expected = "5.2x^4";
		assertEquals(expected,actual);
	}

	@Test
	void testSub() {
		Monom m = new Monom(6.7,4);
		Monom m1=new Monom(2.5,4);
		m.sub(m1);
		String actual =m.toString(); 
		String expected = "4.2x^4";
		assertEquals(expected,actual);
	}

	@Test
	void testToString() {
		String s="6.7x^2";
		Monom m = new Monom(6.7,2);
		String actual =m.toString();
		assertEquals(s,actual);
	}

	@Test
	void testMultiply() {
		Monom m = new Monom(2.7,4);
		Monom m1=new Monom(2.5,4);
		m.multiply(m1);
		String actual =m.toString(); 
		String expected = "6.75x^8";
		assertEquals(expected,actual);
	}

	@Test
	void testEqualsMonom() {
		Monom m = new Monom(2.5,4);
		Monom m1=new Monom(2.5,4);
		m.equals(m1);
		String actual =m.toString(); 
		String expected = "2.5x^4";
		assertEquals(expected,actual);
	}

	@Test
	void testInitFromString() {
		
	}

	@Test
	void testCopy() {
		
	}

}
