from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.category_model import Category

class CategoryDao:

    def __init__(self) -> None:
        pass

    def add_category(self, args):
        with Session(postgres_db.engine) as session:
            category = Category(
                name = args.get("name"),
                description = args.get("description") 
            )
            session.add(category)
            session.commit()
            return category.as_dict()
        
    def get_all(self):
        with Session(postgres_db.engine) as session:
            query = session.query(Category)
            categories = []
            for category in query:
                categories.append(category.as_dict())
            return categories
    