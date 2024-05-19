from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.role_model import Role

class RoleDao:

    def add_role(self, args):
        with Session(postgres_db.engine) as session:
            role = Role(
                name = args.get("name"),
                description = args.get("description")
            )
            session.add(role)
            session.commit()
            return role.as_dict()
        
    def findRolesById(self, id):
        with Session(postgres_db.engine) as session:
            query = session.query(Role).filter(Role.id == id)
            roles = []
            if query:
                for q in query:
                    roles.append(q.as_dict())
            return roles