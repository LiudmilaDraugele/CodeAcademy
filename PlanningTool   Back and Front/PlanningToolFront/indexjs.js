let loginbutton = document.getElementById("loginbutton");
loginbutton.addEventListener("click", check);
loginbutton.addEventListener("click", savedata);
loginbutton.addEventListener("click", logIn);

//padaryti, kad shortname butu case insensitive.
//padaryti, kad suvedant pass - rodytu *


let shortnames = [];

function savedata(e){
    e.preventDefault();
    let myshortname = document.getElementById("shortname").value;
    fetch("http://localhost:8886/planning/api/employee/all")
    .then(res => res.json())
    .then( data => data.forEach(element => {
        if (myshortname == element.shortname){
            localStorage.setItem('user', element.shortname);
            localStorage.setItem('userid',element.id);
        }
    }))
}

fetch(`http://localhost:8886/planning/api/employee/all`)
.then (res => res.json())
.then(data => data.forEach (element => {
    shortnames.push(element.shortname)
}))

function logIn(e){
    e.preventDefault();
    let myshortname = document.getElementById("shortname").value;
    let mypassword = document.getElementById("password").value;
    let existing = false;
    console.log(`user ${myshortname} logging in`);
    fetch("http://localhost:8886/planning/api/auth/login",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        
        },
        body:JSON.stringify({shortname:myshortname, password:mypassword})
    })
    .then(res => 
        {
            if (res.status==200) {
                res.text().then(tokenBody => {
                    localStorage.setItem('token', tokenBody);
                    localStorage.setItem('shortname', myshortname)
                    console.log(`user ${myshortname} got to another window`);
                    window.location.assign("http://127.0.0.1:3000/PlanningToolFront/PlanningTool/indexpage.html");
            })
            
            // res.json().then(employee=>{
            //     console.log(`user ${myshortname} existing and logging in`);
            //    localStorage.setItem('token',res.body);
            //     localStorage.setItem('shortname',employee.shortname)
            // })
            
        }
else{
    let errormessage = document.getElementById("errormessage");
            errormessage.style.display="block";
            console.log("user error message!");
}});

}

function check(e){
    e.preventDefault();
    let myshortname = document.getElementById("shortname").value;
    if(shortnames.includes(myshortname)){

    }
    else{
        let errormessage = document.getElementById("errormessage");
        errormessage.style.display="block";
        console.log("user second error message!"); 
    }
}
        



