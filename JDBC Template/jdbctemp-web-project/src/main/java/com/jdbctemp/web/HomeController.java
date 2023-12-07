package com.jdbctemp.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.http.HttpServletResponse;
 
@Controller
@RequestMapping("/home")
public class HomeController {
 
    // {
    //     System.out.println("home control loaded");
    // }
 
    // @Autowired
    // private EmployeeDao employeeDao;
 
    @Autowired
    private RegistrationDAO registrationDao;



    @RequestMapping("/")
    public String showpage(HttpServletResponse resp) throws SQLException, IOException {
        // int status = employeeDao.saveEmployee(new Employee(102, "gopi", 5000));
        // System.out.println(status);
 
        // int status1 = employeeDao.updateEmployee(new Employee(102, "Sonoo", 15000));
        // System.out.println(status1);
        // return null;
 
        // Employee e = new Employee();
        // e.setId(1);
        // int status = employeeDao.deleteEmployee(e);
        // System.out.println(status);
        // return null ;
 
        // List<Employee> allEmployees = employeeDao.allEmployees();
        // allEmployees.stream().forEach(System.out::println);
        // return null ;
 
        List<Registration> allregistration = registrationDao.listAllRegistrations();

        List<Registration> earliestRegistrations = allregistration.stream()
                    .min(Comparator.comparing(Registration::getRegistration_date))
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());

            // Convert only the names of events with the earliest registration date to JSON
            String json = new Gson().toJson(earliestRegistrations.stream()
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList()));

                   // earliestRegistrations.stream().forEach(System.out::println);
            // 7. Events with the earliest registration date.
            List<Registration> septemberRegistrations = allregistration.stream()
                    .filter(registration -> registration.getRegistration_date().toLocalDate().getMonthValue() == 9)
                    .collect(Collectors.toList());
            
            // Convert only the names of events in September to JSON
           String json1 = new Gson().toJson(septemberRegistrations.stream()
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList()));

                   // septemberRegistrations.stream().forEach(System.out::println);

            // 30. Events with names ending with "Championship."
            List<String> championshipEvents = allregistration.stream()
                    .filter(registration -> registration.getEvent_name().endsWith("Championship"))
                    .map(Registration::getEvent_name)
                    .collect(Collectors.toList());

                   // championshipEvents.stream().forEach(System.out::println);
            // Convert the list of events to JSON
            String json2 = new Gson().toJson(championshipEvents);

            // 18. Athlete name with the most characters.
            String longestAthleteName = allregistration.stream()
                    .map(Registration::getAthlete_name)
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");

                    //System.out.println(longestAthleteName);

            // Convert the result to JSON
            String json3 = new Gson().toJson(longestAthleteName);

            // 2. Athlete who registered for the most events.
           Map<String, Long> athleteEventCounts = allregistration.stream()
                    .collect(Collectors.groupingBy(Registration::getAthlete_name, Collectors.counting()));

            long maxEvents = athleteEventCounts.values().stream()
                    .max(Long::compare)
                    .orElse(0L);
 
            List<String> athletesWithMostEvents = athleteEventCounts.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxEvents)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

                    //athletesWithMostEvents.stream().forEach(System.out::println);

            // Convert the list of athletes to JSON
           String json4 = new Gson().toJson(athletesWithMostEvents);
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

           JsonArray listreg1 = new Gson().toJsonTree(allregistration).getAsJsonArray();
           mainJsonObject.add("listreg1", listreg1);


           String combinedJson = new Gson().toJson(mainJsonObject);

           // Set response content type and write JSON to response
           resp.setContentType("application/json");
           resp.setCharacterEncoding("UTF-8");
           resp.getWriter().write(combinedJson);
            return "home";
        
       

           

    }
}