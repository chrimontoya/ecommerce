from flask import Flask, Blueprint
from routes.routes import bp_auth

app = Flask(__name__)

app.register_blueprint(bp_auth, url_prefix="/api/v1/auth")

def main():
    app.run(host="0.0.0.0", port="5000", debug=True)

if __name__ == "__main__":
    main()