package workersprogram;

public enum MenuOption {
	ADD_EMPLOYEE("Add a new employee"),
    VIEW_EMPLOYEE("View employee data"),
    DELETE_EMPLOYEE("Delete an employee"),
    VIEW_REPORT("View employee report"),
    EXIT("Exit the program");

    private String displayName;

    MenuOption(String description) {
        this.displayName = description;
    }

    public String getDisplayName() {
        return displayName;
    }

}
