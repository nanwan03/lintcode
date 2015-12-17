class Node {
	String name;
	int type;
	Node next;
	
	public Node(String name, int type) {
		this.name = name;
		this.type = type;
		this.next = null;
	}
}

public class AnimalShelter {
    Node header;
	Node tail;
	int CAT = 0;
	int DOG = 1;
    public AnimalShelter() {
        // do initialize if necessary
        header = null;
    	tail = header;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
    	if (header == null) {
    		header = new Node(name, type);
    		tail = header;
    	} else {
    		tail.next = new Node(name, type);
    		tail = tail.next;
    	}
    }

    public String dequeueAny() {
        // Write your code here
    	if (header == null) {
    		return "";
    	}
    	Node node = header;
    	header = header.next;
    	return node.name;
    }

    public String dequeueDog() {
        // Write your code here
    	if (header.type == DOG) {
    		return dequeueAny();
    	}
    	return dequeueType(DOG);
    }

    public String dequeueCat() {
        // Write your code here
    	if (header.type == CAT) {
    		return dequeueAny();
    	}
    	return dequeueType(CAT);
    }
    
    private String dequeueType(int type) {
    	Node cur = header;
    	while (cur != null && cur.next != null) {
    		if (cur.next.type == type) {
    			Node node = cur.next;
    			cur.next = cur.next.next;
    			if (cur.next == null) {
    				tail = cur;
    			}
    			return node.name;
    		}
    		cur = cur.next;
    	}
    	return "";
    }
}
