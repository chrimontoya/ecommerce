from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.user_model import User
from models.user_role_model import UserRole

class UserDao:

    def createUser(self, user):
        with Session(postgres_db.engine) as session:
            roles_user = user.get("roles")
            user = User(
                username= user.get("username"),
                password = user.get("password"),
                email = user.get("email"),
                enabled = user.get("enabled")
            )
            session.add(user)
            session.flush()

            for role in roles_user:
                user_role = UserRole(user_id=user.id, role_id=role.get("id"))
                session.add(user_role)
                session.commit()
            return user.as_dict()
            
    def findUserByUsernameAndPassword(self, username, password):
        with Session(postgres_db.engine) as session:
            user = session.query(User).filter(User.username == username, User.password == password).first()
            return user
