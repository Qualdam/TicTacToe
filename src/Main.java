/**
 * @author qualdoom
 * @version 1.0
 * @description File for codeforces coding
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.math.*;
import java.awt.event.*;
import java.applet.*;

public class Main {

    public static void main(String[] args) {
        JFrame Window = new JFrame();
        Window.setVisible(true);
        Window.setSize(Const.W, Const.H);
        Window.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        Window.setLayout(new BorderLayout());
        Window.setLocationRelativeTo(null);
        Game g = new Game();
        Window.add(g);
    }
}
