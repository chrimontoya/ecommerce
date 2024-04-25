from flask import jsonify

class AuthController:

    def test(self):
        return jsonify(message = "Hola mundo"), 200