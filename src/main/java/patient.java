public class patient {
    private String taj;
    private String name;
    private String birthYear;
    private String kezeleskezdete;
    private String betegsegneve;

    public patient(String taj, String name, String birthYear, String kezeleskezdete, String betegsegneve) {
        this.taj = taj;
        this.name = name;
        this.birthYear = birthYear;
        this.kezeleskezdete = kezeleskezdete;
        this.betegsegneve = betegsegneve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getBetegsegneve() {
        return betegsegneve;
    }

    public void setBetegsegneve(String betegsegneve) {
        this.betegsegneve = betegsegneve;
    }
    public String getKezeleskezdete() {
        return kezeleskezdete;
    }

    public void setKezeleskezdete(String betegsegneve) {
        this.kezeleskezdete = kezeleskezdete;
    }

}
