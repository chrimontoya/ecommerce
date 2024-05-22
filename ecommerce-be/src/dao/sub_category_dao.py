from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.sub_category_model import SubCategory

class SubCategoryDao:

    def __init__(self) -> None:
        pass

    def add_sub_category(self, args):
        with Session(postgres_db.engine) as session:
            sub_category = SubCategory(
                name=args.get("name"),
                description=args.get("description"),
                category_id = args.get("category_id")
            )
            session.add(sub_category)
            session.commit()
            return sub_category.as_dict()
        
    def get_all(self):
        with Session(postgres_db.engine) as session:
            query = session.query(SubCategory)
            sub_categories = []
            for sub_category in query:
                sub_categories.append(sub_category.as_dict())
            return sub_categories
            
