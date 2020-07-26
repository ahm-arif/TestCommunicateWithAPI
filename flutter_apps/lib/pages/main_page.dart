import 'package:flutter/material.dart';
import 'package:flutter_apps/constants/colors.dart';
import 'package:flutter_apps/pages/consult_page.dart';

import 'account_page.dart';
import 'home_page.dart';
import 'schedule_page.dart';

class MainPage extends StatefulWidget {
  MainPage({Key key}) : super(key: key);

  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  String avatarUrl =
      "https://www.inpixio.com/remove-background/images/animation-light-square.gif";

  int currentPage = 1;
  PageController pageController =
      PageController(initialPage: 1, keepPage: true);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBar,
      body: pageView,
      bottomNavigationBar: bottomNavigationBar,
    );
  }

  Widget get appBar {
    final appBarTitle = "Wellness Center";
    return AppBar(
      title: Text(appBarTitle),
      backgroundColor: primaryColor,
      actions: [
        IconButton(icon: Icon(Icons.notifications), onPressed: () {}),
        IconButton(icon: Icon(Icons.message), onPressed: () {}),
        appBarAvatar
      ],
    );
  }

  Widget get appBarAvatar {
    final avatarRadius = 15.0;
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          CircleAvatar(
            radius: avatarRadius,
            backgroundImage: NetworkImage(avatarUrl),
          )
        ],
      ),
    );
  }

  Widget get bottomNavigationBar {
    final textTheme = Theme.of(context)
        .textTheme
        .copyWith(caption: TextStyle(color: Colors.black54));

    return Theme(
      data: Theme.of(context).copyWith(
        canvasColor: primaryColor,
        primaryColor: Colors.white,
        textTheme: textTheme,
      ),
      child: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: currentPage,
        items: bottomNavigationBarItems,
        onTap: (index) {
          setState(() {
            currentPage = index;
            pageController.animateToPage(
              index,
              duration: Duration(milliseconds: 500),
              curve: Curves.ease,
            );
          });
        },
      ),
    );
  }

  List<BottomNavigationBarItem> get bottomNavigationBarItems {
    return [
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
    ];
  }

  Widget get pageView {
    return PageView(
      controller: pageController,
      onPageChanged: (index) {
        setState(() {
          currentPage = index;
        });
      },
      children: <Widget>[
        HomePage(),
        ConsultPage(),
        SchedulePage(),
        AccountPage()
      ],
    );
  }
}
