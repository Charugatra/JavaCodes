import java.util.HashSet;
import java.util.Set;

/* 2.1
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
Hints: #9, #40

#9. 2.1 Have you tried a hash table? 
You should be able to do this in a single pass 
of the linked
list.
#40. 2.1 Without extra space, you'll need time. 
Try using two pointers, where the second
one searches ahead of the first one.
*/


class Node{
	int data;
	Node next=null;
	
	public Node(int d){
		data=d;
	}
}
public class LinkedList {
	Node head;
	
	public static LinkedList add(LinkedList list, int d) {
		Node newnode = new Node(d);
		
		if(list.head ==null) {
			list.head = newnode;
		}
		else {
			Node current = list.head;
			while(current.next != null) {
				current = current.next;
			}
			current.next=newnode;
		}
		return list;
	}
	
	public static void display(LinkedList list) {
		Node current=list.head;
		System.out.println("\nLinked List :");
		while(current !=null) {
			System.out.print(current.data+" ");
			
			current=current.next;
		}
	}
	
	private static LinkedList removeDups(LinkedList list) {
		Node first = list.head;
		
		Node prev=null;
		while(first!=null)
		{
			Node second = first.next;
			prev = first;
			while(second!=null) {
				if (first.data == second.data)
				{
					prev.next = second.next;
				}
				else {
					prev = second;
				}
				second = second.next;
			}
			first = first.next;
		}
		
		return list;
	}
	
	private static LinkedList removeDups_WithSpace(LinkedList list) {
		// TODO Auto-generated method stub
		Set<Integer>  hashset = new HashSet<Integer>();
		Node current = list.head;
		Node prev = null;
		while(current!=null)
		{	
			if(hashset.contains(current.data))
			{
				prev.next = current.next;
			}
			else {
				prev = current;
				hashset.add(current.data);
			}
			current = current.next;
		}
		return list;
	}

	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		//Insertion
		list = add(list, 1);
		list = add(list, 2);
		list = add(list, 1);
		list = add(list, 3);
		list = add(list, 1);
		list = add(list, 3);
		list = add(list, 4);
		list = add(list, 5);
		list = add(list, 1);
		list = add(list, 2);
		display(list);
		
		list = removeDups_WithSpace(list);
		display(list);
		
		list = add(list, 1);
		list = add(list, 2);
		list = add(list, 1);
		list = add(list, 3);
		list = add(list, 1);
		list = add(list, 3);
		list = add(list, 4);
		list = add(list, 5);
		list = add(list, 1);
		list = add(list, 2);
		display(list);
		
		list = removeDups(list);
		display(list);
	}

	
	
}
