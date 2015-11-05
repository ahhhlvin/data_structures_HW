/**
 * Created by alvin2 on 10/18/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */


public class SinglyLinkedList
{
    public class Node
    {
        Node next;
        String         data;

        public Node(String data)
        {
            this.data = data;
        }
    }

    class SinglyList
    {
        Node head;

        // TAIL recursion search method
        public void findRecursiveNode(Node node, String data)
        {

            if(node == null)
            {
                return;
            }

            if(node.data.equals(data))
            {
                System.out.println("Found it!");
            }

            findRecursiveNode(node.next, data);
        }

        public void addToTail(String data) {

            Node newNode = new Node(data);
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }

        public void addToHead(String data)
        {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }


        public void insertAfter (String prevData, String newData) {
            Node newNode = new Node(newData);
            Node current = head;
            while (current != null && !current.data.equals(prevData)) {
                current = current.next;
            }

            if (current != null) {
                newNode.next = current.next; // the one after 'newNode' should point to the CURRENT one after 'current'
                current.next = newNode; // the one after 'current' should point to 'newNode'
            }
        }


        public void update(String oldData, String newData) {
            Node current = head;
            while (current != null && !current.data.equals(oldData)) {
                // if first part of while statement is false, loop will short circuit and not bother to check the second part of the while statement
                current = current.next;
            }
            if (current != null)
            {
                current.data = newData;
            }
        }


        public void delete(String data) {
            // check if list is empty, if it is then delete method should not be able to be called
            if (head == null) {
                return;
            }

            if (head.data.equals(data)) {
                head = head.next;
            }

            Node pointer = head;
            while(pointer.next != null && !pointer.next.data.equals(data)) {
                pointer = pointer.next;
            }

            if (pointer.next != null)
            {
                pointer.next = pointer.next.next;
            }
        }


        public void print()
        {
            Node current = head;

            while(current != null)
            {
                System.out.print(current.data + ", ");
                current = current.next;   // point 'current' to what use to be 'current.next'
            }
            System.out.println();
        }


            public void main(String[] args) {
                SinglyList list = new SinglyList();

                list.print();
                list.addToHead("head");
                list.print();
                list.addToHead("newHead");
                list.print();
                list.addToTail("tail");
                list.print();
                list.insertAfter("newHead", "afterNewHead");
                list.print();
                list.update("tail", "tail2");
                list.print();
                list.delete("afterNewHead");
                list.print();

                SinglyList list2 = new SinglyList();
                list2.insertAfter("foo", "bar");
                list2.print();
                list2.update("foo", "bar");
                list2.print();


            }

    }


}



