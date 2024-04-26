from flask import jsonify
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import DeclarativeBaseNoMeta

class Base(DeclarativeBaseNoMeta):
  __abstract__ = True

  def to_json(self):
    return jsonify(self.to_dict())

postgres_db = SQLAlchemy(model_class=Base)