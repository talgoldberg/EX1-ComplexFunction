package Ex1;



public class PolynomTest {
	public static void main(String[] args) {
		test1();
		test2();
	}
	public static void test1() {
		Polynom p1 = new Polynom("x^3-x^2-7x");
		Polynom p2 = new Polynom("x^4-x^3-4x");
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for(int i=0;i<monoms.length;i++) {
		Monom m = new Monom(monoms[1]);
		p1.add(m);
		double aa = p1.area(0, 1, 0.0001);
		p1.substract(p2);
		System.out.println(p1);
	}
	}
	
	public static void test2() {
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		Polynom p3 = new Polynom("3x^2+8x^3+7");
		String[] monoms1 = {"2","-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		Monom m2 = new Monom("-6x^4");
		System.out.println(p3);
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		
		System.out.println("p1+p2: "+p1);
		p1.multiply(m2);
		
		String s1 = p1.toString();
		
	}
}
