<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <style>
            /* Apply some basic styling to make it visible */
            .container {
              display: flex;
              flex-direction: column;
            }
       
            .row {
              display: flex;
              justify-content: space-between;
              margin-bottom: 10px;
            }
       
            .column {
              flex: 1;
              border: 1px solid #000;
              padding: 10px;
              box-sizing: border-box;
            }
          </style>
</head>
 
<body>
    <div class="container">
        <!-- First row with 5 columns -->
        <div class="row">
          <div id="column1" >earliestRegistrations</div>
          <div id="column2" >septemberRegistrations</div>
          <div id="column3" >championshipEvents</div>
          <div id="column4" >longestAthleteName</div>
          <div id="column5" >athletesWithMostEvents</div>
        </div>
   
        <!-- Second row with 1 column -->
        <div class="row">
          <div id="column"><table>
            <tr>
            <th>Registration_ID</th>
            <th>Event_Name</th>
            <th>Athlete_Name</th>
            <th>Registration_Date</th>
            <th></th>
            <th></th>
            </tr>
            <tbody id="reg"></tbody>
            </table></div>
        </div>
      </div>
   
    <script src="reg.js"></script>
    <script type="text/javascript">
            getItems();
    </script>
</body>
</html>