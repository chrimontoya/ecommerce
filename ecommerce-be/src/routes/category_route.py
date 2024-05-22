from flask import Flask, Blueprint
from controllers.category_controller import CategoryController

category_controller = CategoryController()

bp_category = Blueprint('categories', __name__)

bp_category.route('', methods=['POST'])(category_controller.add_category)
bp_category.route('', methods=['GET'])(category_controller.get_all)