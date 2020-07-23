import 'package:apps/constants/colors.dart';
import 'package:apps/pages/account_page.dart';
import 'package:apps/pages/consult_page.dart';
import 'package:apps/pages/home_page.dart';
import 'package:apps/pages/schedule_page.dart';
import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  MainPage({Key key}) : super(key: key);

  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  String avatarUrl =
      "https://www.inpixio.com/remove-background/images/animation-light-square.gif";

  int _currentPage = 1;

  PageController _pageController = PageController(
    initialPage: 1,
    keepPage: true,
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _buildAppBar(),
      body: _buildPageView(),
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
        currentIndex: _currentPage,
        onTap: (index) {
          setState(() {
            _currentPage = index;
            _pageController.animateToPage(index,
                duration: Duration(milliseconds: 500), curve: Curves.ease);
          });
        },
        items: _buildBottomNavigationItems(),
      ),
    );
  }

  List<BottomNavigationBarItem> _buildBottomNavigationItems() {
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

  Widget _buildPageView() {
    return PageView(
      controller: _pageController,
      onPageChanged: (index) {
        setState(() {
          _currentPage = index;
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
