from flask import request
from dao.sub_category_dao import SubCategoryDao

class SubCategoryController:

    def __init__(self) -> None:
        self.sub_category_dao = SubCategoryDao()

    def add_sub_category(self):
        sub_category = request.json

        if not sub_category:
            return {"msg": "Error sub-category can't be empty", "status": 400}, 400
        return {"msg": "User has been created", "data": self.sub_category_dao.add_sub_category(sub_category), "status": 201}, 201 
    
    def get_all(self):
        sub_categories = self.sub_category_dao.get_all()
    
        if not sub_categories:
            return {"msg": "No sub-categories have been obtained", "data": [], "status": 200}, 200
        return {"msg": "Sub-categories have been obtained", "data": sub_categories, "status": 200}, 200
