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
  Scanner sc = new Scanner(System.in);

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      System.out.println("오라클 드라이브및 서버연결성공 ");   
      ST = CN.createStatement(); //반드시필수 
    }catch(Exception ex){System.out.println("error =" + ex);}
  }//end

  public static void main(String[] args) {

    System.out.println("\t\t\tC G V");
    System.out.println("\t\t영화 예매 프로그램"); 
    System.out.println();

    Cgv a = new Cgv();
    a.getTitle();
    a.getDate();
    a.getTime();
    a.getSeat();
    a.pay();
  }

  public void getTitle() {
    try {
      System.out.println("1.괴물 2.어벤져스:엔드게임 3.극한직업");
      System.out.println("상영하실 영화를 입력하세요: ");
      String movie =sc.nextLine();
      System.out.println(movie+" 선택하셨습니다");
    }catch (Exception e) {System.out.println("에러이유: "+ e);}
  }

  public void getDate() {

  }

  public void getTime() {

  }

  public void getSeat() {

  }

  public void pay() {

  }
}