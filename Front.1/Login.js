const url = 'http://localhost:8080/P1-Greg-Kalaydjian/' //I grabbed this base URL from postman
//it's also what shows up when you run as server and get your 404 page
//Eventually, we'll use this base URL and make calls to the server by adding endpoints to it

//login functionality below-------------------------------------

//add an event listener to the Employee login button
document.getElementById("loginButtonForEmployees").addEventListener('click', loginFuncEmployeeLogin);
document.getElementById("loginButtonForManagement").addEventListener('click', loginFuncManagementLogin);
//this function will send the user-inputted login credentials to the server (For Employees)
async function loginFuncEmployeeLogin() {

    //get the user inputs for the login
    let usern = document.getElementById("EmployeeUsername").value; // usern stands for username
    let userp = document.getElementById("EmployeePassword").value; // userp stands for password

    //we want to send the user/passs as JSON, so what I need to do first is make a JS object
    let user = {
        username:usern,
        password:userp
    }

    console.log(user);

    //now I'm going to set up my fetch request to the server
    //rememeber the second parameter a fetch() can take? 
    //a configuration object!! Essentially the settings of a fetch request
    //if you don't include a second param, it'll just send a GET request to the URL.
    let response = await fetch(url + "employeeLogin", {

        method: "POST", //send as a POST request
        body: JSON.stringify(user), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    //control flow based on success or failed login
    if(response.status === 200) {
        //this will wipe our login row, and welcome the user
        document.getElementById("login-row2").innerText="Welcome Employee!";
        document.getElementById("login-row2").innerText="";
        location.href = "EmployeeLounge.html";


    } else {
        document.getElementById("login-row2").innerText="Login Failed! Invalid Username or Password ERROR: LOGIN.JS (Employee Login)";
    }

}


document.getElementById("loginButtonForManagement").addEventListener('click', loginFuncManagementLogin);
//this function will send the user-inputted login creditials to the server (For Management)
async function loginFuncManagementLogin() {


    
    //get the user inputs for the login
    let usern = document.getElementById("ManagerUsername").value; // usern stands for username
    let userp = document.getElementById("ManagerPassword").value; // userp stands for password

    //we want to send the user/passs as JSON, so what I need to do first is make a JS object
    let user = {
        username:usern,
        password:userp
    }

    console.log(user);

    //now I'm going to set up my fetch request to the server
    //rememeber the second parameter a fetch() can take? 
    //a configuration object!! Essentially the settings of a fetch request
    //if you don't include a second param, it'll just send a GET request to the URL.
    let response = await fetch(url + "managementLogin", {

        method: "POST", //send as a POST request
        body: JSON.stringify(user), //turn into JSON
        credentials: "include" //this will ensure that the cookie is captured
                              //future fetches will also require this value to send the cookie back
        //BTW we won't be using HTML forms anymore... it's too annoying to turn them into JSON
        //Don't worry too much, we will learn Angular and life will be grand
    });

    console.log(response.status);

    //control flow based on success or failed login
    if(response.status === 200) {
        //this will wipe our login row, and welcome the user
        document.getElementById("login-row1").innerText="Welcome Manager!!!!!!!";
        document.getElementById("login-row1").innerText="";
        document.location.href = 'ManagerLounge.html';


    } else {
        document.getElementById("login-row1").innerText="Login Failed, Invalid Username or Password. ERROR: LOGIN.JS (Manager Login)";
    }

}

