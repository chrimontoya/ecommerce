from sqlalchemy import Column, Integer, ForeignKey
from config.postgres_config import postgres_db

class UserRole(postgres_db.Model):
    __tablename__ = 'user_role'
    
    id = Column(Integer, primary_key=True)
    user_id = Column(Integer, ForeignKey("user.id"))
    role_id = Column(Integer, ForeignKey("role.id"))