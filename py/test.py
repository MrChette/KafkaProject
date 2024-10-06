import requests

url = "http://localhost:8080/api/user/createuser" 

# Crear un nuevo usuario
user = {
    "name": "John Doe",
    "isActive": True
}

# Enviar la solicitud POST
response = requests.post(url, json=user)

# Imprimir la respuesta
if response.status_code == 200:
    print("Usuario creado:", response.json())
else:
    print("Error al crear usuario:", response.status_code, response.text)
