import 'package:flutter/material.dart';

class MyBtn extends StatelessWidget {
  final String text;
  VoidCallback onPressed;

  MyBtn({
    super.key,
    required this.text,
    required this.onPressed,
  });

  @override
  Widget build(BuildContext context) {
    return MaterialButton(
      onPressed: onPressed,
      child: Text(text),
      color: Theme.of(context).primaryColor,
    );
  }
}
