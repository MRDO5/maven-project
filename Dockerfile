FROM tomcat:8.0

ADD ./webapp/target/*.war /usr/local/tomcat/webapps/

RUN yum -y update; yum clean all

CMD ["catalina.sh", "run"]

EXPOSE 8080


