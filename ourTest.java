
package Ex1;

import java.util.Iterator;
/** 
 * This class Demonstrates and tests the functionality of the monom and polynom classes
**/

public class ourTest {

	public static void main(String[] args) {
		
		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
		System.out.println(cf.f(2));
		//////////////////////////////the monom class/////////////////////////
		Monom m2 = new Monom("-6x^4");
		//Checking the function toString+constructor
		System.out.println(m2.toString());
		Monom m4= new Monom(-7,1);
		Monom m5= new Monom(m4);
		Monom m6= new Monom(0,0);
		Monom m7= new Monom(9,1);
		Monom m8= new Monom(m7.get_coefficient(),m5.get_power());
		Monom m9= new Monom(-7,4);
		Monom m10= new Monom(5,2);
		System.out.println(m10);//Checking the function  constructor
		System.out.println(m8);//Checking the functions getters
		System.out.println(m6.isZero());//Checking the function isZero
		System.out.println(m7.equals(m6));//Checking the function equals
		System.out.println(m5);//Checking the function copy constructor
		m9.sub(m2);
		System.out.println(m7.f(5));//Checking the function f(x)
		System.out.println(m9);//Checking the function sub
		m8.multiply(m7);
		System.out.println(m8);//Checking the function multiply
		m4.add(m7);
		System.out.println(m4);//Checking the function add
		
		System.out.println(m10);//Checking the function nigzeret
		System.out.println(m10.derivative());//Checking the function derivative_Monom

		//////////////////////////////So far, the Monom class///////////////////////////////////

		System.out.println();
              //////////////////////////////the polynom class/////////////////////////
		String s="4x^4+23x^7+7";
		Polynom m0=new Polynom("x^3-x^2-7x");
		Polynom m1=new Polynom(s);
		System.out.println(m0+" start the polynom");//Checking the function constructor
		System.out.println(m0.root(3.19, 5, 0.01)+"-root");//Checking the function root
		System.out.println(m1);//Checking the function constructor
		Polynom m3=new Polynom(s);
		Polynom m11=new Polynom();
		Polynom_able m31=new Polynom();
		Polynom m21=new Polynom();
		Monom m12 = new Monom("-6x^4");
		Monom m13= new Monom("8x");
		Monom m14= new Monom(-7,1);
		Monom m15= new Monom(-1,1);
		Monom m16= new Monom(1,2);
		System.out.println(m3);
		m11.multiply(m3);
		System.out.println(m11);//Checking the function multiply polynom
		m1.add(m12);
		System.out.println(m11.isZero());//Checking the function isZero
		m11.add(m13);
		m1.add(m4);
		m21.add(m14);
		m21.add(m15);
		m21.add(m16);
		m7.add(m15);
		System.out.println(m21);//Checking the functions consractor+function add Monom+sortbypower+compare
		//compare+sortbypower :is inside in function add
		m21.add(m11);
		System.out.println(m21);//Checking the function add polynom
		System.out.println((m1.area(-2, 3,100)));//Checking the function area
		System.out.println(m0.equals(m1));//Checking the function equals
		m0.substract(m1);
		System.out.println(m0.toString());//Checking the functions toString+subtract polynom
		Iterator <Monom> ok = m1.iteretor();//Checking the function Iterator
		while(ok.hasNext()) {
			Monom m= ok.next();
			System.out.println(m);
		}

		System.out.println(m21.f(1));//Checking the function f(x)
		m11.substract(m15);
		System.out.println(m11);//Checking the function subtract Monom
		m31=m11.copy();
		System.out.println(m31);//Checking the function copy
		m31=m11.derivative();
		System.out.println(m31);//Checking the function derivative
		function f=new Monom("2x^2");
		System.out.println(f.toString());

	}

}