void main() {
  // Variable
  int a = 1;
  String msg1 = 'Hi';
  String msg2 = "Hi";
  // msg1 == msg2

  String msg3 = "Hi $a";
  String msg4 = "Hi " + a.toString();
  // msg3 == msg4

  /*
    kiểu danh sách: (mảng - array tích hợp vào danh sách)
    List - giống set: các phần tử không trùng lặp (dấu “{}”, còn dấu “[]” vẫn trùng được)
   */
  var list1 = [1, 2, 3];
  List<int> list2 = [1, 2, 3];
  // list1 == list2
  list1.add(4);
  list1[0] = 0;
  print('list1 after change: $list1');
  list1.removeAt(0);
  print('list1 after remove: $list1');

  /*
    Cách 2: Dùng biến var: không khai báo kiểu, Dart tự hiểu (int, String)
  */
  var name = 'Voyager I';
  var year = 1977;
  var antennaDiameter = 3.7; // double
  var flybyObjects = ['Jupiter', 'Saturn', 'Uranus', 'Neptune'];
  var image = {
    'tags': ['saturn'],
    'url': '//path/to/saturn.jpg',
  };

  // ========================================================================================================
  // Function
  fun1();
  msg4 = 'Hi ${fun2()}';
  print(msg4);

  // ========================================================================================================
  // Class
  var b = A(1, 3);
  /* OR
    var b = new A(1, 3);
   */
  print("b - $b");
}

// Function
void fun1() {
  print('fun1');
}
String fun2() {
  var msg = 'fun2';
  return msg;
}

// Class
class A {
  int x;
  int y;

  A(this.x, this.y);

  @override
  String toString() {
    return 'class A: $x, $y';
  }
  /* OR
		@override
		String toString() => 'A: $x, $y';
	*/
}