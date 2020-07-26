import 'package:flutter/material.dart';
import 'package:flutter_apps/pages/video_call_request_page.dart';

class ConsultPage extends StatefulWidget {
  @override
  _ConsultState createState() => _ConsultState();
}

class _ConsultState extends State<ConsultPage> {
  final List<String> entries = <String>['A', 'B', 'C'];
  final List<int> colorCodes = <int>[600, 500, 100];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
          'Jadwal Konsultasi',
          style: TextStyle(fontSize: 32),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showVideoCallPage();
        },
        child: Icon(Icons.call),
      ),
    );
  }

  showVideoCallPage() {
    Navigator.push(context,
        MaterialPageRoute(builder: (context) => VideoCallRequestPage()));
  }
}
