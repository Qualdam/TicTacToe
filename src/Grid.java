import java.awt.*;

public class Grid {
    Frame f;
    final int x = Const.SX;
    final int y = Const.SY;
    final int step = Const.CEIL_SIZE;
    final int cnt = Const.CNT_CEIL;
    final int width = Const.SHAPE_W;
    int[][] grid;
    public Grid(int[][] a){
        grid = a;
    }

    public void Draw(Graphics g){
        for(int X = Const.SX, Y = Const.SY;X <= Const.CEIL_SIZE * Const.CNT_CEIL + Const.SX && Y <= Const.CEIL_SIZE * Const.CNT_CEIL + Const.SY;X += Const.CEIL_SIZE, Y += Const.CEIL_SIZE){
            g.drawLine(X, Const.SY, X, Const.SY + Const.CNT_CEIL * Const.CEIL_SIZE);
            g.drawLine(Const.SX, Y, Const.SX + Const.CNT_CEIL * Const.CEIL_SIZE, Y);
        }
    }

    public void PaintZero(Graphics g, int i, int j){
        g.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));
        g.drawOval(x + i * step, y + j * step, step, step);
    }

    public void PaintCross(Graphics g, int i, int j){
        g.setColor(Color.RED);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));
        g.drawLine(x + i * step, y + j * step, x + (i + 1) * step, y + (j + 1) * step);
        g.drawLine(x + (i + 1) * step, y + j * step, x + i * step, y + (j + 1) * step);
    }

}