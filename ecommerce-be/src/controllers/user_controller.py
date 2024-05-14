from flask import request
from dao.user_dao import UserDao
class UserController:

    def __init__(self):
        self.user_dao = UserDao()

    def add_user(self):
        user = request.json

        if not user:
            return {"msg": "Error user can't be empty", "status": 400}, 400
        return {"msg": "User has been created", "data":  self.user_dao.createUser(user), "status": 201}, 201