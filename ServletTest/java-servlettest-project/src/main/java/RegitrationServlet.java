import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.cj.jdbc.MysqlDataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegitrationServlet extends HttpServlet {
    private Connection jdbcConnection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Registration> listreg = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        Statement statement;
        try {
            connect();
            statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int registration_id = resultSet.getInt("registration_id");
                String event_name = resultSet.getString("event_name");
                String athlete_name = resultSet.getString("athlete_name");
                Date registration_date = resultSet.getDate("registration_date");
                Registration registration = new Registration(registration_id, event_name, athlete_name,
                        registration_date);
                listreg.add(registration);

            }

            // Gson gson = new
            // GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

            // 12. Events that occurred in September.
            List<Registration> earliestRegistrations = listreg.stream()
                    .min(Comparator.comparing(Registration::getRegistration_date))
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());

            // Convert only the names of events with the earliest registration date to JSON
            String json = new Gson().toJson(earliestRegistrations.stream()
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList()));
            // 7. Events with the earliest registration date.
            List<Registration> septemberRegistrations = listreg.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                    .collect(Collectors.toList());

            // Convert only the names of events in September to JSON
            String json1 = new Gson().toJson(septemberRegistrations.stream()
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList()));

            // 30. Events with names ending with "Championship."
            List<String> championshipEvents = listreg.stream()
                    .filter(registration -> registration.getEvent_name().endsWith("Championship"))
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList());

            // Convert the list of events to JSON
            String json2 = new Gson().toJson(championshipEvents);

            // 18. Athlete name with the most characters.
            String longestAthleteName = listreg.stream()
                    .map(Registration::getAthlete_name)
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");

            // Convert the result to JSON
            String json3 = new Gson().toJson(longestAthleteName);

            // 2. Athlete who registered for the most events.
           Map<String, Long> athleteEventCounts = listreg.stream()
                    .collect(Collectors.groupingBy(Registration::getAthlete_name, Collectors.counting()));

            long maxEvents = athleteEventCounts.values().stream()
                    .max(Long::compare)
                    .orElse(0L);
 
            List<String> athletesWithMostEvents = athleteEventCounts.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxEvents)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            // Convert the list of athletes to JSON
            String json4 = new Gson().toJson(athletesWithMostEvents);

        //     String json5 = new Gson().toJson(listreg);

            JsonObject mainJsonObject = new JsonObject();

            JsonArray earliestRegistrations1 = new Gson().toJsonTree(earliestRegistrations).getAsJsonArray();
            mainJsonObject.add("earliestRegistrations1", earliestRegistrations1);

            JsonArray septemberRegistrations1 = new Gson().toJsonTree(septemberRegistrations).getAsJsonArray();
            mainJsonObject.add("septemberRegistrations1", septemberRegistrations1);

            JsonArray championshipEvents1 = new Gson().toJsonTree(championshipEvents).getAsJsonArray();
            mainJsonObject.add("championshipEvents1", championshipEvents1);

            mainJsonObject.addProperty("longestAthleteName", longestAthleteName);

            JsonArray athletesWithMostEvents1 = new Gson().toJsonTree(athletesWithMostEvents).getAsJsonArray();
            mainJsonObject.add("athletesWithMostEvents1", athletesWithMostEvents1);

            JsonArray listreg1 = new Gson().toJsonTree(listreg).getAsJsonArray();
            mainJsonObject.add("listreg1", listreg1);


            String combinedJson = new Gson().toJson(mainJsonObject);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(combinedJson);

            resultSet.close();
            statement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            MysqlDataSource d = new MysqlDataSource();
            d.setUrl("jdbc:mysql://localhost:3306/GarciaC");
            d.setUser("root");
            d.setPassword("");
            jdbcConnection = d.getConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}