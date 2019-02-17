// Vladimir Maksimovski

/**
	LList - a doubly linked list that supports pushBack, reverse, and multiple-popFront & multiple-popBack
*/
	
public class LList<E> {
	private int size;
	private Node<E> head, tail;

	public LList(){
		size = 0;
		head = new Node<E>();
		tail = new Node<E>();
		head.setNext(tail);
		tail.setPrev(head);
	}

	public LList(E[] stringData){
		this();

		for(int i = 0; i < stringData.length; i++){
			pushBack(stringData[i]);
		}
	}

	public LList(LList<E> data){
		this();
		
		for(Node<E> ite = data.head.next(); ite != data.tail; ite = ite.next()){
			pushBack(ite.data());
		}
	}
	
	public Node<E> head(){
		return head;
	}

	public Node<E> tail(){
		return tail;
	}

	public int getSize(){
		return size;
	}

	public void pushBack(E data){
		size++;
		Node<E> newNode = new Node<E>(data, tail.prev(), tail);
		tail.prev().setNext(newNode);
		tail.setPrev(newNode);
	}

	public void reverse(){
		Node<E> tmp = head.next();
		//head and tail switch what nodes they're connected to
		head.next().setPrev(tail);
		tail.prev().setNext(head);
		head.setNext(tail.prev());
		tail.setPrev(tmp);

		for(Node<E> i = head.next(); i != head && i != tail; i = i.next()){
			//swap every node's two pointers
			Node<E> tmpPrev = i.prev();
			Node<E> tmpNext = i.next();

			i.setNext(tmpPrev);
			i.setPrev(tmpNext);
		}
	}

	public void deleteFirstNElem(int deletionSize){
		assert deletionSize >= 0 && deletionSize <= size : "Improper delete parameters";

		for(int i = 0; i < deletionSize; i++){
			size -= 1;
			head.setNext(head.next().next());
			head.next().setPrev(head);
		}
	}

	public void deleteLastNElem(int deletionSize){
		assert deletionSize >= 0 && deletionSize <= size : "Improper delete parameters";

		for(int i = 0; i < deletionSize; i++){
			size -= 1;
			tail.setPrev(tail.prev().prev());
			tail.prev().setNext(tail);
		}
	}
}