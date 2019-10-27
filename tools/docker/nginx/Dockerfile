# base image
FROM nginx:1.17.5

# remove the default nginx configuration
RUN rm /etc/nginx/nginx.conf

# add custom nginx configuration
COPY ./tools/docker/nginx/nginx.conf /etc/nginx

# allow nginx conf to be executable
RUN cd /etc/nginx \
    && chmod +x /etc/nginx/nginx.conf

# create working directory
WORKDIR /var/www/app

# copy our temp artifacts
COPY ./temp /var/www/app

# start nginx container
CMD /bin/bash -c "nginx -g 'daemon off;'"
