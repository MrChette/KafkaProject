import requests

url = "http://localhost:8080/api/user/createuser" 

user = {
    "name": "John Doe",
    "isActive": True
}

import requests

url = "http://localhost:8080/api/user/createuser"

# Crear un nuevo usuario
user = {
    "name": "John Doe",
    "isActive": True
}

try:
    # Enviar la solicitud POST
    response = requests.post(url, json=user)
    
    # Comprobar el estado de la respuesta
    if response.status_code == 200:
        print("Usuario creado:", response.json())
    else:
        print("Error al crear usuario:", response.status_code, response.text)

except requests.exceptions.ConnectionError:
    print("Error: No se pudo conectar al servidor. Asegúrate de que el servidor esté en ejecución.")
except requests.exceptions.Timeout:
    print("Error: La solicitud ha superado el tiempo de espera.")
except requests.exceptions.RequestException as e:
    print("Error inesperado:", e)

