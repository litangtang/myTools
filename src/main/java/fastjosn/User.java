package fastjosn;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    private Short age;
    private String ageStr;

    public String getAgeStr() {
        return String.valueOf((int)this.age);
    }

    public void setAgeStr(String ageStr) {
        this.ageStr = ageStr;
    }
}
