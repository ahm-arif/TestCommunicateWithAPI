import 'package:flutter/material.dart';

class ConsultPage extends StatefulWidget {
  @override
  _ConsultState createState() => _ConsultState();
}

class _ConsultState extends State<ConsultPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            _buildSearchInput(),
          ],
        ),
      ),
    );
  }

  TextField _buildSearchInput() {
    return TextField(
      decoration: InputDecoration(
        hintText: "Cari kategori keluhan",
        prefixIcon: Icon(Icons.search),
        labelStyle: TextStyle(fontSize: 12.0),
        contentPadding: EdgeInsets.all(0.0),
        border: OutlineInputBorder(
            borderRadius: BorderRadius.all(Radius.circular(8.0))),
      ),
    );
  }
}
