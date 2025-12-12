public class SingleLinkedList {
    Node head;

    // Method for insert new node at tail
    public void push(Customer data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method for delete node at head
    public void  popHead(){
        if (head != null) {
            head = head.next;
        }
    }

    // Method for display
    public void display(){
        if(head != null){
            Node current = head;
            do{
                System.out.print(current.data.name + "(" + current.data.partySize +" orang)");
                current = current.next;
                if(current!=null){
                    System.out.print(" -> ");
                }
            }while (current!=null);
        }else {
            System.out.print("-");
        }
    }
}
