document.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('jwt');
    if (token) {
        document.getElementById('token').textContent = token;
    } else {
        document.getElementById('token').textContent = 'No token found';
    }

    document.getElementById('validate-user').addEventListener('click', () => {
        // Log the token to ensure it's retrieved correctly
        console.log('JWT Token:', token);

        // Send the JWT token as a header to the next microservice
        fetch('http://localhost:8083/validate', { // API Gateway endpoint for the next microservice
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}` // Pass the JWT token in the Authorization header
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById('response').innerText = data; // Display the response
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
