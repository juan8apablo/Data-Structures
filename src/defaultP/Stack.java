package defaultP;


import java.io.*;

public class Stack {

	Nodo cabeza = null;
	
	public boolean vacia()
	{
		return cabeza == null ? true : false;
	}


	public void printStack() 
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Nodo temp = cabeza;		
		try 
		{
			bw.write("Stack\n");
			while(!vacia())			
				bw.write(pop());				
			
			bw.flush();//print
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	

	public void push(Nodo nuevoNodo)
	{
		nuevoNodo.next = cabeza;
		cabeza = nuevoNodo;
	}
	
	public String pop() //Similar to delete
	{
		Nodo temp = cabeza; 
		cabeza = cabeza.next;
		String info = temp.toString();
		temp = null;
		System.gc();//garbageCollector
		return info;		
	}
	
	public String peek()//return item of the head
	{
		if(vacia())
			return "Stack Empty";
		else
		{
			Nodo temp = cabeza;
			String info = temp.toString();
			return info;
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		Stack pila = new Stack();		
		
		pila.push(new Nodo("Tarea 1", 2.5));		
		pila.push(new Nodo("Quiz 1", 1.5));		
		pila.push(new Nodo("Quiz 3", 1.5));
		pila.push(new Nodo("Eliminar", 1.5));
		pila.pop();
		pila.printStack();
	}

}
