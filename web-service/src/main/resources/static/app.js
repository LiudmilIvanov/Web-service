let tbodyElement = document.getElementById('tbody');
let searchBtn = document.getElementById('submit');
let inputElement = document.querySelector('.form-inline input');


function  viewElements() {
    searchBtn.addEventListener('click', function() {
        let userUrl = `http://localhost:8080/users/${inputElement.value}`;
       
        fetch(userUrl)
        .then((res) => res.json())
        .then((data) =>{
            data.forEach(element => {
             let trElement = document.createElement('tr');
                
             let tdElement = document.createElement('td');
             tdElement.innerHTML = element.username;

             let tdElementMail = document.createElement('td');
             tdElementMail.innerHTML = element.email;

             let tdElemenBtn = document.createElement('td');
             tdElemenBtn.innerHTML = `<button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-trash"></span> Trash </button>`;

             let tdElementEdit = document.createElement('td');
             tdElementEdit.innerHTML = `<input id="editBtn" type="button" value="Edit">`;

             tbodyElement.appendChild(trElement);
             trElement.appendChild(tdElement);
             trElement.appendChild(tdElementMail);
             trElement.appendChild(tdElemenBtn);
             trElement.appendChild(tdElementEdit);


             let deleterUrl = `http://localhost:8080/users/${element.id}`;

             tdElemenBtn.addEventListener('click', function() {
              let answer = window.confirm('Would you like to proceed deleting that record?');
              if (answer) {
                fetch(deleterUrl, {method: 'DELETE'});

                tdElement.innerHTML = '';
                tdElementMail.innerHTML = '';
                tdElemenBtn.innerHTML = '';
              
                tbodyElement.removeChild(trElement);
              } 

            });

            });
        });
    });

    

};

function addUser() {
    let addElement = document.getElementById('submit-user');
    let divElement = document.querySelector('.input');
    let url = `http://localhost:8080/users`

    addElement.addEventListener('click', function(){
        let userInputElement = document.createElement('div');
        userInputElement.innerHTML = "<div class='form-group'><label for='usr'>Name:</label><input type='text' class='form-control' id='usr'></div><div class='form-group'><label for='pwd'>Email:</label><input type='email' class='form-control' id='pwd'><input id='submit-confirm' type='button' value='Confirm'></div>";
       
        divElement.appendChild(userInputElement);

        let confirmElement = document.getElementById('submit-confirm');
        confirmElement.addEventListener('click', function() {
          let usernameInputEl = document.getElementById('usr');
          let emailInputEl = document.getElementById('pwd');


          fetch(url, {
                method: 'POST', 
                mode: 'cors',
                headers: {
                'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({username: usernameInputEl.value, email: emailInputEl.value})      
                });
              
                usernameInputEl.value = '';
                emailInputEl.value = '';
            });
        });
}

addUser();
viewElements();