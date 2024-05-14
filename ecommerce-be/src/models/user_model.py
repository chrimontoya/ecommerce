from sqlalchemy import Column, Integer, String, Date, Boolean, func
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db


class User(postgres_db.Model):
    __tablename__ = 'user'

    id = Column(Integer, primary_key=True)
    username = Column(String, unique=True)
    password = Column(String)
    email = Column(String)
    creation_date = Column(Date, default=func.now())
    enabled = Column(Boolean)

    roles = relationship("Role", secondary="user_role")

    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}