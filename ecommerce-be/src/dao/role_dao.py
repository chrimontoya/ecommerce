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