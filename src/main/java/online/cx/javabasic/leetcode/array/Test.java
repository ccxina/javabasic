package online.cx.javabasic.leetcode.array;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 2020/11/4.
 *
 * @author 曹鑫
 */
public class Test {

    //第一部分代码，通过回溯法随机生成符合九宫格规则的九宫格
    //用回溯法随机生成九宫格（此处只生成一个九宫格），
    // bl用来作为标记，当随机生成第一个九宫格时，将bl置为true，然后结束回溯。
    //jiuGongGe作为临时储存随机生成的九宫格，当回溯法结束时，jiuGongGe将会变为初始状态；
    // end_jiuGongGe用来储存最终随机生成的九宫格
    private static int jiuGongGe[][] = new int[9][9];
    private static Boolean bl = false;
    private static int end_jiuGongGe[][] = new int[9][9];

    /**
     * 判断在九宫格中的坐标(x,y)的位置上插入value，是否符合规则
     *
     * @param x
     * @param y
     * @param value
     * @return
     */
    public static Boolean legal(int a[][], int x, int y, int value) {

        for (int i = 0; i < 9; i++) {
            //如果列中有value，则返回false
            if (i != x && a[i][y] == value) {
                return false;
            }
            //如果行中有value，则返回false
            if (i != y && a[x][i] == value) {
                return false;
            }
        }

        //(minX,minY)是(x,y)所属小九宫格的左上角的坐标
        int minX = x / 3 * 3;
        int minY = y / 3 * 3;

        for (int i = minX; i < minX + 3; i++) {
            for (int j = minY; j < minY + 3; j++) {
                //如果小九宫格中的非(x,y)的坐标上的值为value，返回false
                if (i != x && j != y && a[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 随机生成九宫格的算法，通过回溯生成。
     *
     * @param k
     */
    public static void generateJiugongGe(int k) {
        if (bl) {
            return;
        }
        if (k == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(jiuGongGe[i][j] + " ");
                    end_jiuGongGe[i][j] = jiuGongGe[i][j];
                }
                System.out.println();
            }
            bl = true;
            return;
        }

        //取得第k+1个值所对应的坐标(x,y),k是从0开始的。
        int x = k / 9;
        int y = k % 9;

        if (jiuGongGe[x][y] == 0) {
            //index用来判断是否已经完全随机生成了1-9这个9个数
            int index = 0;
            while (index < 9) {
                //动态数组list用来储存已经随机生成的1-9的数字
                ArrayList list = new ArrayList(9);
                Random random = new Random();
                int i = random.nextInt(9) + 1;
                //当list中包含数字i时，在重新生成1-9的数字
                while (list.contains(i))
                    i = random.nextInt(9) + 1;
                list.add(i);
                index++;
                jiuGongGe[x][y] = i;
                //legal()函数是判断在九宫格中的坐标(x,y)的位置上插入i，是否符合规则
                if (legal(jiuGongGe, x, y, i)) {
                    generateJiugongGe(k + 1);
                }
            }
            jiuGongGe[x][y] = 0;     //回溯时，将坐标(x,y)的值置零

        } else {
            generateJiugongGe(k + 1);
        }
    }

    /**
     * 第二部分，通过第一部分生成的九宫格，对其中的81个数字随机选取46位（81-35=46）置零，以此形成数独游戏。
     *
     * @param ArryJiuGongGe
     * @return
     */
    public static int[][] generateShuDu(int ArryJiuGongGe[][]) {
        Random random = new Random();
        ArrayList list = new ArrayList(35);
        for (int i = 0; i < 35; i++) {
            int index = random.nextInt(81);
            while (list.contains(index)) {
                index = random.nextInt(81);
            }
            list.add(index);
        }
        int shuDu[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!list.contains(i * 9 + j)) {
                    shuDu[i][j] = 0;
                } else {
                    shuDu[i][j] = ArryJiuGongGe[i][j];
                }
            }
        }
        return shuDu;
    }

    //第三部分，是针对第二部分生成的数独游戏，使用回溯法，实现对数独的解答。
    //shuDu[][]是用来存放数独游戏的二维数组。
    //numOfSolution是用来统计shuDu[][]中存放的数独游戏的解的个数
    public static int shuDu[][] = new int[9][9];
    public static int numOfSolution = 1;

    /**
     * @param shuDu
     */
    public static void setShuDu(int[][] shuDu) {
        Test.shuDu = shuDu;
    }

    /**
     * 回溯法求解数独，参考第一部分用回溯法随机生成数独的解空间的代码
     *
     * @param k
     */
    public static void shuDu_solution(int k) {

        if (k == 81) {
            System.out.println("解法" + numOfSolution);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(shuDu[i][j] + " ");
                }
                System.out.println();
            }

            numOfSolution++;
            return;
        }
        int x = k / 9;
        int y = k % 9;
        if (shuDu[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                shuDu[x][y] = i;
                if (legal(shuDu, x, y, i)) {
                    shuDu_solution(k + 1);
                }
            }
            shuDu[x][y] = 0;
        } else {
            shuDu_solution(k + 1);
        }
    }

    //打印二维数组a[m][n]
    public static void displayArray(int a[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //第一部分的测试生成一个符合数独规则的九宫格
        System.out.println("第一部分的测试生成一个符合数独规则的九宫格");
        generateJiugongGe(0);
        System.out.println();
        displayArray(end_jiuGongGe, 9, 9);

        System.out.println();

        //第二部分的测试，生成一个数独游戏，并输出该游戏
        System.out.println("第二部分的测试，生成一个数独游戏，并输出该游戏");
        System.out.println("----------------------------");
        System.out.println("生成数独");
        int generateShuDu[][] = generateShuDu(end_jiuGongGe);
        setShuDu(generateShuDu);
        displayArray(shuDu, 9, 9);

        System.out.println();

        //第三部分的测试，对数独游戏的解，并输出所有的解
        System.out.println("第三部分的测试，对数独游戏的解，并输出所有的解");
        System.out.println("----------------------------");
        System.out.println("shudu_solution");
        shuDu_solution(0);
    }

}