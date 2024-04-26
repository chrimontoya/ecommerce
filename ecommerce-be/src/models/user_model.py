from sqlalchemy import Column, Integer, String, Date
from sqlalchemy.orm import declarative_base, relationship

User_base = declarative_base()

class User(User_base):
    __tablename__ = 'user'

    id = Column(Integer, primary_key=True)
    username = Column(String, unique=True)
    password = Column(String)
    email = Column(String)
    creation_date = Column(Date)
    roles = relationship("Role", secondary="user_role")