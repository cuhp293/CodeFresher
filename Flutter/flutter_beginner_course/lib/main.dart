import 'package:flutter/material.dart';
import 'package:flutter_beginner_course/pages/first_page.dart';
import 'package:flutter_beginner_course/pages/second_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    List names = ['Mitch', 'Sharon', 'Vince'];
    return MaterialApp(
      debugShowCheckedModeBanner: false, // hide Debug Banner in phone (demo)
      home: FirstPage(),
      routes: {
        '/firstpage': (context) => FirstPage(),
        '/secondpage': (context) => SecondPage(),
      },
    );
  }
}