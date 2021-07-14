package mini_project11;

public class Cgv3 extends CgvHandler3 {

  

  CgvArray[][][] arrayTest = new CgvArray[3][7][6];//seat정보를 담을 배열 생성

  public static void main(String[] args) {
    System.out.println("\t\t\tC G V");
    System.out.println("\t\t영화 예매 프로그램"); 
    System.out.println();
    Cgv3 a = new Cgv3();
    try { 
      a.arrayList();
      loop: while(true) {
        System.out.print("[1.예매]   [2.전체 예매현황]   [9.종료]");
        String sel = "9";
        sel = sc.nextLine();
        a.dbConnect();
        //a.screen();
        switch (sel) {
          case "1":
            a.getTitle(); 
            a.getDate();
            a.getTime();
            a.getSeat();
            a.pay(); break;
          case "2":
            a.dbSelect(); break;
          case "9": System.out.println("영화표 예매 프로그램 종료하겠습니다."); break loop;
          default : System.out.println("잘못입력하셨습니다."); continue;
        }
      }
    }catch(Exception ex){ }
  }
}