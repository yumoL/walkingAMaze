//package algo;
//
//import data.MazeData;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import mazeVisualisation.MazeFrame;
//import mazeVisualisation.VisualizationHelper;
//
//public class Astar {
//
//    private List<Node> openList = new ArrayList<Node>();// 开启列表
//    private List<Node> closeList = new ArrayList<Node>();// 关闭列表
//    private MazeData data;
//    private MazeFrame frame;
//
//    public Astar(MazeData data, MazeFrame frame) {
//        this.data = data;
//        this.frame = frame;
//    }
//
//    private void findPath(Node destination) {
//        Node current = destination;
//        while (current != null) {
//            data.result[current.getX()][current.getY()] = true;
//            current = current.getPre();
//        }
//    }
//
//    
//    public boolean searchWay() {
//        final int CONST_HENG = 10;
//       
//        Node startPoint = new Node(data.getEntranceX(), data.getEntranceY());
//        Node endPoint = new Node(data.getExitX(), data.getExitY());
//        int row = data.getRow();
//        int col = data.getColumn();
//        Node curNode = startPoint;
//
//        openList.add(startPoint);
//        while (!openList.isEmpty() && !openList.contains(endPoint)) {
//            curNode = minList(openList);
//            if (curNode.getX() == endPoint.getX() && curNode.getY() == endPoint.getY()
//                    || openList.contains(endPoint)) {
//                System.out.println("ok");
//                findPath(curNode);
////                while (!(curNode.getX() == startPoint.getY() && curNode.getY() == startPoint.getY())) {
////                    //System.out.print("(" + curNode.x + "," + curNode.y + ") ");
////                    //map[curNode.x][curNode.y] = 2;
////                    
////                    if (curNode.parentNode != null) {
////                        curNode = curNode.parentNode;
////                    }
////                }
//                //System.out.print("(" + startPoint.x + "," + startPoint.y + ")\n ");
//                //map[startPoint.x][startPoint.y] = 2;
//                return true;
//            }
//            // up
//            if (curNode.getY() - 1 >= 0) {
//                if (checkPath(curNode.getX(), curNode.getY() - 1, curNode, endPoint,
//                        CONST_HENG)) {
//                    setData(curNode.getX(), curNode.getY() - 1, true);
//                };
//            }
//            // down
//            if (curNode.getY() + 1 < col - 1) {
//                if (checkPath(curNode.getX(), curNode.getY() + 1, curNode, endPoint,
//                        CONST_HENG)) {
//                    setData(curNode.getX(), curNode.getY() + 1, true);
//                };
//            }
//            // left
//            if (curNode.getX() - 1 >= 0) {
//                if (checkPath(curNode.getX() - 1, curNode.getY(), curNode, endPoint,
//                        CONST_HENG)) {
//                    setData(curNode.getX() - 1, curNode.getY(), true);
//                };
//            }
//            // right
//            if (curNode.getX() + 1 < row - 1) {
//                if (checkPath(curNode.getX() + 1, curNode.getY(), curNode, endPoint,
//                        CONST_HENG)) {
//                    setData(curNode.getX() + 1, curNode.getY(), true);
//                };
//            }
//
//            openList.remove(curNode);
//            closeList.add(curNode);
//            setData(curNode.getX(), curNode.getY(), true);
//        }
//        // if (!openList.contains(endPoint)) {
//        // System.out.println("一条路径都未找到！！！");
//        // return false;
//        // }
//
//        return false;
//
//    }
//
//    public void setData(int x, int y, boolean isPath) {
//
//        if (data.inArea(x, y)) {
//            data.path[x][y] = isPath;
//        }
//
//        frame.render(data);
//
//        VisualizationHelper.pause(5);
//    }
//
//   
//    private boolean checkPath(int x, int y, Node preNode, Node endPoint,
//            int c) {
//        Node node = new Node(x, y, preNode);
//      
//        if (data.getMaze(x, y) == data.WALL) {
//            closeList.add(node);
//            return false;
//        }
//        
//        if (isListContains(closeList, x, y) != -1) {// 存在
//            return false;
//        }
//        
//        int index = -1;
//        if ((index = isListContains(openList, x, y)) != -1) {// 存在
//            
//            if ((preNode.g + c) < openList.get(index).g) {
//                countG(node, endPoint, c);
//                countF(node);
//                openList.set(index, node);
//            }
//        } else {
//            
//            node.setPre(preNode);
//            count(node, endPoint, c);
//            openList.add(node);
//        }
//        return true;
//    }
//
//    
//    private void count(Node node, Node eNode, int cost) {
//        countG(node, eNode, cost);
//        countH(node, eNode);
//        countF(node);
//    }
//
//    
//    private void countG(Node node, Node eNode, int cost) {
//        if (node.getPre() == null) {
//            node.setG(cost);
//        } else {
//            node.setG(node.getPre().getG() + cost);
//        }
//    }
//
//    
//    private void countH(Node node, Node eNode) {
//        node.setF((Math.abs(node.getX() - eNode.getX()) + Math.abs(node.getY()
//                - eNode.getY())) * 10);
//    }
//
//    
//    private void countF(Node node) {
//        node.setF(node.getG() + node.getH());
//    }
//
//    
//    private int isListContains(List<Node> list, int x, int y) {
//        for (int i = 0; i < list.size(); i++) {
//            Node node = list.get(i);
//            if (node.getX() == x && node.getY() == y) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    
//    private Node minList(List<Node> list) {
//        Iterator<Node> i = list.iterator();
//        Node candidate = i.next();
//
//        while (i.hasNext()) {
//            Node next = i.next();
//            if (next.compareTo(candidate) < 0) {
//                candidate = next;
//            }
//        }
//        return candidate;
//    }
//}
