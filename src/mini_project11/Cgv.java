package mini_project11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Cgv {
  Connection CN=null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST=null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
  ResultSet RS=null;  //select조회결과값 전체데이터를 기억합니다
  String msg="";
  int Gtotal = 0;  
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\t\t\tC G V");
    System.out.println("\t\t영화 예매 프로그램"); 
    System.out.println();

    Cgv a = new Cgv();
    try { 
      while (true) {
        int sel= 9;
        System.out.println("1.영화제목  2.날짜 3.시간 4.좌석 5.결제 6.결제일 9.종료"); 
        sel = Integer.parseInt(sc.nextLine());

        switch (sel) {
          case 1: a.dbConnect(); break;
          case 2: a.dbSelect(); break;
          case 3: a.getTitle(); break;
          case 4: a.getInsert(); break;
          case 9: 
          default :
            System.out.println("번호를 잘못 입력하셨습니다.");
            break;
        }
      }
    }catch(Exception ex){ }
  }

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      System.out.println("오라클 드라이브및 서버연결성공");   
    }catch(Exception ex){System.out.println("error =" + ex);}
  }//end

  public void dbSelect() {
    try {
      System.out.println("112233전체 데이터출력중입니다.");
      Thread.sleep(500);
      ST = CN.createStatement();
      msg ="select * from cinema";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String utitle = rs.getString("title");
        String udate = rs.getString("mdate");
        String utime = rs.getString("time");
        int uprice = rs.getInt("price");
        String useat = rs.getString("seat");
        String upaydate = rs.getString("paydate");
        System.out.println(utitle +"\t" + udate+"\t" + utime+"\t" + uprice+"\t" + useat+"\t"+upaydate);

      }
    }catch(Exception ex) { System.out.println("에러이유 " + ex);} 
  }

  public void getInsert() {
    ST=CN.createStatement();
    ResultSet rs = ST.executeQuery(msg);
    System.out.println("변경하실 영화제목을 입력하세요:");
    String utitle=sc.nextLine();
    System.out.println("변경하실 날짜를 입력하세요:");
    String udate=sc.nextLine();
    System.out.println("변경하실 시간을 입력하세요:");
    String utime=sc.nextLine();
    System.out.println("변경하실 좌석을 입력하세요:");
    string useat=sc.nextLine();
    msg="insert into cinema(utitle,) values(
  }
  public void getTitle() {
    System.out.println();
    System.out.println("1.괴물 2.어벤져스:엔드게임 3.극한직업");
    System.out.println("상영하실 영화를 입력하세요: ");
    String movie =sc.nextLine();
    System.out.println(movie+" 선택하셨습니다");

  }

  /*public void getDate() {

  }

  public void getTime() {

  }

  public void getSeat() {

  }

  public void pay() {

  }*/
}