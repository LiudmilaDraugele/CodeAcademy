populateEmployeeSelect();
let activityarray;
populateActivitySelect();


//sutvarkyti, kad additional time table, kad butu grazu :)   padaryti grazu grid kaip plane
//sutvarkyti, kad veiktu start ir end date palyginimo funkcija ir 
//issaugotu tiek irasu, kiek yra skirtumo tarp start ir end

//pakoreguoti deleteadditional funkcija, kad pirmai tikrintu, 
//ar norimas trinti irasa tikrai priklauso pasirinktam employee

async function populateEmployeeSelect() {

    await fetch(`http://localhost:8886/planning/api/employee/all`)
    .then(res => res.json())
    .then(data => {
        let employeeselect1 = document.getElementById("addTimeEmployeeSelect");
        let employeeselect2 = document.getElementById("updateTimeEmployeeSelect");
        //let employeeselect3 = document.getElementById("deleteTimeEmployeeSelect");
        let employeeselect4 = document.getElementById("additionalTimeEmployeeSelect");
        data.forEach(employee => {
           let optionref = document.createElement("option");
           optionref.value = employee.id;
           optionref.innerHTML=employee.name;
           employeeselect1.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = employee.id;
           optionref2.innerHTML=employee.name;
           employeeselect2.appendChild(optionref2);

        //    let optionref3 = document.createElement("option");
        //    optionref3.value = employee.id;
        //    optionref3.innerHTML=employee.name;
        //    employeeselect3.appendChild(optionref3);

           let optionref4 = document.createElement("option");
           optionref4.value = employee.id;
           optionref4.innerHTML=employee.name;
           employeeselect4.appendChild(optionref4);

        })
        console.log("employee lists in additional time page populated")});  
}

async function populateActivitySelect() {

    await fetch("http://localhost:8886/planning/api/activity/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        activityarray = data;
       
        let categoryselect = document.getElementById("addActivitySelect");
        let categoryselect2 = document.getElementById("updateActivitySelect");
        //let categoryselect3 = document.getElementById("additionalTimeCategorySelect");
        data.forEach(element => {
           let optionref = document.createElement("option");
           optionref.value = element.id;
           optionref.innerHTML=element.name;
           categoryselect.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = element.id;
           optionref2.innerHTML=element.name;
           categoryselect2.appendChild(optionref2);

        //    let optionref3 = document.createElement("option");
        //    optionref3.value = element.id;
        //    optionref3.innerHTML=element.name;
        //    categoryselect3.appendChild(optionref3);

        })
        console.log("activity lists in additional time page populated")});
    
}

let addadditional = document.getElementById("addTimeForm");
addadditional.addEventListener("submit", createAdditional);

async function createAdditional(e){
	e.preventDefault();
	
	let myemployeeid = document.getElementById("addTimeEmployeeSelect").value;
    let mystartdate = document.getElementById("addStartDateForTime").value.toString();
    //let myenddate = document.getElementById("addEndDateForTime").value;
    let myactivity = document.getElementById("addActivitySelect").value;
    let myduration = document.getElementById("addTimeInput").value;
    let mycomment = document.getElementById("addExplanationInput").value;
     
	await fetch("http://localhost:8886/planning/api/additional/create",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({employeeId: myemployeeid, 
            date: mystartdate,  
            activityId: myactivity, duration: myduration, comment: mycomment})
    })
    .then(res => res.json());
        setTimeout(() => {
            document.getElementById("additionalTimePage").classList = "optionaldivvisible"; 
              }, "300")
}  

let updateadditional = document.getElementById("updateTimeForm");
updateadditional.addEventListener("submit", updateAdditional);

async function updateAdditional(e){
	e.preventDefault();
    let myemployeeid = document.getElementById("updateTimeEmployeeSelect").value;
    let myadditionalid = document.getElementById("updateTimeFieldId").value;
    let mystartdate = document.getElementById("updateStartDateForTime").value.toString();
    //let myenddate = document.getElementById("updateEndDateForTime").value;
    console.log(mystartdate)
    let myactivity = document.getElementById("updateActivitySelect").value;
    let myduration = document.getElementById("updateTimeInput").value;
    let mycomment = document.getElementById("updateExplanationInput").value;

    await fetch(`http://localhost:8886/planning/api/additional/${myadditionalid}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:myadditionalid, employeeId: myemployeeid, 
            date: mystartdate,  
            activityId: myactivity, duration: myduration, comment: mycomment})
       })
   .then(res => res.json());
   setTimeout(() => {
    document.getElementById("additionalTimePage").classList = "optionaldivvisible"; 
      }, "300")
}

let deleteadditional = document.getElementById("deleteTimeForm");
deleteadditional.addEventListener("submit", deleteAdditional);

async function deleteAdditional(){
    //let myemployeeid = document.getElementById("deleteTimeEmployeeSelect").value;
    let myadditionalid = document.getElementById("deleteTimeFieldId").value;
    await fetch (`http://localhost:8886/planning/api/additional/${myadditionalid}`,{
                     method: "DELETE",
                     headers: {
                          "Content-Type": "application/json",
                          "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                      },
                    })
                    window.location.reload();
                    document.getElementById("additionalTimePage").classList = "optionaldivvisible";           
 }


let mygetadditionaltimelist = document.getElementById("getAdditionalTimeslist");
mygetadditionaltimelist.addEventListener("submit",populateAdditionalTimeList)


async function populateAdditionalTimeList() {

    let myemployeeid = document.getElementById("additionalTimeEmployeeSelect").value;
    let mydate = document.getElementById("additionalTimeDateSelect").value.toString();
    console.log(myemployeeid);

    await fetch("http://localhost:8886/planning/api/additional/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        
        document.getElementById("addTable").textContent="";
        //console.log(myemployeeid);
        for(let i =0; i<data.length; i++) {
            if((data[i].employeeId == myemployeeid && data[i].date == mydate )){
                
                
           let row = document.createElement("div");
           row.id = "row-" + data[i].id;
           row.classList = "row";
           document.getElementById("addTable").appendChild(row);

           let idColumn = document.createElement("div");
           idColumn.textContent=data[i].id;
           idColumn.id = "idColumn-" + data[i].id;
           idColumn.classList = "addtimecell";
           row.appendChild(idColumn);

           let dateColumn = document.createElement("div");
           dateColumn.textContent=data[i].date;
           dateColumn.id = "dateColumn-" + data[i].id;
           dateColumn.classList = "addtimecell";
           row.appendChild(dateColumn);

           let activityColumn = document.createElement("div");
            let myactivityId =data[i].activityId;

            for(let j =0; j<activityarray.length; j++) {
                if((activityarray[j].id == myactivityId)){
                    activityColumn.textContent = activityarray[j].name;
                }}
           activityColumn.id = "activityColumn-" + data[i].id;
           activityColumn.classList = "addtimecell";
           row.appendChild(activityColumn);

           let durationColumn = document.createElement("div");
           durationColumn.textContent = data[i].duration;
           durationColumn.id = "durationColumn-" + data[i].id;
           durationColumn.classList = "addtimecell";
           row.appendChild(durationColumn);

           let commentColumn =  document.createElement("div");
           commentColumn.textContent = data[i].comment;
           commentColumn.id = "commentColumn-" + data[i].id;
           commentColumn.classList = "addtimecell";
           row.appendChild(commentColumn);

     } }
        console.log(data)});
    
}
