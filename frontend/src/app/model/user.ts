export class User {

    public email: string;
    public lozinka: string;
    public ime: string;
    public prezime: string;
    public rodjendan: string;
    public uloga: string;


    constructor(username: string, password: string, firstName: string, lastName: string, dateOfBirth: string) {
        this.email = username;
        this.lozinka = password;
        this.ime = firstName;
        this.prezime = lastName;
        this.rodjendan = dateOfBirth;
    }

}