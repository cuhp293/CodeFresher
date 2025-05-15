import 'package:hive_flutter/hive_flutter.dart';

class ToDoDatabase {
  List toDoList = [];

  // reference our box
  final _myBox = Hive.openBox('myBox');
}