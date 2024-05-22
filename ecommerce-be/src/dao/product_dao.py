from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.product_model import Product

class ProductDao:

    def __init__(self) -> None:
        pass

    def add_product(self, args):
        with Session(postgres_db.engine) as session:
            product = Product(
                name = args.get("name"),
                description = args.get("description"),
                price = args.get("price"),
                amount = args.get("amount"),
                sub_category_id = args.get("sub_category_id"),
                mark_id = args.get("mark_id")
            )
            session.add(product)
            session.commit()
            return product.as_dict()
        
    def get_all(self):
        with Session(postgres_db.engine) as session:
            query = session.query(Product)
            products = []
            for product in query:
                products.append(product.as_dict())
            return products