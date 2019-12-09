package Ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
* @author tal goldberg -308361476, avichai israeli -315660845
 *
 */
public class Monom implements function{
	
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	private double _coefficient;  
	private int _power;
	private ArrayList<Monom> monom1;
	/**
	 * this is regular constructor 
	 * @param double a, int b
	 * @throws if its got a negative b	  
	 */
	public Monom(double a, int b){ //regular constructor 
		this.set_coefficient(a);
		if(b<0) {throw new RuntimeException("there is a negative power "); }
		this.set_power(b);
	}
    
	/**
	 * this is copy constructor 
	 * @param Monom ot
	 *  
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * this is String constructor
	 * note: there is no difference between x and X
	 * @param String s
	 * @throws if its got null,
	 * if its not from this shape = ax^b
	 * @exception
	 * if there is no a like x^6 >>>> a=1 or -x^6 >>>> a=-1,
	 * if there is no b like 4x b=1,
	 * if there is just a real number like 7 a=7 b=0,
	 */ 
	public Monom(String s) {// String constructor 
		this(initString(s)._coefficient, initString(s)._power);
	}
	/**
	 * this is the String constructor helper
	 * note: there is no difference between x and X
	 * @param String s
	 * @throws if its got null,
	 * if its not from this shape = ax^b
	 * @exception
	 * if there is no a like x^6 >>>> a=1 or -x^6 >>>> a=-1,
	 * if there is no b like 4x b=1,
	 * if there is just a real number like 7 a=7 b=0,
	 *  @return Monom 
	 */
	private static Monom initString(String s) {

		if(s==null) {throw new RuntimeException("got a null string");}
		double a=0;
		int b=0;
		String low= s.toLowerCase();
		int index_X= low.indexOf("x");
		if(index_X<0) {      //There is no "x" it only option is to be a real number
			a=Double.parseDouble(low);
		}
		else {
			String A =low.substring(0,index_X);// string that represent the "a"
			if(A.isEmpty()) {
				a=1;
			}
			else {
				if(A.equals("-"))
					a=-1;
				else
					a=Double.parseDouble(A);
			}
			String B = low.substring(index_X+1);// string that represent the "^b"
			if(B.isEmpty()) {
				b=1;
			}
			else {
				// if the isn't a power sign first
				if(B.charAt(0)!='^') {throw new RuntimeException("there is no power sign");}
				else {
					B = B.substring(1);  // string that represent the "b" without "^"
					if(B.isEmpty()) {throw new RuntimeException("there is no power number");}
					else {
						b=Integer.parseInt(B);
					}
				}
			}
		}
		Monom m= new Monom(a,b);
		return m;
	}




	// ***************** add your code below **********************
	/**
	 * @return int
	 */
	public int get_power() {
		return this._power;
	}
	/**
     * @return int
	 */
	public double get_coefficient() {

		return this._coefficient;
	}
	/**
	 * this is derivative function 
	 * -derivative this monom
	 *  
	 */
	/*
	public void nigzeret () {
		if(this._power==0) {
			this._coefficient=0;
		}
		else {
			this._coefficient=this._coefficient*this._power;
			this._power= this._power-1;
		}

	}
	*
	*/
	
	/**
	 * this is derivative function- 
	 * derivative but live this monom as it is 
	 * @return Monom
	 *  
	 */
	
	public Monom derivative () {

		Monom m=new Monom(0,0);
		if(this._power==0) {

		}
		else {
			m.set_coefficient(this._coefficient*this._power);
			m.set_power(this._power-1);
		}
		return m;

	}
	
	/**
	 * if this is the "zero monom"- coefficient=0 return true
	 * @return boolean
	 */
	public boolean isZero() {
		return (this._coefficient==0);
	}
	
	/**
	 * gives the value of this monom in that point
	 * @param x
	 * @return double
	 *  
	 */
	public double f(double x) {

		return this._coefficient*(Math.pow(x, this._power));
	} 

	
	/**
	 * add m to this Monom
	 * @param m 
	 * @throws - if they don't have the same power 
	 */
	public void add(Monom m) {
		if(this._power!=m._power){throw new RuntimeException("this function cant add this monon because they are not from the same type");}
		else
			this.set_coefficient(this.get_coefficient()+m.get_coefficient());
	}
	
	/**
	 * subtract m from this monom
	 * @param Monom m
	 * @throws if they don't have the same power 
	 */
	public void sub(Monom m) {
		if(this._power!=m._power){throw new RuntimeException("this function cant add this monon because they are not from the same type");}
		else
			this.set_coefficient(this.get_coefficient()-m.get_coefficient());
	}
	
	/**
	 * 
	 * this function make this monom to a String ,
	 * if the coefficient or the power is 1 its like the are not in the String,
	 * if the power is zero the is no "x" in the string,
	 * simply its doing the reverse for the string constructor
	 * @return String
	 */
	
	public String toString() {
		String s="";
		if(this._coefficient==0)
			return "0";
		if(this._coefficient==1) {
			if(this._power==0)
				return "1";
			if(this._power==1)
				return "x";
			return "x"+"^"+this._power;
		}
		if(this._coefficient==-1) {
			if(this._power==0)
				return "-1";
			if(this._power==1)
				return "-x";
			return "-x"+"^"+this._power;
		}
		s=s+this._coefficient;
		if(this._power==0)
			return s;
		if(this._power==1)
			return s+"x";	
	   
		s=s+"x"+"^"+this._power;
		return s;
	}
	
	/**
	 * 
	 * this function multiply this monom whit d, 
	 * @param Monom d
	 */
	public void multiply(Monom d) {
		this._coefficient=this._coefficient*d._coefficient;
		this._power=this._power+d._power;
	}
	/**
	 * 
	 * this function check if this monom is equals to m 
	 *only if the coefficient and the power is equals return true
	 *@param m
	 *@return boolean
	 */
	public boolean equals(Monom m) {
		if((this.get_coefficient()==m.get_coefficient())&&(this.get_power()==m.get_power()))
			return true;
		return false;
	}

	//****************** Private Methods and Data *****************

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) { throw new RuntimeException ("ERR the power of monom should not be negative, got :" + p);}
		this._power = p;
	}

	
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}

	@Override
	public function initFromString(String s) {
		
		
		function f=new Monom(s);
		return f;
	}

	@Override
	public function copy() {
		
		return null;
		
	}


	

	
	


	
	
	

}
