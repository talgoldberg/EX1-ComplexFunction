package Ex1;


//import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.function.Predicate;

/**
* This class represents a Polynom with add, multiply functionality, it also should support the following:
* 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
* 2. Finding a numerical value between two values (currently support root only f(x)=0).
* 3. Derivative
* @author tal goldberg -308361476, avichai israeli -315660845
*
*/
public class Polynom implements Polynom_able{
	// the parameters
	private ArrayList<Monom> Polynom1;


	/**
	 * empty constructor
	 * its built an "empty polynom" = polynom without monom's = "zero polynom"
	 */
	public Polynom() {
		Polynom1= new ArrayList<Monom>(); 
	}	

	/**
	 * this is String constructor,
	 * the string must be from this shape = monom+-monom....
	 * it base on the String constructor of monom - read from there the exceptions
	 * @param  String s
	 * @throws null , negative power, an illegal signs
	 */
	public Polynom(String s) {
		if(s==null) {throw new RuntimeException("got a null string");}//if its null
		if(s.contains("^-")){throw new RuntimeException("got a negative power");}//if its got a negative power
		if(s.contains("@")){throw new RuntimeException("got a @ -not legal");}//if its got '@'
		Polynom1= new ArrayList<Monom>(); 
		String newS =newString(s);      // its make before every "+" to "@+" for the sake of the split function
		String[] parts1 = newS.split("@+"); //split according to "@+"
		for (int i = 0; i < parts1.length; i++) {
			String[] parts2 = parts1[i].split("(?=-)");// split anther time for the "-" sign
			for (int j = 0; j < parts2.length; j++) {
				Monom m=new Monom(parts2[j]);   // after we split them we built every monom
				this.add(m);
			}
		}
	}


	/**
	 * return the same string only that before every "+" there is "@"
	 * @param String s
	 * @return String 
	 */
	private static String newString(String s) {

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='+') {
				s=s.substring(0, i)+"@"+s.substring( i);

				i++;
			}
		}	
		return s;

	}

	/**
	 * calculate the value of this polynom in that point
	 * @param double 
	 * @return double 
	 *  
	 */
	@Override
	public double f(double x) {
		if(this.isZero())
			return 0;
		double sum=0;
		Iterator<Monom> it = Polynom1.iterator();  // needs to chack how to use iterator
		while(it.hasNext()) {
			Monom m = new Monom(it.next());
			sum=sum+m.f(x); 
		}
		return sum;
	}


	/**
	 * adding p1 to this polynom
	 * @param Polynom_able 
	 */
	@Override
	public void add(Polynom_able p1) {
		if(!p1.isZero()) {
			Iterator<Monom> it = p1.iteretor();
			while(it.hasNext()) {
				Monom m= it.next();
				this.add(m);
			}

		}

	}

	/**
	 * adding m1 to this polynom
	 * @param Monom 
	 */
	@Override
	public void add(Monom m1) {
		if(m1.get_coefficient()!=0) {// if this is a zero monom its doesn't add
			boolean flag =true;
			Iterator<Monom> it = Polynom1.iterator();
			while(it.hasNext()&&flag) {
				Monom m = it.next();
				if(m1.get_power() == m.get_power()) {//if they have the same power
					m.add(m1);
					flag=false;
				}

			}
			if(flag) {//if we chack all the polynome and didnt fond monom whit the same power
				Polynom1.add(m1);
			}
			this.sortbypower();
		}
	}

	/**
	 * sorting the polynom by the power
	 */
	private void sortbypower() {
		Comparator<Monom> sort_power=new Monom_Comperator();//creating the object 
		Polynom1.sort(sort_power);
	}

	/**
	 * subtract p1 to this polynom
	 * @param Polynom_able 
	 */
	@Override
	public void substract(Polynom_able p1) {
		if(!p1.isZero()) {
			Iterator<Monom> it = p1.iteretor();
			while(it.hasNext()) {
				Monom m = it.next();
				this.substract(m);
			}
			this.sortbypower();
		}

	}

	/**
	 * subtract m1 to this polynom
	 * @param Monom 
	 */
	public void substract(Monom m1) {
		if(m1.get_coefficient()!=0) {
			boolean flag =true;
			Iterator<Monom> it = Polynom1.iterator();
			while(it.hasNext()&&flag) {
				Monom m = it.next();
				if(m1.get_power() == m.get_power()) {//if they have the same power
					if(m1.get_coefficient() == m.get_coefficient()) {
						flag=false;
						it.remove();  
					}
					else {
						m.sub(m1);
						flag=false;
					}
				}
			}
			if(flag) {//if we chack all the polynome and didnt fond monom whit the same power
				Monom negative= new Monom(-1,0);
				m1.multiply(negative);// torn the monom to be negative
				Polynom1.add(m1);
			}
			this.sortbypower();
		}
	}



	/**
	 * multiply p1 to this polynom
	 * note: if you multiply with the zero polynom = zero polynom
	 * @param Polynom_able p1
	 */
	@Override
	public void multiply(Polynom_able p1) {
		if(p1.isZero()||this.isZero()) {
			Polynom1.clear();
		}
		else {
			Polynom_able copy1= new Polynom();

			Iterator<Monom> it = p1.iteretor();
			while (it.hasNext())
			{
				Monom m=it.next();
				copy1.add(this.multiply1(m));
			}

			Polynom1.clear();
			it = copy1.iteretor();
			while (it.hasNext())   //coping copy1 to this polynom
			{
				Monom m=it.next();
				Polynom1.add(m);
			}

		}
	}


	/**
	 * multiply m1 to this polynom
	 * if one of them is zero its make the zero polynom
	 * @param Monom m1
	 * @return Polynom
	 */
	public Polynom multiply1(Monom m1) {
		if(this.isZero()||m1.isZero()) {
			Polynom1.clear();
		}
		Polynom_able copy1= this.copy();
		Iterator<Monom> it = copy1.iteretor();
		while (it.hasNext())
		{
			Monom m=it.next();
			m.multiply(m1);
		}
		return (Polynom) copy1;

	}

	/**
	 * Checking if every monom's of those polynom's are equals
	 * @param Polynom_able p1
	 * @return boolean
	 */
	@Override
	/*
	public boolean equals(Polynom_able p1) {
		if(this.isZero()&&p1.isZero())// if they are the zero polynom
			return true;
		if(Polynom1.size()!=((Polynom) p1).size())//if they don't have the same sum of element
			return false; //they are not equals
		else {  // is going to chack if they equals
			Iterator<Monom> it = Polynom1.iterator();
			// i cut the casting
			Iterator<Monom> it1 = p1.iteretor();
			boolean flag=true;
			while(it.hasNext()&&flag) {// chak for every monom if the are equals
				Monom m= it.next();
				Monom m1= it1.next();
				if(!m.equals(m1))
					flag=false;
			}
			return flag;
		}
	}

	/**
	 * returns the number of monom's in this polynom - the list size
	 * @return int
	 */
	/*
	private int size() {	
		return Polynom1.size();
/*
	}
	/**
	 * if this is polynom without monom's return true
	 * @return boolean
	 */
	
	public boolean isZero() {
		if(Polynom1.size()==0)
			return true;
		return false;
	}

	/**
	 * its give the point (x',0)- ("hituh point")
	 * Assuming f(x0)*f(x1)<0
	 * Assuming x0<x1
	 * @param double x0, double x1, double eps
	 * @return double
	 * @throws x0>x1,x0)*f(x1)>0
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if(x0>x1){throw new RuntimeException("x0>x1"); }
		if(f(x0)*f(x1)>0){throw new RuntimeException("f(x0)*f(x1)>0!!!"); }
		if(f(x0)*f(x1)==0) {  // if one of the is the point
			if(f(x0)==0)
				return x0;
			if(f(x1)==0)
				return x1;
		}
		if(this.disX(x0, x1)<eps||(this.f((x0+x1)/2)==0)) //the base of the Recursion
			return x0+(this.disX(x0, x1))/2;
		else {
			double mid =x0+(this.disX(x0, x1))/2;
			if(this.f(x0)*this.f(mid)<0)//if x' is between x0 , mid
				return root(x0,mid,eps);
			if (this.f(x1)*this.f(mid)<=0)// x' is between mid , x1                        
				return root(mid,x1,eps);
			return 0;
		}

	}

	/**
	 * function that gives the distance between x0 to x1
	 * note: Assuming x0<x1
	 * @param double x0,double x1
	 * @return double
	 */
	 public double disX(double x0,double x1) {
		if((x1>=0)&&(x0>=0))
			return x1-x0;
		if((x1<0)&&(x0<0))
			return x1-x0;
		if(x0<0&&x1>=0)
			return Math.abs(x0)+x1;
		return x1;

	}
	/**
	 * creating a deep copy of this polynom
	 * @return Polynom_able
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able copy1=new Polynom();
		Iterator<Monom> it = Polynom1.iterator();
		while(it.hasNext()) {
			Monom m= new Monom(it.next());
			copy1.add(m);
		}
		return copy1;
	}
	/**
	 * creating a polynom that is a derivative of this polynom
	 * @return Polynom_able
	 */
	@Override
	public Polynom_able derivative() {
		Polynom deriv = new Polynom();
		Iterator<Monom> it = Polynom1.iterator();
		while(it.hasNext()) {
			Monom m= it.next();
			deriv.add(m.derivative());
		}
		return deriv;
	}


	/**
	 * calculate the area above axis x of this polynom between x0 and x1
	 * Assuming x0<x1
	 * note if eps>1 eps=1
	 * @throws x0>x1
	 * @param double x0, double x1, double eps
	 * @return double
	 */
	@Override
	public double area (double x0, double x1, double eps) {
		if(x0>x1){throw new RuntimeException("x0>x1"); }
		if(x0==x1)return 0;
		if(eps>1) {
			eps=1;   //this is the max of eps
		}
		int numOfPartition=(int) ((x1-x0)/eps); //how many Rectangles to do 
		double sum = 0,mid=0;
		double Partition=x0;
		for (int i = 0; i < numOfPartition; i++) {
			Partition=Partition+eps;  //going to the next Rectangle
			if(this.f(Partition)>=0) {  // if its above axis x
				mid=Partition-eps/2;
				sum= sum + eps*f(mid);
			}
		}
		return sum;
	}
	/**
	 * creating the polynom iteretor base on the list iteretor 
	 * @return Iterator<Monom>
	 */
	@Override
	public Iterator<Monom> iteretor() {
		return Polynom1.iterator();
	}

	/**
	 * 
	 * this function make this polynom to a String 
	 * if the coefficient or the power is 1 its like the are not in the String
	 * if the power is zero the is no "x" in the string
	 * simply its doing the reverse for the "string constructor"
	 * @return String
	 */
	public String toString() {
		String s="";
		if(this.isZero()) {
			s=s+"0";
		}
		else {
			Iterator<Monom> it = Polynom1.iterator();
			boolean first=true;
			while(it.hasNext()) {
				Monom m = it.next();
				if(first) {
					first=false;
					s=s+m.toString();
				}
				else {
					if(m.get_coefficient()<0)
						s=s+m.toString();
					else
						s=s+"+"+m.toString();
				}
			}
		}
		return s;
	}

	public void multiply(Monom m1) {
		String s=" ";
		if(this.isZero()||m1.isZero()) {
			Polynom1.clear();
		}
		Polynom_able copy1= this.copy();
		Iterator<Monom> it = copy1.iteretor();
		while (it.hasNext())
		{
			Monom m=it.next();
			m.multiply(m1);
			s=s+m;
		}
		System.out.println("the multuply : " + s);
		
	}

	@Override
	public function initFromString(String s) {
	
		function f=new Polynom(s); 
		return f;
	}

	

}
