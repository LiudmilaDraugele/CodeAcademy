makeFunctionsInvisibleByRole();

function makeFunctionsInvisibleByRole(){
    let myrole = localStorage.getItem("userrole");

    switch(myrole){
        case "ROLE_USER": 
            document.getElementById("AddNewEmployeeDiv").style.display = "none";
            document.getElementById("AddEmployeeToTeamDiv").style.display = "none";
            document.getElementById("DeleteEmployeeDiv").style.display = "none";
            break;
        case "ROLE_PLANNER": 
            document.getElementById("AddNewEmployeeDiv").style.display = "none";
            document.getElementById("AddEmployeeToTeamDiv").style.display = "none";
            document.getElementById("DeleteEmployeeDiv").style.display = "none";
            break;
        default: console.log();
            break;
    }
    if (myrole == "ROLE_USER") {
        populateEmployeeSelectToChangePasswordUSER();
    } else{
        populateEmployeeSelect();
        populateRoleSelect();
        populateTeamSelect();
    }
}

async function populateEmployeeSelectToChangePasswordUSER(){
    let employeeselect2 = document.getElementById("employeeForPassChangeSelect");

    let optionref = document.createElement("option");
    optionref.value = localStorage.getItem("userid");
    optionref.innerHTML=localStorage.getItem("username");
    employeeselect2.appendChild(optionref);
}

async function populateEmployeeSelect() {

    await fetch(`http://localhost:8886/planning/api/employee/all`)
    .then(res => res.json())
    .then(data => {
        let employeeselect1 = document.getElementById("employeeToAddToTeamSelect");
        let employeeselect2 = document.getElementById("employeeForPassChangeSelect");
        let employeeselect3 = document.getElementById("employeeToDeleteSelect");
        
        data.forEach(employee => {
           let optionref = document.createElement("option");
           optionref.value = employee.id;
           optionref.innerHTML=employee.name;
           employeeselect1.appendChild(optionref);

           let optionref2 = document.createElement("option");
           optionref2.value = employee.id;
           optionref2.innerHTML=employee.name;
           employeeselect2.appendChild(optionref2);

           let optionref3 = document.createElement("option");
           optionref3.value = employee.id;
           optionref3.innerHTML=employee.name;
           employeeselect3.appendChild(optionref3);

        })
        console.log("employee lists in employee page populated")});  
}

async function populateRoleSelect() {

    await fetch("http://localhost:8886/planning/api/role/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let roleselect = document.getElementById("roleToUpdateEmployeeSelect");
    
        data.forEach(role => {
           let optionref = document.createElement("option");
           optionref.value = role.id;
           optionref.innerHTML=role.name.substring(5);
           roleselect.appendChild(optionref);

        })
        console.log("role list in employee page populated")});
    
}

async function populateTeamSelect() {

    await fetch("http://localhost:8886/planning/api/team/all",{
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
    })
    .then(res => res.json())
    .then(data => {
        let teamnameselect = document.getElementById("teamToUpdateEmployeeSelect");
        data.forEach(team => {
           let optionref = document.createElement("option");
           optionref.value = team.id;
           optionref.innerHTML=team.name;
           teamnameselect.appendChild(optionref);

        })
        console.log(data)});
    
}

let addemployee = document.getElementById("addNewEmployeeForm");
addemployee.addEventListener("submit", createEmployee);

async function createEmployee(e){
	e.preventDefault();
	
	let myemployeeshortname = document.getElementById("createShortnameInput").value;
    myemployeeshortname = myemployeeshortname.toString().toUpperCase();
    let myemployeename = document.getElementById("createNameInput").value;
    let myemployeeemail = document.getElementById("createEmailInput").value;
    let myemployeepass = document.getElementById("createPasswordInput").value;
    let myemployeepassrepeat = document.getElementById("repeatPasswordInput").value;
    
    console.log(myemployeeshortname);
	await fetch("http://localhost:8886/planning/api/auth/signup",{
        method: "POST",
        headers: {
            "Content-type": "application/json",
            "Authorization":`Bearer `+`${localStorage.getItem("token")}`
        },
        body: JSON.stringify({shortname: myemployeeshortname, 
            name:myemployeename, email:myemployeeemail, 
            password:myemployeepass, repeatPassword:myemployeepassrepeat, active:true })
    })
    .then(res => res.json())
    .then(data => { 
        console.log(data);
        window.location.reload();
        e.preventDefault();
        document.getElementById("employeesPage").classList = "optionaldivvisible"; 
    });      
}

let updateemployee = document.getElementById("addEmployeeToTeamForm");
updateemployee.addEventListener("submit", updateEmployee);

async function updateEmployee(e){
	e.preventDefault();
    let myemployeeid = document.getElementById("employeeToAddToTeamSelect").value;
    let mynewroletoemployee = document.getElementById("roleToUpdateEmployeeSelect").value;
    let mynewteamtoemployee = document.getElementById("teamToUpdateEmployeeSelect").value;
    let mynewhourstoemployee = document.getElementById("addWorkingHours").value * 60;

    await fetch(`http://localhost:8886/planning/api/employee/addteamrole/${myemployeeid}/${mynewteamtoemployee}/${mynewroletoemployee}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:myemployeeid, teamId:mynewteamtoemployee, role:{id:mynewroletoemployee}})
       })
   .then(res => res.json());

   await fetch(`http://localhost:8886/planning/api/employee/addhours?id=${myemployeeid}&min=${mynewhourstoemployee}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:myemployeeid, minutes:mynewhourstoemployee})
       })
   .then(res => res.json());


    window.location.reload();
    
    document.getElementById("employeePage").classList = "optionaldivvisible";
}

let updatepassword = document.getElementById("changeEmployeePasswordForm");
updatepassword.addEventListener("submit", updatePassword);

async function updatePassword(e){
	e.preventDefault();
    let myemployeeid = document.getElementById("employeeForPassChangeSelect").value;
    let mynewpassword = document.getElementById("changePasswordInput").value;
    

    await fetch(`http://localhost:8886/planning/api/employee/changepass/${myemployeeid}`,{
        method: "PUT",
        headers: {
             "Content-type": "application/json",
             "Access-Control-Allow-Origin":"http://127.0.0.1:3000",
             "Authorization":`Bearer `+`${localStorage.getItem("token")}`
         },
        body: JSON.stringify({id:myemployeeid, password:mynewpassword})
       })
   .then(res => res.json());


    window.location.reload();
    
    document.getElementById("employeePage").classList = "optionaldivvisible";
}


let deleteemployee = document.getElementById("deleteEmployeeForm");
deleteemployee.addEventListener("submit", deleteEmployee);

async function deleteEmployee(){
   
    let myemployeeid = document.getElementById("employeeToDeleteSelect").value;
    await fetch (`http://localhost:8886/planning/api/employee/${myemployeeid}`,{
                     method: "DELETE",
                     headers: {
                          "Content-Type": "application/json",
                          "Authorization":`Bearer `+`${localStorage.getItem("token")}`
                      },
                    });
                    window.location.reload();
                    document.getElementById("employeePage").style.display = "block";           
 }