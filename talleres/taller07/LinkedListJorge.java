


import java.lang.IndexOutOfBoundsException;

public class LinkedListJorge
{
   
    Node first;
    int size;
    public LinkedListJorge()
    {
        size=0;
        first=null;
    }

   
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
   
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }
    
    public int size() {
        return size;
    }
    
    public boolean contains(int data) {
        Node temp=first;
        while(temp!=null){
        
            if(temp.data == data)
            return true;
            temp=temp.next;
            
        }
        return false;
    }
    
    public void insert(int data, int index)
  
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

 

        if (size == 0 && index > 0)    
            throw new IndexOutOfBoundsException();
            
        Node temp = new Node(data);
        if(index == 0){
            temp.next = first;
            first = temp;
            this.size++;
            return;
        }
 
        temp = first;
    
        for (int i = 1; i <= index - 1; i++){
            temp = getNode(index-1);     
        
            Node nuevo=new Node(data);
        
            nuevo.next= temp.next;
        
            temp.next = nuevo;        
        
            size++;
  
        }
        
    }
    
    public void remove(int index) {
        try {
            if (index == 0) {
                Node temp = first;
                first = temp.next;
                size--;
            } else if (index == size - 1) {
                Node temp = getNode(size - 2);
                temp.next = null;
                size--;
            } else {
                Node temp = getNode(index - 1);
                temp.next = temp.next.next;
                size--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }

    }
    
}
