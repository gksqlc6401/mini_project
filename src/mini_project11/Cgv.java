package mini_project11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  String payDate;

  public static void main(String[] args) {

    System.out.println("\t\t\tC G V");
    System.out.println("\t\t영화 예매 프로그램"); 
    System.out.println();

    Cgv a = new Cgv();
    try { 
      loop: while(true) {
        System.out.print("[1.예매]   [2.전체 예매현황]   [9.종료]");
        int sel = 9;
        sel = Integer.parseInt(sc.nextLine());
        a.dbConnect();

        switch (sel) {
          case 1:
            a.getTitle(); 
            a.getDate();
            a.getTime();
            a.getSeat();
            a.pay(); break;
          case 2:
            a.dbSelect(); break;
          case 9: System.out.println("영화표 예매 프로그램 종료하겠습니다."); break loop;
          default : System.out.println("잘못입력하셨습니다."); continue;
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

  public void getTitle() {
    try {
      while(true) {
        System.out.println();
        System.out.println("[1.괴물]     [2.어벤져스:엔드게임]     [3.극한직업]\n");
        System.out.print("상영하실 영화번호를 입력하세요: ");
        title =sc.nextLine();
        System.out.println();
        switch(title) {
          case "1": title="괴물"; break;
          case "2": title="어벤져스:엔드게임"; break;
          case "3": title="극한직업"; break;
          default : System.out.println("다시선택해주세요"); continue;
        }
        System.out.println();
        System.out.println( title +" 선택하셨습니다");
        break;
      }
    }catch(Exception ex){System.out.println("error =" + ex);}
  }

  public void getDate() {
    try {
      while(true) {
        System.out.println();
        System.out.print("19일 ~ 25일 중에 입력해 주세요(예: 19)>> \n");
        date = sc.nextLine();
        switch(date) {
          case "19": date="19일"; break;
          case "20": date="20일"; break;
          case "21": date="21일"; break;
          case "22": date="22일"; break;
          case "23": date="23일"; break;
          case "24": date="24일"; break;
          case "25": date="25일"; break;
          default: System.out.println("다시입력해주세요\n"); continue;
        }
        System.out.println();
        System.out.println("7월 "+date+"로 예약 완료\n");
        break;
      }
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
          case 1 :
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

    try {
      while(true) {
        System.out.print("결제 하시겠습니까? Y/N");
        String ans = sc.nextLine();
        if (ans.equals("Y")) {
          System.out.println("시간 : "+time+" , 티켓비용 : "+ticketPrice);
          System.out.println();

          StringBuffer stringBuffer = new StringBuffer();
          Date now = new Date();

          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
          simpleDateFormat.format(now, stringBuffer, new FieldPosition(0));
          payDate=stringBuffer.toString();
          System.out.println(payDate);

          System.out.println("+------------------------------------------------+"); Thread.sleep(300);
          System.out.println();Thread.sleep(300);
          System.out.println("    \t\t[비트영화관]     ");Thread.sleep(300);
          System.out.println();Thread.sleep(300);
          System.out.println(" 영화제목 :"+title);Thread.sleep(300);
          System.out.println();Thread.sleep(300);
          System.out.println(" 상영일   :7월 "+date);Thread.sleep(300);
          System.out.println(" 상영시간 :"+time);Thread.sleep(300);
          System.out.println(" 좌석번호 :"+seat);Thread.sleep(300);
          System.out.println();Thread.sleep(300);
          System.out.println();Thread.sleep(300);
          System.out.println("                  \t가격  :"+ticketPrice);Thread.sleep(300);
          System.out.println("                  \t결제일:"+payDate);Thread.sleep(300);
          System.out.println("+-----------------------------------------------+");Thread.sleep(300);

          msg="insert into cinema values('"+title+"','"+date+"','"+time+"',"+ticketPrice+",'"+seat+"','"+payDate+"')";
          ST=CN.createStatement();
          int rs = ST.executeUpdate(msg);
          return;
        }else if(ans.equals("N")){
          System.out.println("처음으로 돌아가시겠습니까?");
          return;
        }else {System.out.println("잘못입력했습니다.");}
        continue;
      }
    }catch (Exception e) {System.out.println("에러이유: " + e);}
  }
}