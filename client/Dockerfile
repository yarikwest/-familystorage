FROM nginx:alpine
MAINTAINER Yaroslav Zakhidnyi <yarikwest@meta.ua>

ARG NGINX_FILE
COPY ${NGINX_FILE} /etc/nginx/nginx.conf
RUN rm -rf /usr/share/nginx/html/*

ARG DIST
COPY ${DIST} /usr/share/nginx/html
