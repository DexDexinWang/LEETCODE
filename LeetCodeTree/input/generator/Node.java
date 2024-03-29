package generator;

import java.util.List;

public class Node {
    public List<Node> children;
    public int val;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};