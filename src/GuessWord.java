/**
 * @program: Hangman
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-09 09:44
 */

import acm.program.*;
import acm.util.*;

public class GuessWord extends ConsoleProgram {

    public void run() {

        fordisplaying.reset();
        String secretword = getsecretword(forguessing);//生成待猜的单词
        int length = secretword.length();
        char[] display = new char[length];//初始化用来指示被猜中情况的字符数组
        for (int i = 0; i < length; i++) {
            display[i] = '-';
        }
        String fordisplay = new String(display);//此字符串用来显示被猜中的字母
        println("欢迎来到搏命猜单词游戏!");
        int guesscount = 8;
        while (guesscount > 0 && !fordisplay.equals(secretword)) {
            println("你猜的单词是这样的 : " + fordisplay);
            println("你还有 " + guesscount + " 次");
            String guess = readLine("你猜的是 :");
            String lowerguess = guess.toLowerCase();//得到玩家输入字符的小写版本，用于对比是否猜中
            String upperguess = guess.toUpperCase();//得到玩家输入字符的大写版本，目的同上
            char guesschar = guess.charAt(0);//得到玩家输入的字符，注意前面得到的是字符串
            char lowerguesschar = Character.toLowerCase(guesschar);//得到小写版本
            char upperguesschar = Character.toUpperCase(guesschar);//得到大写版本
            if (guess.length() > 1 || Character.isLetter(guesschar) != true) {//输入了不止一个字符，或者输入的字符非英文字母，则提示错误输入
                println("无效的输入，只接受字符输入。");
                continue;
            }
            if (secretword.indexOf(lowerguess) == -1 && secretword.indexOf(upperguess) == -1) {//如果用大写和小写版本都无法在secretword里面检测到，说明并未猜中
                println("单词中没有你输入的字符： " + guess );
                guesscount--;
                fordisplaying.noteIncorrectGuess(guesschar, guesscount);
            } else {
                println("你猜对了一个");
                for (int i = 0; i < length; i++) {//用小写和大写字符逐个对比secretword中的字符，发生相符的情况则用该字符替换显示用的‘-’
                    if (lowerguesschar == secretword.charAt(i) || upperguesschar == secretword.charAt(i)) {
                        display[i] = secretword.charAt(i);
                    }
                }
                String tem = new String(display);
                fordisplay = tem;
                fordisplaying.displayWord(fordisplay);
            }

        }
        if (guesscount == 0) {
            println("你失败了！");
        }
        if (fordisplay.equals(secretword)) {
            println("你赢了!");
        }
    }

    public void init() {
        add(fordisplaying);
    }

    private GuessWordCanvas fordisplaying = new GuessWordCanvas();
    private GuessWordLexicon forguessing = new GuessWordLexicon();

    private String getsecretword(GuessWordLexicon a) {
        RandomGenerator rgen = RandomGenerator.getInstance();
        int n = a.getWordCount();
        int m = rgen.nextInt(0, n - 1);
        String secretword = a.getWord(m);
        return secretword;
    }
}
