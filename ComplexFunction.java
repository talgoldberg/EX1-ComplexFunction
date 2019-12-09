package Ex1;



public class ComplexFunction implements complex_function {

	function left;
	function right;
	Operation op;
	
	
	
	public ComplexFunction(String _op1,function _left,function _right) {
		
		_op1=switchOp(_op1);
		this.left=_left; 
		this.right=_right; 
		this.op=Operation.valueOf(_op1);
		
	}
	
	
	public ComplexFunction(function _left) {
		 this.left=_left;
	}

	

	public function getLeft() {
		return left;
	}

	public void setLeft(function left) {
		this.left = left;
	}

	public function getRight() {
		return right;
	}

	public void setRight(function right) {
		this.right = right;
	}

	public Operation getOp() {
		if(right==null) 
			System.out.println("we dont have a Operation ");
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}
	public String get_op() { 
		return op.toString();

	}
	@Override
	public double f(double x) {
		
		if(op==Operation.Divid) 
			return left.f(x)/right.f(x);
		
		if(op==Operation.Plus) 
			return left.f(x)+right.f(x);
		
		if(op==Operation.Times) 
			return left.f(x)*right.f(x);
		
		if(op==Operation.Max) 
			return Math.max(left.f(x), right.f(x)); 
		
		if(op==Operation.Min)
			return Math.min(left.f(x), right.f(x));
		
		if(op==Operation.Comp)
			return left.f(right.f(x));
		return 0;
	}

	@Override
	public function initFromString(String s) {
		
		String op=""; 
		String left1="";
		String right1="";
		String ans="";
		int start=0;
		int end=s.length()-1;
		if(!s.contains(",")&&!s.contains("+")&&!s.contains("-"))
			return new Monom(s);
		
		if(!s.contains(",") && (s.contains("+") || s.contains("-")))
			return new Polynom(s);
		
		while(s.charAt(start)!='(') 
		{
			op=op+s.charAt(start);
			start++;
		}
		
		start++;
		while(s.charAt(start)!='(' && s.charAt(start) !=',')
		{
			ans=ans+s.charAt(start);
			start++;
		}
		
		if(s.charAt(start)=='(') {
			int temp=0;
			boolean f=true; 
			while(f) {
				
				if(s.charAt(start)=='(')
					temp++; 
				if(s.charAt(start)==')')
					temp--;
				
				ans=ans+s.charAt(start); 
				start++;
				
				if(temp==0)
					f=false;
			}
		
			left1=ans;
			right1=s.substring(start+1, end);
			op=switchOp(op); 
		}

		if(s.charAt(start)==',') {
			left1=ans;
			right1=s.substring(start+1, end);
			op=switchOp(op); 
			
		}
		
		function left=initFromString(left1);
		function right=initFromString(right1);
		op=switchOp(op); 
		
		
		return new ComplexFunction(op,left,right);
	
	}
	
	private String switchOp(String Operator) 

	{
		
		if(Operator=="Plus"||Operator=="Times"||Operator=="Comp"||Operator=="Divid"||Operator=="Max"||Operator=="Min") {
			return Operator;
		}
		
		switch(Operator) {
		

		case "comp":{

			return "Comp";
			
		}

		case "mul":{

			return "Times";

		}

		case "div":{

			return "Divid";

		}

		case "plus":{

			return "Plus";

		}

		case "max":{

			return "Max";

		}

		case "min":{

			return "Min";

		}

		default:

			return "None";

		}
	}
	
	@Override
	public function copy() {
		ComplexFunction ans=new ComplexFunction(get_op(),getLeft(),getRight());
		function f=initFromString(ans.toString());
		return f;
	}

	@Override
	public void plus(function f1) {
	
		String op=switchOp("plus");
		ComplexFunction ans = right!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
	}

	@Override
	public void mul(function f1) {
		
		String op=switchOp("mul");
		ComplexFunction ans = getRight()!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
		
	}

	@Override
	public void div(function f1) {
	
		String op=switchOp("div");
		ComplexFunction ans = getRight()!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
	}

	@Override
	public void max(function f1) {
		
		String op=switchOp("max"); 
		ComplexFunction ans = getRight()!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
	}

	@Override
	public void min(function f1) {
		
		String op=switchOp("min"); 
		ComplexFunction ans = getRight()!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
	}

	@Override
	public void comp(function f1) {
	
		String op=switchOp("comp");
		ComplexFunction ans = getRight()!=null ? new ComplexFunction(get_op(),getLeft(),getRight()) : new ComplexFunction(getLeft());
		ComplexFunction temp=new ComplexFunction(op,ans,f1);
		System.out.println(temp);
	}

	@Override
	public function left() {
		return left;
		
	}

	@Override
	public function right() {
		if(right==null) 
			System.out.println("we dont have a function");
		return right;
			
		
	}

	
	
	
	public String toString() {
		if(op==null && right==null)
			return left + "";
		return op + "(" + left + "," + right + ")";
	}
}
