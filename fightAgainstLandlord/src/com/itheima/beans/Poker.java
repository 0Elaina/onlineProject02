package com.itheima.beans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Poker extends JLabel implements MouseListener {
    private String pokerName;
    private boolean pokerFace;
    private boolean canClick = false;
    private boolean isClicked = false;

    public Poker(String pokerName, boolean pokerFace){
        this.pokerName = pokerName;
        this.pokerFace = pokerFace;

        if(this.pokerFace){
            setFront();
        }else{
            setRear();
        }

        this.setSize(71, 96);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    public void setFront(){
        this.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/poker/" + this.getPokerName() + ".png"));
        this.pokerFace = true;
    }

    public void setRear(){
        this.setIcon(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/poker/rear.png"));
        this.pokerFace = false;
    }

    public void setPokerName(String pokerName){
        this.pokerName = pokerName;
    }

    public String getPokerName(){
        return this.pokerName;
    }

    public void setCanClick(boolean canClick){
        this.canClick = canClick;
    }

    public boolean getCanClick(){
        return this.canClick;
    }

    public void setPokerFace(boolean pokerFace){
        this.pokerFace = pokerFace;
    }

    public boolean getPokerFace(){
        return this.pokerFace;
    }

    public void setClicked(boolean clicked){
        this.isClicked = clicked;
    }

    public boolean getClicked(){
        return this.isClicked;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int step = 0;
        if(canClick){
            if(isClicked){
                step = 20;
            }else{
                step = -20;
            }
            isClicked = !isClicked;
            Point from = this.getLocation();
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
