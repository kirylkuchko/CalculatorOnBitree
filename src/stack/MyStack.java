package stack;

public class MyStack<T> implements Stack<T> {

    public List<T> myList;

    public MyStack() {
        myList = new List<T>();
    }

    public List<T> getList() {
        return myList;
    }

    @Override
    public boolean empty() {
        // TODO Auto-generated method stub

        return myList.pusta();
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        return myList.remove();
    }

    @Override
    public T push(T elem) {
        myList.insert(elem);
        return elem;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return myList.getElement();
    }

}
