from sqlalchemy import Column, Integer, String, Date, func, ForeignKey
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db

class Product(postgres_db.Model):
    __tablename__ = 'product'

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String)
    price = Column(Integer)
    amount = Column(Integer)
    sub_category_id = Column(Integer, ForeignKey('sub_category.id'))
    mark_id = Column(Integer, ForeignKey('mark.id'))
    sub_category = relationship("SubCategory") 
    mark = relationship("Mark") 
    creation_date = Column(Date, default=func.now())
    update_date = Column(Date, default=func.now())
    
    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}
    