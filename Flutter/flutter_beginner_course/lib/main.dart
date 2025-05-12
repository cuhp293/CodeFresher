import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
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
        body: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            // 1st box
            Container(
              height: 200,
              width: 200,
              color: Colors.deepPurple,
            ),

            // 2nd box
            Expanded(
              child: Container(
                width: 200,
                color: Colors.deepPurple[400],
              ),
            ),

            // 3rd box
            Expanded(
              flex: 1,
              child: Container(
                width: 200,
                color: Colors.deepPurple[100],
              ),
            ),
          ],
        ),
      ),
    );
  }
}