function getItems() {
    $.ajax({
        url: "http://localhost:8080/app/Registration",
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            // console.log(data.octoberRegistrationsarr);
 
            // console.log(JSON.parse(data));
            _displayItems(data);
 
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function _displayItems(data) {
 
    const q1 = document.getElementById("column1");
    q1.innerHTML = "<h3>EarliestRegistration_Event</h3><br>";
    q1.innerHTML = q1.innerHTML + data.earliestRegistrations1
    .reduce((earliest, current) => {
        const earliestDate = new Date(earliest.registration_date);
        const currentDate = new Date(current.registration_date);
        return currentDate < earliestDate ? current : earliest;
    })
    .event_name;

    
    const q2 = document.getElementById("column2");
    q2.innerHTML = " <h3>SeptemberRegistrations</h3><br>";
    q2.innerHTML = q2.innerHTML + data.septemberRegistrations1.filter(obj => obj.registration_date.includes("Sep")).map(obj => `event_name: ${obj.event_name}`).join("<br>");

 
    const q3= document.getElementById("column3");
    q3.innerHTML = " <h3>ChampionshipEvents</h3><br>";
    q3.innerHTML = q3.innerHTML + data.championshipEvents1.join("<br>");

    const q4= document.getElementById("column4");
    q4.innerHTML = " <h3>Longest_Athlete_Name</h3><br>";
    q4.innerHTML = q4.innerHTML + data.longestAthleteName;

    const q5= document.getElementById("column5");
    q5.innerHTML = " <h3>Athlete_WithMostParticipation</h3><br>";
    q5.innerHTML = q5.innerHTML + data.athletesWithMostEvents1.join("<br>");

    //q1.innerHTML = data.earliestInSeptember.registration_id;
 
    const tBody = document.getElementById("reg");
    tBody.innerHTML = "";

    data.listreg1.forEach((item) => {

        let tr = tBody.insertRow();

        let td1 = tr.insertCell(0);
        let registration_id = document.createTextNode(item.registration_id);
        td1.appendChild(registration_id);

        let td2 = tr.insertCell(1);
        let event_name = document.createTextNode(item.event_name);
        td2.appendChild(event_name);

        let td3 = tr.insertCell(2);
        let athlete_name = document.createTextNode(item.athlete_name);
        td3.appendChild(athlete_name);

        let td4 = tr.insertCell(3);
        let registration_date = document.createTextNode(item.registration_date);
        td4.appendChild(registration_date);


    });

    reg = data;

}
 
 
