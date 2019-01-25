package algo;

public class Node implements Comparable<Node>{

    private int x, y;
    private Node pre;// previous Node
    public int g, h, f; //variables used in Astar-algorithm. Since A star doesn't work yet, the details of these variables haven't been added

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

    public int getH() {
        return this.h;
    }

    @Override
    public int compareTo(Node candidate) {
        return this.f - candidate.f;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this.getClass()!=obj.getClass())return false;
        Node comp=(Node)obj;
        return this.x==comp.x&&this.y==comp.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.x;
        hash = 71 * hash + this.y;
        return hash;
    }

}
