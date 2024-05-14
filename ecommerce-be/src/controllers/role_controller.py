from flask import request
from dao.role_dao import RoleDao

class RoleController:

    def __init__(self):
        self.role_dao = RoleDao()

    def add_role(self):
        role = request.json
        if not role:
            return {"msg": "Role can't be empty"}, 400

        return {"msg": "Role has been created", "data": self.role_dao.add_role(role), "status": 201}, 201