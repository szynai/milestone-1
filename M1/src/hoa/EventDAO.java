
package hoa;

import java.sql.*;

public class EventDAO {

    public void addEvent(Event e) {

         if (e.getName().isEmpty() ||
            e.getContact().isEmpty() ||
            e.getEventName().isEmpty() ||
            e.getEventDate().isEmpty() ||
            !e.getContact().matches("\\d{10,11}")) {

            System.out.println("Event Registration Failed!");
        }else
             System.out.println("Event Registration Successfully.");


        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO events (name, contact, event_name, event_date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getContact());
            ps.setString(3, e.getEventName());
            ps.setString(4, e.getEventDate());
            ps.setString(5, e.getStatus());

            int rows = ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void viewEvents() {
        try {
            Connection conn = DBConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM events");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("contact") + " | " +
                    rs.getString("event_name") + " | " +
                    rs.getString("event_date") + " | " +
                    rs.getString("status")
                );
            }

            //  NO DATA CASE
            if (!hasData) {
                System.out.println("No events available.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // CANCEL EVENT
    public void cancelEvent(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE events SET status = 'Cancelled' WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            //  CHECK IF EVENT EXISTS
            if (rows > 0) {
                System.out.println("Event cancelled!");
            } else {
                System.out.println("Event not found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}