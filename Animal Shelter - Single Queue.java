class Node {
    String name;
    int type;
    Node(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
public class AnimalShelter {
    Queue<Node> queue;
    public AnimalShelter() {
        // do initialize if necessary
        queue = new LinkedList<Node>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        queue.offer(new Node(name, type));
    }

    public String dequeueAny() {
        // Write your code here
        Node node = queue.poll();
        return node.name;
    }

    public String dequeueDog() {
        // Write your code here
        return dequeueType(1);
    }

    public String dequeueCat() {
        // Write your code here
        return dequeueType(0);
    }
    
    private String dequeueType(int type) {
        int shiftTime = 0;
        while (queue.peek().type != type) {
            queue.offer(queue.poll());
            shiftTime++;
        }
        Node node = queue.poll();
        shiftTime = queue.size() - shiftTime;
        while (shiftTime != 0) {
            queue.offer(queue.poll());
            shiftTime--;
        }
        return node.name;
    }
}
