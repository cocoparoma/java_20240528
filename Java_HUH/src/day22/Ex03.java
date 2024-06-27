package day22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        System.out.println("원하시는 만큼 숫자를 입력해 주세요 (다 입력하셨으면 -1을 입력해 주세요)");
        while (true) {
            System.out.print(">>");
            String tmp =sc.nextLine();
            if (tmp.equals("-1")) {
                break;
            }
            list.add(tmp);
        }
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        //Collections.reverse(); => 요소들을 역순으로 배치한다는 의미
        System.out.println(list);

        Collections.sort(list, (o1,o2)->Integer.parseInt(o1)-Integer.parseInt(o2));
        System.out.println(list);
    }
}
