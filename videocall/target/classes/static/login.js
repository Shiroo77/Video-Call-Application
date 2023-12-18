const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", handleLogin);

function handleLogin(event){
    event.preventDefault();

    // Get user input 
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // User object that we've 
    const user = {
        email: email,
        password: password
    };

    // Make a call to backend 
    fetch('http://localhost:8080/api/v1/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, 
        body: JSON.stringify(user)
    }).then(response => {
        if(!response.ok){
            alert('Login and / or password is incorrect');
        }
        // Got an error here, Remember it's json() 
        // Didnt't added those () & was able to login without correct details 
        return response.json();
    })
    // This will execute when the response is ok
    .then((response) => {
        localStorage.setItem('connectedUser', JSON.stringify(response))

        // User details are correct, Redirect the user to index page 
        window.location.href = 'index.html'
    })
    // Executes when the response is not ok 
    .catch(error => console.error(`Post request error ${error}`))
    

}