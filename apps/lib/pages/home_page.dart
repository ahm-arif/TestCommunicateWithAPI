import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  @override
  _RedState createState() => _RedState();
}

class _RedState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
          "Beranda",
          style: TextStyle(
            fontSize: 20.0,
          ),
        ),
      ),
    );
  }
}
