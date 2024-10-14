import requests  # Asegúrate de importar el módulo requests

user = {
    "name": "RaspBerryUser1",
    "isActive": True
}



url = "http://192.168.1.145:8080/api/user/createuser"  # Cambia la URL al endpoint correcto


i = 1

while i < 100:
		user["name"] = "userandmessage" + str(i)
		
		try : 
			response = requests.post(url,json = user)
			response.raise_for_status()
			print(f"Usuario creado {user['name']}: {response.status_code}")
		except requests.exceptions.RequestException as e:
				print(f"Error al enviar datos para {user['name']}: {e}")
		
		i += 1
