public class Main {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertPosition(int position, int value){

        ListNode node = new ListNode(value);
        if(position == 1){
            node.next = head;
            head = node;
        }else {
            ListNode previous = head;
            int count =1;
            while(count < position -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }

//        ListNode current = head;
//        ListNode newNode = new ListNode(value);
//        int k =1;
//        while(current.next != null && k<position-1 ){
//            current = current.next;
//            k++;
//        }
//        newNode.next = current.next;
//        current.next = newNode;
    }

    public void deletePosition(int pos){
        if (pos==1 ){
            head = head.next;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < pos -1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }

    }

    public void deleteFirst(){
        //dikos mou tropos alliws phgaine video 49
        if (head == null){
            //return null;
        }
        //ListNode temp = head;
        head = head.next;
        //temp.next = null;
        //return temp;

    }

    public ListNode deleteLast(){
        if (head == null || head.next ==null){
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public boolean SearchElement(int num){
        ListNode current = head;
        while(current != null){
            if (current.data == num) return true;
            current = current.next;
        }
        return false;
    }

    public ListNode ReversedList(ListNode head){//na to jana dw
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode MiddleNode(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (slowPtr != null && fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n){
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count =0;
        while(count < n){
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void RemoveDuplicatesFromSorted(ListNode head){
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public ListNode insertInSortedList(int n){
        ListNode current = head;
        ListNode newNode = new ListNode(n);
        ListNode temp = null;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        temp.next = newNode;
        newNode.next = current;
        return head;
    }

    public void removeElement(int n){
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data != n){
            temp = current;
            current = current.next;
        }
        if (current == null) return;
        temp.next = current.next;
    }

    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr){
                return true;
            }
        }

        return false;
    }

    public ListNode FindTheStartOfTheLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowPtr){
        ListNode temp = head;
        while (slowPtr != temp){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }
    //--


    public static void main(String[] args) {
        Main sll = new Main();
        sll.head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        //sll.insertFirst(1);
        //sll.insertLast(5);
        //sll.insertPosition(5,22);
        //sll.deleteFirst();
        //sll.deleteLast();
        //sll.deletePosition(2);
        //ListNode bab = sll.ReversedList(sll.head);
        //ListNode current = bab;
        //sll.RemoveDuplicatesFromSorted(sll.head);
        //sll.insertInSortedList(10);

        ListNode current = sll.head;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.print("null");
    }


}