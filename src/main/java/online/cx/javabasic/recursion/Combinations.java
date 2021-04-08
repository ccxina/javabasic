package online.cx.javabasic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 曹鑫 1428604355@qq.com
 * @date 2019/9/20 15:40
 */
public class Combinations {

    /**
     *  Generates all combinations and output them
     *  selecting n elements from data
     */
    public void combinations(List<Integer> selected, List<Integer> data, int n) {
        //initial value for recursion
        //how to select elements
        //how to output

        if(n == 0){
            //output all selected elements
            for (Integer i: selected){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if(data.isEmpty()){
            return;
        }

        //select element 0
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        selected.remove(selected.size() -1);
        combinations(selected, data.subList(1, data.size()), n);

    }

    public static void main(String[] args) {


        Combinations comb = new Combinations();
        comb.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4), 2);
    }

}
