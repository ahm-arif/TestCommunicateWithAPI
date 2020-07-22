import 'package:flutter/material.dart';

class SchedulePage extends StatefulWidget {
  @override
  _RedState createState() => _RedState();
}

class _RedState extends State<SchedulePage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
          "Jadwal",
          style: TextStyle(fontSize: 20.0),
        ),
      ),
    );
  }
}
