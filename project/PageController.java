package project;


public class PageController {
    public void displayPage(User user) {
        if (user.getRole() == String.valueOf(UserRole.ADMIN)) {
            displayAdminPage(user);
        } else {
            displayUserPage(user);
        }
    }

    private void displayAdminPage(User user) {
        AdminMainMenu am = new AdminMainMenu();
    }

    private void displayUserPage(User user) {
        MainMenu mm = new MainMenu();
    }
}

