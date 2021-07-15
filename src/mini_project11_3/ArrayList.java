package mini_project11_3;

public class ArrayList {

  // 배열의 최대 크기를 지정하는 변수는 모든 인스턴스가 같다.
  // => 따라서 각 인스턴스 마다 이 변수를 가질 필요는 없다.
  // => 그러니 이 변수는 그냥 클래스 변수로 둔다.
  // => 보통 상수 변수(final 변수)는 클래스 변수(스태틱 변수)로 선언한다.
  static final int MAX_LENGTH = 100;

  //각 인스턴스 마다 개별적으로 관리해야 하는 변수는 인스턴스 변수로 선언한다.
  Object[] list = new Object[MAX_LENGTH];
  int size = 0;

  // 메서드가 작업할 때 인스턴스 변수를 사용할 수 있도록 파라미터로 인스턴스 주소를 전달한다.
  void append(Object obj) {
    this.list[this.size++] = obj;
  }


  Object[] toArray() {
    Object[] arr = new Object[this.size];

    for (int i = 0; i < this.size; i++)
      arr[i] = this.list[i];

    return arr;
  }


  Object retrieve(int index) {
    return this.list[index];
  }


  void remove(int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.list[i] = this.list[i+1];
    }

    this.size--;

  }
}
