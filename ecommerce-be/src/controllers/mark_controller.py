from flask import request
from dao.mark_dao import MarkDao

class MarkController:

    def __init__(self) -> None:
        self.mark_dao = MarkDao()

    def add_mark(self):
        mark = request.json

        if not mark:
            return {"msg": "Error mark can't be empty", "status": 400}, 400
        return {"msg": "Mark has been created", "data": self.mark_dao.add_mark(mark), "status": 201}, 201
    
    def get_all(self):
        marks = self.mark_dao.get_all()
        
        if not marks:
            return {"msg": "No marks have been obtained", "data": [], "status": 200}, 200
        return {"msg": "Marks have been obtained", "data": marks, "status": 200}, 200
    
