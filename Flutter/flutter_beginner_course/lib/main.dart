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
        body: ListView.builder(
          itemCount: names.length,
          itemBuilder: (context, index) => ListTile(
            title: Text(names[index]),
          )
        ),
      ),
    );
  }
}