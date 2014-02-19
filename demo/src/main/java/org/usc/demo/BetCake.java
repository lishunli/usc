package org.usc.demo;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BetCake extends JFrame {

    public class Test {// 游戏结束，是否重新开始游戏？

        public Test() {

            int response = JOptionPane.showConfirmDialog(null, "是否重新开始？", "选择对话框",

                    JOptionPane.YES_NO_OPTION);

            if (response == 0)

            {

                dispose();

                new BetCake().setVisible(true);

            }

            else

            {

                System.exit(1);

            }

        }
    }

    public class Test1 {// 游戏开始设置判断

        public Test1() {

            JOptionPane.showMessageDialog(null, "未进行游戏设置或设置未完成！", "警告", JOptionPane.WARNING_MESSAGE);

            dispose();

            new BetCake().setVisible(true);

        }
    }

    public static boolean isNumer(String str) {// 正则表达式法 判断输入字符串是否为数字0-9。

        Pattern pattern = Pattern.compile("[0-9]*");

        Matcher isNumer = pattern.matcher(str);

        return isNumer.matches();

    }

    int[] diceNum = new int[7];

    int[] dice = new int[7];

    int[] man = new int[7];

    int yixiu = 0;// 设置一秀；

    int erju = 0;// 设置二举;

    int sanhong = 0;// 设置三红;

    int sijin = 0;// 设置四进;

    int duitang = 0;// 设置对堂;

    final int zhuangyuan = 1;// 设置状元；

    int liuhong = 0;// 六杯红，判断结束；

    int people = 0;// 玩家数；

    int yixiu1 = 0;// 统计一秀;

    int erju1 = 0;// 统计二举;

    int sanhong1 = 0;// 统计三红;

    int sijin1 = 0;// 统计四进;

    int duitang1 = 0;// 统计对堂;

    int zhuangyuan1 = 0;// 统计状元；

    int wuzi = 0;

    int chajin = 0;

    String Result = "";

    JTextField[] t = new JTextField[7];// 创建单行文本框，其长度为3。

    public static void main(String args[]) {

        BetCake zhongqiu = new BetCake();

        zhongqiu.setVisible(true);// 绘出窗体，否则你写的东西都是存在于内存中，并不可见。个性台历

    }

    public String ShowResult(int[] sum)

    {

        String result = "";

        switch (sum[4])

        {

        case 0:

            if (sum[1] == 4 || sum[2] == 4 || sum[3] == 4 || sum[5] == 4 || sum[6] == 4)

            {

                result = "四进，恭喜。";

                if (sijin1 < sijin)
                    sijin1++;

                else {
                    result += "很遗憾,奖品已发完嘿嘿。";
                    man[4] = 1;
                }

            }

            else if (sum[1] == 5 || sum[2] == 5 || sum[3] == 5 || sum[5] == 5 || sum[6] == 5)

            {

                result = "五子登科，恭喜。";

                if (wuzi + zhuangyuan1 + chajin < zhuangyuan)
                    wuzi++;

                else if (zhuangyuan1 > 0) {
                    zhuangyuan1--;
                    wuzi++;
                }

                else {
                    result += "很遗憾，您的状元级不大于已获状元任意玩家。";
                }

            }

            else {
                result = " 无奖，继续努力！";
            }

            break;

        case 1:

            if (sum[1] == 1 && sum[2] == 1 && sum[3] == 1 && sum[5] == 1 && sum[6] == 1)

            {

                result = "对堂，恭喜。";

                if (duitang1 < duitang) {
                    duitang1++;
                }

                else {

                    result += "很遗憾,奖品已发完。";

                    man[5] = 1;

                    if (yixiu1 < yixiu) {
                        yixiu1++;
                    }

                    else {
                        result += "晕。。。一秀奖品也已发完。";
                    }

                }

            }

            else if (sum[1] == 5 || sum[2] == 5 || sum[3] == 5 || sum[5] == 5 || sum[6] == 5)

            {

                result = "五子登科，恭喜。";

                if (wuzi + zhuangyuan1 + chajin < zhuangyuan) {
                    wuzi++;
                }

                else if (zhuangyuan1 > 0) {
                    zhuangyuan1--;
                    wuzi++;
                }

                else {

                    result += "很遗憾，您的状元级不大于已获状元玩家。";

                    if (yixiu1 < yixiu) {
                        yixiu1++;
                    }

                    else {
                        result += "嘿嘿,一秀奖品也已发完.";
                    }

                }

            }

            else

            if (sum[1] == 4 || sum[2] == 4 || sum[3] == 4 || sum[5] == 4 || sum[6] == 4)

            {

                result = " 四进，恭喜.";

                if (sijin1 < sijin) {
                    sijin1++;
                }

                else {

                    result += "不过,奖品已发完。";

                    man[4] = 1;

                    if (yixiu1 < yixiu) {
                        yixiu1++;
                    }

                    else {
                        result += "(*^__^*) 嘻嘻,一秀奖品也已发完.";
                    }

                }

            }

            else {

                result = " 一秀，恭喜。";

                if (yixiu1 < yixiu) {
                    yixiu1++;
                }

                else {
                    result += "不过，奖品已发完.";
                    man[1] = 1;
                }

            }

            break;

        case 2:

            if (sum[1] == 4 || sum[2] == 4 || sum[3] == 4 || sum[5] == 4 || sum[6] == 4)

            {

                result = " 四进，恭喜.";

                if (sijin1 < sijin) {
                    sijin1++;
                }

                else

                {

                    result += "不过，奖品已发完.";

                    man[4] = 1;

                    if (erju1 < erju) {
                        erju1++;
                    }

                    else {
                        result += "悲剧。。。二举奖品也已发完.";
                        man[2] = 1;
                    }

                }

            }

            else

            {

                result = " 二举，恭喜.";

                if (erju1 < erju) {
                    erju1++;
                }

                else {
                    result += "不过，奖品已发完.";
                    man[2] = 1;
                }

            }

            break;

        case 3:

            result = " 三红，恭喜。";

            if (sanhong1 < sanhong) {
                sanhong1++;
            }

            else {
                result += "不过，个性挂历奖品已发完.";
                man[3] = 1;
            }

            break;

        case 4:

            if (sum[1] == 2)

            {

                result = " 状元插金花，恭喜。";

                if (wuzi + zhuangyuan1 + chajin < zhuangyuan) {
                    chajin++;
                }

                else if (wuzi > 0) {
                    wuzi--;
                    chajin++;
                }

                else if (zhuangyuan1 > 0) {
                    zhuangyuan1--;
                    chajin++;
                }

                else {
                    result += "不过，您的状元级不大于已获状元玩家.";
                }

            }

            else

            {

                result = " 状元，恭喜。";

                if (wuzi + zhuangyuan1 + chajin < zhuangyuan) {
                    zhuangyuan1++;
                }

                else {
                    result += "NO,奖品已发完.";
                    man[6] = 1;
                }

            }

            break;

        case 5:

            result = " 五子登科，个性相册恭喜。";

            if (wuzi + zhuangyuan1 + chajin < zhuangyuan) {
                wuzi++;
            }

            else if (zhuangyuan1 > 0) {
                zhuangyuan1--;
                wuzi++;
            }

            else {
                result += "不过，您的状元级不大于已获状元玩家.";
            }

            break;

        case 6:

            result = " 六杯红，恭喜。";

            liuhong = 1;

            break;

        }// end switch

        return result;

    }

    public boolean GameOver()

    {

        if (liuhong == 1 || (man[1] == 1 && man[2] == 1 && man[3] == 1 && man[4] == 1 && man[5] == 1 && man[6] == 1))

        {

            return true;

        }

        return false;

    }
    public BetCake() {

        super();

//        URL url1 = BetCake.class.getResource("1.jpg");// 设置窗体标题栏图标

//        ImageIcon imageicon = new ImageIcon(url1);

//        Image image = imageicon.getImage();

//        setIconImage(image);

        setBounds(50, 50, 450, 450);

        setTitle("中 秋 博 饼 ");

        getContentPane().setLayout(new GridLayout(3, 1)); // 设置窗体容器布局。

        JPanel p1 = new JPanel(); // 声明面板容器。

        p1.setLayout(new GridLayout(3, 3)); // 设置面板布局,放置6个骰子；

        JLabel[] label1 = new JLabel[7];

        for (int i = 1; i <= 6; ++i)

        {

            label1[i] = new JLabel("骰子" + i + ":");// 创建标签。

            t[i] = new JTextField(2);

            t[i].setEditable(false);

            p1.add(label1[i]);

            p1.add(t[i]);

        }

        getContentPane().add(p1);

        JPanel p2 = new JPanel();

        p2.setLayout(new FlowLayout());

        JLabel label3 = new JLabel("设 置 奖 品 数 ：");

        p2.add(label3);

        JLabel[] label4 = new JLabel[6];// 设置奖品数；

        JTextField[] beginText = new JTextField[7];

        label4[0] = new JLabel("一秀：");

        p2.add(label4[0]);

        beginText[0] = new JTextField(3);

        p2.add(beginText[0]);

        beginText[0].addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                char code = e.getKeyChar();

                String s = String.valueOf(code);

                if (isNumer(s))

                    yixiu = Integer.parseInt(s);

                else {

                    JOptionPane.showMessageDialog(null, "输入不符合或非法！请重新输入。。。");

                    dispose();

                    new BetCake().setVisible(true);

                }

            }
        });

        label4[1] = new JLabel("二举：");

        p2.add(label4[1]);

        beginText[1] = new JTextField(3);

        p2.add(beginText[1]);

        beginText[1].addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                char code = e.getKeyChar();

                String s = String.valueOf(code);

                if (isNumer(s))

                    erju = Integer.parseInt(s);

                else {

                    JOptionPane.showMessageDialog(null, "输入不符合或非法！请重新输入。。。");

                    dispose();

                    new BetCake().setVisible(true);

                }

            }
        });

        label4[2] = new JLabel("三红：");

        p2.add(label4[2]);

        beginText[2] = new JTextField(3);

        p2.add(beginText[2]);

        beginText[2].addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                char code = e.getKeyChar();

                String s = String.valueOf(code);

                if (isNumer(s))

                    sanhong = Integer.parseInt(s);

                else {

                    JOptionPane.showMessageDialog(null, "输入不符合或非法！请重新输入。。。");

                    dispose();

                    new BetCake().setVisible(true);

                }

            }
        });

        label4[3] = new JLabel("四进：");

        p2.add(label4[3]);

        beginText[3] = new JTextField(3);

        p2.add(beginText[3]);

        beginText[3].addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                char code = e.getKeyChar();

                String s = String.valueOf(code);

                if (isNumer(s))

                    sijin = Integer.parseInt(s);

                else {

                    JOptionPane.showMessageDialog(null, "输入不符合或非法！请重新输入。。。");

                    dispose();

                    new BetCake().setVisible(true);

                }

            }
        });

        label4[4] = new JLabel("对堂：");

        p2.add(label4[4]);

        beginText[4] = new JTextField(3);

        p2.add(beginText[4]);

        beginText[4].addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                char code = e.getKeyChar();

                String s = String.valueOf(code);

                if (isNumer(s))

                    duitang = Integer.parseInt(s);

                else {

                    JOptionPane.showMessageDialog(null, "输入不符合或非法！请重新输入。。。");

                    dispose();

                    new BetCake().setVisible(true);

                }

            }
        });

        label4[5] = new JLabel("状元：");

        p2.add(label4[5]);

        beginText[5] = new JTextField(3);

        p2.add(beginText[5]);

        beginText[5].setText("1");

        beginText[5].setEditable(false);

        JLabel txt = new JLabel("注意：所有的输入不能有0.");

        p2.add(txt);

        JLabel label2 = new JLabel("博 饼 结 果：");

        final JTextField resultText = new JTextField(35);

        p2.add(label2);

        p2.add(resultText);

        resultText.setEditable(false);

        getContentPane().add(p2);

        JPanel p3 = new JPanel();

        // URL url=BetCake.class.getResource("1.jpg");//图片的载入；

        // Icon icon=new ImageIcon(url);

        JButton button1 = new JButton("开 始 博 饼！");

        p3.add(button1);

        getContentPane().add(p3);

        JButton button2 = new JButton(" 博饼介绍请点击！");

        p3.add(button2);

        getContentPane().add(p3);

        button2.addActionListener(new ActionListener()

        {

            public void actionPerformed(ActionEvent e)

            {

                try {

                    Desktop dp = Desktop.getDesktop();

                    dp.browse(new URI("http://baike.baidu.com/view/.htm"));

                }

                catch (IOException ex) {

                    JOptionPane.showMessageDialog(null, " 注意：此网络地址不存在！");

                }

                catch (URISyntaxException ex) {

                    JOptionPane.showMessageDialog(null, "网络地址不存在！");

                }

            }

        });

        button1.addActionListener(new ActionListener()

        {

            public void actionPerformed(ActionEvent e)

            {

                if (yixiu == 0 || erju == 0 || sanhong == 0 || sijin == 0 || duitang == 0 || zhuangyuan == 0)

                {

                    new Test1();

                }

                for (int j = 1; j <= 6; ++j)

                    diceNum[j] = 0;

                // 开始博饼；

                for (int w = 1; w <= 6; ++w)

                {

                    dice[w] = 1 + (int) ((Math.random()) * 6);// 产生随机数1-6；

                    diceNum[dice[w]]++;

                    t[w].setText(Integer.toString(dice[w]));

                }

                Result = ShowResult(diceNum);

                resultText.setText(Result);

                if (GameOver())

                {

                    resultText.setText("游戏结束！");

                    new Test();

                }

            }
        });

    }
}
