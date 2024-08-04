import java.io.*;
import java.util.*;
import java.sql.*
import javax.servlet.*;

@WebServlet("/TShirtServlet")
public class TShirtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tagLine = request.getParameter("tagline");
        String[] accessories = request.getParameterValues("accessory");
        String tShirtOption = request.getParameter("tShirtOption");
        String color = request.getParameter("color");

        String accessoryList = String.join(", ", accessories);

        // Database connection
        String url = "jdbc:mysql://localhost:3306/Home48";
        String user = "root";
        String password = "2314";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert the data into the database
            String sql = "INSERT INTO TShirts (tagLine, Accessories, Color, tShirtOption) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tagLine);
                pstmt.setString(2, accessoryList);
                pstmt.setString(3, color);
                pstmt.setString(4, tShirtOption);
                pstmt.executeUpdate();
            }

            // Retrieve and display all records
            String selectSQL = "SELECT * FROM TShirts";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL); ResultSet rs = selectStmt.executeQuery()) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body><h2>T-Shirts Records</h2>");
                out.println("<table border='1'><tr><th>Tagline</th><th>Accessories</th><th>Color</th><th>Option</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getString("tagLine") + "</td>");
                    out.println("<td>" + rs.getString("Accessories") + "</td>");
                    out.println("<td>" + rs.getString("Color") + "</td>");
                    out.println("<td>" + rs.getString("tShirtOption") + "</td></tr>");
                }
                out.println("</table></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
