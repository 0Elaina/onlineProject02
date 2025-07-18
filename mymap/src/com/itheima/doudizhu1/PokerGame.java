package com.itheima.doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    static ArrayList<String> poker = new ArrayList<>();

    //静态代码块
    //特点：随着类的加载而加载的，而且只执行一次
    static{
        String[] colors = {"♠", "♥", "♦", "♣"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for(String color: colors){
            for(String number: numbers){
                poker.add(color+number);
            }
        }
        poker.add("大王");
        poker.add("小王");
    }

    public PokerGame() {
        Collections.shuffle(poker);

        ArrayList<String> landLordPokerCard = new ArrayList<>();
        ArrayList<String> playerPokerCard1 = new ArrayList<>();
        ArrayList<String> playerPokerCard2 = new ArrayList<>();
        ArrayList<String> playerPokerCard3 = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if(i <= 2){
                landLordPokerCard.add(poker.get(i));
                continue;
            }

            if(i % 3 == 0){
                playerPokerCard1.add(poker.get(i));
            }else if(i % 3 == 1){
                playerPokerCard2.add(poker.get(i));
            }else if(i % 3 == 2){
                playerPokerCard3.add(poker.get(i));
            }
        }

        checkPokerCard("A", landLordPokerCard);
        checkPokerCard("B", playerPokerCard1);
        checkPokerCard("C", playerPokerCard2);
        checkPokerCard("D", playerPokerCard3);
    }

    public static void checkPokerCard(String playerName, ArrayList<String> list){
        System.out.print(playerName + ": ");
        for(String card: list){
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
