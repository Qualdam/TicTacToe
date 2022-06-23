import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Game extends JComponent {

    int[][] grid = new int[Const.CNT_CEIL][Const.CNT_CEIL];
    Grid g = new Grid(grid);
    public static Integer
            EMPTY = Const.EMPTY,
            Zero = Const.ZERO,
            Cross = Const.CROSS;

    int who = 1;
    int cnt = 0;

    public void sendMessage (String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public Game(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        for(int i = 0;i < Const.CNT_CEIL;i++){
            for(int j = 0;j < Const.CNT_CEIL;j++){
                grid[i][j] = Const.EMPTY;
            }
        }
    }

    int WhoWins(){
        int ok = EMPTY;
        cnt = 0;
        for(int i = 0;i < Const.CNT_CEIL;i++){
            for(int j = 0;j < Const.CNT_CEIL;j++){
                boolean a = grid[i][j] != EMPTY;
                if(a)cnt++;
            }
        }
        for(int x = Const.ZERO;x <= Const.CROSS;x++){
            {
                boolean res = true;
                for(int i = 0;i < Const.CNT_CEIL;i++){
                    res &= (grid[i][i] == x);
                }
                if(res)ok = x;
            }
            {
                boolean res = true;
                for(int i = 0;i < Const.CNT_CEIL;i++){
                    res &= (grid[Const.CNT_CEIL - i - 1][i] == x);
                }
                if(res)ok = x;
            }
            {
                for(int i = 0;i < Const.CNT_CEIL;i++){
                    boolean res = true;
                    for(int j = 0;j < Const.CNT_CEIL;j++){
                        res &= (grid[i][j] == x);
                    }
                    if(res)ok = x;
                }
            }
            {
                for(int i = 0;i < Const.CNT_CEIL;i++){
                    boolean res = true;
                    for(int j = 0;j < Const.CNT_CEIL;j++){
                        res &= (grid[j][i] == x);
                    }
                    if(res)ok = x;
                }
            }
        }
        return ok;
    }

    void sendMessage(){
        int z = WhoWins();
        if(z == 0){
            sendMessage("ZERO WIN", "Krasava. Zhestko");
            System.exit(0);
        }
        if(z == 1){
            sendMessage("CROSS WIN", "Lol");
            System.exit(0);
        }
        if(cnt == Const.CNT_CEIL * Const.CNT_CEIL){
            sendMessage("Draw!", "What a losers");
            System.exit(0);
        }
    }

    @Override
    protected void processMouseEvent (MouseEvent event){
        super.processMouseEvent(event);
        sendMessage();
        if(event.getButton() == MouseEvent.BUTTON1){
            int x = event.getX();
            int y = event.getY();
            if(x < Const.SX || x > Const.SX + Const.CNT_CEIL * Const.CEIL_SIZE){
                return;
            }
            if(y < Const.SX || y > Const.SX + Const.CNT_CEIL * Const.CEIL_SIZE){
                return;
            }
            int i = (x - Const.SX) / Const.CEIL_SIZE;
            int j = (y - Const.SY) / Const.CEIL_SIZE;
            if(grid[i][j] != EMPTY){
                return;
            }
            if(who == 1){
                grid[i][j] = Cross;
            } else {
                grid[i][j] = Zero;
            }
            who = 3 - who;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graph){
        g.Draw(graph);
        for(int x = 0;x < Const.CNT_CEIL;x++){
            for(int y = 0;y < Const.CNT_CEIL;y++){
                if(grid[x][y] == Cross){
                    g.PaintCross(graph, x, y);
                }
                if(grid[x][y] == Zero){
                    g.PaintZero(graph, x, y);
                }
            }
        }
    }

}