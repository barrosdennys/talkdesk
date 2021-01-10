package main.java.model;

public class Company {
    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    @Override
    public String toString() {
        return "Company name = " + name + '\n' +
                "Company catchPhrase=" + catchPhrase + '\n' +
                "Company bs = " + bs + '\n';
    }

    private String name;
    private String catchPhrase;
    private String bs;
}
