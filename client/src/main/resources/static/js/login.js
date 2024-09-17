  document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault();

            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            fetch('http://localhost:8083/auth/login', { // API Gateway endpoint
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`
            })
            .then(response => {
                if (response.ok) {
                    return response.json(); // Expecting JSON with JWT token
                } else {
                    throw new Error('Invalid credentials token');
                }
            })
            .then(data => {
                const token = data.token;
                // Store token and redirect
                localStorage.setItem('jwt', token);
                window.location.href = 'success.html';
            })
            .catch(error => {
                alert(error.message);
            });
        });