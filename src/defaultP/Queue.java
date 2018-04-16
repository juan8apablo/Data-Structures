package defaultP;



import java.io.*;


public class Queue {

	Nodo cabeza = null;
	
	public boolean vacia()
	{
		return cabeza == null ? true : false;
	}


	public void imprimirCola() 
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Nodo temp = cabeza;
		
		try 
		{
			bw.write("Cola\n");
			while(temp != null)
			{
				bw.write(temp.toString());
				temp = temp.next;
			}
			bw.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	public void enqueue(Nodo nuevoNodo)
	{
		if(vacia())
			cabeza = nuevoNodo;
		else
		{
			Nodo temp = cabeza;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			temp.next = nuevoNodo;
		}
	}
	
	public String dequeue() 
	{
		Nodo temp = cabeza; // se ncesesita para eliminar de memoria
		cabeza = cabeza.next;
		String info = temp.toString();
		temp = null;
		System.gc();//garbageCollector
		return info;
	}
	


	public static void main(String[] args) 
	{
		Queue cola = new Queue();		
		
		cola.enqueue(new Nodo("Eliminar", 1.5));
		cola.enqueue(new Nodo("Quiz 1", 2.5));		
		cola.enqueue(new Nodo("Quiz 2", 1.5));		
		cola.enqueue(new Nodo("Quiz 3", 1.5));
		cola.enqueue(new Nodo("Quiz 1", 1.5));
		
		//cola.eliminar();
		cola.imprimirCola();
	}

}
