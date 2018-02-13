FROM nginx

ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD ./default.conf /etc/nginx/conf.d/default.conf
COPY ./.htpasswd /etc/nginx/.htpasswd

ADD info /www/data/info
ADD robots.txt /www/data/robots.txt