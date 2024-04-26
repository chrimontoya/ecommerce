from sqlalchemy import Column, Integer, String, Date, Boolean
from sqlalchemy.orm import relationship
from config.postgres_config import postgres_db


class User(postgres_db.Model):
    __tablename__ = 'user'

    def __init__(self, id,username, password, email, creation_date, enabled, roles):
        self.id = id
        self.username = username
        self.password = password
        self.email = email
        self.creation_date = creation_date
        self.enabled = enabled
        self.roles = roles

    id = Column(Integer, primary_key=True)
    username = Column(String, unique=True)
    password = Column(String)
    email = Column(String)
    creation_date = Column(Date)
    enabled = Column(Boolean)
    roles = relationship("Role", secondary="user_role")