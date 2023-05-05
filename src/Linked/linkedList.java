package Linked;

class node<T> {
    T data;
    node<T> next;

    node(T data)
    {
        this.data = data;
        this.next = null;
    }
}


public class linkedList<T> {
    node<T> head;
    private int length = 0;

    public linkedList() { this.head = null; }

    public void add(T data)
    {
        node<T> currentNode = new node<>(data);
        if (this.head == null) {
            head = currentNode;
        }
        else {
            node<T> currentLL = head;
            while (currentLL.next != null) {
                currentLL = currentLL.next;           }
            currentLL.next = currentNode;
        }
        length++;
    }

    public void remove(T removeNode)
    {
        node<T> prev = new node<>(null);
        prev.next = head;
        node<T> next = head.next;
        node<T> currentNode = head;
        boolean exists = false;

        // If head node needs to be deleted
        if (head.data == removeNode) {
            head = head.next;
            exists = true;
        }
        while (currentNode.next != null) {
            if (String.valueOf(currentNode.data).equals(
                    String.valueOf(removeNode))) {

                 prev.next = next;
                 exists = true;
                break;
            }
            prev = currentNode;
            currentNode = currentNode.next;
            next = currentNode.next;
        }

        if (exists == false && String.valueOf(currentNode.data).equals(
                String.valueOf(removeNode))) {
            prev.next = null;
            exists = true;
        }

        if (exists) {
            length--;
        }
        else {
            System.out.println("The given Value is not available");
        }
    }

    public void clear()
    {
        head = null;
        length = 0;
    }
    public boolean empty()
    {
        if (head == null) {
            return true;
        }
        return false;
    }

    public int length() { return this.length; }


    public void display() {

        node current = head;

        if(head == null) {
            System.out.println("Empty");
            return;
        }

        while(current != null) {

            System.out.print(current.data + "\n");
            current = current.next;
        }
        System.out.println();
    }
}


