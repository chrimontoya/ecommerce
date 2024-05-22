from flask import request
from dao.category_dao import CategoryDao

class CategoryController:

    def __init__(self) -> None:
        self.category_dao = CategoryDao()

    def add_category(self):
        category = request.json

        if not category:
            return {"msg": "Error category can't be empty", "status": 400}, 400
        return {"msg": "Category has been created", "data": self.category_dao.add_category(category), "status": 201}, 201
    
    def get_all(self):
        categories = self.category_dao.get_all()
        
        if not categories:
            return {"msg": "No categories have been obtained", "data": [], "status": 200}, 200
        return {"msg": "Categories have been obtained", "data": categories, "status": 200}, 200
    
