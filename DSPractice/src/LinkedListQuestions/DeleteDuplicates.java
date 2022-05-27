package LinkedListQuestions;

public class DeleteDuplicates {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	
	public void push(int new_data)
	{
		Node new_node= new Node(new_data);
		new_node.next=head;
		head=new_node;
	}
	
	void printList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public void removeDuplicates()
	{
		Node curr = head;
		 
        /* Traverse list till the last node */
        while (curr != null) {
             Node temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
		
	}
	
	public static void main(String[] args) {
		DeleteDuplicates delDup= new DeleteDuplicates();
		delDup.push(20);
		delDup.push(13);
		delDup.push(13);
		delDup.push(11);
		delDup.push(11);
		delDup.push(11);
         
        System.out.println("List before removal of duplicates");
        delDup.printList();
         
        delDup.removeDuplicates();
         
        System.out.println("List after removal of elements");
        delDup.printList();

	}

}
