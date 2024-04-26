from sqlalchemy.orm import Session
from sqlalchemy import select
from config.postgres_config import postgres_db
from models.user_model import User
from models.role_model import Role
from datetime import datetime

class UserDao:

    def createUser(self, user):
        with Session(postgres_db.engine) as session:
            session.add(user)
            session.commit()
            
    def findUserByUsernameAndPassword(self, username, password):
        with Session(postgres_db.engine) as session:
            user = session.query(User).filter(User.username == username, User.password == password).first()
            return user
