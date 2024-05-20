import { RoleModel } from "./role.model";

export interface UserModel {
    username: string;
    email: string;
    roles: RoleModel[];
}