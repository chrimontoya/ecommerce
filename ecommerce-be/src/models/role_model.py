from sqlalchemy import Column, Integer, String
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db

class Role(postgres_db.Model):
    __tablename__ = 'role'

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String)
    users = relationship("User",secondary="user_role", back_populates="roles")

    def as_dict(self):
        return {c.name: getattr(self, c.name) for c in self.__table__.columns}
    