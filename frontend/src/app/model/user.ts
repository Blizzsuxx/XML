export class User {

    public username: string;
    public password: string;
    public firstName: string;
    public lastName: string;
    public dateOfBirth: string;


    constructor(username: string, password: string, firstName: string, lastName: string, dateOfBirth: string) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}