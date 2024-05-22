from flask import Flask, Blueprint
from controllers.mark_controller import MarkController

mark_controller = MarkController()

bp_mark = Blueprint('marks', __name__)

bp_mark.route('', methods=['POST'])(mark_controller.add_mark)
bp_mark.route('', methods=['GET'])(mark_controller.get_all)