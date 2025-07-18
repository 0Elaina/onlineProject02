package com.itheima.doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {

    static HashMap<String, Integer> hm = new HashMap<>();
    static ArrayList<String> poker = new ArrayList<>();

    static{
        String[] colors = {"♠", "♥", "♦", "♣"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for(String color: colors){
            for(String number: numbers){
                poker.add(color+number);
            }
        }
        poker.add(" 小王");
        poker.add(" 大王");

        for (int i = 8; i < numbers.length; i++) {
            hm.put(numbers[i], i + 3);
        }
        hm.put("小王", 50);
        hm.put("大王", 100);

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
            }else{
                playerPokerCard3.add(poker.get(i));
            }
        }
        pokerSort(landLordPokerCard);
        pokerSort(playerPokerCard1);
        pokerSort(playerPokerCard2);
        pokerSort(playerPokerCard3);

        System.out.println(landLordPokerCard);
        System.out.println(playerPokerCard1);
        System.out.println(playerPokerCard2);
        System.out.println(playerPokerCard3);

    }

    public void pokerSort(ArrayList<String> pokerCards){
        Collections.sort(pokerCards, new Comparator<String>(){
           @Override
           public int compare(String o1, String o2) {
               String color1 = o1.substring(0, 1);
               String color2 = o2.substring(0, 1);
               int value1 = getValue(o1.substring(1));
               int value2 = getValue(o2.substring(1));

               int result = value1 - value2;
               result = result == 0 ? color1.compareTo(color2) : result;
               return result;
           }
        });
    }

    public int getValue(String pokerCardNum){
        if(hm.containsKey(pokerCardNum)){
            return hm.get(pokerCardNum);
        }else{
            return Integer.parseInt(pokerCardNum);
        }
    }
}
