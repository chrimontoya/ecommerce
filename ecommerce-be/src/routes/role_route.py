from flask import Flask, Blueprint
from controllers.role_controller import RoleController

role_controller = RoleController()

bp_role = Blueprint('roles', __name__)

bp_role.route('', methods=['POST'])(role_controller.add_role)