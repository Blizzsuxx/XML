import { User } from "./user";

export class Token {
    jwt: string;
    user: User;

    constructor(jwt: string, user: User) {
        this.jwt = jwt;
        this.user = user;
    }
}