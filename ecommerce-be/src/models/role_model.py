from sqlalchemy import Column, Integer, String
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db

class Role(postgres_db.Model):
    __tablename__ = 'role'

    def __init__(self, id, name, description, users):
        self.id = id
        self.name = name,
        self.description = description
        self.users = users

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String, unique=True)
    users = relationship("User", secondary="user_role")
    