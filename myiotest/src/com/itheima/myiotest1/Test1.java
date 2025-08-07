package com.itheima.myiotest1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
import java.util.Collections;
import java.util.Random;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
        制造假数据：
        获取姓氏:https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
        获取男生名字：http://www.haoming8.cn/baobao/10881.html
        获取女生名字：http://www.haoming8.cn/baobao/7641.html
         */
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        ArrayList<String> familyNameTempList = getData(familyNameStr, "(\\W{4})(，|。)", 1);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "(([\\u4E00-\\u9FA5]{2} )){4}(\\W\\W)", 0);

        ArrayList<String> familyNameList = new ArrayList<>();
        for(String str: familyNameTempList){
            for(int i = 0; i < str.length(); i++){
                String familyName = str.charAt(i) + "";
                if(!familyNameList.contains(familyName)) familyNameList.add(familyName);
            }
        }

        ArrayList<String> boyNameList = new ArrayList<>();
        /*HashSet<String> hs = new HashSet();
        for(String str: boyNameTempList)    hs.add(str);
        for(String str: hs)     boyNameList.add(str);*/
        for(String str: boyNameTempList){
            if(!boyNameList.contains(str)) boyNameList.add(str);
        }

        ArrayList<String> girlNameList = new ArrayList<>();
        for(String str: girlNameTempList){
            String[] arr = str.split(" ");
            for(int i = 0; i < arr.length; i++){
                if(!girlNameList.contains(arr[i]))  girlNameList.add(arr[i]);
            }
        }
        
        ArrayList<String> finalList = getInfos(familyNameList, boyNameList, girlNameList, 70, 50);
        Collections.shuffle(finalList);

        File parentPath = new File("myiotest\\src\\com\\itheima\\testFiles");
        parentPath.mkdirs();
        File file = new File("myiotest\\src\\com\\itheima\\testFiles\\names.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for(String name: finalList){
            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }
    /*
     * 作用：
     * 获取男生和女生的信息：张三-男-23
     * 形参：
     * 参数一：装着姓氏的集合
     * 参数二：装着男生名字的集合
     * 参数三：装着女生名字的集合
     * 参数四：男生的个数
     * 参数五：女生的个数
     */
    private static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCount, int girlCount){
        ArrayList<String> finalList = new ArrayList<>();

        HashSet<String> boySet = new HashSet<>();
        while(true){
            if(boySet.size() == boyCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boySet.add(familyNameList.get(0) + boyNameList.get(0));
        }

        HashSet<String> girlSet = new HashSet<>();
        while(true){
            if(girlSet.size() == girlCount){ break; }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlSet.add(familyNameList.get(0) + girlNameList.get(0));
        }

        Random r = new Random();
        for(String boyName: boySet){
            int age = r.nextInt(10) + 18;
            finalList.add(boyName + "-男-" + age);
        }

        for(String girlName: girlSet){
            int age = r.nextInt(8) + 18;
            finalList.add(girlName + "-女-" + age);
        }
        return finalList;
    }

    /*
     * 作用：
     *      根据正则表达式获取字符串中的数据
     * 参数一：
     *      完整的字符串
     * 参数二：
     *      正则表达式
     * 参数三：
     *      正则匹配后结果的索引
     * 返回值：
     *      真正想要的数据
     */
    private static ArrayList<String> getData(String str, String regex, int index){
        ArrayList<String> tempNameList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            tempNameList.add(matcher.group(index));
        }
        return tempNameList;
    }

    /*
    作用：
        从网络中爬取数据，把数据拼接成字符串返回
    形参：
        网址
    返回值：
        爬取到的所有数据
     */
    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        URLConnection conn = url.openConnection();
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while((ch = isr.read()) != -1){
            sb.append((char)ch);
        }
        isr.close();
        return sb.toString();
    }
}
