// Function to validate the email format
function validateEmail(email) {
    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    return emailPattern.test(email);
}

// Function to validate the password
function validatePassword(password) {
    const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordPattern.test(password);
}

document.getElementById('register-form').addEventListener('submit', function(event) {
    let valid = true;

    // Email validation
    const emailInput = document.getElementById('email');
    const emailError = document.getElementById('email-error');
    if (!validateEmail(emailInput.value)) {
        emailError.style.display = 'inline';
        valid = false;
    } else {
        emailError.style.display = 'none';
    }

    // Password validation
    const passwordInput = document.getElementById('password');
    const passwordError = document.getElementById('password-error');
    if (!validatePassword(passwordInput.value)) {
        passwordError.style.display = 'inline';
        valid = false;
    } else {
        passwordError.style.display = 'none';
    }

    // Confirm password validation
    const confirmPasswordInput = document.getElementById('confirm-password');
    const confirmPasswordError = document.getElementById('confirm-password-error');
    if (passwordInput.value !== confirmPasswordInput.value) {
        confirmPasswordError.style.display = 'inline';
        valid = false;
    } else {
        confirmPasswordError.style.display = 'none';
    }

    // Prevent form submission if validation fails
    if (!valid) {
        event.preventDefault();
    }
});
