import 'package:flutter/material.dart';

class AccountPage extends StatefulWidget {
  @override
  _RedState createState() => _RedState();
}

class _RedState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text(
          "Akun",
          style: TextStyle(fontSize: 20.0),
        ),
      ),
    );
  }
}
