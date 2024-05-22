from flask import Flask, Blueprint
from controllers.sub_category_controller import SubCategoryController

sub_category_controller = SubCategoryController()

bp_sub_category = Blueprint('sub_categories', __name__)

bp_sub_category.route('', methods=['POST'])(sub_category_controller.add_sub_category)
bp_sub_category.route('', methods=['GET'])(sub_category_controller.get_all)