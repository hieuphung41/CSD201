package TrainBooking;

public class Node {

    Train train;
    Node left, right;

    public Node(Train train, Node left, Node right) {
        this.train = train;
        this.left = left;
        this.right = right;
    }

    public Node(Train train) {
        this(train, null, null);
    }

    public int compareTo(Node other) {
        return this.train.getTcode().compareTo(other.train.getTcode());
    }

    public int compareTo(String key) {
        return this.train.getTcode().compareTo(key);
    }

}
