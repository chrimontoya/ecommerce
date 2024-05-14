from flask import Blueprint
from controllers.user_controller import UserController

user_controller = UserController()

bp_user = Blueprint('users', __name__)

bp_user.route('', methods=['POST'])(user_controller.add_user)