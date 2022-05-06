set -a
source ./core/.env
set +a

docker-compose up -d
docker-compose run --rm app python manage.py migrate app