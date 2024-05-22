from sqlalchemy.orm import Session
from config.postgres_config import postgres_db
from models.mark_model import Mark

class MarkDao:

    def __init__(self) -> None:
        pass

    def add_mark(self, args):
        with Session(postgres_db.engine) as session:
            mark = Mark(
                name = args.get("name"),
                description = args.get("description") 
            )
            session.add(mark)
            session.commit()
            return mark.as_dict()
        
    def get_all(self):
        with Session(postgres_db.engine) as session:
            query = session.query(Mark)
            marks = []
            for mark in query:
                marks.append(mark.as_dict())
            return marks
    