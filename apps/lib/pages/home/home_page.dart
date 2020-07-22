import 'package:apps/constants/colors.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  HomePage({Key key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  String avatarUrl =
      "https://www.inpixio.com/remove-background/images/animation-light-square.gif";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _buildAppBar(),
      body: Center(),
      bottomNavigationBar: _buildBottomNavigationBar(),
    );
  }

  AppBar _buildAppBar() {
    return AppBar(
      title: Text("Wellness Center"),
      backgroundColor: primaryColor,
      actions: _buildAppBarActions(),
    );
  }

  List<Widget> _buildAppBarActions() {
    return [
      IconButton(icon: Icon(Icons.notifications), onPressed: () {}),
      IconButton(icon: Icon(Icons.message), onPressed: () {}),
      Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            CircleAvatar(
              radius: 15,
              backgroundImage: NetworkImage(avatarUrl),
            )
          ],
        ),
      )
    ];
  }

  Widget _buildBottomNavigationBar() {
    return Theme(
      data: Theme.of(context).copyWith(
        canvasColor: primaryColor,
        primaryColor: Colors.white,
        textTheme: Theme.of(context)
            .textTheme
            .copyWith(caption: TextStyle(color: Colors.black54)),
      ),
      child: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        items: [
          BottomNavigationBarItem(
            icon: new Icon(Icons.home),
            title: new Text('Beranda'),
          ),
          BottomNavigationBarItem(
            icon: new Icon(Icons.help),
            title: new Text('Konsultasi'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.date_range),
            title: Text('Jadwal'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            title: Text('Akun'),
          ),
        ],
      ),
    );
  }
}
