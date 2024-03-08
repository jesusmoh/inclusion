// Function to send 3 values from HTML fields in a JSON format to an external URL using fetch
function sendDataToExternalURL() {
    // Get values from HTML fields
    const value1 = document.getElementById('field1').value;
    const value2 = document.getElementById('field2').value;
    const value3 = document.getElementById('field3').value;

    // Create JSON object with the values
    const data = {
        value1: value1,
        value2: value2,
        value3: value3
    };

    // Define the URL to send the data to
    const url = 'http://localhost:8080/app/service/findk';

    // Make a POST request using fetch
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(data => {
            console.log('Data sent successfully:', data);
        })
        .catch(error => {
            console.error('Error sending data:', error);
        });
}