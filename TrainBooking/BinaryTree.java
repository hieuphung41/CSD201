package TrainBooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.println(p.train.getTcode() + ", "
                + p.train.getTrainName() + ", "
                + p.train.getSeat() + ", "
                + p.train.getBooked() + ", "
                + p.train.getDepartTime() + ", "
                + p.train.getDepartPlace());
    }

    //    1.1.      Load data from file
    public boolean loadDataFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println(file + " does not exist. Creating a new file.");
                if (file.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("Failed to create file.");
                    return false;
                }
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] parts = line.split(",");
                    String tcode = parts[0].trim();
                    String trainName = parts[1].trim();
                    int seat = Integer.parseInt(parts[2].trim());
                    int booked = Integer.parseInt(parts[3].trim());
                    double departTime = Double.parseDouble(parts[4].trim());
                    String departPlace = parts[5].trim();
                    Node newNode = new Node(new Train(tcode, trainName, seat, booked, departTime, departPlace));
                    insertData(newNode);
                    line = reader.readLine();
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //    1.2.      Input & insert data
    public Node input() {
        Train train = new Train();
        train.createTrain();
        Node data = new Node(train);
        return data;
    }

    public void insertData(Node data) {
        if (root == null) {
            root = data;
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (data.compareTo(p) == 0) {
                System.out.println("The key " + data.train.getTcode() + " already exists, no insertion");
                return;
            }
            f = p;
            if (data.compareTo(p) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (data.compareTo(f) < 0) {
            f.left = data;
        } else {
            f.right = data;
        }
    }

    //    1.3.      In-order traverse
    public void inOrderTraverse(Node data) {
        if (data == null) {
            return;
        }
        inOrderTraverse(data.left);
        visit(data);
        inOrderTraverse(data.right);
    }

    //    1.4.      Breadth-first traverse
    public void breadthFirstTraverse(Node data) {
        if (data == null) {
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(data);
        while (!list.isEmpty()) {
            Node q = (Node) list.removeFirst();
            visit(q);
            if (q.left != null) {
                list.addLast(q.left);
            }
            if (q.right != null) {
                list.addLast(q.right);
            }
        }
    }

    //    1.5.      In-order traverse to file
    public boolean inOrderTraverseToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            inOrderTraverseAndWrite(root, writer);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void inOrderTraverseAndWrite(Node node, FileWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        inOrderTraverseAndWrite(node.left, writer);
        writer.write(node.train.toString());
        inOrderTraverseAndWrite(node.right, writer);
    }

    //    1.6.      Search by tcode
    public Node searchByTcode(Node data, String tcode) {
        if (data == null) {
            System.out.println("Not found!");
            return null;
        }
        if (data.compareTo(tcode) == 0) {
            return data;
        } else if (data.compareTo(tcode) > 0) {
            return searchByTcode(data.left, tcode);
        } else {
            return searchByTcode(data.right, tcode);
        }
    }

    //    1.7.      Delete by tcode by copying
    public void deleteTcodeByCopy(String tcode) {
        Node p = searchByTcode(root, tcode);
        if (p == null) {
            System.out.println("Key " + tcode + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.compareTo(p) > 0) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.train = q.train;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }

    // 1.8. Simply balancing
    void inOrder(ArrayList<Train> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.train);
        inOrder(t, p.right);
    }

    void balance(ArrayList<Train> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        Train train = t.get(k);
        Node x = new Node(train);
        insertData(x);
        visit(x);
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void bal() {
        ArrayList<Train> t = new ArrayList<>();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }

    //    1.9.      Count number of trains
    public int countTrains(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countTrains(node.left);
            int rightCount = countTrains(node.right);
            return leftCount + rightCount + 1;
        }
    }

}