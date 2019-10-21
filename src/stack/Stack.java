package stack;

public interface Stack<T> {
    public boolean empty();

    public T pop();

    public T push(T elem);

    public T peek();

}