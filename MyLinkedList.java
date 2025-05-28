import CodeJava.recordTest;

public class MyLinkedList {

Node head;

public void insert(int data){
    Node newNode= new Node(data);
    if(head==null){
       head = newNode;
       return;
    }

    Node current=head;
    while (current.nextNode!=null) {
       current= current.nextNode;
    }
    current.nextNode=newNode;
 
}

// Display the list

public void display(){
    Node current = head;
    while (current!=null) {
        System.out.print(current.data+" ->");
        current = current.nextNode;
        
    }
    System.out.println("null");
    
}

public void delete(int data){
    Node current =head;
    Node previous= null;
    //if head node holds the data 
    if(current!=null&& current.data==data){
        head=current.nextNode;
        return;
    }
    //case search for the node to delete 
    while (current!=null && current.data != data) {
       previous =current;
       current=current.nextNode;
        
    }
    //if no data was found 
    if(current==null){
        return;
    }
    // unlink this node 
    previous.nextNode =current.nextNode;





}






    
}
