import java.util.*;

class Stack<T>
{
    List<T> list;
    int size;
    int top=-1;
    Stack(int size)
    {
        this.size = size;
        list=new ArrayList<>(size);
    }

    public void push(T item)
    {
        if(list.size()!=size) {
            list.add(item);
            top++;
        }
        else
            System.out.println("Stack is full");
    }
    public T pop()
    {
        if(list.size()==0) {
            System.out.println("Stack is empty");
            top=-1;
            return null;
        }
        else {
            return list.remove(top--);
        }
    }

    public void clear()
    {
        top=-1;
        list.removeAll(list);
    }
    public void display()
    {
        for(int i=list.size()-1;i>=0;i--)
            System.out.println(list.get(i));
    }

}

public class Main
{
    public static void main(String args[])
    {
        Stack<String> st= new Stack<>(5);
        st.push("A");
        st.push("B");
        st.push("C");
        st.push("D");
        st.push("E");
        st.push("F");
        System.out.println("Popped:"+st.pop());
        System.out.println("Popped:"+st.pop());
        st.display();

        Stack<Integer> st1= new Stack<>(5);
        for(int i=0;i<5;i++)
            st1.push(i);
        for(int i=0;i<2;i++)
            System.out.println("Popped:"+st1.pop());
        st1.display();
    }
}
