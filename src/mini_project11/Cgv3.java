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
      a.dbConnect();
      loop: while(true) {
        System.out.print("[1.회원가입]    [2. 예매]    [3. 전체 예매 현황]    [4.회원목록 조회]   [9. 종료] ");
        String sel = "9";
        sel = sc.nextLine();
        switch (sel) {
          case "1":
            a.join(); break;
          case "2":
            a.getTitle(); 
            a.getDate();
            a.getTime();
            a.getSeat();
            a.pay(); break;
          case "3":
            a.dbSelect(); break;
          case "4":
            a.jselect(); break;

          case "9": System.out.println(); 
          System.out.println("영화 예매 프로그램 종료하겠습니다."); break loop;
          default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.\n"); continue;
        }
      }
    }catch(Exception ex){ }
  }
}