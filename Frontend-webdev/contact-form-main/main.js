const form = document.querySelector('form');
const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const email = document.getElementById("email");
const msg = document.getElementById("message");
const firstErr = document.getElementById("fErrorMsg");
const lastErr = document.getElementById("lErrorMsg");
const emailErr = document.getElementById("eErrorMsg");
const queryErr = document.getElementById("qErrorMsg");
const msgErr = document.getElementById("msgErrorMsg");
const cErr = document.getElementById("cErrorMsg");
const successMsg = document.getElementById("successMsg");

// Email validation func

function validateEmail(email) {
    // 1. Remove whitespace from beginning/end
    email = email.trim();

    // 2. Convert uppercase letters to lowercase
    email = email.toLowerCase();

    // 3. Check that the email isn't empty
    if (email === "") {
        return {
            valid: false,
            email: email,
            message: "Please enter a valid email address"
        };
    }

    // 4. Check for spaces anywhere in the email
    if (/\s/.test(email)) {
        return {
            valid: false,
            email: email,
            message: "Email cannot contain spaces."
        };
    }

    // 5. Check that there is exactly one @ symbol
    const atCount = (email.match(/@/g) || []).length;

    if (atCount !== 1) {
        return {
            valid: false,
            email: email,
            message: "Email must contain exactly one @ symbol."
        };
    }

    // 6. Split the email around the @ symbol
    const [localPart, domain] = email.split("@");

    // 7. Make sure there are characters before and after @
    if (localPart === "") {
        return {
            valid: false,
            email: email,
            message: "Enter something before the @ symbol."
        };
    }

    if (domain === "") {
        return {
            valid: false,
            email: email,
            message: "Enter a domain after the @ symbol."
        };
    }

    // 8. Make sure the domain contains a dot
    if (!domain.includes(".")) {
        return {
            valid: false,
            email: email,
            message: "Email domain must contain a dot."
        };
    }

    // 9. Make sure there is text before the dot
    const [domainName, extension] = domain.split(".");

    if (!domainName || !extension) {
        return {
            valid: false,
            email: email,
            message: "Enter a valid email domain."
        };
    }

    // 10. Check for invalid characters
    const emailRegex = /^[a-z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-z0-9-]+(?:\.[a-z0-9-]+)+$/;

    if (!emailRegex.test(email)) {
        return {
            valid: false,
            email: email,
            message: "Please enter a valid email address."
        };
    }

    // 11. Prevent domain from starting or ending with a hyphen
    if (
        domain.startsWith("-") ||
        domain.endsWith("-") ||
        domain.includes(".-") ||
        domain.includes("-.")
    ) {
        return {
            valid: false,
            email: email,
            message: "Invalid domain name."
        };
    }

    // 12. Check that the extension has at least 2 characters
    if (extension.length < 2) {
        return {
            valid: false,
            email: email,
            message: "Email domain extension is too short."
        };
    }

    // Everything passed
    return {
        valid: true,
        email: email
        // message: "Email is valid."
    };
};

// Error display func
function error(name, err){
    name.style.borderColor = "hsl(0, 66%, 54%)";
    err.style.display = "block";
    name.style.marginBottom = "0";
};

// Clear Error func
function clearError(name, err) {
    name.style.borderColor = "hsl(186, 15%, 59%)";
    err.style.display = "none";
    name.style.marginBottom = "1.9rem";
}

// Main func
function main() {
    // Name check
    if (firstName.value.trim() === "") {
        error(firstName, firstErr);
        return false;
    } else {
        clearError(firstName, firstErr);
    }
    
    if (lastName.value.trim() === "") {
        error(lastName, lastErr);
        return false;
    } else {
        clearError(lastName, lastErr);
    }

    // Email check
    let vEmail = validateEmail(email.value);
    if (!vEmail.valid) {
        error (email, emailErr);
        emailErr.innerText = vEmail.message;
        return false;
    } else {
        clearError(email, emailErr);
    }

    // query check
    const selectedQuery = document.querySelector('input[name="query"]:checked');
    if (!selectedQuery) {
        queryErr.style.display = "block";
        return false;
    } else {
        queryErr.style.display = "none";
    }

    //Message check
    if (msg.value.trim() === "") {
        error(msg, msgErr);
        return false;
    } else {
        clearError(msg, msgErr);
    }

    return true;

};

form.addEventListener("submit", e => {
    e.preventDefault();
    
    const consent = document.querySelector('input[name="consent"]:checked');

    if (!consent) {
        cErr.style.display = "block";
    } else {
        cErr.style.display = "none";
        const isValid = main();
        if (!isValid) {
            return;
        } else {
            successMsg.style.display = "flex";

            setTimeout(() => {
                successMsg.style.display = "none";
                form.reset();
            }, 3000);            
        }


    }
});



