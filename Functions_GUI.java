package Ex1;


import java.awt.Color;
import java.awt.Font;
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
		return funcs.add(arg0);
		
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		return funcs.addAll(arg0);
		
	}

	@Override
	public void clear() {
		funcs.clear();
		
	}

	@Override
	public boolean contains(Object arg0) {
		
		return funcs.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return funcs.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return funcs.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		
		return funcs.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return funcs.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
	
		return funcs.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return funcs.retainAll(arg0);
	}

	@Override
	public int size() {
		return funcs.size();
	}

	@Override
	public Object[] toArray() {
		return funcs.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return funcs.toArray(arg0);
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
		
	
		
		
			StdDraw.setYscale(ry.get_min(),ry.get_max());
			StdDraw.setXscale(rx.get_min(),rx.get_max());
			StdDraw.setPenColor(Color.black);
			StdDraw.setPenRadius(0.00010);  
			for (double i =rx.get_min(); i < rx.get_max(); i++) {
			 StdDraw.line(i,ry.get_min(),i,ry.get_max());
		}
		 	  
		 	
			for (double i = ry.get_min(); i < ry.get_max(); i++) {
				 StdDraw.line(rx.get_min(),i,rx.get_max(),i);
			}
			   
			 StdDraw.setPenRadius(0.00010); 
			 StdDraw.setPenRadius(0.0020);
			 StdDraw.line(rx.get_min(),0,rx.get_max(),0); 
			 StdDraw.line(0,ry.get_min(),0,ry.get_max());
			 StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
			 for (double i = ry.get_min(); i < ry.get_max(); i++) {
				 StdDraw.text(0, i, Integer.toString((int)i));
			 }
			
			 for (double i = rx.get_min(); i < rx.get_max(); i++) {
				 StdDraw.text(i, 0, Integer.toString((int)i));
			 }
			 
			 for (int i = 0; i < funcs.size(); i++) {
				
			}
	
	
	}
	


	@Override
	public void drawFunctions(String json_file) {

		
	}

		
	

	@Override
	public String toString() 
	{
		return funcs.toString();
	}

	public function get(int i) 
	{
		if(i<funcs.size())
			return funcs.get(i);
		return null;
	}

	}

