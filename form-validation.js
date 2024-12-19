// form-validation.js
document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const contactInput = document.getElementById("contact");

    // Function to validate email format
    const validateEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

    // Function to check password strength
    const checkPasswordStrength = (password) => {
        const strongRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#]).{8,}$/;
        return strongRegex.test(password);
    };

    // Live email validation
    emailInput.addEventListener("input", () => {
        const emailError = emailInput.nextElementSibling;
        if (!validateEmail(emailInput.value)) {
            emailError.textContent = "Invalid email format.";
        } else {
            emailError.textContent = "";
        }
    });

    // Live password strength feedback
    passwordInput.addEventListener("input", () => {
        const passwordError = passwordInput.nextElementSibling;
        if (!checkPasswordStrength(passwordInput.value)) {
            passwordError.textContent = "Password must be at least 8 characters long, include uppercase, lowercase, number, and special character.";
        } else {
            passwordError.textContent = "";
        }
    });

    // Live contact number validation
    contactInput.addEventListener("input", () => {
        const contactError = contactInput.nextElementSibling;
        if (isNaN(contactInput.value) || contactInput.value.length !== 10) {
            contactError.textContent = "Contact number must be 10 digits.";
        } else {
            contactError.textContent = "";
        }
    });

    // Form submission validation
    form.addEventListener("submit", (event) => {
        if (
            !validateEmail(emailInput.value) ||
            !checkPasswordStrength(passwordInput.value) ||
            isNaN(contactInput.value) || 
            contactInput.value.length !== 10
        ) {
            alert("Please fix the errors before submitting.");
            event.preventDefault();
        }
    });
});
