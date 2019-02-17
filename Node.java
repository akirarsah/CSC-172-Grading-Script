// Vladimir Maksimovski

public class Node<E> {
	private E data;
	private Node<E> next;
	private Node<E> prev;

	public Node(){
		prev = null;
		next = null;
	}
	
	public Node(E initialData, Node<E> initialPrev, Node<E> initialNext){
		data = initialData;
		prev = initialPrev;
		next = initialNext;
	}

	public void setPrev(Node<E> newPrev){
		prev = newPrev;
	}
	public void setNext(Node<E> newNext){
		next = newNext;
	}

	public Node<E> prev(){
		return prev;	
	}
	public Node<E> next(){
		return next;
	}

	public E data(){
		return data;
	}
}