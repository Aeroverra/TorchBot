package me.woder.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class RComponent extends JComponent {
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 10;
    private static final int PREF_H = PREF_W;
    private int x, y, w, h, type;
    private PRadar img;
    public String text;
    public String name;
    Rectangle rect;

    public RComponent(int x, int y, int w, int h, final String text, int type, PRadar img, String name) {
       this.x = x;
       this.y = y;
       this.w = w;
       this.h = h;
       this.img = img;
       this.type = type;
       this.text = text;
       this.name = name;
       rect = new Rectangle(x, y, w, h);
       
    }
    
    public void moveDot(int x, int y, int ox, int oy, int oz){
        this.x = x;
        this.y = y;
        updateText(name, ox, oy, oz);
        rect = new Rectangle(x, y, w, h);
        repaint();
    }
    
    public void updateText(String name2, int ox, int oy, int oz) {
        this.text = "<html>Player " + name2 + "<br>Location: " + ox + ", " + oy + ", " + oz + "</html>";
    }
    
    public void updateName(String n){
        this.name = n;
    }

    public boolean isInside(Point e){
        return rect.contains(e.x, e.y);
    }

    @Override
    public Dimension getPreferredSize() {
       return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2 = img.background.createGraphics();
       if(type == 0){
        g2.setColor(Color.ORANGE);
       }else if(type == 1){
        g2.setColor(Color.PINK);
       }else if(type == 2){
        g2.setColor(Color.RED);  
       }else if(type == 3){
        g2.setColor(Color.BLUE);
       }
       g2.fillRect(x, y, w, h);
       g2.dispose();
       //img.repaint();
    }

 }
