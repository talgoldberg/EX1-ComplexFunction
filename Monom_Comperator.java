package Ex1;



import java.util.Comparator;
/**
 * this Comparator compare by the size of the power of the Monom
 * if the first is bigger return negative 
 * if the first is bigger return positive
 * if they are equals  return zero
 * @author tal goldberg -308361476, avichai israeli -315660845
 */

public class Monom_Comperator implements Comparator<Monom> {
    
	
	// ******** add your code below *********
	
	/**
	 * @param Monom o1, Monom o2
	 * @return int
	 */
	
	public Monom_Comperator() {;}
	public int compare(Monom o1, Monom o2) {
		int dp = o2.get_power() - o1.get_power();
		return dp;
	}

	

}
