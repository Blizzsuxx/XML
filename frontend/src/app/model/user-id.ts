export class UserId {

    public id : number;
    public username: string;
    public password: string;
    public firstName: string;
    public lastName: string;
    public dateOfBirth: string;

    constructor(id : number,username: string, password: string, firstName: string, lastName: string, dateOfBirth: string) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

}