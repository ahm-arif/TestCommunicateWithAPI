import 'package:flutter/material.dart';
import 'package:flutter_apps/constants/colors.dart';
import 'package:flutter_apps/models/complaint.dart';
import 'package:flutter_apps/repos/complaint_repo.dart';

class ConsultPage extends StatefulWidget {
  @override
  _ConsultState createState() => _ConsultState();
}

class _ConsultState extends State<ConsultPage> {
  final String complaintImage =
      "https://images.unsplash.com/photo-1520342868574-5fa3804e551c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=6ff92caffcdd63681a35134a6770ed3b&auto=format&fit=crop&w=1951&q=80";

  List<Complaint> complaints = List.empty(growable: true);

  @override
  void initState() {
    super.initState();
    ComplaintRepo().getComplaintList().then((value) {
      setState(() {
        complaints = value;
      });
    });
  }

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
      child: GridView.builder(
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 3,
            childAspectRatio: 1.0,
            mainAxisSpacing: 4.0,
            crossAxisSpacing: 4.0,
          ),
          itemCount: complaints.length,
          itemBuilder: (context, index) {
            return _buildComplaintItem(index);
          }),
    );
  }

  Widget _buildComplaintItem(int index) {
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
                height: 80.0,
                fit: BoxFit.cover,
              ),
            ),
            Expanded(
              child: Container(
                alignment: Alignment.center,
                child: Padding(
                  padding: const EdgeInsets.all(2.0),
                  child: Text(
                    complaints[index].name,
                    maxLines: 2,
                    textAlign: TextAlign.center,
                    style: TextStyle(fontSize: 12.0),
                  ),
                ),
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
