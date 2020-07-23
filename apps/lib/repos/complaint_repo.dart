import 'dart:convert';

import 'package:apps/models/complaint.dart';
import 'package:http/http.dart' as http;

class ComplaintRepo {
  final String baseUrl = "http://10.0.2.2:8080/api";

  Future<List<Complaint>> getComplaintList() async {
    final response = await http.get(baseUrl + '/complaints');
    if (response.statusCode == 200) {
      List data = json.decode(response.body)["data"];
      return data.map((e) => Complaint.fromJson(e)).toList();
    }
    return List.empty();
  }
}
