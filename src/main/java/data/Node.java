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

    public void setPre(Node newPre) {
        this.pre = newPre;
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

    //node a <node b, if a.f<b.f
    @Override
    public int compareTo(Node candidate) {
        if (this.equals(candidate)) {
            return 0;
        }
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

    @Override
    public String toString() {
        return this.x + "-" + this.y;
    }

}
