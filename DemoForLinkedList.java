public class DemoForLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList= new MyLinkedList();
        linkedList.insert(5);
        linkedList.insert(15);
        linkedList.insert(20);
        linkedList.display();

        linkedList.delete(15);

        linkedList.display();
        
    }
    
}
