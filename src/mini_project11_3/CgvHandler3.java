package mini_project11_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class CgvArray{//seat정보를 배열별로 담을 클래스 생성
  int floor; 
  int room; 
  String[][] name = new String[6][10];
}

public class CgvHandler3 {
  Connection CN=null; 
  Statement ST=null;  
  ResultSet RS=null; 
  String msg="";
  String jid;
  String jpw;
  String jname;
  int jpoint;
  String title;
  String time;
  String date;
  int ticketPrice;
  String seat;
  String payDate;
  String smsg="";
  String jmsg="";
  String msg1="";
  String aid;
  int apoint;
  public int atitle;
  public int adate;
  public int atime;
  CgvArray[][][] arrayTest = new CgvArray[3][7][6];//seat정보를 담을 배열 생성

  static Scanner sc = new Scanner(System.in);

  public void dbConnect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");   
    }catch(Exception ex){System.out.println("error =" + ex);}
  }//end
  public void jselect() {
    try {
      System.out.println();
      System.out.println("전체 데이터 출력 중입니다.");
      System.out.println();
      Thread.sleep(500);
      ST = CN.createStatement();
      msg ="select * from member";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String jid = rs.getString("mid");
        String jpw = rs.getString("mpw");
        String jname = rs.getString("mname");
        int jpoint = rs.getInt("mpoint");
        System.out.println(jid +"\t" + jpw+"\t" + jname+"\t" + jpoint);
      }
      System.out.println();
    }catch(Exception ex) { System.out.println("에러 이유 " + ex);} 
  }

  public void dbSelect() {
    try {
      System.out.println();
      System.out.println("전체 데이터 출력 중입니다.");
      System.out.println();
      Thread.sleep(500);
      ST = CN.createStatement();
      smsg ="select * from cinema";
      ResultSet rs = ST.executeQuery(smsg);
      while(rs.next()==true) {
        String stitle = rs.getString("title");
        String sdate = rs.getString("mdate");
        String stime = rs.getString("time");
        int sticketPrice = rs.getInt("price");
        String sseat = rs.getString("seat");
        String spaydate = rs.getString("paydate");
        System.out.println(stitle +"\t" + sdate+"\t" + stime+"\t" + sticketPrice+"\t" + sseat+"\t"+spaydate);
      }
      System.out.println();
    }catch(Exception ex) { System.out.println("에러 이유 " + ex);} 
  }
  public void join() {
    try {
      System.out.print("아이디를 입력해주세요:(6자이하) ");
      jid = sc.nextLine();
      System.out.print("비밀번호를 입력해주세요:(6자이하) ");
      jpw = sc.nextLine();
      System.out.print("이름을 입력해주세요:(한글로3자이하) ");
      jname = sc.nextLine();

      jmsg="insert into member(mid, mpw, mname ) values('"+jid+"','"+jpw+"','"+jname+"')";
      ST=CN.createStatement();
      ST.executeUpdate(jmsg);
    }catch (Exception e) {System.out.println("에러이유 :" + e);}
  }

  public void getTitle() {
    try {
      while(true) {
        System.out.println();
        System.out.println("[1. 괴물]     [2. 어벤져스: 엔드게임]     [3. 극한직업]\n");
        System.out.print("관람하실 영화의 번호를 입력하세요.>> ");
        title =sc.nextLine();
        System.out.println();
        switch(title) {
          case "1": title="괴물"; atitle=0; break;
          case "2": title="어벤져스: 엔드게임"; atitle=1; break;
          case "3": title="극한직업"; atitle=2; break;
          default : System.out.println("다시 선택해 주세요."); continue;
        }
        System.out.println( title +" 선택하셨습니다.");
        break;
      }
    }catch(Exception ex){System.out.println("error =" + ex);}
  }

  public void getDate() {
    try {
      while(true) {
        System.out.println();
        System.out.print("19일 ~ 25일 중에 입력해 주세요.(예: 19)>> ");
        date = sc.nextLine();
        switch(date) {
          case "19": date="19일"; adate=0; break;
          case "20": date="20일"; adate=1; break;
          case "21": date="21일"; adate=2; break;
          case "22": date="22일"; adate=3; break;
          case "23": date="23일"; adate=4; break;
          case "24": date="24일"; adate=5; break;
          case "25": date="25일"; adate=6; break;
          default: System.out.println(); 
          System.out.println("다시 입력해 주세요."); continue;
        }
        System.out.println();
        System.out.println("7월 "+date+"로 예약 완료\n");
        break;
      }
    } catch(Exception ex) { System.out.println("error = " + ex);} 
  }

  public void getTime() {
    while(true) {
      try {
        System.out.println("[ 시간대 선택 - 조조 / 일반 / 심야 ]");
        System.out.println();
        System.out.println("조조 할인 시간 (10,000원) : [1] AM  8:00 - 10:00 \t[2] AM 10:00 - 12:00 \n");
        System.out.println("일반 상영 시간 (14,000원) : [3] PM  2:00 -  4:00 \t[4] PM  4:00 -  6:00 \n");    
        System.out.println("심야 상영 시간 (12,000원) : [5] PM  8:00 - 10:00 \t[6] PM 10:00 - 12:00 \n");
        System.out.print("1번 ~ 6번 중에서 시간을 선택해 주세요.>> ");
        String timeSelect = sc.nextLine();
        switch (timeSelect) {
          case "1":
            time = "AM 8:00 - 10:00";
            ticketPrice = 10000; atime=0;
            break;
          case "2":
            time = "PM 10:00 - 12:00";
            ticketPrice = 10000; atime=1;
            break;
          case "3":
            time = "PM 2:00 - 4:00";
            ticketPrice = 14000; atime=2;
            break;
          case "4":
            time = "PM 4:00 - 6:00";
            ticketPrice = 14000; atime=3;
            break;
          case "5":
            time = "PM 8:00 - 10:00";
            ticketPrice = 12000; atime=4;
            break;
          case "6":  
            time = "PM 10:00 - 12:00";
            ticketPrice = 12000; atime=5;
            break;
          default: System.out.println(); 
          System.out.println("올바른 시간을 선택해 주세요.\n"); continue;
        }
      }catch (Exception e) {}
      System.out.println();
      System.out.print("선택한 시간이 맞습니까?>> Y / n ");
      String ans = sc.nextLine();
      if (ans.equals("Y")) {
        System.out.println();
        System.out.println("시간: "+time+", 티켓비용: "+ticketPrice+"원");
        System.out.println();
        return;
      } else {
        System.out.println();
        System.out.println("다시 선택해 주세요.\n");
        continue;
      }
    }  
  }

  public void arrayList() {
    //ArrayTest 배열 생성
    for(int i = 0; i < 3; i++) {
      for (int j = 0; j < 7; j++) {
        for (int k = 0 ; k < 6; k++) {
          arrayTest[i][j][k]=new CgvArray();
        }
      }
    }
  }

  public void getSeat() {
    try {
      while(true) {
        System.out.print("어느 열을 선택하시겠습니까?(A열 ~ F열)>> ");
        String row = sc.nextLine();
        switch(row) {
          case "A" : arrayTest[atitle][adate][atime].floor=1; break;
          case "B" : arrayTest[atitle][adate][atime].floor=2; break;
          case "C" : arrayTest[atitle][adate][atime].floor=3; break;
          case "D" : arrayTest[atitle][adate][atime].floor=4; break;
          case "E" : arrayTest[atitle][adate][atime].floor=5; break;
          case "F" : arrayTest[atitle][adate][atime].floor=6; break;
          default : System.out.println();
          System.out.println("다시 입력해 주세요.\n"); continue;
        }

        System.out.println();
        System.out.print("몇 번을 선택하시겠습니까?(1번 ~ 10번까지)>> ");
        arrayTest[atitle][adate][atime].room = Integer.parseInt(sc.nextLine());
        if(arrayTest[atitle][adate][atime].room < 1 || arrayTest[atitle][adate][atime].room >10) {
          System.out.println("해당 번호는 존재하지 않습니다.\n"); continue;
        }

        if(arrayTest[atitle][adate][atime].name[arrayTest[atitle][adate][atime].floor-1][arrayTest[atitle][adate][atime].room-1] == null) {//name 배열에 값을 넣는 메소드 .. 값을 넣을 때 배열에 넣어두면 배열대로 저장됨.
          System.out.println();
          System.out.print("이름을 입력하세요.>> ");
          arrayTest[atitle][adate][atime].name[arrayTest[atitle][adate][atime].floor-1][arrayTest[atitle][adate][atime].room-1] = sc.nextLine();
          System.out.println();
          System.out.println("좌석 예약 완료"); 
        } else {
          System.out.println("이미 예약된 좌석입니다.\n"); continue;
        }

        System.out.println("\n\t\t\t\t\t\t\t\t\t[ S C R E E N ]");
        System.out.println();
        String a= "ABCDEF";
        for(int i = 0; i < 6; i++) {
          for(int j = 0; j < 10; j++) {
            if(arrayTest[atitle][adate][atime].name[i][j] == null) {
              System.out.print(" " + (a.charAt(i))+(j+1) +"좌석"+"□\t"); 
            } else {
              System.out.print( " " + (a.charAt(i))+(j+1) +"좌석"+"■ " + arrayTest[atitle][adate][atime].name[i][j]+"\t"); 
            }
          } //j end
          System.out.println();
        }//for i end
        seat=row+Integer.toString(arrayTest[atitle][adate][atime].room); break;
      }
    }catch (Exception e) {System.out.println("에러 이유:"+ e);}//end
  }

  public void pay() {
    try {
      while(true) {
        System.out.println();
        System.out.print("현대카드 20% 할인받을 수 있는데 받으시겠어요? Y / N ");
        String card = sc.nextLine();
        double discount = 1;
        if(card.equals("Y")) {
          System.out.println();
          System.out.println((int)(ticketPrice*0.8)+"원입니다.\n");
          discount=0.8;
        } else if(card.equals("N")){
          System.out.println("할인받지 않고 결제하겠습니다.");
          System.out.println();
        } else {System.out.println("잘못 입력했습니다. 다시 입력하세요."); continue;}

        while(true) {
          System.out.print("포인트 적립 하시겠어요? Y / N ");
          String point = sc.nextLine();
          if (point.equals("Y")) {
            System.out.println("아이디를 입력하세요: ");
            /*member id 필드를 넣어야함*/aid = sc.nextLine();
            apoint=(int)(ticketPrice*0.1);
            System.out.println("추가될 포인트는"+apoint+ "점입니다.\n");
          }else if(point.equals("N")){
            System.out.println("포인트 적립하지 않고 결제하겠습니다.");
            System.out.println();
          } else {System.out.println("잘못 입력했습니다. 다시 입력하세요."); continue;}

          System.out.print("결제하시겠습니까? Y / N ");
          String ans = sc.nextLine();
          if (ans.equals("Y")) {
            ticketPrice = (int)(ticketPrice * discount);
            System.out.println();
            System.out.println("시간: "+time+", 티켓비용: "+ticketPrice+"원");
            System.out.println();
            StringBuffer stringBuffer = new StringBuffer();
            Date now = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            simpleDateFormat.format(now, stringBuffer, new FieldPosition(0));
            payDate=stringBuffer.toString();
            System.out.println(payDate);
            System.out.println();
            System.out.println("+------------------------------------------------+"); Thread.sleep(300);
            System.out.println();Thread.sleep(300);
            System.out.println("    \t\t[비트영화관]     ");Thread.sleep(300);
            System.out.println();Thread.sleep(300);
            System.out.println(" 영화제목: "+title);Thread.sleep(300);
            System.out.println();Thread.sleep(300);
            System.out.println(" 상영일  : 7월 "+date);Thread.sleep(300);
            System.out.println(" 상영시간: "+time);Thread.sleep(300);
            System.out.println(" 좌석번호: "+seat);Thread.sleep(300);
            System.out.println();Thread.sleep(300);
            System.out.println();Thread.sleep(300);
            System.out.println("                \t포인트:"+apoint+"점");Thread.sleep(300);
            System.out.println("                \t가격  : "+ticketPrice+"원");Thread.sleep(300);
            System.out.println("                \t결제일: "+payDate);Thread.sleep(300);
            System.out.println();
            System.out.println("+------------------------------------------------+");Thread.sleep(300);
            System.out.println();
            msg="insert into cinema values('"+title+"','"+date+"','"+time+"',"+ticketPrice+",'"+seat+"','"+payDate+"')";
            System.out.println(aid);
            msg1="update member set mpoint=mpoint+"+apoint+" where mid="+"'"+aid+"'";
            ST=CN.createStatement();
            ST.executeUpdate(msg);
            ST.executeUpdate(msg1);
            return;
          } else if(ans.equals("N")){
            System.out.println("처음으로 돌아갑니다.\n");

            arrayTest[atitle][adate][atime].name[arrayTest[atitle][adate][atime].floor-1][arrayTest[atitle][adate][atime].room-1] = null;

            return;
          } else {System.out.println("잘못 입력했습니다. 다시 입력하세요.");}
          continue;
        }
      }
    }catch (Exception e) {System.out.println("에러 이유: " + e);}
  }
}