from flask import Flask, current_app
from routes.routes import bp_auth
from config.postgres_config import postgres_db

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "postgresql://postgres:postgres@ecommerce-bd/postgres"

postgres_db.init_app(app)

from models.user_model import User, User_base
from models.role_model import Role, Role_base
from models.user_role_model import UserRole, UserRole_base

with app.app_context():
    try:
        engine = postgres_db.engine
        User_base.metadata.create_all(bind=engine)
        Role_base.metadata.create_all(bind=engine)
        UserRole_base.metadata.create_all(bind=engine)
    except Exception as e:
        current_app.logger.error("Error al crear tablas: ", exc_info=True)

#routes
app.register_blueprint(bp_auth, url_prefix="/api/v1/auth")

def main():
    app.run(host="0.0.0.0", port="5000", debug=True)

if __name__ == "__main__":
    main()
