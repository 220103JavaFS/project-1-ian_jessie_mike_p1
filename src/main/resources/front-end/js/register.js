let registerBtn = document.getElementById('registerBtn');

const selectBtn = document.getElementById('roleSelect');

//eventListeners
registerBtn.addEventListener('click', registerUser);

const url = 'http://localhost:8080/';

async function registerUser() {
  var selectValue = selectBtn.value;
  if (selectValue === 'Employee') {
    selectValue = 1;
  } else if (selectValue === 'Manager') {
    selectValue = 2;
  } else {
    selectValue = undefined;
  }

  let newUser = {
    user_Name: document.getElementById('inputUserName').value.trim(), //input values will make up user object
    user_Pass: document.getElementById('inputPassword').value.trim(),
    user_First_Name: document.getElementById('inputFirstName').value.trim(),
    user_Last_Name: document.getElementById('inputLastName').value.trim(),
    user_Email: document.getElementById('inputEmail').value.trim(),
    user_Role_ID: selectValue, //assign role ID of 1 or 2
  };
  console.log(newUser);
  let response = await fetch(url + 'register', {
    method: 'POST',
    body: JSON.stringify(newUser),
    credentials: 'include', //stores cookie
  });

  if (response.status === 201) {
    //if login is successful, redirect to correct page
    if (selectValue === 2) {
      //document.location.replace(url + ''); //add Manager url
      console.log('success manager');
    } else if (selectValue === 1) {
      //document.location.replace(url + ''); //add Employee url
      console.log('success employee');
    } else {
      console.error(response.status);
    }
    document.location.replace(url + 'html/login.html');
    console.log('ok');
  } else {
    console.log('Error Status:' + response.status + ' Registration failed!');
    alert('Invalid input, please try again!');
  }
}
