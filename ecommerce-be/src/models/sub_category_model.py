from sqlalchemy import Column, Integer, String, Date, func, ForeignKey
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db

class SubCategory(postgres_db.Model):
    __tablename__ = 'sub_category'

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String)
    creation_date = Column(Date, default=func.now())
    category_id = Column(Integer, ForeignKey("category.id"))
    category = relationship("Category")
    # products = relationship("Product", back_populates="sub_category")
    
    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}
    