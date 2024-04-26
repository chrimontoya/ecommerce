from flask import jsonify, request
from flask_jwt_extended import create_access_token
from dao.user_dao import UserDao

class AuthController:

    def __init__(self) -> None:
        self.auth_dao = UserDao()

    def login(self):
        username = request.json.get("username", None)
        password = request.json.get("password", None)

        user = self.auth_dao.findUserByUsernameAndPassword(username, password)

        if user is None:
            return jsonify({"msg": "Bad username or password"}), 401

        access_token = create_access_token(identity=username)
        return jsonify(access_token=access_token)
