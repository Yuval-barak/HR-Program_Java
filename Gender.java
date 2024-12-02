package workers;

public enum Gender {
	    MALE("Male"),
	    FEMALE("Female");

	    private String genderName;

	    Gender(String genderName) {
	        this.genderName = genderName;
	    }

	    public String getGenderName() {
	        return genderName;
	    }
	}

