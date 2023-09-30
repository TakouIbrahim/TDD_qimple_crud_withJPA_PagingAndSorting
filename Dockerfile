FROM debian:9

RUN apt-get update -yq \
    && apt-get install curl gnupg -yq\
    && curl -sL https://deb.nodesource.com/setup_10.x | bash \
    && apt-get install nodejs -yq\
    && apt-get clean -y

ADD . /app/

WORKDIR /app

RUN NPM install

EXPOSE 2368

VOLUME /app/logs

CMD npm run start

CMD ["echo", "fin du processus"]