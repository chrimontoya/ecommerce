from flask import jsonify, request
from flask_jwt_extended import create_access_token
from dao.user_dao import UserDao
from dao.role_dao import RoleDao

class AuthController:

    def __init__(self) -> None:
        self.auth_dao = UserDao()
        self.roles_dao = RoleDao()

    def login(self):
        username = request.json.get("username", None)
        password = request.json.get("password", None)

        user = self.auth_dao.findUserByUsernameAndPassword(username, password)

        if user is None:
            return jsonify(message="Bad username or password", status=400, data=[]), 400

        access_token = create_access_token(identity=username)
        data = {
            "token": access_token,
            "user": {
                "username": user.get("username"),
                "email": user.get("email"),
                "roles": self.roles_dao.findRolesById(user.get("id"))
            }
        }
        return jsonify(message="", status=200, data=data)
