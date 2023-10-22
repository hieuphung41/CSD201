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
        int thisNumber = Integer.parseInt(this.train.getTcode().substring(1));
        int otherNumber = Integer.parseInt(other.train.getTcode().substring(1));
        return Integer.compare(thisNumber, otherNumber);
    }

    public int compareTo(String key) {
        int thisNumber = Integer.parseInt(this.train.getTcode().substring(1));
        return Integer.compare(thisNumber, Integer.parseInt(key.substring(1)));
    }
}