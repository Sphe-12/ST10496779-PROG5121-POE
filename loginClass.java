

public class loginClass {
    private final String username;
    private final String password;
    private final String cellNumber;
    private final String userSurname;
    private final String firstName;

    public loginClass (String username, String password, String cellNumber, String userName, String userSurname) {
        this.username = username;
        this.firstName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.cellNumber = cellNumber;
    }

    public boolean checkUsername () {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        return password.contains(".*[A-Z]*.*") && password.contains(".*[0-9]*.*") && password.length() >= 8 && password.contains(".*[!@#$%^&*()_+]*.*");
    }

    public boolean checkCellNumber() {
        return cellNumber.length() == 10 && cellNumber.matches("[0-9]+") && cellNumber.startsWith("+27");
    }
    public String registerUser() {
        if (checkUsername() && checkPasswordComplexity() && checkCellNumber()) {
            return "Welcome " + firstName +","+ userSurname + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public String returnLoginStatus() {
        if (loginUser(username, password)) {
            return "Login successful!";
        } else {
            return "Login failed! Please check your username and password.";
        }
    }
}
