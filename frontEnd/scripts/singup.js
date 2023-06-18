function registerCustomer() {
    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let age = document.getElementById("age").value;
    let gender = document.getElementById("gender").value;
    let email = document.getElementById("email").value;
    let street = document.getElementById("street").value;
    let area = document.getElementById("area").value;
    let state = document.getElementById("state").value;
    let country = document.getElementById("country").value;
    let mobile = document.getElementById("mobile").value;
    let role = document.getElementById("role").value;
    let password = document.getElementById("password").value;
    let building = document.getElementById("building").value;
    let city = document.getElementById("city").value;
    let pincode = document.getElementById("pincode").value;
  
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
  
    var raw = JSON.stringify({
      "firstName": fname,
      "lastName": lname,
      "age": age,
      "gender": gender,
      "mobileNumber": mobile,
      "address": {
        "buildingName": building,
        "streetNo": street,
        "area": area,
        "city": city,
        "state": state,
        "country": country,
        "pincode": pincode
      },
      "email": email,
      "password": password,
      "role": role
    });
  
    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
  
    fetch("http://localhost:9000/customers", requestOptions)
      .then(response => response.json())
      .then(result => showmydata(result))
      .catch(error => console.log('error', error));
  
    function showmydata(data) {
      let main = document.getElementById("main");
      console.log(data.name, "53");
  
      let div = document.createElement("div");
  
      let title = document.createElement("h1");
      title.innerText = data.name;
  
      let body = document.createElement("h1");
      body.innerText = data.email;
  
      div.append(title, body);
      main.append(div);
    }
  }
  