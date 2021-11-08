/**
 * @program: JavaProgromming
 * @description: 该程序实现的是轮盘赌游戏该程序含有错误，使用Debugger调试器方式运行调试程序
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-20 09:46
 */
import acm.program.*;
import acm.util.*;
public class Roulette extends ConsoleProgram {
    /** 玩家初始的赌资 */
    private static final int STARTING_MONEY = 100;

    /** 每个游戏的下注 */
    private static final int WAGER_AMOUNT = 10;

    public void run() {
        setFont("Courier-24");
        giveInstructions();
        playRoulette();
    }

    /*玩轮盘赌，直到玩家破产，游戏结束*/
    private void playRoulette() {
        int money = STARTING_MONEY;
        while (money > 0) {
            println("现在你有 $" + money + "块钱。");
            String bet = readLine("输入博彩类别: ");
            int outcome = spinRouletteWheel();
            println(outcome);

            if (isWinningCategory(outcome, bet)) {
                println("那个数字是： " + bet + "，所以你赢了！");
                money += WAGER_AMOUNT;
            } else {
                println("那个数字不是： " + bet + "，所以你输了！");
                money -= WAGER_AMOUNT;
            }
        }
        println("你没钱了！");
    }

    /*该方法返回球落在哪个点数*/
    private int spinRouletteWheel() {
        int spin = rgen.nextInt(0, 36);
        println("球落在了 " + spin + "中。");
        return spin;
    }

    /*
     * 如果玩家的赌注和轮盘中的球落点是一样的，返回true。
     * 如果玩家输入错误了的赌注类型，则会返回false。
     */
    private boolean isWinningCategory(int outcome, String bet) {
        if (bet == "奇数") {
            return outcome % 2 == 1;
        } else if (bet == "偶数") {
            return (outcome % 2 == 0);
        } else if (bet == "小") {
            return (1 <= outcome && outcome <= 18);
        } else if (bet == "大") {
            return (19 <= outcome && outcome <= 36);
        } else {
            return (false);
        }
    }

    /**
     * 提供给玩家此游戏的规则
     */
    private void giveInstructions() {
        println("欢迎玩轮盘赌游戏！！");
        println("轮盘赌游戏是将轮盘划分0~36格，");
        println("每一局有个小球在轮盘中滚动并停在某一格中。");
        println("玩家可赌小球停在轮盘中的位置，在本游戏中玩家有四种下注方法：");
        println("赌奇数、赌偶数、赌大（19~36），赌小（1~18）。");
        println("当球停在0处时，庄家赢，玩家输。");
        println("玩家初始赌资为$100，每次下注为$10。");
        println("玩家赢时，赌资增加$10，玩家输时，赌资减少$10。");
        println("当玩家的赌资为0时，游戏结束。");
    }

    private RandomGenerator rgen = new RandomGenerator();
}

