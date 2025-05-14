import 'package:flutter/material.dart';

class SecondPage extends StatefulWidget {
  const SecondPage({super.key});

  @override
  State<SecondPage> createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {

  // text editing controller to get access to what the user typed
  TextEditingController myController = TextEditingController();

  // greeting msg variable
  String greetingMessage = "";

  // greet user method
  void greetUser() {
    print(myController.text);
    setState(() {
      greetingMessage = "Hello, " + myController.text;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(25.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // greet user msg
              Text(greetingMessage),

              // text field
              TextField(
                controller: myController,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Type your name.."
                ),
              ),
          
              // button
              ElevatedButton(
                onPressed: greetUser,
                child: Text("Tap"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
