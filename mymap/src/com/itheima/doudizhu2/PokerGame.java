package com.itheima.doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    static HashMap<Integer, String> poker = new HashMap<>();
    static ArrayList<Integer> pokerSerialNumbers = new ArrayList<>();

    static{
        String[] colors = {"♠", "♥", "♦", "♣"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int serialNumber = 1;
        for(String number: numbers){
            for(String color: colors){
                poker.put(serialNumber, color + number);
                pokerSerialNumbers.add(serialNumber);
                serialNumber++;
            }
        }

        poker.put(serialNumber, "小王");
        pokerSerialNumbers.add(serialNumber);
        serialNumber++;
        poker.put(serialNumber, "大王");
        pokerSerialNumbers.add(serialNumber);
    }

    public PokerGame(){
        Collections.shuffle(pokerSerialNumbers);

        TreeSet<Integer> landLordSerialNumbers = new TreeSet<>();
        TreeSet<Integer> playerSerialNumbers1 = new TreeSet<>();
        TreeSet<Integer> playerSerialNumbers2 = new TreeSet<>();
        TreeSet<Integer> playerSerialNumbers3 = new TreeSet<>();

        for (int i = 0; i < pokerSerialNumbers.size(); i++) {
            if(i <= 2){
                landLordSerialNumbers.add(pokerSerialNumbers.get(i));
                continue;
            }

            if(i % 3 == 0){
                playerSerialNumbers1.add(pokerSerialNumbers.get(i));
            }else if(i % 3 == 1){
                playerSerialNumbers2.add(pokerSerialNumbers.get(i));
            }else{
                playerSerialNumbers3.add(pokerSerialNumbers.get(i));
            }
        }

        checkPoker("A", landLordSerialNumbers);
        checkPoker("B", playerSerialNumbers1);
        checkPoker("C", playerSerialNumbers2);
        checkPoker("D", playerSerialNumbers3);

    }
    public static void checkPoker(String playerName, TreeSet<Integer> playerPoker){
        System.out.print(playerName + ": ");
        for(int i: playerPoker){
            System.out.print(poker.get(i) + " ");
        }
        System.out.println();
    }
}
