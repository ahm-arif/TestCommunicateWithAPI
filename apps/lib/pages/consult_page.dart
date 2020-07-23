import 'package:flutter/material.dart';
import 'package:apps/constants/colors.dart';

class ConsultPage extends StatefulWidget {
  @override
  _ConsultState createState() => _ConsultState();
}

class _ConsultState extends State<ConsultPage> {
  final String complaintImage =
      "https://images.unsplash.com/photo-1520342868574-5fa3804e551c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6ff92caffcdd63681a35134a6770ed3b&auto=format&fit=crop&w=1951&q=80";

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(children: [
          _buildSearchInput(),
          _buildComplaintList(),
        ]),
      ),
    );
  }

  Widget _buildComplaintList() {
    return Expanded(
      child: GridView.count(
        crossAxisCount: 3,
        mainAxisSpacing: 4.0,
        crossAxisSpacing: 4.0,
        children: List.generate(50, (index) {
          return _buildComplaintItem();
        }),
      ),
    );
  }

  Widget _buildComplaintItem() {
    return GridTile(
      child: Card(
        elevation: 2.0,
        margin: EdgeInsets.all(0.0),
        child: Column(
          children: [
            ClipRRect(
              borderRadius: BorderRadius.vertical(top: Radius.circular(4.0)),
              child: Image.network(
                complaintImage,
                fit: BoxFit.cover,
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(4.0),
              child: Text(
                "Komplain",
                style: TextStyle(fontSize: 12.0),
                maxLines: 2,
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget _buildSearchInput() {
    return Container(
      decoration: BoxDecoration(
        color: greyBackground,
        borderRadius: BorderRadius.circular(4.0),
      ),
      padding: EdgeInsets.only(left: 8.0),
      margin: EdgeInsets.only(bottom: 8.0),
      child: TextField(
        decoration: InputDecoration(
          hintStyle: TextStyle(fontSize: 12.0),
          hintText: 'Cari kategori keluhan',
          suffixIcon: Icon(Icons.search),
          border: InputBorder.none,
        ),
      ),
    );
  }
}
