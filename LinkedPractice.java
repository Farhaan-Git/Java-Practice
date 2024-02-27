public class LinkedPractice{
    public static void main(String[] args) {
        Node head=null;
        for(int i=1;i<=21;i++){
            if(i==1){
                head=Node.getNewnode(i);
            }
            else{
                Node temp=Node.getNewnode(i);
                Node  temp2=head;
                while(temp2.next!=null){
                    temp2=temp2.next;
                }
                temp2.next=temp;
            }
        }
        // System.out.println("Before reversal:");
        Node.printLinkedList(head);
        // head= Node.getReverseLinkedList(head);
        // System.out.println("After reversal :");
        // Node.printLinkedList(head);
        Node temp = Node.getMiddleElement(head);
        System.out.println(temp.data);
    }
}
class Node{
    int data;
    Node next;
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    public Node(){

    }
    public static Node getNewnode(int data){
        Node obj= new Node(data,null);
        return obj;
    }
    public static void printLinkedList(Node head){
        System.out.println();
        System.out.print("[ ");
        while(head!=null){
            System.out.print(head.data+", ");
            head=head.next;
        }
        System.out.print("]");
        System.out.println();
        // System.out.println(head.data);
    }
    public static Node getReverseLinkedList(Node head){
        Node prev=null;
        Node cur=head;
        Node temp=head;
        while (temp.next!=null) {
            if(cur==head){
                // System.out.println("inside if");
                temp=temp.next;
                prev=cur;
                prev.next=null;
                cur=temp;
                
            }
            else{
                // System.out.println("inside else");
                temp=cur.next;
                cur.next=prev;
                prev=cur;
                cur=temp;
            }   
        }
        cur.next=prev;
        head=cur;
        return head;
        
    }
    public static Node getMiddleElement(Node head){
        Node fast=head.next.next;
        Node slow= head;
        while(fast!=null){
            if(fast.next!=null){
                if(fast.next.next==null){
                     slow=slow.next;
                    break;
                }
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=slow.next;
        return slow;
    }
}