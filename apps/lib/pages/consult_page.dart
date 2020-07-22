import 'package:flutter/material.dart';

class ConsultPage extends StatefulWidget {
  @override
  _RedState createState() => _RedState();
}

class _RedState extends State<ConsultPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
          "Konsultasi",
          style: TextStyle(fontSize: 20.0),
        ),
      ),
    );
  }
}
