from flask import Flask, Blueprint
from controllers.auth_controller import AuthController

auth_controller = AuthController()

bp_auth = Blueprint('auth', __name__)

bp_auth.route('/login', methods=['POST'])(auth_controller.login)