
export class PasswordChanger {

    public oldPassword: string;
    public newPassword : string;

    constructor(oldPassword : string, newPassword : string) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}