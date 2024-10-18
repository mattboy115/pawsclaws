window.onload = function() {
    let btns = document.querySelectorAll('.adopt-btn');

    // Ensure the buttons exist
    if (btns.length > 0) {
        btns.forEach(btn => {
            btn.addEventListener('click', function(event) {
                event.preventDefault();  // Stop the default anchor behavior
                let confirmAdoption = confirm("Are you sure you want to adopt this pet?\nThey will not be coming back.");
                if (confirmAdoption) {
                    window.location.href = this.href;  // Redirect to the link if confirmed
                }
            });
        });
    } else {
        console.log("No adoption buttons found.");  // Fallback in case no buttons are found
    }
};
