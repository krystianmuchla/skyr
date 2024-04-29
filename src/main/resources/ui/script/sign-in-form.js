{
    const signIn = document.getElementById('sign-in');
    document.onkeypress = function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            signIn.click();
        }
    }
    signIn.onclick = async function() {
        signIn.disabled = true;
        const login = document.getElementById('login');
        const password = document.getElementById('password');
        try {
            const response = await fetch('/api/id/sign_in', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    'login': login.value,
                    'password': password.value
                })
            });
            if (response.ok) {
                window.location.replace('/todo');
            } else if (response.status === 401) {
                console.error('Incorrect credentials given.');
            } else {
                console.error('Cannot sign in. Try again later.');
            }
        } catch (error) {
            console.error(error.message);
        }
        password.value = '';
        signIn.disabled = false;
    }
}
