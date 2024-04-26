from sqlalchemy import Column, Integer, String, ForeignKey
from sqlalchemy.orm import declarative_base, relationship
from models.role_model import Role
from models.user_model import User

UserRole_base = declarative_base()

class UserRole(UserRole_base):
    __tablename__ = 'user_role'
    id = Column(Integer, primary_key=True)
    user_id = Column(Integer, ForeignKey(User.id))
    role_id = Column(Integer, ForeignKey(Role.id))