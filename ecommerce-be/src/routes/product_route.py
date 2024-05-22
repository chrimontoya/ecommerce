from flask import Flask, Blueprint
from controllers.product_controller import ProductController

product_controller = ProductController()

bp_product = Blueprint('products', __name__)

bp_product.route('', methods=['POST'])(product_controller.add_product)
bp_product.route('', methods=['GET'])(product_controller.get_all)