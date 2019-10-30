# Demo ClojureScript Nginx

## Quick Start - Dev

- Run App

  ```bash
  clj -A:dev
  ```

- Visit App

  http://localhost:9500


## Build Prod Artifacts

```bash
clj -A:prod
```


## Setup Nginx Webserver

This will show the steps involved in building the docker nginx webserver locally.

- Build prod artifact image

  ```bash
  docker build -t \
               demo-clojurescript-nginx/build:0.0.0 \
               -f "tools/nginx/Dockerfile.build" .
  ```

- Run prod artifact container

  ```bash
  docker run -d \
           --name demo-clojurescript-nginx-build \
           demo-clojurescript-nginx/build:0.0.0 \
           sleep 20000
  ```

- Move prod artifacts from above container to local filesystem

  ```bash
  mkdir temp
  mkdir temp/cljs-out
  docker cp demo-clojurescript-nginx-build:app/resources/public/index.html ./temp/index.html
  docker cp demo-clojurescript-nginx-build:app/resources/public/style.css ./temp/style.css
  docker cp demo-clojurescript-nginx-build:app/out/dev-main.js ./temp/cljs-out/dev-main.js
  ```

- Build prod nginx image

  ```bash
  docker build -t \
             demo-clojurescript-nginx/prod:0.0.0 \
             -f "tools/nginx/Dockerfile" .
  ```

- Run prod nginx container

  ```bash
  docker run -d \
           -p 4001:4001 \
           --name demo-clojurescript-nginx-prod \
           demo-clojurescript-nginx/prod:0.0.0
  ```

Visit the site at http://localhost:4001
