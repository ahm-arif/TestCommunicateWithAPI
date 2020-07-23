class Complaint {
  int id;
  String name;
  String description;

  Complaint.fromJson(Map<String, dynamic> json)
      : id = json["id"],
        name = json["name"],
        description = json["description"];
}
