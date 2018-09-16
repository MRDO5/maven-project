FROM tomcat:8.0

ADD ./webapp/target/*.war /usr/local/tomcat/webapps/

RUN apt-get update -y && apt-get clean all

CMD ["catalina.sh", "run"]

EXPOSE 8080


