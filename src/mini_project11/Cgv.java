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

  public int floor; //층=행 3층
  public int room; 
  public String[][] name = new String[6][10];
  String title;
  String time;
  String date;
  int ticketPrice;
  String seat;
  String payDate="ddd";

  public static void main(String[] args) {

    System.out.println("\t\t\tC G V");
    System.out.println("\t\t영화 예매 프로그램"); 
    System.out.println();

    Cgv a = new Cgv();
    try { 
      a.dbConnect();
      // a.dbSelect(); 
      a.getTitle(); 
      a.getDate();
      a.getTime();
      a.getSeat();
      a.getInsert();
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
        String stitle = rs.getString("title");
        String sdate = rs.getString("mdate");
        String stime = rs.getString("time");
        int sticketPrice = rs.getInt("price");
        String sseat = rs.getString("seat");
        String spaydate = rs.getString("paydate");
        System.out.println(stitle +"\t" + sdate+"\t" + stime+"\t" + sticketPrice+"\t" + sseat+"\t"+spaydate);

      }
    }catch(Exception ex) { System.out.println("에러이유 " + ex);} 
  }

  public void getInsert() {
    try {
      System.out.println("성공!");
      msg="insert into cinema values('"+title+"','"+date+"','"+time+"',"+ticketPrice+",'"+seat+"','"+payDate+"')";
      //ST=CN.createStatement();
      int rs = ST.executeUpdate(msg);
    }catch (Exception e) {System.out.println("에러이유:"+ e);}
  }




  /* msg="insert into test(code,name,title,wdate,cnt) values("+a+" , '"+b+"' , '"+c+"' , sysdate , 0)";        
  System.out.println(msg);


  //4번째 서버에서 실행 executeUpdate("insert~~")
  int OK = ST.executeUpdate(msg);
  if(OK>0) {
    System.out.println(a+ "코드 저장 성공했습니다");
  }else { System.out.println(a+ "코드 저장 실패했습니다");}

}catch(Exception ex) {System.out.println("에러이유" +ex);};

}
   */



  public void getTitle() {
    try {
      /*ST=CN.createStatement();
      RS=ST.executeQuery(msg);
      msg="insert into"*/
      System.out.println();
      System.out.println("1.괴물     2.어벤져스:엔드게임     3.극한직업\n");
      System.out.print("상영하실 영화를 입력하세요: ");
      title =sc.nextLine();
      System.out.println();
      System.out.println( title +" 선택하셨습니다");
    }catch(Exception ex){System.out.println("error =" + ex);}
  }

  public void getDate() {
    try {
      System.out.println();
      System.out.print("19일 ~ 25일 중에 입력해 주세요(예: 19)>> ");
      date = sc.nextLine();
      System.out.println();
      System.out.println("7월 "+date+"일로 예약 완료");
    } catch(Exception ex) { System.out.println("error = " + ex);} 
  }

  public void getTime() {

    Scanner sc = new Scanner(System.in);
    loop: while(true) {
      try {
        System.out.println("[시간대 선택 - 조조 / 일반 / 심야 ] ");
        System.out.println("조조 할인 시간 (10,000원) : [1] AM  8:00 - 10:00 \t[2] AM 10:00 - 12:00 \n");
        System.out.println("일반 상영 시간 (14,000원) : [3] PM  2:00 -  4:00 \t[4] PM  4:00 -  6:00 \n");    
        System.out.println("심야 상영 시간 (12,000원) : [5] PM  8:00 - 10:00 \t[6] PM 10:00 - 12:00 \n");
        System.out.println("시간을 선택해주세요. 1 ~ 6 ");
        System.out.println();

        int timeSelect = Integer.parseInt(sc.nextLine());
        switch (timeSelect) {
          case 1:
            time = "AM 8:00 - 10:00";
            ticketPrice = 10000;
            break;
          case 2:
            time = "PM 10:00 - 12:00";
            ticketPrice = 10000;
            break;
          case 3:
            time = "PM 2:00- 4:00";
            ticketPrice = 14000;
            break;
          case 4:
            time = "PM 4:00 - 6:00";
            ticketPrice = 14000;
            break;
          case 5:
            time = "PM 8:00 - 10:00";
            ticketPrice = 12000;
            break;
          case 6:  
            time = "PM 10:00 - 12:00";
            ticketPrice = 12000;
            break;
          default: System.out.println("올바른 시간을 선택해주세요.\n"); continue;

        }
      }catch (Exception e) {}
      System.out.println("선택한 시간이 맞습니까? Y /n ");
      String ans = sc.nextLine();
      if (ans.equals("Y")) {
        System.out.println("시간 : "+time+" , 티켓비용 : "+ticketPrice);
        System.out.println();
        return;
      }else {
        System.out.println("다시 선택해주세요");
        continue;
      }
    }  
  }

  public void getSeat() {

    try {
      System.out.print("무슨열 선택하시겠습니까?(A~F층까지)>>> ");
      String row = sc.nextLine();

      switch(row) {
        case "A" : floor=1; break;
        case "B" : floor=2; break;
        case "C" : floor=3; break;
        case "D" : floor=4; break;
        case "E" : floor=5; break;
        case "F" : floor=6; break;
        default : System.out.println("다시입력해주세요"); break;
      }
      if(floor <1  || floor >6) {
        System.out.println("해당 열은 존재하지 않습니다");
      }

      System.out.print("몇 번을 선택 하시겠습니까?(1~10번까지)>>> ");
      room = Integer.parseInt(sc.nextLine());
      if(room < 1 || room >10) {
        System.out.println("해당 번호는 존재하지 않습니다");
      }

      if(name[floor-1][room-1] == null) {
        System.out.print("이름을 입력하세요>>> ");
        name[floor-1][room-1] = sc.nextLine();

        System.out.println("객실 예약 완료");
      }else {
        System.out.println("이미 예약된 객실입니다");
      }
      System.out.println("\n\t\t\t\t\t\t\t\t\t[ S C R E E N ]");

      String a= "ABCDEF";
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 10; j++){
          if(name[i][j] == null) {

            System.out.print(" " + (a.charAt(i))+(j+1) +"좌석"+"□\t"); 
          }else {
            System.out.print( " " + (a.charAt(i))+(j+1) +"좌석"+"■ " + name[i][j]+"\t"); 
          }
        } //j end
        System.out.println();
      }//for i end
      seat=row+Integer.toString(room);
    }catch (Exception e) {System.out.println("에러이유:"+ e);}//end
  }
  public void pay() {
  }
}