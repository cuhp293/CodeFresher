import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("1st page")),
      drawer: Drawer(
        backgroundColor: Colors.deepPurple[100],
        child: Column(
          children: [
            // common to place a drawer header here: A P P  L O G O
            DrawerHeader(
                child: Icon(
                  Icons.favorite,
                  size: 48,
                ),
            ),
            
            // home page list title
            ListTile(
              leading: Icon(Icons.home),
              title: Text("H O M E"),
              onTap: () {
                // pop drawer first
                Navigator.pop(context);

                // go to home page
                Navigator.pushNamed(context, '/homepage');
              },
            ),
            
            // setting page list title
            ListTile(
              leading: Icon(Icons.settings),
              title: Text("S E T T I N G S"),
              onTap: () {
                // pop drawer first
                Navigator.pop(context);

                // go to settings page
                Navigator.pushNamed(context, '/settingspage');
              },
            )
          ],
        ),
      ),
    );
  }
}
