package deepCopy;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Hello");
		List ListA = new LinkedList();
		List ListB = new LinkedList();
		ListA.add(24);
		ListA.add(25);
		ListA.add(27);
		ListA.add(29);
		
		//To see if it copied correctly
		for(int x=0; x<ListA.size();x++)
		{
			System.out.println("Index " + x + " is: " + ListA.get(x));
		}
		
		//Perform a Deep Copy
		for(int x=0; x<ListA.size();x++)
		{
			ListB.add(x,ListA.get(x));
		}
		ListA.remove(1);
		//List B is not effected by a delete of an item form ListA
		for(int x=0; x<ListB.size();x++)
		{
			System.out.println("Index " + x + " is: " + ListB.get(x));
		}
		
		
		
		//Second way to do this
		Node head = new Node(5,null,null);
		Node head2 = new Node();
		
		//Adding things to the first LinkedList
		Node adder = new Node();
		adder = head;
		for(int x=0; x<10; x++)
		{
			Node new1 = new Node();
			adder.setNext(new1);
			adder.setValue(2*x+1);
			adder = adder.getNext();
		}
			
		/*Node reader = new Node();
		reader.setValue(head.getValue());
		reader.setNext(head.getNext());
		
		while(reader.getNext() != null)
		{
			System.out.println("Value!!: " + reader.getValue());
			reader.setValue(reader.getNext().getValue());
			reader.setNext(reader.getNext().getNext());
		}	
		/*Node temp = new Node(head.getValue(),head.getNext(),head.getRandom());
		Node temp2 = new Node();*/

		//Copy Method
		/*while(temp.getNext() !=null)
		{
			
			Node new2 = new Node(temp.getValue(), temp.getNext(), temp.getRandom());
			//System.out.println(temp2.getValue());
			if(temp == head){
				head2 = new2;
				temp2 = head2;				
			}
			else
			{
				temp.setValue(temp.getNext().getValue());
				temp.setNext(temp.getNext().getNext());
				temp.setRandom(temp.getNext().getRandom());
			}
			
		}*/
		
		
		//Actual Deep Copy Code??????????????????????????
		Node iter = new Node();
		iter = head;
		//int counter =0;
		Node ptr = new Node();
		while(iter!=null)
		{
			Node new2 = new Node();
			if(iter == head)	//counter ==0
			{
				head2 = new2;
				ptr = head2;
				ptr.setAll(head.getValue()+1,head.getRandom(),null);
				
				/*ptr.setValue();
				ptr.setRandom();
				ptr.setNext(null);*/
			}
			else
			{
				ptr.setNext(new2);
				ptr = ptr.getNext();
				
				ptr.setAll(iter.getValue()+1,iter.getRandom(),null);

				/*ptr.setValue(iter.getValue()+1);
				ptr.setRandom(iter.getRandom());
				ptr.setNext(null);*/
			}
			//counter++;
			iter = iter.getNext();
		}
		
		//System.out.println(counter);
		//System.out.println("Head Val: " + head2.getValue());
		
		
		
		Scanner scanner = new Scanner(System.in);
		int input=1;
		
		while(input>0)
		{
			System.out.println("What would you like to do?\n0. Quit\n1. Print Lists\n2. Add Random\n3. Delete Node\n4. Add Node");
			input = scanner.nextInt();
			System.out.println(input);
			if(input ==1)
				printLists(head,head2);
			else if(input ==2)
				addRandom(head2, scanner);
			else if(input ==3)
				deleteNode(head2, scanner);
			else if(input ==4)
				addNode(head2, scanner);
		}
		System.out.println("Program Completed");
	}
	
	public static void addRandom(Node head2, Scanner scanner)
	{
		int from, to;
		System.out.println("Which number would you like to point from?");
		from = scanner.nextInt();
		System.out.println("Which number would you like to point to?");
		to = scanner.nextInt();
		
		Node test = new Node();
		Node test1 = new Node();
		boolean good = false;
		test = head2;
		test1 = head2;
		while(test.getNext() != null)
		{
			if(test.getValue()==from)
			{
				System.out.println("Item Found");
				while(test1.getNext()!=null)
				{
					if(test1.getValue()==to)
					{
						System.out.println("Item Found");
						good = true;
						test.setRandom(test1);
						break;
					}
					test1=test1.getNext();
				}
			}
			test=test.getNext();
		}
		if(good)
		{
			System.out.println("Item " + from + " points to " + to);
		}
		else
		{
			System.out.println("Items not found in the list");
		}
	}
	
	public static void printLists(Node head, Node head2)
	{
		Node reader2 = new Node();
		reader2 = head2;
		Node reader1 = new Node();
		reader1 = head;
		
		System.out.println("Printing from ListA");
		
		while(reader1.getNext() != null)
		{
			if(reader1.hasValue())
				System.out.printf("Value: %d", reader1.getValue());
			if(reader1.hasNext())
				System.out.printf("\t Next Value: %d", reader1.getNext().getValue());
			if(reader1.hasRandom())
				System.out.printf("\t Random Value: %d", reader1.getRandom().getValue());
			//reader2 = reader2.getNext();
			System.out.println();
			reader1 = reader1.getNext();
		}
		
		System.out.println("\nPrinting from ListB");
		
		while(reader2.getNext() != null)
		{
			if(reader2.hasValue())
				System.out.printf("Value: %d", reader2.getValue());
			if(reader2.hasNext())
				System.out.printf("\t Next Value: %d", reader2.getNext().getValue());
			if(reader2.hasRandom())
				System.out.printf("\t Random Value: %d", reader2.getRandom().getValue());
			//reader2 = reader2.getNext();
			System.out.println();
			reader2 = reader2.getNext();
		}
		//Printing the values from the different arrays at the same time.
		/*while(reader2.getNext() != null)
		{
			System.out.println("Value from old Array: " + reader1.getValue());
			System.out.println("Value from new Array: " + reader2.getValue());
			reader2 = reader2.getNext();
			reader1 = reader1.getNext();
		}*/
	}
	
	public static void addNode(Node head2, Scanner scanner)
	{
		Node lead = new Node();
		Node ptr = new Node();
		
		ptr = head2;
		lead = head2.getNext();
		
		System.out.println("Which number would you like to Add?");
		int add = scanner.nextInt();
		
		if(ptr.getValue()>add)
		{
			Node new1 = new Node(add, ptr, null);
			head2 = new1;
			head2.setAll(add, ptr, null);

			return;
		}
		
		while(lead.getNext()!=null)
		{
			//System.out.println("Iteration");
			if(add<=lead.getValue())
			{
				Node new1 = new Node(add, lead, null);

				ptr.setNext(new1);	
				System.out.println("Added: " + add);
				return;
			}
			ptr = ptr.getNext();
			lead=lead.getNext();
		}
		Node new1 = new Node(add, null, null);
		lead.setNext(new1);
	}
	
	public static void deleteNode(Node head2, Scanner scanner)
	{
		Node lead = new Node();
		Node ptr = new Node();
		
		ptr = head2;
		lead = head2.getNext();
		
		System.out.println("Which number would you like to Delete?");
		int del = scanner.nextInt();
		
		if(ptr.getValue()==del)
		{
			head2.setAll(lead.getValue(), lead.getNext(), lead.getRandom());
			return;
		}
		
		while(lead.getNext()!=null)
		{
			//System.out.println("Iteration");
			if(del==lead.getValue())
			{
				ptr.setNext(lead.getNext());	
				lead.setAll(-1, null, null);
				System.out.println("Deleted: " + del);
				break;
			}
			ptr = ptr.getNext();
			lead=lead.getNext();
		}
	}
}

class Node{
	private int value;
	private Node next;
	private Node random;
	
	public Node()
	{
		value = -1;
		next = null;
		random = null;
	}
	public Node(int v, Node n, Node r)
	{
		value = v;
		next = n;
		random = r;
	}
	
	//Public Funtions
	public boolean hasValue()
	{
		if(value>=0)
			return true;
		return false;
	}
	
	public boolean hasNext()
	{
		if(next == null)
			return false;
		return true;
	}
	
	public boolean hasRandom()
	{
		if(random == null)
			return false;
		return true;
	}
	
	
	//Public Set Functions
	public void setValue(int v)	{	value =v;	}
	public void setNext(Node n)	{	next = n;	}
	public void setRandom(Node r){	random = r;	}
	public void setAll(int v, Node n, Node r)	{	value =v; next = n; random = r;	}
	
	//Public set Functions
	public int getValue()	{	return value;	}
	public Node getNext()	{	return next;	}
	public Node getRandom()	{	return random;	}
}
