package mini_project11_3;

import java.util.Scanner;

public class Cinema {
  public static void main (String[] args) {
    Cinema c = new Cinema();
    c.getDate();
  }

  public int getDate() {
    try {
      System.out.print("19일 ~ 25일 중에 입력해 주세요(예: 19)>> ");
      Scanner sc = new Scanner(System.in);
      int date = Integer.parseInt(sc.nextLine());
      System.out.println("7월 "+date+"일로 예약 완료");
    } catch(Exception ex) {
      System.out.println("error = " + ex);
    } return getDate();
  }
}//class END