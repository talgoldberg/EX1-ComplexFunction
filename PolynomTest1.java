package Ex1;

import org.junit.jupiter.api.Test;

class PolynomTest1 {

	@Test
	void testPolynom() {
		fail("Not yet implemented");
	}

	@Test
	void testPolynomString() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPolynom_able() {
		Polynom p1 = new Polynom("x^2+3");

		Polynom p2 = new Polynom("x^2+3+1");

		Polynom result = new Polynom("2x^2+7");

		p1.add(p2);

		assertEquals(true, p1.equals(result));
	}

	@Test
	void testAddMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testSubstractPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testSubstractMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply1() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testDisX() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testIteretor() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplyMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		fail("Not yet implemented");
	}

}
