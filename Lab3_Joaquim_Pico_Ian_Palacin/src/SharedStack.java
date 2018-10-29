public class SharedStack<E> implements Stack<E>{

    private final Node<E> topOfStack;

    private static class Node<E>{
        private final E elem;
        private final Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }
    }

    public SharedStack(){
        topOfStack = new Node<>(null,null);
    }

    private SharedStack(E elem, Node<E> next){
        topOfStack = new Node<>(elem,next);
    }

    private SharedStack(Node<E> topOfStack){
        this.topOfStack = topOfStack;
    }

    @Override
    public Stack<E> push(E elem){
        return new SharedStack<>(elem,this.topOfStack);
    }
    @Override
    public Stack<E> pop() throws StackError {
        if(isEmpty()){
            throw new StackError("StackError: empty stack");
        }else{
            return new SharedStack<>(topOfStack.next);
        }
    }
    @Override
    public E top() throws StackError{
        if(isEmpty()){
            throw new StackError("StackError: empty stack");
        }else{
            return topOfStack.elem;
        }

    }
    @Override
    public boolean isEmpty(){
        return topOfStack == null;
    }
}







































/*public class SharedStack<E> implements Stack<E>{

    private Node<E> topOfStack;

    private static class Node<E>{
        private final E elem;
        private final Node<E> next;

        private Node(E elem, Node<E> next){
            this.elem = elem;
            this.next = next;
        }
    }

    public SharedStack(){
        topOfStack = new Node<>(null,null);
    }

    @Override
    public Stack<E> push(E elem) {
        SharedStack<E> newSharedStack = new SharedStack<>();
        Node<E> newNode = new Node<>(elem,this.topOfStack);
        newSharedStack.topOfStack = newNode;
    }

    @Override
    public Stack<E> pop() throws StackError {
        return null;
    }

    @Override
    public E top() throws StackError {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
*/