package mini_project11_1;
import java.util.Scanner;
public class CinemaProject_TimePart {


  static class TicketInfo{
    String time;
    int ticketPrice;
  }

  void getTime(){

    Scanner sc = new Scanner(System.in);
    TicketInfo ticketInfo = new TicketInfo();

    System.out.println("[시간대 선택 - 조조 / 일반 / 심야 ] ");
    System.out.println("조조 할인 시간 (10,000원) : [1] AM  8:00 - 10:00 [2] AM 10:00 - 12:00 ");
    System.out.println("일반 상영 시간 (14,000원) : [3] PM  2:00 -  4:00 [4] PM  4:00 -  6:00 ");    
    System.out.println("심야 상영 시간 (12,000원) : [5] PM  8:00 - 10:00 [6] PM 10:00 - 12:00 ");
    System.out.println("시간을 선택해주세요. 1 ~ 6 ");



    int timeSelect = Integer.parseInt(sc.nextLine());


    switch(timeSelect) {
      case 1:
        ticketInfo.time = "AM 8:00 - 10:00";
        ticketInfo.ticketPrice = 10000;
        break;
      case 2:
        ticketInfo.time = "PM 10:00 - 12:00";
        ticketInfo.ticketPrice = 10000;
        break;
      case 3:
        ticketInfo.time = "PM 2:00- 4:00";
        ticketInfo.ticketPrice = 14000;
        break;
      case 4:
        ticketInfo.time = "PM 4:00 - 6:00";
        ticketInfo.ticketPrice = 14000;
        break;
      case 5:
        ticketInfo.time = "PM 8:00 - 10:00";
        ticketInfo.ticketPrice = 12000;
        break;
      case 6:  
        ticketInfo.time = "PM 10:00 - 12:00";
        ticketInfo.ticketPrice = 12000;
        break;
      default:
        System.out.println("올바른 시간을 선택해주세요.");
        break;


    }
    System.out.println("선택한 시간이 맞습니까? Y / N ");
    System.out.println("시간 : "+ticketInfo.time+" , 티켓비용 : "+ticketInfo.ticketPrice);



  }



  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CinemaProject_TimePart test = new CinemaProject_TimePart();
    test.getTime();



  }

}
