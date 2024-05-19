from sqlalchemy import Column, Integer, String, Date, Boolean, func
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db
from models.user_role_model import UserRole


class User(postgres_db.Model):
    __tablename__ = 'user'

    id = Column(Integer, primary_key=True)
    username = Column(String, unique=True)
    password = Column(String)
    email = Column(String)
    creation_date = Column(Date, default=func.now())
    enabled = Column(Boolean)

    roles = relationship("Role",secondary=UserRole, back_populates="users")

    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}