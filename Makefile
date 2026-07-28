.PHONY: docker-push docker-pull docker-up docker-down k8s-up k8s-down

# Build all services and push images to Docker Hub
docker-push:
	docker build -t sebitcaroca/demomicro-configserver:latest ./infrastructure/configserver
	docker build -t sebitcaroca/demomicro-eurekaserver:latest ./infrastructure/eurekaserver
	docker build -t sebitcaroca/demomicro-gatewayserver:latest ./infrastructure/gatewayserver
	docker build -t sebitcaroca/demomicro-profileservice:latest ./services/profileservice
	docker build -t sebitcaroca/demomicro-postservice:latest ./services/postservice
	docker push sebitcaroca/demomicro-configserver:latest
	docker push sebitcaroca/demomicro-eurekaserver:latest
	docker push sebitcaroca/demomicro-gatewayserver:latest
	docker push sebitcaroca/demomicro-profileservice:latest
	docker push sebitcaroca/demomicro-postservice:latest

# Pull latest images from Docker Hub
docker-pull:
	docker pull sebitcaroca/demomicro-configserver:latest
	docker pull sebitcaroca/demomicro-eurekaserver:latest
	docker pull sebitcaroca/demomicro-gatewayserver:latest
	docker pull sebitcaroca/demomicro-profileservice:latest
	docker pull sebitcaroca/demomicro-postservice:latest

# Start all containers
docker-up:
	docker compose --profile full up -d

# Stop all containers
docker-down:
	docker compose --profile full down

# Deploy to Kubernetes
k8s-up:
	kubectl apply -f deployment/kubernetes/

# Tear down Kubernetes deployment
k8s-down:
	kubectl delete -f deployment/kubernetes/
