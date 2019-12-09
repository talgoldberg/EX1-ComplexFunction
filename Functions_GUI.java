package Ex1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions {

	public ArrayList<function> funcs = new ArrayList<function>();
	
	public Functions_GUI()
	{
		
	}
	@Override
	public boolean add(function arg0) 
	{
		funcs.add(arg0);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initFromFile(String file) throws IOException {
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"),new Polynom("x+1"));

		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		while ((st = br.readLine()) != null) {
		  funcs.add(cf4.initFromString(st)); 
		  
		}
		br.close();
	
	}

	@Override
	public void saveToFile(String file) throws IOException 
	{
			File f= new File(file);
			f.createNewFile();
		    BufferedWriter buffer = new BufferedWriter(new FileWriter(f));
		    for (function function : funcs) 
		    {
			    buffer.write(function.toString()+"\n");
			    buffer.newLine();
		    }

		 
		    buffer.close();
		    
		    Path currentRelativePath = Paths.get("");
		    String s = currentRelativePath.toAbsolutePath().toString();
		    System.out.println("Current relative path is: " + s);	
		    }

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() 
	{
		return funcs.toString();
	}
//	public static void main(String[] args) throws IOException 
//	{
//		Functions_GUI data = new Functions_GUI();
//		String s1 = "3.1+2.4x^2-x^4";
//		String s2 = "5+2x-3.3x+0.1x^5";
//		String[] s3 = {"x+3","x-2","x-4"};
//		Polynom p1 = new Polynom(s1);
//		Polynom p2 = new Polynom(s2);
//		Polynom p3 = new Polynom(s3[0]);
//		ComplexFunction cf3 = new ComplexFunction(p3);
//		//for(int i=1;i<s3.length;i++) {
//			//cf3.mul(new Polynom(s3[i]));
//		//}
//		String s4="mul(div(mul(x+1,x+3.0),x+3.0),x+2)"; 
//			
//		ComplexFunction cf = new ComplexFunction("plus", p1,p2);
//		ComplexFunction cf2 = new ComplexFunction("plus", p1,p2);
//		ComplexFunction cf5 = new ComplexFunction("plus", p1,p2);
//		ComplexFunction cf4 = new ComplexFunction("plus", p1,p2);
//		data.add(cf);
//		data.add(cf2);
//		data.add(cf5);
//		data.add(cf4);
//		data.saveToFile("asdf.txt");
////		functions_GUI.initFromFile("C:\\Users\\TAL\\eclipse-workspace53\\Ex1\\asdf.txt");
////		functions_GUI.saveToFile("asdf.txt");

	}

