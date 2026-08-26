package ex1;

import java.util.Scanner;

public class CoffeeOrder {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("아메리카노(2500원) - (3잔 이상 주문시 스탬프 발급) 주문 수량: ");
            int cnt = scanner.nextInt();

             if(cnt <= 0) {
                 System.out.println("1잔 이상 주문해야합니다.");
                 continue;
             } else if(cnt < 3) {
                 System.out.printf("총 %d잔 주문 -- 결제 금액 : %d" , cnt , cnt * 2500);
                 break;
             } else {
                 System.out.printf("총 %d잔 주문 -- 결제 금액 : %d" , cnt , cnt * 2500);
                 System.out.println("3잔 이상 주문하였습니다. 스탬프 발급");

                 for(int i = 0; i < 3; i++) {
                     System.out.println();
                     for (int j = 0; j < 3; j++) {
                         System.out.print("* " );
                     }
                 }
                 break;
             }
         }
    }
}
