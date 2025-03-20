## Проект с использованием Apache Flink и S3-хранилище MinIO

Для запуска нужно:

### 1. Собрать Docker образ:
```
docker build . -t user_name/flink-job:1.0.1
```
### 2. Загрузить на Docker Hub:
```
docker push user_name/flink-job:1.0.1
```
### 3. Запустить deployment файлы:
```
kubectl apply -f flink-deployment.yaml
kubectl apply -f minio-deployment.yaml 
```