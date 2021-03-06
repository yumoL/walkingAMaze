package data;

public class Node implements Comparable<Node> {

    private int x, y;
    private Node pre;// previous Node
    /**
     * g=distance from entrance node to current node h=estimated distance from
     * current node to exit node f=g+h
     */
    private int g, h, f;

    public Node(int x, int y, Node pre) {
        this.x = x;
        this.y = y;
        this.pre = pre;
    }

    public Node(int x, int y) {
        this(x, y, null);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Node getPre() {
        return this.pre;
    }

    public int getG() {
        return this.g;
    }

    public void setG(int newG) {
        this.g = newG;
    }

    public void setF(int newF) {
        this.f = newF;
    }

    public int getF() {
        return this.f;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int newH) {
        this.h = newH;
    }

    /**
     * Compare two nodes
     *
     * @param candidate the node which is to be compared with the current one
     * @return a negative number if the f of the node is smaller than the f of
     * candidate. Return 0 if the f of node is equals to the f of candidate.
     * Otherwise return a positive number
     */
    @Override
    public int compareTo(Node candidate) {
        return this.f - candidate.f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node comp = (Node) obj;
        return this.x == comp.x && this.y == comp.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }

}
