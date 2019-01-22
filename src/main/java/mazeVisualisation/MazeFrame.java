
package maze;

import java.awt.*;
import javax.swing.*;

public class MazeFrame extends JFrame{
    private int canvasWidth;
    private int canvasHeight;
    
    private class MazeCanvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            
        }
    }
    
    public MazeFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        
        this.canvasWidth=canvasWidth;
        this.canvasHeight=canvasHeight;
    }
}
