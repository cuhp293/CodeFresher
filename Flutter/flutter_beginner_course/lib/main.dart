import 'package:flutter/material.dart';

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
      home: Scaffold(
        backgroundColor: Colors.green[100],
        appBar: AppBar(
          title: Text("My App Bar"),
          backgroundColor: Colors.green,
          elevation: 0,
          leading: Icon(Icons.menu),
          actions: [
            IconButton(onPressed: () {}, icon: Icon(Icons.logout)),
          ],
        ),
        body: Stack(
          alignment: Alignment.center,
          children: [
            // big box
            Container(
              height: 300,
              width: 300,
              color: Colors.deepPurple,
            ),

            // medium box
            Container(
              height: 200,
              width: 200,
              color: Colors.deepPurple[400],
            ),

            // small box
            Container(
              height: 100,
              width: 100,
              color: Colors.deepPurple[200],
            ),

          ],
        ),
      ),
    );
  }
}