import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // functions & methods
  void userTapped() {
    print("User tapped on function!");
  }

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
        body: Center(
          child: GestureDetector(
            /* onTap: () {
              // do something, user tapped the container.
              print("User tapped!");
            }, */
            onTap: userTapped,
            child: Container(
              height: 200,
              width: 200,
              color: Colors.deepPurple,
              child: Center(child: Text("Tap me!")),
            ),
          ),
        ),
      ),
    );
  }
}