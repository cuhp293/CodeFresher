import 'package:flutter/material.dart';
import 'package:flutter_beginner_course/pages/second_page.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("1st page")),
      body: Center(
        child: ElevatedButton(
            onPressed: () {
              // navigate to 2nd page
              Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => SecondPage(),
                  ),
              );
            },
            child: Text("Go to 2nd page!"),
        ),
      ),
    );
  }
}
