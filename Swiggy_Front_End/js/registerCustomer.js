function registerCustomer(){
    let cname = document.getElementById("name").value;
    let cemail= document.getElementById("email").value;
    let caddress= document.getElementById("address").value;
    let password= document.getElementById("password").value;

    
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    
    
    var raw = JSON.stringify({
      "name": cname,
      "email": cemail,
      "password": password,
      "address": caddress
    });
    
    var requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    
    fetch("http://localhost:8888/customers", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));
  }