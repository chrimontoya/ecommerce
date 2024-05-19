from flask import Flask, current_app
from routes.auth_route import bp_auth
from routes.user_route import bp_user
from routes.role_route import bp_role
from config.postgres_config import postgres_db
from flask_jwt_extended import JWTManager
from flask_cors import CORS

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "postgresql://postgres:postgres@ecommerce-bd/postgres"
app.config["JWT_SECRET_KEY"] = "super-secret"  # Change this!
CORS(app)
jwt = JWTManager(app)

postgres_db.init_app(app)

from models.user_role_model import UserRole
from models.user_model import User
from models.role_model import Role

with app.app_context():
    try:
        engine = postgres_db.engine
        postgres_db.create_all()
    except Exception as e:
        current_app.logger.error("Error al crear tablas: ", exc_info=True)

#routes
app.register_blueprint(bp_auth, url_prefix="/api/v1/auth")
app.register_blueprint(bp_user, url_prefix="/api/v1/users")
app.register_blueprint(bp_role, url_prefix="/api/v1/roles")

def main():
    app.run(host="0.0.0.0", port="5000", debug=True)

if __name__ == "__main__":
    main()
