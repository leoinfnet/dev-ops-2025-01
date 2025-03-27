import requests
import random
import time

# URLs dos endpoints
ENDPOINT_1 = "http://localhost:8080/service1"
ENDPOINT_2 = "http://localhost:8082/service3"

# Função para enviar requisições aleatórias
def enviar_requisicoes():
    while True:
        # Decide para qual endpoint enviar a requisição com probabilidades de 90% para o primeiro e 90% para o segundo
        if random.random() < 0.9:
            url = ENDPOINT_1
        else:
            url = ENDPOINT_2

        # Envia a requisição GET
        try:
            response = requests.get(url)
            print(f"Requisição enviada para {url}. Status: {response.status_code}")
        except requests.exceptions.RequestException as e:
            print(f"Erro ao enviar requisição para {url}: {e}")

        # Gera um tempo aleatório entre 20ms e 1 segundo (0.02 a 1 segundo)
        tempo_aleatorio = random.uniform(0.02, 1.0)
        time.sleep(tempo_aleatorio)  # Aguarda o tempo aleatório antes de enviar a próxima requisição

if __name__ == "__main__":
    enviar_requisicoes()
