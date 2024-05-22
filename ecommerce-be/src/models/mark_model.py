from sqlalchemy import Column, Integer, String, Date, func
from config.postgres_config import postgres_db

class Mark(postgres_db.Model):
    __tablename__ = 'mark'

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String)
    creation_date = Column(Date, default=func.now())
    
    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}
    