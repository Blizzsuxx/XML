export class User {

    public email: string;
    public lozinka: string;
    public ime: string;
    public prezime: string;
    public rodjendan: string;
    public uloga: string;
    public jmbg: string;


    constructor(username: string, password: string, firstName: string, lastName: string, jmbg: string, dateOfBirth: string) {
        this.email = username;
        this.lozinka = password;
        this.ime = firstName;
        this.prezime = lastName;
        this.rodjendan = dateOfBirth;
        this.jmbg = jmbg;
    }

}