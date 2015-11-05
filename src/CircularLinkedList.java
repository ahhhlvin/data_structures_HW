/**
 * Created by alvin2 on 10/29/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class CircularLinkedList
{


    public class Node
    {
        Node   next;
        String data;

        public Node(String data)
        {
            this.data = data;
        }
    }

    class CircularList
    {
        Node head;

        public void addToTail(String data)
        {

            Node newNode = new Node(data);
            Node current = head;

            if(head != null)
            {
                while(current.next != head)
                {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
            else
            {
                head = newNode;
                head.next = head;
            }

        }

        public void addToHead(String data)
        {
            Node newNode = new Node(data);
            Node current = head;

            if(head != null)
            {
                while(current.next != head)
                {
                    current = current.next;
                }

                current.next = newNode;
                newNode.next = head;
                head = newNode;
            }
            else
            {
                head = newNode;
                head.next = head;
            }

        }


        public void insertAfter(String prevData, String newData)
        {
            Node newNode = new Node(newData);
            Node current = head;

            if(head != null)
            {
                while(current.data != prevData)
                {
                    if(current.next == head)
                    {
                        return;
                    }
                    current = current.next;

                }

                newNode.next = current.next;
                current.next = newNode;
            }

        }


        public void delete(String data)
        {
            if(head != null)
            {

                Node pointer = head;
                while(pointer.next != head)
                {
                    if(pointer.next.data.equals(data))
                    {
                        pointer.next = pointer.next.next;
                    }

                    pointer = pointer.next;
                }


            }

        }

    }
}



