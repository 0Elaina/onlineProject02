package com.itheima.ui;

import com.itheima.beans.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameJFrame extends JFrame implements ActionListener {
    //获取界面中的隐藏容器
    protected static Container container = null;

    //管理抢地主和不抢两个按钮
    private JButton[] landlordButtons = new JButton[2];

    //管理出牌和不要两个按钮
    private JButton[] publishCardButtons = new JButton[2];

    //游戏界面中地主的图标
    private JLabel landlordImageLabel = new JLabel();

    private ArrayList<ArrayList<Poker>> currentPokerList = new ArrayList<>();

    private ArrayList<ArrayList<Poker>> playerHandPokerList = new ArrayList<>();

    //底牌
    private ArrayList<Poker> landLordCardList = new ArrayList<>();

    //牌盒
    private ArrayList<Poker> allPokerCardList = new ArrayList<>();

    //三个玩家前方的文本提示
    private JTextField[] times = new JTextField[3];


    public GameJFrame() {
        //设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("fightAgainstLandlord/src/com/itheima/image/poker/dizhu.png"));

        initJFrame();
        initView();

        this.setVisible(true);

        initCard();
        initGame();
    }

    private void initGame() {
    }

    private void initCard() {
        //准备牌
        for(int i = 0; i <= 5; i++){
            for(int j = 0; j <=13; j++){
                if(i == 5 && j > 2){
                    break;
                }else{
                    Poker poker = new Poker(i + "-" + j, false);
                    poker.setLocation(350, 150);
                    allPokerCardList.add(poker);
                    container.add(poker);
                }
            }
        }

        //洗牌
        Collections.shuffle(allPokerCardList);

        ArrayList<Poker> player0 = new ArrayList<>();
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();

        //发牌
        for(int i = 0; i < allPokerCardList.size(); i++){
            Poker poker = allPokerCardList.get(i);

            if(i <= 2){
                landLordCardList.add(poker);
                Common.move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                continue;
            }

            if(i % 3 == 0){
                Common.move(poker, poker.getLocation(), new Point(50, 60 + 5 * i));
                player0.add(poker);
            }else if(i % 3 == 1){
                Common.move(poker, poker.getLocation(), new Point(130 + i * 6, 450));
                player1.add(poker);
                //把自己的牌展示正面
                poker.setFront();
            }else{
                Common.move(poker, poker.getLocation(), new Point(700, 40 + i * 5));
                player2.add(poker);
            }

            //把当前的牌至于最顶端，这样就会有牌依次错开且叠起来的效果
            container.setComponentZOrder(poker, 0);
        }


        playerHandPokerList.add(player0);
        playerHandPokerList.add(player1);
        playerHandPokerList.add(player2);


        //排序
        for(int i = 0; i < playerHandPokerList.size(); i++){
            sortPokerCard(playerHandPokerList.get(i));
            Common.rePosition(this, playerHandPokerList.get(i), i);
        }
    }

    public void sortPokerCard(ArrayList<Poker> pokers) {
        Collections.sort(pokers, new Comparator<Poker> (){
            @Override
            public int compare(Poker o1, Poker o2) {
                int color1 = Integer.parseInt(o1.getPokerName().substring(0, 1));
                int value1 = getValue(o1, color1);

                int color2 = Integer.parseInt(o2.getPokerName().substring(0, 1));
                int value2 = getValue(o2, color2);

                int result = value2 - value1;
                result = result == 0 ? color2 - color1 : result;
                return result;
            }
        });
    }

    public int getValue(Poker poker, int color){
        String pokerName = poker.getPokerName();
        int value = Integer.parseInt(pokerName.substring(2));

        if(color == 5) return value += 100;
        if(value <= 2) return value += 20;
        return value;
    }

    private void initView() {
        //创建抢地主的按钮
        JButton grabLandlordButton = new JButton("抢地主");
        grabLandlordButton.setBounds(320, 400, 75, 20);
        grabLandlordButton.addActionListener(this);
        //设置隐藏
        grabLandlordButton.setVisible(false);
        landlordButtons[0] = grabLandlordButton;
        container.add(grabLandlordButton);

        //创建不抢的按钮
        JButton noGrabButton = new JButton("不抢");
        noGrabButton.setBounds(420, 400, 75, 20);
        noGrabButton.addActionListener(this);
        noGrabButton.setVisible(false);
        landlordButtons[1] = noGrabButton;
        container.add(noGrabButton);


        //创建出牌的按钮
        JButton outCardButton = new JButton("出牌");
        outCardButton.setBounds(320, 400, 60, 20);
        outCardButton.addActionListener(this);
        outCardButton.setVisible(false);
        publishCardButtons[0] = outCardButton;
        container.add(outCardButton);

        //创建不要的按钮
        JButton noCardButton = new JButton("不要");
        noCardButton.setBounds(420, 400, 60, 20);
        noCardButton.addActionListener(this);
        noCardButton.setVisible(false);
        publishCardButtons[1] = noCardButton;
        container.add(noCardButton);

        //创建倒计时提示文字
        for(int i = 0; i < 3; i++){
            times[i] = new JTextField("倒计时: ");
            times[i].setEditable(false);
            times[i].setVisible(false);
            container.add(times[i]);
        }
        times[0].setBounds(140, 230, 60, 20);
        times[1].setBounds(374, 360, 60, 20);
        times[2].setBounds(620, 230, 60, 20);

        //创建地主图标
        landlordImageLabel = new JLabel(new ImageIcon("fightAgainstLandlord/src/com/itheima/image/poker/dizhu.png"));
        landlordImageLabel.setVisible(false);
        landlordImageLabel.setSize(40, 40);
        container.add(landlordImageLabel);
    }

    private void initJFrame() {
        this.setTitle("斗地主");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(830, 620);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
