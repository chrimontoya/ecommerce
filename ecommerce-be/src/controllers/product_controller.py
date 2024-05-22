from flask import request
from dao.product_dao import ProductDao

class ProductController:

    def __init__(self) -> None:
        self.product_dao = ProductDao()

    def add_product(self):

        product = request.json

        if not product:
            return {"msg": "Error product can't be empty", "status": 400}, 400
        return {"msg": "Product has been created", "data": self.product_dao.add_product(product), "status": 201}, 201 
    
    def get_all(self):
        products = self.product_dao.get_all()
        
        if not products:
            return {"msg": "No products have been obtained", "data": [], "status": 200}, 200
        return {"msg": "Products have been obtained", "data": products, "status": 200}, 200
