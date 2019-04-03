/* Aidan Jay, Overlake APCS, 10/22/18
Project 3 - Cafe Wall: This program uses multiple methods, nested for loops, class constants, drawing panel,
the Graphics class, and parameters to print an image of illusions rows and grids of squares.
*/
import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
   
   // Creates and draws the drawing panel with a gray background and draws all of the rows and grids in the specified places
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      row(g, 0, 0, 4, 20);
      row(g, 50, 70, 5, 30);
      grid(g, 10, 150, 4, 25, 0);
      grid(g, 250, 200, 3, 25, 10);
      grid(g, 425, 180, 5, 20, 10);
      grid(g, 400, 20, 2, 35, 35);
      
   }
   
   // Prints a row of squares in different locations using the given parameters
   public static void row(Graphics g, int x, int y, int pairs, int size) {
      for (int i = 0; i < pairs; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x + size * 2 * i, y, size, size);
         g.setColor(Color.WHITE);
         g.fillRect(x + size + size * 2 * i, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x + size * 2 * i, y, x + size + size * 2 * i, y + size);
         g.drawLine(x + size * 2 * i, y + size, x + size + size * 2 * i, y);
      }
   }
   
   // Prints the grids of squares in different locations using the given parameters
   public static void grid(Graphics g, int x , int y, int pairs, int size, int offset) {
      for (int i = 0; i < pairs; i++) {
         row(g, x, y + (size + MORTAR) * 2 * i, pairs, size);
         row(g, x + offset, y + size + MORTAR + (size + MORTAR) * 2 * i, pairs, size);
      }
   }
}