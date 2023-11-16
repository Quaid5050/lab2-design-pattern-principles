package Practice;

interface Authentication {
    void login();
    void logout();
}

class FirebaseAuth implements Authentication {
    public void login() {
        System.out.println("Login with Firebase");
    }

    public void logout() {
        System.out.println("Logout with Firebase");
    }
}

class GoogleAuth implements Authentication {
    public void login() {
        System.out.println("Login with Google");
    }

    public void logout() {
        System.out.println("Logout with Google");
    }
}

class User{

    private final Authentication auth;

    public User(Authentication auth) {
        this.auth = auth;
    }

    public void login() {
        auth.login();
    }

    public void logout() {
        auth.logout();
    }
}

class Interfaces {
    public static void main(String[] args)
    {
        Authentication auth;
        auth= new FirebaseAuth();
        User user = new User(auth);
        user.login();
        user.logout();

        auth = new GoogleAuth();
        user = new User(auth);
        user.login();
        user.logout();
    }
}
