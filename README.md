"# Ashvaghosh_Ringne_Hello_Books_Assignment" 

Test Cases for HelloBooks Automation
1. New Registration with OTP Verification
Description:
Automates the full user registration process including entering first name, last name, email, password, accepting terms, and verifying OTP received via email.
Steps:
Open signup page.
Enter user details and password.
Accept terms and conditions.
Submit the form.
Fetch OTP from Mailinator and verify account.
Expected Result:
User should see the onboarding process message: "Onboarding Process".

2.While signup Leave Mandatory Fields Blank
Description:
Tests that the form validation works when required fields (like email) are left blank.
Steps:
Open signup page.
Click the signup button without entering any details.
Expected Result:
Error message "Email is required" should appear.

3. Signup Without Accepting Terms and Conditions
Description:
Verifies that signup cannot proceed if the user does not accept the terms and conditions checkbox.
Steps:
Fill all required fields except the checkbox.
Click signup.
Expected Result:
Error message "Please accept the terms and conditions" should appear.

4. Signup with Weak Password
Description:
Ensures password strength validation is enforced during signup.
Steps:
Fill signup form with a weak password (less than 8 characters, missing uppercase, number, or symbol).
Click signup.
Expected Result:
Error message "Password must include at least 8 characters, 1 uppercase letter, 1 number and 1 symbol" should appear.
