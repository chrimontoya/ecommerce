from sqlalchemy import Column, Integer, String
from sqlalchemy.orm import declarative_base, relationship

Role_base = declarative_base()

class Role(Role_base):
    __tablename__ = 'role'

    id = Column(Integer, primary_key=True)
    name = Column(String, unique=True)
    description = Column(String, unique=True)
    users = relationship("User", secondary="user_role")
    