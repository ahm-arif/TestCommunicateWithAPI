import 'package:flutter/material.dart';
import 'package:flutter_apps/constants/colors.dart';

class VideoCallRequestPage extends StatefulWidget {
  @override
  _VideoCallRequestPageState createState() => _VideoCallRequestPageState();
}

class _VideoCallRequestPageState extends State<VideoCallRequestPage> {
  String avatarUrl =
      "https://www.inpixio.com/remove-background/images/animation-light-square.gif";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Align(child: doctorProfile, alignment: Alignment.center),
          Align(child: waitingText, alignment: Alignment.bottomCenter),
        ],
      ),
    );
  }

  Widget get doctorProfile {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Padding(
            padding: const EdgeInsets.only(bottom: 32.0),
            child: CircleAvatar(
              radius: 60.0,
              backgroundImage: NetworkImage(avatarUrl),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'Berikan waktu untuk\nmenghubungkan dengan:',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 18.0),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'Dokter A',
              style: Theme.of(context).textTheme.headline5,
            ),
          ),
        ],
      ),
    );
  }

  Widget get waitingText {
    return Padding(
      padding: const EdgeInsets.only(bottom: 32.0),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'Mohon menunggu',
              style: TextStyle(fontSize: 18.0),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('10 detik',
                style: TextStyle(fontSize: 24.0, color: primaryColor)),
          ),
        ],
      ),
    );
  }
}
