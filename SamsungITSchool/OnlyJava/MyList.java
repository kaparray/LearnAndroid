public class Main {
    
    public static void main(String[] args) {
        MyList a = new MyList();
        a.add(4);
        a.add(2);
        a.add(3);
        a.addStart(5);
        a.show();
        a.dellStart();
       
    }
}
    
    // Start Node class
    class Node{
		int data;
		Node pev;
		Node next;
    		
    		
		Node(int data){
			this.data = data;
		}
    		
    }
    

    // Start MyList class
    class MyList{
    	Node head;
	    		
    	void dellStart() {
			head = head.next;
   			head.pev = null;
   		}
    		
        void add(int data) {
    		if(head == null) {
    			head = new Node(data);
			} else {
    			Node helper = head;;
    			while (helper.next != null) {
    				helper = helper.next;
				}
                Node node = new Node(data);
    			node.pev = helper;
    			helper.next = helper;
    			}
    		}
    		
    	void addStart(int data) {
    		Node node = new Node(data);
    		node.next = head;
			head.pev = node;
   			head = node;
 		}
    		
    		
        void show() {
   			Node nexter = head;
            int i = 0;
    			
    		while (nexter != null) {
    			System.out.println(nexter.data + " ");
    			nexter = nexter.next;
			}    		
        }
    }